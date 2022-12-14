/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.externaltax.impl;

import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.AddressModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * 
 *
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultTaxAreaLookupStrategyTest
{
	private DefaultTaxAreaLookupStrategy defaultTaxAreaLookupStrategy;

	@Before
	public void setUp()
	{
		defaultTaxAreaLookupStrategy = new DefaultTaxAreaLookupStrategy();
	}

	@Test
	public void shouldGetTaxArea()
	{
		final AbstractOrderModel abstractOrder = Mockito.mock(AbstractOrderModel.class);
		final AddressModel deliveryAddress = Mockito.mock(AddressModel.class);
		final CountryModel country = Mockito.mock(CountryModel.class);
		given(country.getIsocode()).willReturn("US");
		given(deliveryAddress.getCountry()).willReturn(country);
		given(abstractOrder.getDeliveryAddress()).willReturn(deliveryAddress);
		final String taxArea = defaultTaxAreaLookupStrategy.getTaxAreaForOrder(abstractOrder);

		Assert.assertNotNull(taxArea);
		Assert.assertEquals("US", taxArea);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotGetTaxArea()
	{
		final AbstractOrderModel abstractOrder = Mockito.mock(AbstractOrderModel.class);
		defaultTaxAreaLookupStrategy.getTaxAreaForOrder(abstractOrder);
	}
}
