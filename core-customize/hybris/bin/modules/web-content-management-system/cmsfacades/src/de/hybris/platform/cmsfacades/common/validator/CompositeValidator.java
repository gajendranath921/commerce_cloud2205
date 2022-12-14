/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * It has a composite of {@link Validator} <br>
 * Iterates and executes validate for each {@link Validator}
 */
public class CompositeValidator implements Validator
{

	private List<Validator> validators;

	@Override
	public boolean supports(final Class<?> clazz)
	{
		return getValidators().stream().map(v -> v.supports(clazz)).reduce(true, (a, b) -> a && b);
	}

	@Override
	public void validate(final Object value, final Errors errors)
	{
		getValidators().forEach(validator -> validator.validate(value, errors));
	}

	protected List<Validator> getValidators()
	{
		return validators;
	}

	@Required
	public void setValidators(final List<Validator> validators)
	{
		this.validators = validators;
	}
}
