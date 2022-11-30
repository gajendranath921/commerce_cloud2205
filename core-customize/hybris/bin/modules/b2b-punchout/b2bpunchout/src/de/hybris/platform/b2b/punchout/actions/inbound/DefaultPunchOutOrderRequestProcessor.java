/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.inbound;

import de.hybris.platform.b2b.punchout.PunchOutResponseCode;
import de.hybris.platform.b2b.punchout.PunchOutResponseMessage;
import de.hybris.platform.b2b.punchout.PunchOutUtils;
import de.hybris.platform.b2b.punchout.services.CXMLBuilder;
import de.hybris.platform.b2b.punchout.services.PunchOutService;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;

import org.cxml.CXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Default implementation of {@link PunchOutService}.
 */
public class DefaultPunchOutOrderRequestProcessor implements PunchOutInboundProcessor
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultPunchOutOrderRequestProcessor.class);

	private DefaultPunchOutAuthenticationVerifier punchoutAuthenticationVerifier;
	private PrepareCartPurchaseOrderProcessing prepareCartPurchaseOrderProcessing;
	private PopulateCartPurchaseOrderProcessing populateCartPurchaseOrderProcessing;
	private PlacePurchaseOrderProcessing placePurchaseOrderProcessing;
	private CartService cartService;

	@Override
	public CXML generatecXML(final CXML requestBody)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug("CXML input: {}", PunchOutUtils.marshallFromBeanTree(requestBody));
		}
		getCartService().removeSessionCart();
		final CartModel cartModel = getCartService().getSessionCart();

		cartModel.setStatus(OrderStatus.CREATED);
		cartModel.setPunchOutOrder(Boolean.TRUE);

		getPunchOutAuthenticationVerifier().verify(requestBody);
		getPopulateCartPurchaseOrderProcessing().process(requestBody, cartModel);
		getPrepareCartPurchaseOrderProcessing().process();
		getPlacePurchaseOrderProcessing().process();

		final CXML generatedCXML = CXMLBuilder.newInstance().withResponseCode(PunchOutResponseCode.SUCCESS)
				.withResponseMessage(PunchOutResponseMessage.OK).create();
		if (LOG.isDebugEnabled())
		{
			LOG.debug("CXML generated:{}", PunchOutUtils.marshallFromBeanTree(generatedCXML));
		}
		return generatedCXML;
	}

	protected DefaultPunchOutAuthenticationVerifier getPunchOutAuthenticationVerifier()
	{
		return punchoutAuthenticationVerifier;
	}

	public void setPunchOutAuthenticationVerifier(final DefaultPunchOutAuthenticationVerifier punchoutAuthenticationVerifier)
	{
		this.punchoutAuthenticationVerifier = punchoutAuthenticationVerifier;
	}

	/**
	 * @return the prepareCartPurchaseOrderProcessing
	 */
	protected PrepareCartPurchaseOrderProcessing getPrepareCartPurchaseOrderProcessing()
	{
		return prepareCartPurchaseOrderProcessing;
	}

	/**
	 * @param prepareCartPurchaseOrderProcessing the prepareCartPurchaseOrderProcessing to set
	 */
	public void setPrepareCartPurchaseOrderProcessing(final PrepareCartPurchaseOrderProcessing prepareCartPurchaseOrderProcessing)
	{
		this.prepareCartPurchaseOrderProcessing = prepareCartPurchaseOrderProcessing;
	}

	/**
	 * @return the populateCartPurchaseOrderProcessing
	 */
	protected PopulateCartPurchaseOrderProcessing getPopulateCartPurchaseOrderProcessing()
	{
		return populateCartPurchaseOrderProcessing;
	}

	/**
	 * @param populateCartPurchaseOrderProcessing the populateCartPurchaseOrderProcessing to set
	 */
	public void setPopulateCartPurchaseOrderProcessing(
			final PopulateCartPurchaseOrderProcessing populateCartPurchaseOrderProcessing)
	{
		this.populateCartPurchaseOrderProcessing = populateCartPurchaseOrderProcessing;
	}

	/**
	 * @return the placePurchaseOrderProcessing
	 */
	protected PlacePurchaseOrderProcessing getPlacePurchaseOrderProcessing()
	{
		return placePurchaseOrderProcessing;
	}

	/**
	 * @param placePurchaseOrderProcessing the placePurchaseOrderProcessing to set
	 */
	public void setPlacePurchaseOrderProcessing(final PlacePurchaseOrderProcessing placePurchaseOrderProcessing)
	{
		this.placePurchaseOrderProcessing = placePurchaseOrderProcessing;
	}

	/**
	 * @return the cartService
	 */
	protected CartService getCartService()
	{
		return cartService;
	}

	/**
	 * @param cartService the cartService to set
	 */
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}

}
