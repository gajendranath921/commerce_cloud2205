/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.config.cache.impl;

import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.regioncache.CacheValueLoadException;
import de.hybris.platform.regioncache.key.CacheKey;
import de.hybris.platform.regioncache.test.TestCacheKey;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.daos.SolrFacetSearchConfigDao;
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultFacetSearchConfigCacheValueLoaderTest
{
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private static final String FACET_SEARCH_CONFIG_NAME = "testFacetSearchConfig";
	private static final String NOT_EXISTING_CONFIG = "notExistingConfig";

	private static final String LANG_EN = "en";
	private static final String TENANT_ID = "junit";

	private DefaultFacetSearchConfigCacheValueLoader facetSearchConfigCacheValueLoader;
	private SolrFacetSearchConfigModel solrFacetSearchConfigModel;
	private FacetSearchConfig facetSearchConfig;

	@Mock
	private SolrFacetSearchConfigDao solrFacetSearchConfigDao;

	@Mock
	private Converter<SolrFacetSearchConfigModel, FacetSearchConfig> solrFacetSearchConfigConverter;

	@Before
	public void setUp()
	{
		facetSearchConfigCacheValueLoader = new DefaultFacetSearchConfigCacheValueLoader();
		facetSearchConfigCacheValueLoader.setSolrFacetSearchConfigConverter(solrFacetSearchConfigConverter);
		facetSearchConfigCacheValueLoader.setSolrFacetSearchConfigDao(solrFacetSearchConfigDao);

		facetSearchConfig = new FacetSearchConfig();
		facetSearchConfig.setName(FACET_SEARCH_CONFIG_NAME);
		solrFacetSearchConfigModel = new SolrFacetSearchConfigModel();
		solrFacetSearchConfigModel.setName(FACET_SEARCH_CONFIG_NAME);
	}

	@Test
	public void testLoad()
	{
		//given
		final FacetSearchConfigCacheKey key = new FacetSearchConfigCacheKey(FACET_SEARCH_CONFIG_NAME, LANG_EN, TENANT_ID);
		given(solrFacetSearchConfigDao.findFacetSearchConfigByName(FACET_SEARCH_CONFIG_NAME))
				.willReturn(solrFacetSearchConfigModel);
		given(solrFacetSearchConfigConverter.convert(solrFacetSearchConfigModel)).willReturn(facetSearchConfig);

		//when
		final FacetSearchConfig config = facetSearchConfigCacheValueLoader.load(key);

		//then
		Assert.assertEquals(facetSearchConfig, config);
	}

	@Test
	public void testLoadNotExistingObject()
	{
		//given
		final FacetSearchConfigCacheKey key = new FacetSearchConfigCacheKey(NOT_EXISTING_CONFIG, LANG_EN, TENANT_ID);
		given(solrFacetSearchConfigDao.findFacetSearchConfigByName(NOT_EXISTING_CONFIG))
				.willThrow(new UnknownIdentifierException("Facet search configuration not foundk"));

		// expect
		expectedException.expect(CacheValueLoadException.class);

		//when
		facetSearchConfigCacheValueLoader.load(key);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoadWithIncorectKeyType()
	{
		//given
		final CacheKey key = new TestCacheKey("test");

		//when
		facetSearchConfigCacheValueLoader.load(key);
	}
}
