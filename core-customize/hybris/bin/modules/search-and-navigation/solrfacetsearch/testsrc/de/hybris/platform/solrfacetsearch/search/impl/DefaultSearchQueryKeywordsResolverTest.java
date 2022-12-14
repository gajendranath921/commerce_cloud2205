/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.search.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.search.Keyword;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSearchQueryKeywordsResolverTest
{
	private static final String KEYWORD1 = "keyword1";
	private static final String KEYWORD2 = "keyword2";
	private static final String KEYWORD3 = "keyword3";

	private DefaultSearchQueryKeywordsResolver defaultSearchQueryKeywordsResolver;

	private FacetSearchConfig facetSearchConfig;
	private IndexedType indexedType;

	@Before
	public void setUp()
	{
		defaultSearchQueryKeywordsResolver = new DefaultSearchQueryKeywordsResolver();
		facetSearchConfig = new FacetSearchConfig();
		indexedType = new IndexedType();
	}

	@Test
	public void testResolveKeywordsUserQueryNull()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType, null);

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(0);
	}

	@Test
	public void testResolveKeywordsUserQueryEmpty()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType, "");

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(0);
	}

	@Test
	public void testResolveKeywordsUserQueryWithSpace()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType,
				KEYWORD1 + " " + KEYWORD2);

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(2);
		assertThat(keywords).extracting(Keyword::getValue).contains(KEYWORD1, KEYWORD2);
	}

	@Test
	public void testResolveKeywordsUserQueryWithMultipleSpaces()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType,
				KEYWORD1 + "      " + KEYWORD2);

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(2);
		assertThat(keywords).extracting(Keyword::getValue).contains(KEYWORD1, KEYWORD2);
	}

	@Test
	public void testResolveKeywordsUserQueryWithOnlySpaces()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType, "      ");

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(0);
	}

	@Test
	public void testResolveKeywordsUserQueryWithQuotes()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType,
				"\"" + KEYWORD1 + " " + KEYWORD2 + "\"");

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(1);
		assertThat(keywords).extracting(Keyword::getValue).contains(KEYWORD1 + " " + KEYWORD2);
	}

	@Test
	public void testResolveKeywordsUserQueryWithMultipleSpacesInsideQuotes()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType,
				"\"" + KEYWORD1 + "      " + KEYWORD2 + "\"");

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(1);
		assertThat(keywords).extracting(Keyword::getValue).contains(KEYWORD1 + " " + KEYWORD2);
	}

	@Test
	public void testResolveKeywordsUserQueryWithMultipleQuotes()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType,
				"\"" + KEYWORD1 + " " + KEYWORD2 + "\"\"" + KEYWORD2 + " " + KEYWORD3 + "\"");

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(2);
		assertThat(keywords).extracting(Keyword::getValue).contains(KEYWORD1 + " " + KEYWORD2, KEYWORD2 + " " + KEYWORD3);
	}

	@Test
	public void testResolveKeywordsUserQueryWithOnlyQuotes1()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType,
				"\"\"\"\"");

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(0);
	}

	@Test
	public void testResolveKeywordsUserQueryWithOnlyQuotes2()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType, "\"\"\"");

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(1);
		assertThat(keywords).extracting(Keyword::getValue).contains("\"");
	}

	@Test
	public void testResolveKeywordsUserQueryWithSpacesAndQuotes()
	{
		// when
		final List<Keyword> keywords = defaultSearchQueryKeywordsResolver.resolveKeywords(facetSearchConfig, indexedType,
				KEYWORD1 + " \"" + KEYWORD1 + " " + KEYWORD2 + "\" " + KEYWORD2);

		// then
		assertThat(keywords).isNotNull();
		assertThat(keywords).hasSize(3);
		assertThat(keywords).extracting(Keyword::getValue).contains(KEYWORD1, KEYWORD1 + " " + KEYWORD2, KEYWORD2);
	}
}
