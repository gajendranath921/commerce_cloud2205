/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.selectivecartfacades.populators;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.selectivecartfacades.data.Wishlist2EntryData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.wishlist2.model.Wishlist2EntryModel;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Junit test suite for {@link WishlistEntryForSelectiveCartPopulator}
 */
@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class WishlistEntryForSelectiveCartPopulatorTest
{

	WishlistEntryForSelectiveCartPopulator wishlistEntryForSelectiveCartPopulator = null;
	private static final Integer NUMS = 100;

	@Mock
	private Converter<ProductModel, ProductData> productConverter;
	@Mock
	private Converter<ProductModel, ProductData> productPriceAndStockConverter;

	@Before
	public void setUp()
	{
		wishlistEntryForSelectiveCartPopulator = new WishlistEntryForSelectiveCartPopulator();
		wishlistEntryForSelectiveCartPopulator.setProductPriceAndStockConverter(productPriceAndStockConverter);
	}

	@Test
	public void testPopulateWithSuccessfulResult()
	{
		wishlistEntryForSelectiveCartPopulator.setProductConverter(productConverter);

		final ProductData productData = new ProductData();

		productData.setCode("000001");
		productData.setName("testProduct");

		final Wishlist2EntryModel wishlist2EntryModel = new Wishlist2EntryModel();
		final Date date = new Date();
		wishlist2EntryModel.setAddedDate(date);
		wishlist2EntryModel.setQuantity(NUMS);
		final Wishlist2EntryData wishlist2EntryData  = new Wishlist2EntryData();

		given(productConverter.convert(any())).willReturn(productData);
		given(productPriceAndStockConverter.convert(any(), any())).willReturn(productData);

		wishlistEntryForSelectiveCartPopulator.populate(wishlist2EntryModel, wishlist2EntryData);

		Assert.assertSame(date, wishlist2EntryData.getAddedDate());
		Assert.assertSame(NUMS, wishlist2EntryData.getQuantity());
		Assert.assertSame(productData.getCode(), wishlist2EntryData.getProduct().getCode());
		Assert.assertSame(productData.getName(), wishlist2EntryData.getProduct().getName());

	}

}
