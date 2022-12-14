/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.voucher.converters.populator;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.nullable;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.commercefacades.voucher.data.VoucherData;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.voucher.VoucherModelService;
import de.hybris.platform.voucher.VoucherService;
import de.hybris.platform.voucher.jalo.util.VoucherValue;
import de.hybris.platform.voucher.model.VoucherModel;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test suite for {@link VoucherAppliedValuePopulator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class VoucherAppliedValuePopulatorTest
{
	private static final String VOUCHER_CODE = "voucherCode";
	private static final String CODE = "code";
	private VoucherAppliedValuePopulator voucherAppliedValuePopulator;
	@Mock
	private VoucherService voucherService;
	@Mock
	private VoucherModelService voucherModelService;
	@Mock
	private PriceDataFactory priceDataFactory;
	@Mock
	private AbstractOrderModel orderModel;
	@Mock
	private VoucherModel voucherModel;
	@Mock
	private PriceData priceData;
	@Mock
	private VoucherValue voucherValue;

	@Before
	public void setUp()
	{
		voucherAppliedValuePopulator = new VoucherAppliedValuePopulator();
		voucherAppliedValuePopulator.setVoucherService(voucherService);
		voucherAppliedValuePopulator.setVoucherModelService(voucherModelService);
		voucherAppliedValuePopulator.setPriceDataFactory(priceDataFactory);
	}

	@Test
	public void testPopulate()
	{
		final VoucherData voucherData = new VoucherData();
		voucherData.setVoucherCode(VOUCHER_CODE);
		voucherData.setCode(CODE);
		given(voucherService.getVoucher(VOUCHER_CODE)).willReturn(voucherModel);
		given(voucherModelService.getAppliedValue(voucherModel, orderModel)).willReturn(voucherValue);
		given(priceDataFactory.create(nullable(PriceDataType.class), nullable(BigDecimal.class), nullable(String.class))).willReturn(priceData);

		voucherAppliedValuePopulator.populate(orderModel, voucherData);
		Assert.assertEquals(priceData, voucherData.getAppliedValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPopulateWithNullSource()
	{
		final VoucherData voucherData = new VoucherData();
		voucherAppliedValuePopulator.populate(null, voucherData);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPopulateWithNullTarget()
	{
		voucherAppliedValuePopulator.populate(orderModel, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPopulateWithNullVoucherCodeAttribute()
	{
		final VoucherData voucherData = new VoucherData();
		voucherAppliedValuePopulator.populate(orderModel, voucherData);
	}
}
