/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.inbound;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.punchout.PunchOutException;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.order.InvalidCartException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class PlacePurchaseOrderProcessingTest
{
	@Mock
	private CheckoutFacade checkoutFacade;

	@Mock
	private CartData cartData;

	@Mock
	private OrderData orderData;

	@InjectMocks
	private PlacePurchaseOrderProcessing placePurchaseOrderProcessing;

	@Before
	public void setUp() throws InvalidCartException, PunchOutException
	{
		cartData = new CartData();
		orderData = new OrderData();
		when(checkoutFacade.getCheckoutCart()).thenReturn(cartData);
	}

	@Test
	public void testExceptionMessage() throws InvalidCartException
	{
		when(checkoutFacade.placeOrder()).thenThrow(new InvalidCartException("Testing Failure Condition4"));
		when(checkoutFacade.getCheckoutCart()).thenReturn(cartData);

		assertThatThrownBy(() -> placePurchaseOrderProcessing.process())
			.isInstanceOf(PunchOutException.class);
	}

	@Test
	public void shouldProcessFully() throws InvalidCartException
	{
		when(checkoutFacade.placeOrder()).thenReturn(orderData);

		placePurchaseOrderProcessing.process();

		verify(checkoutFacade).placeOrder();
	}
}
