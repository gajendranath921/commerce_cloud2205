/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.voucher.converters.populator;

import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.voucher.VoucherService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test suite for {@link OrderAppliedVouchersPopulator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class OrderAppliedVouchersPopulatorTest
{
	private OrderAppliedVouchersPopulator orderAppliedVouchersPopulator;
	@Mock
	private OrderModel orderModel;
	@Mock
	private VoucherService voucherService;

	private Collection<String> appliedVoucherCodes;

	@Before
	public void setUp()
	{
		orderAppliedVouchersPopulator = new OrderAppliedVouchersPopulator();
		orderAppliedVouchersPopulator.setVoucherService(voucherService);
		appliedVoucherCodes = new ArrayList(Arrays.asList("SUMMER69", "WINTER16"));
		given(voucherService.getAppliedVoucherCodes(orderModel)).willReturn(appliedVoucherCodes);
	}

	@Test
	public void testPopulate()
	{
		final OrderData orderData = new OrderData();
		orderAppliedVouchersPopulator.populate(orderModel, orderData);

		Assert.assertThat(orderData.getAppliedVouchers(), IsIterableContainingInOrder.contains(appliedVoucherCodes.toArray()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPopulateWithNullSource()
	{
		final OrderData orderData = new OrderData();
		orderAppliedVouchersPopulator.populate(null, orderData);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPopulateWithNullTarget()
	{
		orderAppliedVouchersPopulator.populate(orderModel, null);
	}

}
