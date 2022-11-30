/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.outboundsync.activator.impl;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.exception.IntegrationAttributeException;
import de.hybris.platform.integrationservices.exception.IntegrationAttributeProcessingException;
import de.hybris.platform.integrationservices.service.ItemModelSearchService;
import de.hybris.platform.integrationservices.util.Log;
import de.hybris.platform.outboundservices.enums.OutboundSource;
import de.hybris.platform.outboundservices.facade.OutboundServiceFacade;
import de.hybris.platform.outboundservices.facade.SyncParameters;
import de.hybris.platform.outboundsync.activator.OutboundItemConsumer;
import de.hybris.platform.outboundsync.activator.OutboundSyncService;
import de.hybris.platform.outboundsync.dto.OutboundItemDTO;
import de.hybris.platform.outboundsync.dto.OutboundItemDTOGroup;
import de.hybris.platform.outboundsync.job.OutboundItemFactory;
import de.hybris.platform.outboundsync.job.impl.OutboundSyncJobRegister;
import de.hybris.platform.outboundsync.retry.RetryUpdateException;
import de.hybris.platform.outboundsync.retry.SyncRetryService;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Collection;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Preconditions;

import rx.Observable;

/**
 * Default implementation of {@link OutboundSyncService} that uses {@link OutboundServiceFacade} for sending changes to the
 * destinations.
 */
public class DefaultOutboundSyncService extends BaseOutboundSyncService implements OutboundSyncService
{
	private static final Logger LOG = Log.getLogger(DefaultOutboundSyncService.class);

	private ModelService modelService;
	private OutboundServiceFacade outboundServiceFacade;
	private SyncRetryService syncRetryService;

	/**
	 * Instantiates this service. Uses default implementations available in the application context for the required dependencies.
	 * Not required dependencies will not be injected after this service is instantiated. They need to be injected separately by
	 * calling the corresponding {@code set...()} methods.
	 *
	 * @see BaseOutboundSyncService#setOutboundItemFactory(OutboundItemFactory)
	 * @see BaseOutboundSyncService#setItemModelSearchService(ItemModelSearchService)
	 * @see BaseOutboundSyncService#setEventService(EventService)
	 * @see BaseOutboundSyncService#setOutboundItemConsumer(OutboundItemConsumer)
	 * @see #setOutboundServiceFacade(OutboundServiceFacade)
	 * @see #setSyncRetryService(SyncRetryService)
	 * @deprecated Use the constructor with dependencies to inject parameters
	 * {@link #DefaultOutboundSyncService(ItemModelSearchService, OutboundItemFactory, OutboundSyncJobRegister, OutboundServiceFacade)}
	 */
	@Deprecated(since = "2205", forRemoval = true)
	public DefaultOutboundSyncService()
	{
		this(BaseOutboundSyncService.getService("itemModelSearchService", ItemModelSearchService.class),
				BaseOutboundSyncService.getService("outboundItemFactory", OutboundItemFactory.class),
				BaseOutboundSyncService.getService("outboundSyncJobRegister", OutboundSyncJobRegister.class),
				BaseOutboundSyncService.getService("outboundServiceFacade", OutboundServiceFacade.class));
	}

	/**
	 * Instantiates this outbound sync service.
	 *
	 * @param searchService Service to search for item models
	 * @param factory       A factory implementation to create instances of {@link de.hybris.platform.outboundsync.dto.OutboundItem}
	 * @param register      Service to use for inquirying about currently running outbound sync jobs
	 * @param facade        An implementation of the facade to send changes through
	 */
	public DefaultOutboundSyncService(@NotNull final ItemModelSearchService searchService,
	                                  @NotNull final OutboundItemFactory factory,
	                                  @NotNull final OutboundSyncJobRegister register,
	                                  @NotNull final OutboundServiceFacade facade)
	{
		super(searchService, factory, register);
		Preconditions.checkArgument(facade != null, "OutboundServiceFacade cannot be null");
		outboundServiceFacade = facade;
	}

	@Override
	public void sync(final Collection<OutboundItemDTO> outboundItemDTOs)
	{
		final var itemGroup = asItemGroup(outboundItemDTOs);
		syncInternal(itemGroup.getCronJobPk(), itemGroup, () -> synchronizeItem(itemGroup));
	}

	private void synchronizeItem(final OutboundItemDTOGroup outboundItemDTOGroup)
	{
		final Long rootItemPk = outboundItemDTOGroup.getRootItemPk();
		LOG.debug("Synchronizing changes in item with PK={}", rootItemPk);

		findItemByPk(PK.fromLong(rootItemPk))
				.ifPresent(item -> synchronizeItem(outboundItemDTOGroup, item));
	}

