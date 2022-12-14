/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.users.populator;

import de.hybris.platform.cmsfacades.data.UserData;
import de.hybris.platform.cmsfacades.users.services.CMSUserService;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.beans.factory.annotation.Required;


/**
 * Populates a {@link UserData} instance from the {@link UserModel} source data model.
 */
public class UserModelToDataPopulator implements Populator<UserModel, UserData>
{
	// ------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------
	private CMSUserService cmsUserService;

	// ------------------------------------------------------------------
	// Public API
	// ------------------------------------------------------------------
	@Override
	public void populate(final UserModel userModel, final UserData target) throws ConversionException
	{
		target.setUid(userModel.getUid());
		target.setReadableLanguages(getCmsUserService().getReadableLanguagesForUser(userModel));
		target.setWriteableLanguages(getCmsUserService().getWriteableLanguagesForUser(userModel));
	}

	// ------------------------------------------------------------------
	// Getters/Setters
	// ------------------------------------------------------------------
	protected CMSUserService getCmsUserService()
	{
		return cmsUserService;
	}

	@Required
	public void setCmsUserService(CMSUserService cmsUserService)
	{
		this.cmsUserService = cmsUserService;
	}

}
