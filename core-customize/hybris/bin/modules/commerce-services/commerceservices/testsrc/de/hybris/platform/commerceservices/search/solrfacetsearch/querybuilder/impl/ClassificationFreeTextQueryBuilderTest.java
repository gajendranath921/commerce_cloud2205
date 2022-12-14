/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.search.solrfacetsearch.querybuilder.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.config.SearchConfig;
import de.hybris.platform.solrfacetsearch.search.RawQuery;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ClassificationFreeTextQueryBuilderTest
{
	private ClassificationFreeTextQueryBuilder classificationFreeTextQueryBuilder;

	@Mock
	private FacetSearchConfig facetSearchConfig;
	@Mock(lenient = true)
	private SearchConfig searchConfig;

	@Before
	public void setUp()
	{
		classificationFreeTextQueryBuilder = new ClassificationFreeTextQueryBuilder();

		given(facetSearchConfig.getSearchConfig()).willReturn(searchConfig);
		given(searchConfig.getDefaultSortOrder()).willReturn(Collections.<String> emptyList());
	}

	@Test
	public void testConvert()
	{
		final IndexedType indexedType = mock(IndexedType.class);
		final SearchQuery searchQuery = spy(new SearchQuery(facetSearchConfig, indexedType));
		searchQuery.setLanguage("en");
		searchQuery.setCurrency("GBP");

		final ClassAttributeAssignmentModel classAttributeAssignmentModel = mock(ClassAttributeAssignmentModel.class);
		given(classAttributeAssignmentModel.getSearchable()).willReturn(Boolean.TRUE);

		final IndexedProperty commerceIndexedProperty = new IndexedProperty();
		commerceIndexedProperty.setName("code");
		commerceIndexedProperty.setType("string");

		commerceIndexedProperty.setClassAttributeAssignment(classAttributeAssignmentModel);
		given(indexedType.getIndexedProperties()).willReturn(Collections.singletonMap("code", commerceIndexedProperty));

		//	given(indexedType.getIndexedProperties()).willReturn(Collections.singleton((IndexedProperty) commerceIndexedProperty));

		classificationFreeTextQueryBuilder.setBoost(10);
		classificationFreeTextQueryBuilder.addFreeTextQuery(searchQuery, "full text string", new String[]
		{ "full", "text", "string" });

		verify(searchQuery).addRawQuery(new RawQuery("code", "full\\ text\\ string^20.0", SearchQuery.Operator.OR));
		verify(searchQuery).addRawQuery(new RawQuery("code", "full\\ text\\ string*^10.0", SearchQuery.Operator.OR));
		verify(searchQuery).addRawQuery(new RawQuery("code", "full^10.0", SearchQuery.Operator.OR));
		verify(searchQuery).addRawQuery(new RawQuery("code", "full*^5.0", SearchQuery.Operator.OR));
		verify(searchQuery).addRawQuery(new RawQuery("code", "text^10.0", SearchQuery.Operator.OR));
		verify(searchQuery).addRawQuery(new RawQuery("code", "text*^5.0", SearchQuery.Operator.OR));
		verify(searchQuery).addRawQuery(new RawQuery("code", "string^10.0", SearchQuery.Operator.OR));
		verify(searchQuery).addRawQuery(new RawQuery("code", "string*^5.0", SearchQuery.Operator.OR));
	}
}
