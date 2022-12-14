/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bpunchoutaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCartPageController;
import de.hybris.platform.b2bpunchoutaddon.constants.B2bpunchoutaddonConstants;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Controller for Punch Out Inspect operation.
 * @deprecated (Please use #de.hybris.platform.b2bpunchoutocc.controllers instead)
 */
@Deprecated (since="2205", forRemoval=true)
@Component
@RequestMapping(value = "/punchout/cxml/inspect")
public class DefaultInspectCartController extends AbstractCartPageController implements PunchOutController
{
	private static final String INSPECT_PAGE = "/pages/cart/inspect";

	@Resource(name = "cartFacade")
	private CartFacade cartFacade;


	@GetMapping
	public String showCart(final Model model) throws CMSItemNotFoundException
	{
		super.prepareDataForPage(model);
		setNotUpdatable(model);
		model.addAttribute("isInspectOperation", true);

		return B2bpunchoutaddonConstants.VIEW_PAGE_PREFIX + INSPECT_PAGE;
	}

	/**
	 * Set items from cart as not updatable.
	 *
	 * @param model
	 *           Model that will contain the cart.
	 */
	protected void setNotUpdatable(final Model model)
	{
		final CartData cartData = cartFacade.getSessionCart();
		for (final OrderEntryData entry : cartData.getEntries())
		{
			entry.setUpdateable(false);
		}
		model.addAttribute("cartData", cartData);
	}
}
