/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.validator.impl;

import de.hybris.platform.cmsfacades.common.validator.ValidatableService;
import de.hybris.platform.cmsfacades.common.validator.ValidationErrors;
import de.hybris.platform.cmsfacades.common.validator.ValidationErrorsProvider;
import de.hybris.platform.cmsfacades.exception.ValidationException;

import java.util.Collection;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Required;

/**
 * Default Implementation of the {@link ValidatableService}. 
 * This implementation executes the validatable supplier and then checks if there are errors registered. 
 * If there are errors present in current {@link ValidationErrors}, then it throws a validation exception with the list of Errors.   
 */
public class DefaultValidatableService implements ValidatableService
{
	private ValidationErrorsProvider validationErrorsProvider;

	@Override
	public <T> T execute(final Supplier<T> validatable)
	{
		final ValidationErrors validationErrors = getValidationErrorsProvider().initializeValidationErrors();
		try
		{
			final T value = validatable.get();
			if (!isEmptyCollection(validationErrors.getValidationErrors()))
			{
				throw new ValidationException(validationErrors);
			}
			return value;
		}
		finally
		{
			getValidationErrorsProvider().finalizeValidationErrors();
		}
	}

	/**
	 * Verifies whether the collection is empty or not.
	 */
	protected boolean isEmptyCollection(final Collection<?> c) {
		return c == null || c.isEmpty();
	}

	protected ValidationErrorsProvider getValidationErrorsProvider()
	{
		return validationErrorsProvider;
	}

	@Required
	public void setValidationErrorsProvider(final ValidationErrorsProvider validationErrorsProvider)
	{
		this.validationErrorsProvider = validationErrorsProvider;
	}

}
