/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.predicate;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.cms2.servicelayer.services.admin.CMSAdminComponentService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Required;


/**
 * Predicate to test if a given component uid maps to an existing component.
 * <p>
 * Returns <tt>TRUE</tt> if the component exists; <tt>FALSE</tt> otherwise.
 * </p>
 */
public class ComponentExistsInCatalogVersionsPredicate implements Predicate<String>
{
	private CMSAdminComponentService cmsAdminComponentService;
	private CatalogVersionService catalogVersionService;

	@Override
	public boolean test(final String target)
	{
		boolean result = true;
		try
		{
			getCmsAdminComponentService().getCMSComponentForIdAndCatalogVersions(target,
					getCatalogVersionService().getSessionCatalogVersions());
		}
		catch (UnknownIdentifierException | AmbiguousIdentifierException e)
		{
			result = false;
		}
		return result;
	}

	protected CMSAdminComponentService getCmsAdminComponentService()
	{
		return cmsAdminComponentService;
	}

	@Required
	public void setCmsAdminComponentService(final CMSAdminComponentService cmsAdminComponentService)
	{
		this.cmsAdminComponentService = cmsAdminComponentService;
	}

	protected CatalogVersionService getCatalogVersionService()
	{
		return catalogVersionService;
	}

	@Required
	public void setCatalogVersionService(final CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}
}
