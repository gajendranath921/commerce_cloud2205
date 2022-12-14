/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.strategies.impl;

import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.strategies.NetGrossStrategy;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.store.services.BaseStoreService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 *
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class CommerceNetGrossStrategyTest
{
	private CommerceNetGrossStrategy strategy;
	@Mock
	private BaseStoreService baseStoreService;
	@Mock
	private CartService cartService;
	@Mock(lenient = true)
	private CartModel cart;
	@Mock
	private BaseStoreModel store;
	@Mock(lenient = true)
	private NetGrossStrategy defaultStrategy;


	@Before
	public void setUp()
	{
		strategy = new CommerceNetGrossStrategy()
		{
			@Override
			protected CartService getCartService()
			{
				return cartService;
			}
		};
		strategy.setBaseStoreService(baseStoreService);
		strategy.setDefaultNetGrossStrategy(defaultStrategy);
		given(cartService.getSessionCart()).willReturn(cart);
	}

	@Test
	public void testBaseStore()
	{
		given(baseStoreService.getCurrentBaseStore()).willReturn(store);
		given(Boolean.valueOf(store.isNet())).willReturn(Boolean.FALSE);
		given(cart.getNet()).willReturn(Boolean.TRUE);
		given(Boolean.valueOf(defaultStrategy.isNet())).willReturn(Boolean.TRUE);
		Assert.assertEquals(Boolean.FALSE, Boolean.valueOf(strategy.isNet()));
	}

	@Test
	public void testCart()
	{
		given(baseStoreService.getCurrentBaseStore()).willReturn(null);
		given(Boolean.valueOf(cartService.hasSessionCart())).willReturn(Boolean.TRUE);
		given(cart.getNet()).willReturn(Boolean.FALSE);
		given(Boolean.valueOf(defaultStrategy.isNet())).willReturn(Boolean.TRUE);
		Assert.assertEquals(Boolean.FALSE, Boolean.valueOf(strategy.isNet()));
	}

	@Test
	public void testDefault()
	{
		given(baseStoreService.getCurrentBaseStore()).willReturn(null);
		given(cart.getNet()).willReturn(null);
		given(Boolean.valueOf(defaultStrategy.isNet())).willReturn(Boolean.FALSE);
		Assert.assertEquals(Boolean.FALSE, Boolean.valueOf(strategy.isNet()));
	}
}
