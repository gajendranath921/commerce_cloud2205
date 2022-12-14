/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.provider.impl;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.servicelayer.session.Session;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.QualifierProvider;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractValueResolverTest
{
	protected static final String INDEXED_PROPERTY_NAME = "indexedProperty";

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Mock
	private SessionService sessionService;

	@Mock
	private QualifierProvider qualifierProvider;

	@Mock
	private JaloSession jaloSession;

	@Mock
	private InputDocument inputDocument;

	@Mock
	private IndexerBatchContext batchContext;

	private FacetSearchConfig facetSearchConfig;

	private IndexConfig indexConfig;

	private IndexedType indexedType;

	private IndexedProperty indexedProperty;

	protected SessionService getSessionService()
	{
		return sessionService;
	}

	protected QualifierProvider getQualifierProvider()
	{
		return qualifierProvider;
	}

	protected InputDocument getInputDocument()
	{
		return inputDocument;
	}

	protected IndexerBatchContext getBatchContext()
	{
		return batchContext;
	}

	protected FacetSearchConfig getFacetSearchConfig()
	{
		return facetSearchConfig;
	}

	protected IndexConfig getIndexConfig()
	{
		return indexConfig;
	}

	protected IndexedType getIndexedType()
	{
		return indexedType;
	}

	protected IndexedProperty getIndexedProperty()
	{
		return indexedProperty;
	}

	@Before
	public void setUpAbstractValueResolverTest()
	{
		when(sessionService.getRawSession(nullable(Session.class))).thenReturn(jaloSession);

		facetSearchConfig = new FacetSearchConfig();
		indexConfig = new IndexConfig();
		indexedType = new IndexedType();

		facetSearchConfig.setIndexConfig(indexConfig);

		when(batchContext.getFacetSearchConfig()).thenReturn(facetSearchConfig);
		when(batchContext.getIndexedType()).thenReturn(indexedType);

		indexedProperty = new IndexedProperty();
		indexedProperty.setName(INDEXED_PROPERTY_NAME);
		indexedProperty.setValueProviderParameters(new HashMap<String, String>());
		indexedProperty.setLocalized(false);
	}
}
