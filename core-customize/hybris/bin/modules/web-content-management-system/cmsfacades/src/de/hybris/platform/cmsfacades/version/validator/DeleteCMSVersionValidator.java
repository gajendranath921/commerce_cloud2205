/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.version.validator;

import static de.hybris.platform.cmsfacades.constants.CmsfacadesConstants.FIELD_UID;
import static de.hybris.platform.cmsfacades.constants.CmsfacadesConstants.VERSION_REMOVE_INVALID_VERSION_UID;

import de.hybris.platform.cmsfacades.constants.CmsfacadesConstants;
import de.hybris.platform.cmsfacades.data.CMSVersionData;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Validates fields of {@link CMSVersionData} for a delete operation
 */
public class DeleteCMSVersionValidator implements Validator
{
	private Predicate<String> isLabeledVersionPredicate;

	@Override
	public boolean supports(final Class<?> clazz)
	{
		return CMSVersionData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors)
	{
		ValidationUtils.rejectIfEmpty(errors, FIELD_UID, CmsfacadesConstants.FIELD_REQUIRED);

		final CMSVersionData cmsVersionData = (CMSVersionData) obj;

		if (getIsLabeledVersionPredicate().negate().test(cmsVersionData.getUid()))
		{
			errors.rejectValue(FIELD_UID, VERSION_REMOVE_INVALID_VERSION_UID);
		}
	}

	protected Predicate<String> getIsLabeledVersionPredicate()
	{
		return isLabeledVersionPredicate;
	}

	@Required
	public void setIsLabeledVersionPredicate(final Predicate<String> isLabeledVersionPredicate)
	{
		this.isLabeledVersionPredicate = isLabeledVersionPredicate;
	}
}
