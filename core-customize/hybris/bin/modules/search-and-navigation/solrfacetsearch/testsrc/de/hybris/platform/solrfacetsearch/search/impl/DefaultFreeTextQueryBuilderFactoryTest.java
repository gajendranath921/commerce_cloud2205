/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.search.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.search.FreeTextQueryBuilder;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFreeTextQueryBuilderFactoryTest
{
	private static final String DEFAULT_QUERY_BUILDER = "defaultFreeTextQueryBuilder";
	private static final String DISMAX_QUERY_BUILDER = "disMaxFreeTextQueryBuilder";

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private DefaultFreeTextQueryBuilderFactory freeTextQueryBuilderFactory;

	private SearchQuery searchQuery;

	@Mock
	private BeanFactory beanFactory;

	@Before
	public void setUp()
	{
		final IndexedType indexedType = new IndexedType();
		final FacetSearchConfig facetSearchConfig = new FacetSearchConfig();
		searchQuery = new SearchQuery(facetSearchConfig, indexedType);

		freeTextQueryBuilderFactory = new DefaultFreeTextQueryBuilderFactory();
		freeTextQueryBuilderFactory.setBeanFactory(beanFactory);
	}

	@Test
	public void testDefaultFreeTextQueryBuilder()
	{
		// given
		searchQuery.setFreeTextQueryBuilder(DEFAULT_QUERY_BUILDER);

		final MultiFieldFreeTextQueryBuilder defaultFreeTextQueryBuilder = mock(MultiFieldFreeTextQueryBuilder.class);
		when(beanFactory.getBean(DEFAULT_QUERY_BUILDER, FreeTextQueryBuilder.class)).thenReturn(defaultFreeTextQueryBuilder);

		// when
		final FreeTextQueryBuilder queryBuilder = freeTextQueryBuilderFactory.createQueryBuilder(searchQuery);

		// then
		Assert.assertSame(queryBuilder, defaultFreeTextQueryBuilder);
	}

	@Test
	public void testUseDefaultWhenEmpty()
	{
		// given
		searchQuery.setFreeTextQueryBuilder(StringUtils.EMPTY);

		final MultiFieldFreeTextQueryBuilder defaultFreeTextQueryBuilder = mock(MultiFieldFreeTextQueryBuilder.class);
		when(beanFactory.getBean(DEFAULT_QUERY_BUILDER, FreeTextQueryBuilder.class)).thenReturn(defaultFreeTextQueryBuilder);

		// when
		final FreeTextQueryBuilder queryBuilder = freeTextQueryBuilderFactory.createQueryBuilder(searchQuery);

		// then
		Assert.assertSame(defaultFreeTextQueryBuilder, queryBuilder);
	}

	@Test
	public void testThrowExceptionWhenNonExistingBeanId()
	{
		// given
		searchQuery.setFreeTextQueryBuilder("test");
		when(beanFactory.getBean("test", FreeTextQueryBuilder.class)).thenThrow(new NoSuchBeanDefinitionException("test"));

		// expect
		expectedException.expect(NoSuchBeanDefinitionException.class);

		// when
		freeTextQueryBuilderFactory.createQueryBuilder(searchQuery);
	}

	@Test
	public void testFreeTextQueryBuilderCreation()
	{
		// given
		searchQuery.setFreeTextQueryBuilder(DISMAX_QUERY_BUILDER);

		final DisMaxFreeTextQueryBuilder dismaxFreeTextQueryBuilder = mock(DisMaxFreeTextQueryBuilder.class);
		when(beanFactory.getBean(DISMAX_QUERY_BUILDER, FreeTextQueryBuilder.class)).thenReturn(dismaxFreeTextQueryBuilder);

		// when
		final FreeTextQueryBuilder queryBuilder = freeTextQueryBuilderFactory.createQueryBuilder(searchQuery);

		// then
		Assert.assertSame(queryBuilder, dismaxFreeTextQueryBuilder);
	}
}
