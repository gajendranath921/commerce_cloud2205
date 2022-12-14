/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.version.predicate;

import de.hybris.platform.cms2.model.contents.CMSItemModel;
import de.hybris.platform.cms2.version.service.CMSVersionService;
import de.hybris.platform.cmsfacades.uniqueidentifier.UniqueItemIdentifierService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiPredicate;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Required;


/**
 * Predicate to test if a label exists in versions pertaining to an item model.
 * <p>
 * Returns <tt>TRUE</tt> if the item model exists AND the label exists in any versions pertaining to the item model;
 * <tt>FALSE</tt> otherwise.
 * </p>
 */
public class LabelExistsInCMSVersionsPredicate implements BiPredicate<String, String>
{
	private UniqueItemIdentifierService uniqueItemIdentifierService;
	private CMSVersionService cmsVersionService;

	@Override
	public boolean test(final String itemUUID, final String label)
	{
		try
		{
			final Optional<CMSItemModel> cmsItemModel = getUniqueItemIdentifierService().getItemModel(itemUUID, CMSItemModel.class);

			return cmsItemModel.isPresent() && Strings.isNotBlank(label) && getCmsVersionService().getVersionByLabel(cmsItemModel.get(), label).isPresent();
		}
		catch (final UnknownIdentifierException e)
		{
			return false;
		}
	}

	protected UniqueItemIdentifierService getUniqueItemIdentifierService()
	{
		return uniqueItemIdentifierService;
	}

	@Required
	public void setUniqueItemIdentifierService(final UniqueItemIdentifierService uniqueItemIdentifierService)
	{
		this.uniqueItemIdentifierService = uniqueItemIdentifierService;
	}

	protected CMSVersionService getCmsVersionService()
	{
		return cmsVersionService;
	}

	@Required
	public void setCmsVersionService(final CMSVersionService cmsVersionService)
	{
		this.cmsVersionService = cmsVersionService;
	}
}
