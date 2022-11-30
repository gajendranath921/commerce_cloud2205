/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.odata2services.odata.errors;

import de.hybris.platform.inboundservices.persistence.PersistenceContext;
import de.hybris.platform.inboundservices.persistence.impl.PersistenceFailedException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.servicelayer.exceptions.SystemException;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;

/**
 * A populator that handles {@link de.hybris.platform.inboundservices.persistence.impl.PersistenceFailedException}s and turns them
 * into client responses.
 */
public class PersistenceFailedExceptionContextPopulator implements ErrorContextPopulator
{
	private static final String MESSAGE_TEMPLATE = "An error occurred while attempting to save entries for entityType: %s";
	private static final String DETAILED_MESSAGE_TEMPLATE = MESSAGE_TEMPLATE + ", with error message %s";

	@Override
	public void populate(final ODataErrorContext context)
	{
		if (context.getException() instanceof PersistenceFailedException)
		{
			final PersistenceFailedException exception = (PersistenceFailedException) context.getException();
			context.setHttpStatus(deriveStatus(exception));
			context.setErrorCode(deriveErrorCode(exception));
			context.setMessage(generateMessage(exception));
			context.setLocale(Locale.ENGLISH);
			context.setInnerError(deriveIntegrationKey(exception.getPersistenceContext()));
		}
	}

	@Override
	public Class<? extends Exception> getExceptionClass()
	{
		return PersistenceFailedException.class;
	}

	private static String generateMessage(final PersistenceFailedException ex)
	{
		final var itemType = ex.getPersistenceContext() != null
				? ex.getPersistenceContext().getIntegrationItem().getItemType().getItemCode()
				: null;
		return generateMessage(itemType, ex.getCause());
	}

	private static String generateMessage(final String type, final Throwable cause)
	{
		if (isCausedByRequest(cause))
		{
			return String.format(DETAILED_MESSAGE_TEMPLATE, type, extractExceptionCauseDetail(cause));
		}
		else if (cause instanceof SystemException)
		{
			return String.format(DETAILED_MESSAGE_TEMPLATE, type, cause.getMessage());
		}
		return String.format(MESSAGE_TEMPLATE, type);
	}

	private static String extractExceptionCauseDetail(final Throwable t)
	{
		return messageContainsPackageAndClassName(t) ? extractDetailMessageWithoutClassName(t) : t.getCause().getMessage();
	}

	private static String extractDetailMessageWithoutClassName(final Throwable t)
	{
		return StringUtils.substringAfter(t.getCause().getMessage(), "]:");
	}

	private static boolean messageContainsPackageAndClassName(final Throwable t)
	{
		return t.getCause().getMessage().contains("]:");
	}

	private static String deriveErrorCode(final PersistenceFailedException t)
	{
		final var cause = t.getCause();
		return isCausedByRequest(cause)
				? "invalid_attribute_value"
				: "internal_error";
	}

	private static HttpStatusCodes deriveStatus(final PersistenceFailedException ex)
	{
		final var cause = ex.getCause();
		return isCausedByRequest(cause)
				? HttpStatusCodes.BAD_REQUEST
				: HttpStatusCodes.INTERNAL_SERVER_ERROR;
	}

	private static boolean isCausedByRequest(final Throwable t)
	{
		return t != null && (t.getCause() instanceof InterceptorException
				|| t.getCause() instanceof JaloInvalidParameterException);
	}

	private static String deriveIntegrationKey(final PersistenceContext context)
	{
		return context != null ? context.getIntegrationItem().getIntegrationKey() : null;
	}
}
