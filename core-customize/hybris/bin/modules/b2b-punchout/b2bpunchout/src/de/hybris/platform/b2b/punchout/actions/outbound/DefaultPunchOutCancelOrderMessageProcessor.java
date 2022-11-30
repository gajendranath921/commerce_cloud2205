/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.outbound;

import de.hybris.platform.b2b.punchout.services.PunchOutService;
import de.hybris.platform.order.CartService;

import org.cxml.CXML;


/**
 * Default implementation of {@link PunchOutService}.
 */
public class DefaultPunchOutCancelOrderMessageProcessor implements PunchOutOutboundProcessor
{
	private CartService cartService;
	private PunchOutOutboundProcessor punchOutOrderMessageProcessor;

	@Override
	public CXML generatecXML()
	{
		//cancellation means we want to return an empty cart -> need to initialize the cart (remove and create new)
		getCartService().removeSessionCart();
		getCartService().getSessionCart();
		return getPunchOutOrderMessageProcessor().generatecXML();
	}

	protected CartService getCartService()
	{
		return cartService;
	}

	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}

	/**
	 * @return the punchOutOrderMessageProcessor
	 */
	protected PunchOutOutboundProcessor getPunchOutOrderMessageProcessor()
	{
		return punchOutOrderMessageProcessor;
	}

	/**
	 * @param defaultPunchOutOrderMessageProcessor the punchOutOrderMessageProcessor to set
	 */
	public void setPunchOutOrderMessageProcessor(final PunchOutOutboundProcessor defaultPunchOutOrderMessageProcessor)
	{
		this.punchOutOrderMessageProcessor = defaultPunchOutOrderMessageProcessor;
	}

}