	private void synchronizeItem(final OutboundItemDTOGroup dtoGroup, final ItemModel itemModel)
	{
		try
		{
			final var syncParameters = SyncParameters.syncParametersBuilder()
			                                         .withItem(itemModel)
			                                         .withIntegrationObjectCode(dtoGroup.getIntegrationObjectCode())
			                                         .withDestinationId(dtoGroup.getDestinationId())
			                                         .withSource(OutboundSource.OUTBOUNDSYNC)
			                                         .build();

			final Observable<ResponseEntity<Map>> outboundResponse = getOutboundServiceFacade().send(syncParameters);
			outboundResponse.subscribe(r -> handleResponse(r, dtoGroup), e -> handleError(e, dtoGroup));
		}
		catch (final RuntimeException e)
		{
			handleError(e, dtoGroup);
		}
	}

	private void handleError(final Throwable throwable, final OutboundItemDTOGroup outboundItemDTOGroup)
	{
		LOG.error("Failed to send item with PK={}", outboundItemDTOGroup.getRootItemPk(), throwable);
		if (throwable instanceof IntegrationAttributeProcessingException)
		{
			handleError(outboundItemDTOGroup);
		}
		else if (throwable instanceof IntegrationAttributeException)
		{
			publishSystemErrorEvent(outboundItemDTOGroup.getCronJobPk(), outboundItemDTOGroup);
		}
		else
		{
			handleError(outboundItemDTOGroup);
		}
	}

	protected void handleError(final OutboundItemDTOGroup outboundItemDTOGroup)
	{
		LOG.warn("The item with PK={} couldn't be synchronized", outboundItemDTOGroup.getRootItemPk());
		try
		{
			if (syncRetryService.handleSyncFailure(outboundItemDTOGroup))
			{
				consumeChanges(outboundItemDTOGroup);
			}
		}
		// Due to the observable.onerror flow, we'll never get to this catch block. The plan is to get rid of the Observable in
		// the facade invocation, so this code block will then be correct
		catch (final RetryUpdateException e)
		{
			LOG.debug("Retry could not be updated", e);
		}
		finally
		{
			publishUnSuccessfulCompletedEvent(outboundItemDTOGroup);
		}
	}

	protected void handleResponse(final ResponseEntity<Map> responseEntity, final OutboundItemDTOGroup outboundItemDTOGroup)
	{
		if (isSuccessResponse(responseEntity))
		{
			handleSuccessfulSync(outboundItemDTOGroup);
		}
		else
		{
			handleError(outboundItemDTOGroup);
		}
	}

	protected void handleSuccessfulSync(final OutboundItemDTOGroup outboundItemDTOGroup)
	{
		LOG.debug("The product with PK={} has been synchronized", outboundItemDTOGroup.getRootItemPk());
		try
		{
			syncRetryService.handleSyncSuccess(outboundItemDTOGroup);
			consumeChanges(outboundItemDTOGroup);
			publishSuccessfulCompletedEvent(outboundItemDTOGroup);
		}
		catch (final RetryUpdateException e)
		{
			LOG.debug("Retry could not be updated", e);
		}
	}

	private boolean isSuccessResponse(final ResponseEntity<Map> responseEntity)
	{
		return responseEntity.getStatusCode() == HttpStatus.CREATED || responseEntity.getStatusCode() == HttpStatus.OK;
	}

	/**
	 * @deprecated This method will be removed without alternative
	 */
	@Deprecated(since = "2105", forRemoval = true)
	protected ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @deprecated Use {@link ItemModelSearchService} instead and inject it through the constructor
	 */
	@Deprecated(since = "2105", forRemoval = true)
	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * Retrieves implementation of the {@link OutboundServiceFacade} being used by this service.
	 *
	 * @return implementation of the outbound facade being used to send items to an external system.
	 */
	public OutboundServiceFacade getOutboundServiceFacade()
	{
		return outboundServiceFacade;
	}

	/**
	 * Injects an outbound service facade to be used for sending the items to an external system.
	 *
	 * @param facade facade implementation to use.
	 */
	public void setOutboundServiceFacade(@NotNull final OutboundServiceFacade facade)
	{
		outboundServiceFacade = facade;
	}

	/**
	 * Injects implementation of the retry service to manage retries when outbound sync was not successful.
	 *
	 * @param service an implementation of the service to use.
	 */
	public void setSyncRetryService(@NotNull final SyncRetryService service)
	{
		syncRetryService = service;
	}
}

