/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.inbound;

import de.hybris.platform.b2b.punchout.PunchOutException;
import de.hybris.platform.b2b.punchout.PunchOutResponseCode;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.order.InvalidCartException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Places an order using the session shopping cart.
 */
public class PlacePurchaseOrderProcessing
{
	private static final Logger LOG = LoggerFactory.getLogger(PlacePurchaseOrderProcessing.class);
	private CheckoutFacade checkoutFacade;

	public void process()
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		if (LOG.isDebugEnabled())
		{
			LOG.debug("Placing an order for cart with code: {}", cartData.getCode());
		}
		try
		{
			if(null == cartData.getDeliveryMode()){
				getCheckoutFacade().setDeliveryModeIfAvailable();
			}
			final OrderData orderData = getCheckoutFacade().placeOrder();
			if (LOG.isDebugEnabled())
			{
				LOG.debug("Order with code {} was placed.", orderData.getCode());
			}
		}
		catch (final InvalidCartException e)
		{
			throw new PunchOutException(PunchOutResponseCode.CONFLICT, "Unable to checkout", e);
		}
	}

	public void setCheckoutFacade(final CheckoutFacade checkoutFacade)
	{
		this.checkoutFacade = checkoutFacade;
	}

	/**
	 * @return the checkoutFacade
	 */
	protected CheckoutFacade getCheckoutFacade()
	{
		return checkoutFacade;
	}

}
