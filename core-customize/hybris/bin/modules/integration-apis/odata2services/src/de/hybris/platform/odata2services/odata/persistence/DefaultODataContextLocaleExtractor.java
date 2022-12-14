/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.odata.persistence;

import de.hybris.platform.integrationservices.service.IntegrationLocalizationService;
import de.hybris.platform.integrationservices.util.Log;

import java.util.Locale;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.apache.olingo.odata2.api.commons.HttpHeaders;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Required;

/**
 * Default implementation of {@link ODataContextLanguageExtractor}
 */
public class DefaultODataContextLocaleExtractor implements ODataContextLanguageExtractor
{
	private static final String LOCALE_WILDCARD = "*";
	private static final Logger LOG = Log.getLogger(DefaultODataContextLocaleExtractor.class);
	private IntegrationLocalizationService localizationService;

	@Override
	public Locale extractFrom(final ODataContext oDataContext, final String headerName)
	{
		Preconditions.checkArgument(
				HttpHeaders.ACCEPT_LANGUAGE.equals(headerName) || HttpHeaders.CONTENT_LANGUAGE.equals(headerName),
				"Language header not supported. Please use Accept-Language or Content-Language when defining the request language.");

		final Optional<String> optionalLanguage = extractLanguageFromHeader(oDataContext, headerName);

		if (optionalLanguage.isPresent())
		{
			final Locale locale = getLocale(optionalLanguage.get());
			LOG.trace("Using following Locale from {}: {}", headerName, locale);
			return locale;
		}

		return getPlatformDefaultLocale();
	}

	private Locale getLocale(final String languageTag)
	{
		return getLocalizationService().getSupportedLocaleForLanguageTag(languageTag);
	}

	private Optional<String> extractLanguageFromHeader(final ODataContext oDataContext, final String headerName)
	{
		return HttpHeaders.ACCEPT_LANGUAGE.equals(headerName)
				? extractAcceptLanguage(oDataContext)
				: extractContentLanguage(oDataContext);
	}

	private Locale getPlatformDefaultLocale()
	{
		final Locale defaultLocale = getLocalizationService().getDefaultLocale();
		LOG.trace("Use default content language: {}", defaultLocale);
		return defaultLocale;
	}

	@Override
	public Optional<Locale> getAcceptLanguage(final ODataContext oDataContext)
	{
		final Optional<String> language = extractAcceptLanguage(oDataContext);
		return language.map(lang -> extractFrom(oDataContext, HttpHeaders.ACCEPT_LANGUAGE));
	}

	private Optional<String> extractAcceptLanguage(final ODataContext oDataContext)
	{
		final Optional<Locale> optionalLocale = oDataContext.getAcceptableLanguages().stream().findFirst();
		return optionalLocale.isPresent() && containsALanguage(optionalLocale.get().toString()) ? Optional.of(
				optionalLocale.get().toString()) : Optional.empty();
	}

	protected Optional<String> extractContentLanguage(final ODataContext oDataContext)
	{
		final String languageRange = oDataContext.getRequestHeader(HttpHeaders.CONTENT_LANGUAGE);
		return containsALanguage(languageRange) ? Optional.of(languageRange) : Optional.empty();
	}

	protected boolean containsALanguage(final String language)
	{
		return StringUtils.isNotEmpty(language) && !LOCALE_WILDCARD.equals(language);
	}

	protected IntegrationLocalizationService getLocalizationService()
	{
		return localizationService;
	}

	@Required
	public void setLocalizationService(final IntegrationLocalizationService service)
	{
		localizationService = service;
	}
}
