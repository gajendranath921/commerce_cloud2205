/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.odata2services.odata.impl;

import static de.hybris.platform.odata2services.constants.Odata2servicesConstants.ENTITY_TYPE;
import static de.hybris.platform.odata2services.constants.Odata2servicesConstants.SERVICE;

import de.hybris.platform.odata2services.odata.InvalidServiceNameException;
import de.hybris.platform.odata2services.odata.ODataContextGenerator;
import de.hybris.platform.odata2services.odata.ODataRequestEntityExtractor;
import de.hybris.platform.odata2services.odata.ODataWebException;

import java.util.Collections;
import java.util.List;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataRequest;
import org.apache.olingo.odata2.core.ODataContextImpl;
import org.springframework.beans.factory.annotation.Required;

import com.google.common.base.Preconditions;

public class DefaultODataContextGenerator implements ODataContextGenerator
{
	private ODataServiceFactory serviceFactory;
	private List<ODataRequestEntityExtractor> entityExtractors;

	@Override
	public ODataContext generate(final ODataRequest oDataRequest)
	{
		Preconditions.checkArgument(oDataRequest.getPathInfo() != null, "Path info cannot be null");
		Preconditions.checkArgument(!oDataRequest.getPathInfo().getServiceRoot().toString().isEmpty(),
				"Service cannot be empty.");

		final String serviceName = getServiceNameIfValid(oDataRequest);
		final ODataContextImpl context = new ODataContextImpl(oDataRequest, getServiceFactory());
		context.setParameter(ENTITY_TYPE, getEntity(oDataRequest));
		context.setParameter(SERVICE, serviceName);
		final ODataService oDataService = createODataService(context);
		context.setService(oDataService);
		return context;
	}

	protected ODataService createODataService(final ODataContext oDataContext)
	{
		try
		{
			return getServiceFactory().createService(oDataContext);
		}
		catch (final ODataException e)
		{
			throw new ODataWebException("The ODataServiceFactory failed to create an ODataService", e);
		}
	}

	protected String getEntity(final ODataRequest oDataRequest)
	{
		return getEntityExtractors().stream()
		                            .filter(handler -> handler.isApplicable(oDataRequest))
		                            .map(handler -> handler.extract(oDataRequest))
		                            .findFirst().orElse("");
	}

	protected String getServiceNameIfValid(final ODataRequest oDataRequest)
	{
		final String[] rootPath = oDataRequest.getPathInfo().getServiceRoot().getPath().split("/");
		if (rootPath.length > 0)
		{
			final String serviceName = rootPath[rootPath.length - 1];
			if (!serviceName.isEmpty() && !"odata2webservices".equals(serviceName))
			{
				return serviceName;
			}
		}
		throw new InvalidServiceNameException();
	}

	protected ODataServiceFactory getServiceFactory()
	{
		return serviceFactory;
	}

	@Required
	public void setServiceFactory(final ODataServiceFactory serviceFactory)
	{
		this.serviceFactory = serviceFactory;
	}

	protected List<ODataRequestEntityExtractor> getEntityExtractors()
	{
		return entityExtractors;
	}

	@Required
	public void setEntityExtractors(final List<ODataRequestEntityExtractor> entityExtractors)
	{
		this.entityExtractors = entityExtractors != null ? List.copyOf(entityExtractors) : Collections.emptyList();
	}
}
