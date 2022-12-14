/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.catalog.impl;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.withSettings;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.catalog.CatalogOption;
import de.hybris.platform.commercefacades.catalog.PageOption;
import de.hybris.platform.commercefacades.catalog.converters.populator.CatalogHierarchyPopulator;
import de.hybris.platform.commercefacades.catalog.converters.populator.CatalogVersionPopulator;
import de.hybris.platform.commercefacades.catalog.converters.populator.CategoryHierarchyPopulator;
import de.hybris.platform.commercefacades.catalog.data.CatalogData;
import de.hybris.platform.commercefacades.catalog.data.CatalogVersionData;
import de.hybris.platform.commercefacades.catalog.data.CategoryHierarchyData;
import de.hybris.platform.site.BaseSiteService;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.ImmutableSet;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultCatalogFacadeTest
{
	@InjectMocks
	DefaultCatalogFacade catalogFacade = new DefaultCatalogFacade();

	@Mock
	private CatalogService catalogService;
	@Mock
	private CategoryService categoryService;
	@Mock
	private CatalogVersionService catalogVersionService;
	@Mock
	private CatalogHierarchyPopulator catalogHierarchyPopulator;
	@Mock
	private CatalogVersionPopulator catalogVersionPopulator;
	@Mock
	private CategoryHierarchyPopulator categoryHierarchyPopulator;
	@Mock
	private BaseSiteService baseSiteService;

	static final String CATALOG_ID = "hwcatalog";

	private static final String CATALOG_VERSION_ID = "Online";

	private static final String CATEGORY_ID = "HW-1000";

	@Test
	public void testGetAllCatalogsWithOptions()
	{
		final CatalogModel mockCatalog = Mockito.mock(CatalogModel.class);
		given(mockCatalog.getId()).willReturn(CATALOG_ID);
		given(catalogService.getCatalogForId(CATALOG_ID)).willReturn(mockCatalog);

		given(catalogService.getAllCatalogs()).willReturn(ImmutableSet.of(mockCatalog));

		final List<CatalogData> catalogs = catalogFacade.getAllCatalogsWithOptions(ImmutableSet.of(CatalogOption.BASIC));

		assertThat(catalogs).hasSize(1);
		final CatalogData catalog = catalogs.get(0);
		assertThat(catalog.getId()).isEqualTo("hwcatalog");

		Mockito.verify(catalogHierarchyPopulator).populate(mockCatalog, catalog, ImmutableSet.of(CatalogOption.BASIC));
	}

	@Test
	public void testGetCatalogByIdAndOptions()
	{
		final CatalogModel mockCatalog = Mockito.mock(CatalogModel.class, withSettings().lenient());
		given(mockCatalog.getId()).willReturn(CATALOG_ID);
		given(catalogService.getCatalogForId(CATALOG_ID)).willReturn(mockCatalog);

		final CatalogData catalog = catalogFacade.getCatalogByIdAndOptions(CATALOG_ID, ImmutableSet.of(CatalogOption.BASIC));

		assertThat(catalog.getId()).isEqualTo("hwcatalog");

		Mockito.verify(catalogHierarchyPopulator).populate(mockCatalog, catalog, ImmutableSet.of(CatalogOption.BASIC));
	}

	@Test
	public void testGetCatalogVersionByIdAndOptions()
	{
		final CatalogVersionModel mockCatalogVersion = Mockito.mock(CatalogVersionModel.class, withSettings().lenient());
		given(mockCatalogVersion.getVersion()).willReturn(CATALOG_VERSION_ID);
		given(catalogVersionService.getCatalogVersion(CATALOG_ID, CATALOG_VERSION_ID)).willReturn(mockCatalogVersion);

		final CatalogVersionData catalogVersion = catalogFacade.getCatalogVersionByIdAndOptions(CATALOG_ID, CATALOG_VERSION_ID,
				ImmutableSet.of(CatalogOption.BASIC));

		assertThat(catalogVersion.getUrl()).isEqualTo("/hwcatalog/Online");

		Mockito.verify(catalogVersionPopulator).populate(mockCatalogVersion, catalogVersion, ImmutableSet.of(CatalogOption.BASIC));
	}

	@Test
	public void testGetCategoryById()
	{
		final CatalogModel mockCatalog = Mockito.mock(CatalogModel.class);
		final CatalogVersionModel mockCatalogVersion = Mockito.mock(CatalogVersionModel.class);
		final CategoryModel mockCategory = Mockito.mock(CategoryModel.class);
		final BaseSiteModel mockBaseSite = Mockito.mock(BaseSiteModel.class);
		given(mockCatalog.getId()).willReturn(CATALOG_ID);
		given(mockCatalogVersion.getVersion()).willReturn(CATALOG_VERSION_ID);
		given(baseSiteService.getCurrentBaseSite()).willReturn(mockBaseSite);
		given(baseSiteService.getProductCatalogs(mockBaseSite)).willReturn(Collections.singletonList(mockCatalog));
		given(mockCatalog.getCatalogVersions()).willReturn(Collections.singleton(mockCatalogVersion));
		given(categoryService.getCategoryForCode(mockCatalogVersion, CATEGORY_ID)).willReturn(mockCategory);
		final PageOption page = PageOption.createWithoutLimits();

		final CategoryHierarchyData categoryData = catalogFacade.getCategoryById(CATALOG_ID, CATALOG_VERSION_ID, CATEGORY_ID, page,
				ImmutableSet.of(CatalogOption.BASIC));

		assertThat(categoryData.getUrl()).isEqualTo("hwcatalog/Online");

		Mockito.verify(categoryHierarchyPopulator).populate(mockCategory, categoryData, ImmutableSet.of(CatalogOption.BASIC), page);
	}
}
