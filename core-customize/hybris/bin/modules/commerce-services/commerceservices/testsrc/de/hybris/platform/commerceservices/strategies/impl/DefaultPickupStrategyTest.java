/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.strategies.impl;


import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.enums.PickupInStoreMode;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.store.services.BaseStoreService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test cases for {@link DefaultPickupStrategy}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultPickupStrategyTest
{
	@Spy
	@InjectMocks
	private final DefaultPickupStrategy strategy = new DefaultPickupStrategy();

	@Mock
	private BaseStoreService baseStoreService;

	@Mock
	private BaseStoreModel baseStoreModel;


	@Before
	public void setup()
	{
		strategy.setBaseStoreService(baseStoreService);
		strategy.setDefaultPickupInStoreMode(PickupInStoreMode.DISABLED);
		given(baseStoreService.getCurrentBaseStore()).willReturn(baseStoreModel);
		given(baseStoreModel.getPickupInStoreMode()).willReturn(PickupInStoreMode.BUY_AND_COLLECT);
	}

	@Test
	public void testNoStoreAvailable()
	{
		doReturn(null).when(baseStoreService).getCurrentBaseStore();
		assertEquals("Expected to return the disabled mode", PickupInStoreMode.DISABLED, strategy.getPickupInStoreMode());
	}

	@Test
	public void testStoreAvailable()
	{
		assertEquals("Expected to be BUY_AND_COLLECT mode", PickupInStoreMode.BUY_AND_COLLECT, strategy.getPickupInStoreMode());
	}

}
