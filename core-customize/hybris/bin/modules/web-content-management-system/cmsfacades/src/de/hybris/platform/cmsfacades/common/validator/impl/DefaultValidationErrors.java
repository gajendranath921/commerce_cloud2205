/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.validator.impl;

import static java.util.Collections.asLifoQueue;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.joining;

import de.hybris.platform.cmsfacades.common.validator.ValidationErrors;
import de.hybris.platform.cmsfacades.validator.data.ValidationError;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Default implementation of {@link ValidationErrors}.
 * It manages a list of Validation Errors and supports multilevel field structure by storing field names in a stack.
 */
public class DefaultValidationErrors implements ValidationErrors, Serializable
{
	private static final long serialVersionUID = -9074846244002405869L;

	protected static final String SEPARATOR = ".";

	private final Deque<String> fieldStack = new LinkedList<>();

	private final List<ValidationError> validationErrors = new LinkedList<>();

	@Override
	public void add(final ValidationError validationError)
	{
		if (!getFieldStack().isEmpty())
		{
			validationError.setField(parseFieldStack() + SEPARATOR + validationError.getField());
		}
		validationErrors.add(validationError);
	}

	@Override
	public void pushField(final String field)
	{
		fieldStack.push(field);
	}

	@Override
	public void popField()
	{
		fieldStack.pop();
	}

	@Override
	public List<ValidationError> getValidationErrors()
	{
		return unmodifiableList(validationErrors);
	}

	@Override
	public String parseFieldStack()
	{
		return fieldStack.stream().collect(joining(SEPARATOR));
	}

	protected Queue<String> getFieldStack()
	{
		return asLifoQueue(fieldStack);
	}
}
