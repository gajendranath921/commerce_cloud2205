/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.rendering.suppliers.page.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.data.PagePreviewCriteriaData;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ProductPageModel;
import de.hybris.platform.cms2.servicelayer.data.CMSDataFactory;
import de.hybris.platform.cms2.servicelayer.data.RestrictionData;
import de.hybris.platform.cms2.servicelayer.services.CMSPageService;
import de.hybris.platform.cms2.servicelayer.services.CMSPreviewService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class RenderingProductPageModelSupplierTest
{
	private String VALID_PRODUCT_CODE = "validProductCode";
	private String INVALID_PRODUCT_CODE = "invalidProductCode";

	@Mock
	private ProductPageModel productPageModel;
	@Mock
	private RestrictionData restrictionData;
	@Mock
	private PagePreviewCriteriaData pagePreviewCriteriaData;
	@Mock
	private CMSPageService cmsPageService;
	@Mock
	private CMSDataFactory cmsDataFactory;
	@Mock
	private CMSPreviewService cmsPreviewService;

	@InjectMocks
	private RenderingProductPageModelSupplier supplier;

	@Before
	public void setUp()
	{
		when(cmsPreviewService.getPagePreviewCriteria()).thenReturn(pagePreviewCriteriaData);
	}

	@Test
	public void shouldReturnPageForValidProductCode() throws CMSItemNotFoundException
	{
		// GIVEN
		when(cmsPageService.getPageForProductCode(VALID_PRODUCT_CODE, pagePreviewCriteriaData)).thenReturn(productPageModel);

		// WHEN
		Optional<AbstractPageModel> result = supplier.getPageModel(VALID_PRODUCT_CODE);

		// THEN
		assertTrue(result.isPresent());
	}

	@Test
	public void shouldReturnEmptyForInvalidProductCode() throws CMSItemNotFoundException
	{
		// GIVEN
		when(cmsPageService.getPageForProductCode(INVALID_PRODUCT_CODE, pagePreviewCriteriaData)).thenThrow(new CMSItemNotFoundException(""));

		// WHEN
		Optional<AbstractPageModel> result = supplier.getPageModel(INVALID_PRODUCT_CODE);

		// THEN
		assertFalse(result.isPresent());
	}

	@Test
	public void shouldReturnRestrictionDataForValidProductCode()
	{
		// GIVEN
		when(cmsDataFactory.createRestrictionData(any(), any(), any())).thenReturn(restrictionData);

		// WHEN
		Optional<RestrictionData> result = supplier.getRestrictionData(VALID_PRODUCT_CODE);

		// THEN
		verify(cmsDataFactory).createRestrictionData(null, VALID_PRODUCT_CODE, null);
		assertTrue(result.isPresent());
	}
}
