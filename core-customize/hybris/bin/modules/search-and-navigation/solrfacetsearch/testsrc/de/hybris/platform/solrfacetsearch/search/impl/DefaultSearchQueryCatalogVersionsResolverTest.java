/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.search.impl;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DefaultSearchQueryCatalogVersionsResolverTest
{
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private DefaultSearchQueryCatalogVersionsResolver resolver;
	private FacetSearchConfig facetSearchConfig;
	private IndexedType indexedType;
	private IndexConfig indexConfig;

	@Mock
	private CatalogVersionModel catalogVersion1;

	@Mock
	private CatalogVersionModel catalogVersion2;

	@Mock
	private CatalogVersionService catalogVersionService;

	@Before
	public void setUp()
	{
		resolver = new DefaultSearchQueryCatalogVersionsResolver();
		facetSearchConfig = new FacetSearchConfig();
		indexedType = new IndexedType();
		indexConfig = new IndexConfig();
		facetSearchConfig.setIndexConfig(indexConfig);

		resolver.setCatalogVersionService(catalogVersionService);
	}

	@Test
	public void testNullSource()
	{
		// expect
		expectedException.expect(IllegalArgumentException.class);

		// when
		resolver.resolveCatalogVersions(null, null);
	}

	@Test
	public void testFacetConfigWithNoCatalogVersionsSource()
	{
		// when
		indexConfig.setCatalogVersions(null);

		// given
		final List<CatalogVersionModel> resolvedCatalogVersions = resolver.resolveCatalogVersions(facetSearchConfig, indexedType);

		// then
		assertThat(resolvedCatalogVersions).isEmpty();
	}

	@Test
	public void testFacetConfigWithEmptyCatalogVersionsSource()
	{
		// when
		indexConfig.setCatalogVersions(Collections.emptyList());

		// given
		final List<CatalogVersionModel> resolvedCatalogVersions = resolver.resolveCatalogVersions(facetSearchConfig, indexedType);

		// then
		assertThat(resolvedCatalogVersions).isEmpty();
	}

	@Test
	public void testTwoSessionCatalogVersionButOnlyOneConfigured()
	{
		// when
		indexConfig.setCatalogVersions(Arrays.asList(catalogVersion2));
		given(catalogVersionService.getSessionCatalogVersions()).willReturn(Arrays.asList(catalogVersion1, catalogVersion2));

		// given
		final List<CatalogVersionModel> resolvedCatalogVersions = resolver.resolveCatalogVersions(facetSearchConfig, indexedType);

		// then
		assertThat(resolvedCatalogVersions).containsOnly(catalogVersion2);
	}

	@Test
	public void testOneSessionCatalogVersionButTwoConfigured()
	{
		// when
		indexConfig.setCatalogVersions(Arrays.asList(catalogVersion1, catalogVersion2));
		given(catalogVersionService.getSessionCatalogVersions()).willReturn(Arrays.asList(catalogVersion1));

		// given
		final List<CatalogVersionModel> resolvedCatalogVersions = resolver.resolveCatalogVersions(facetSearchConfig, indexedType);

		//then
		assertThat(resolvedCatalogVersions).containsOnly(catalogVersion1);
	}

	@Test
	public void testExclusiveCase()
	{
		// when
		indexConfig.setCatalogVersions(Arrays.asList(catalogVersion1));
		given(catalogVersionService.getSessionCatalogVersions()).willReturn(Arrays.asList(catalogVersion2));

		// given
		final List<CatalogVersionModel> resolvedCatalogVersions = resolver.resolveCatalogVersions(facetSearchConfig, indexedType);

		// then
		assertThat(resolvedCatalogVersions).isEmpty();
	}

	@Test
	public void testBothCatalogVersionsMatch()
	{
		// when
		indexConfig.setCatalogVersions(Arrays.asList(catalogVersion1, catalogVersion2));
		given(catalogVersionService.getSessionCatalogVersions()).willReturn(Arrays.asList(catalogVersion1, catalogVersion2));

		// given
		final List<CatalogVersionModel> resolvedCatalogVersions = resolver.resolveCatalogVersions(facetSearchConfig, indexedType);

		//then
		assertThat(resolvedCatalogVersions).containsExactly(catalogVersion1, catalogVersion2);
	}

}
