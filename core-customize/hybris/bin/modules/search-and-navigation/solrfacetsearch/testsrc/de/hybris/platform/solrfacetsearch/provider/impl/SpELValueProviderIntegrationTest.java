/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.provider.impl;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.constants.SolrfacetsearchConstants;
import de.hybris.platform.solrfacetsearch.integration.AbstractIntegrationTest;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.util.Collection;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;


@IntegrationTest
public class SpELValueProviderIntegrationTest extends AbstractIntegrationTest
{
	protected static final String HW2300_2356_PROD_CODE = "HW2300-2356";
	protected static final Float HW2300_2356_PROD_PRICE_EUR = 157.95f;
	protected static final Float HW2300_2356_PROD_PRICE_USD = 217.97f;

	@Resource
	private CatalogVersionService catalogVersionService;

	@Resource
	private SpELValueProvider springELValueProvider;

	@Resource
	private ProductService productService;

	private final PropertyConfigSwitcher fullSpELSupport = new PropertyConfigSwitcher(
			SolrfacetsearchConstants.FULL_SPEL_SUPPPORT_PROPERTY);

	@After
	public void cleanup()
	{
		fullSpELSupport.switchBackToDefault();
	}

	@Test
	public void testUsingExpression() throws Exception
	{
		final FacetSearchConfig facetSearchConfig = getFacetSearchConfig();

		final IndexConfig indexConfig = facetSearchConfig.getIndexConfig();
		assertThat(indexConfig).isNotNull();

		final IndexedType indexedType = facetSearchConfig.getIndexConfig().getIndexedTypes().values().iterator().next();
		assertThat(indexedType).isNotNull();

		final IndexedProperty indexedProperty = indexedType.getIndexedProperties().get("code");
		assertThat(indexedProperty).isNotNull();
		indexedProperty.setValueProviderParameter("code");

		final CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion("hwcatalog", "Online");
		final ProductModel product = productService.getProductForCode(catalogVersion, HW2300_2356_PROD_CODE);
		assertThat(product).isNotNull();

		final Collection<FieldValue> fieldValues = springELValueProvider.getFieldValues(indexConfig, indexedProperty, product);

		assertThat(fieldValues).hasSize(1);
		assertThat(fieldValues.iterator().next().getFieldName()).isEqualTo("code_string");
		assertThat(fieldValues.iterator().next().getValue()).isEqualTo(HW2300_2356_PROD_CODE);
	}

	@Test
	public void testWithoutExpression() throws Exception
	{
		final FacetSearchConfig facetSearchConfig = getFacetSearchConfig();

		final IndexConfig indexConfig = facetSearchConfig.getIndexConfig();
		assertThat(indexConfig).isNotNull();

		final IndexedType indexedType = facetSearchConfig.getIndexConfig().getIndexedTypes().values().iterator().next();
		assertThat(indexedType).isNotNull();

		final IndexedProperty indexedProperty = indexedType.getIndexedProperties().get("code");
		assertThat(indexedProperty).isNotNull();

		final CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion("hwcatalog", "Online");
		final ProductModel product = productService.getProductForCode(catalogVersion, HW2300_2356_PROD_CODE);
		assertThat(product).isNotNull();

		final Collection<FieldValue> fieldValues = springELValueProvider.getFieldValues(indexConfig, indexedProperty, product);

		assertThat(fieldValues).hasSize(1);
		assertThat(fieldValues.iterator().next().getFieldName()).isEqualTo("code_string");
		assertThat(fieldValues.iterator().next().getValue()).isEqualTo(HW2300_2356_PROD_CODE);
	}

	@Test
	public void testWithExpressionMultilanguage() throws Exception
	{
		fullSpELSupport.switchToValue(Boolean.TRUE.toString());

		final FacetSearchConfig facetSearchConfig = getFacetSearchConfig();

		final IndexConfig indexConfig = facetSearchConfig.getIndexConfig();
		assertThat(indexConfig).isNotNull();

		final IndexedType indexedType = facetSearchConfig.getIndexConfig().getIndexedTypes().values().iterator().next();
		assertThat(indexedType).isNotNull();

		final IndexedProperty indexedProperty = indexedType.getIndexedProperties().get("name");
		assertThat(indexedProperty).isNotNull();
		indexedProperty.setValueProviderParameter("getName(#lang)");

		final CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion("hwcatalog", "Online");
		final ProductModel product = productService.getProductForCode(catalogVersion, HW2300_2356_PROD_CODE);
		assertThat(product).isNotNull();

		final Collection<FieldValue> fieldValues = springELValueProvider.getFieldValues(indexConfig, indexedProperty, product);

		assertThat(fieldValues).hasSize(4);
		assertThat(fieldValues).onProperty("fieldName").contains("name_text_de", "name_sortable_de_sortabletext", "name_text_en",
				"name_sortable_en_sortabletext");
	}

	@Test
	public void testWithExpressionMulticurrency() throws Exception
	{
		fullSpELSupport.switchToValue(Boolean.TRUE.toString());

		final FacetSearchConfig facetSearchConfig = getFacetSearchConfig();

		final IndexConfig indexConfig = facetSearchConfig.getIndexConfig();
		assertThat(indexConfig).isNotNull();

		final IndexedType indexedType = indexConfig.getIndexedTypes().values().iterator().next();
		assertThat(indexedType).isNotNull();

		final IndexedProperty indexedProperty = indexedType.getIndexedProperties().get("price");
		assertThat(indexedProperty).isNotNull();
		indexedProperty.setValueProviderParameter(
				"T(String).format('%.2f', @priceService.getPriceInformationsForProduct(#item).![priceValue].?[currencyIso == #currency.isocode].![value])");

		final CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion("hwcatalog", "Online");
		final ProductModel product = productService.getProductForCode(catalogVersion, HW2300_2356_PROD_CODE);
		assertThat(product).isNotNull();

		final Collection<FieldValue> fieldValues = springELValueProvider.getFieldValues(indexConfig, indexedProperty, product);

		assertThat(fieldValues).hasSize(2);
		assertThat(fieldValues).onProperty("fieldName").containsOnly("price_eur_string", "price_usd_string");
		assertThat(fieldValues).onProperty("value").containsOnly(
				String.format(Locale.getDefault(), "%.2f", HW2300_2356_PROD_PRICE_EUR),
				String.format(Locale.getDefault(), "%.2f", HW2300_2356_PROD_PRICE_USD));
	}
}
