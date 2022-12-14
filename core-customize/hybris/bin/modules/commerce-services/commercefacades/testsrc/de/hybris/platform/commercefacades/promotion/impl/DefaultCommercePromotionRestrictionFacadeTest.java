/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.promotion.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.platform.commerceservices.model.promotions.PromotionOrderRestrictionModel;
import de.hybris.platform.commerceservices.order.CommerceCartService;
import de.hybris.platform.commerceservices.promotion.CommercePromotionRestrictionException;
import de.hybris.platform.commerceservices.promotion.CommercePromotionRestrictionService;
import de.hybris.platform.commerceservices.promotion.CommercePromotionService;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.promotions.model.AbstractPromotionModel;
import de.hybris.platform.promotions.model.OrderPromotionModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test for {@link DefaultCommercePromotionRestrictionFacade}
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultCommercePromotionRestrictionFacadeTest
{
	final static String ORDER_PROMOTION_CODE = "orderPromotionCode";
	final static String ABSTRACT_PROMOTION_CODE = "abstractPromotionCode";
	final static String NOT_EXISTING_PROMOTION_CODE = "notExistingPromotion";
	@Mock
	protected CommercePromotionService commercePromotionService;
	@Mock
	protected CommercePromotionRestrictionService commercePromotionRestrictionService;
	@Mock
	protected CartService cartService;
	@Mock
	protected CommerceCartService commerceCartService;
	@Mock
	protected AbstractPromotionModel abstractPromotionModel;
	@Mock
	protected OrderPromotionModel orderPromotionModel;
	@Mock
	protected PromotionOrderRestrictionModel promotionOrderRestrictionModel;
	@Mock
	protected CartModel cartModel;
	protected DefaultCommercePromotionRestrictionFacade commercePromotionRestrictionFacade;
	@Mock
	protected CommerceCartParameter commerceCartParameter;
	@Before
	public void setUp()
	{
		commercePromotionRestrictionFacade = new DefaultCommercePromotionRestrictionFacade();
		commercePromotionRestrictionFacade.setCommercePromotionService(commercePromotionService);
		commercePromotionRestrictionFacade.setCommercePromotionRestrictionService(commercePromotionRestrictionService);
		commercePromotionRestrictionFacade.setCartService(cartService);
		commercePromotionRestrictionFacade.setCommerceCartService(commerceCartService);
	}

	@Test
	public void testEnablePromotionForCurrentCart() throws CommercePromotionRestrictionException, CalculationException
	{
		given(commercePromotionService.getPromotion(ORDER_PROMOTION_CODE)).willReturn(orderPromotionModel);
		given(commercePromotionRestrictionService.getPromotionOrderRestriction(orderPromotionModel)).willReturn(
				promotionOrderRestrictionModel);
		given(cartService.getSessionCart()).willReturn(cartModel);
		commercePromotionRestrictionFacade.enablePromotionForCurrentCart(ORDER_PROMOTION_CODE);
		verify(commercePromotionRestrictionService, times(1)).addOrderToRestriction(promotionOrderRestrictionModel, cartModel);
		verify(commerceCartService, times(1)).recalculateCart(any(CommerceCartParameter.class));
	}
}
