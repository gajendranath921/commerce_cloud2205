/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.configurablebundleocc.controllers;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.order.data.CartModificationData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.data.SearchStateData;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.commerceservices.search.facetdata.ProductSearchPageData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commercewebservicescommons.dto.order.CartModificationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.facetdata.ProductSearchPageWsDTO;
import de.hybris.platform.configurablebundlefacades.order.BundleCartFacade;
import de.hybris.platform.configurablebundleocc.dto.BundleStarterWsDTO;
import de.hybris.platform.webservicescommons.mapping.DataMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ConfigurableBundleControllerTest
{
	private static final String TEMPLATE_ID = "MY_TEMPLATE_ID";
	private static final String PRODUCT_CODE = "MY_PRODUCT_CODE";
	private static final long QUANTITY = 3L;
	private static final Integer ENTRY_GROUP_NUMBER = 7;
	private static final int CURRENT_PAGE = 11;
	private static final int PAGE_SIZE = 200;
	private static final String SORT = "MY_SORT";
	private static final String FIELDS = "MY_FIELDS";
	private static final String QUERY = "MY_QUERY";

	@Mock
	private DataMapper dataMapper;
	@Mock
	private BundleCartFacade bundleCartFacade;
	@InjectMocks
	private ConfigurableBundleController controller;

	@Captor
	private ArgumentCaptor<PageableData> pageableDataCaptor;

	private final BundleStarterWsDTO bundleStarter = new BundleStarterWsDTO();
	private final CartModificationData data = new CartModificationData();
	private final CartModificationWsDTO wsDTO = new CartModificationWsDTO();
	private final ProductSearchPageWsDTO pWsDTO = new ProductSearchPageWsDTO();
	private final ProductSearchPageData<SearchStateData, ProductData> searchPageData = new ProductSearchPageData<>();

	@Before
	public void setUp() throws CommerceCartModificationException
	{
		when(bundleCartFacade.startBundle(anyString(), anyString(), anyLong())).thenReturn(data);
		when(dataMapper.map(data, CartModificationWsDTO.class)).thenReturn(wsDTO);

		bundleStarter.setTemplateId(TEMPLATE_ID);
		bundleStarter.setProductCode(PRODUCT_CODE);
		bundleStarter.setQuantity(QUANTITY);
	}

	@Test
	public void testStartBundle() throws CommerceCartModificationException
	{
		final CartModificationWsDTO cartModificationWsDTO = controller.createBundle(bundleStarter);

		verify(bundleCartFacade).startBundle(TEMPLATE_ID, PRODUCT_CODE, QUANTITY);
		verify(dataMapper).map(data, CartModificationWsDTO.class);

		assertThat(cartModificationWsDTO).isSameAs(wsDTO);
	}

	@Test
	public void testGetAvailableProducts()
	{
		when(bundleCartFacade.getAllowedProducts(anyInt(), anyString(), any())).thenReturn(searchPageData);
		when(dataMapper.map(searchPageData, ProductSearchPageWsDTO.class, FIELDS)).thenReturn(pWsDTO);

		final ProductSearchPageWsDTO productSearchPageWsDTO = controller.getAllowedProducts(QUERY, ENTRY_GROUP_NUMBER, CURRENT_PAGE, PAGE_SIZE, SORT, FIELDS);
		verify(bundleCartFacade).getAllowedProducts(eq(ENTRY_GROUP_NUMBER), eq(QUERY), pageableDataCaptor.capture());
		verify(dataMapper).map(searchPageData, ProductSearchPageWsDTO.class, FIELDS);

		assertThat(productSearchPageWsDTO).isSameAs(pWsDTO);
		assertThat(pageableDataCaptor.getValue()).isNotNull()
												 .hasFieldOrPropertyWithValue("currentPage", CURRENT_PAGE)
												 .hasFieldOrPropertyWithValue("pageSize", PAGE_SIZE)
												 .hasFieldOrPropertyWithValue("sort", SORT);
	}
}
