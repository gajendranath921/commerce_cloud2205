/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.promotion.impl;

import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.model.promotions.PromotionOrderRestrictionModel;
import de.hybris.platform.commerceservices.promotion.dao.CommercePromotionRestrictionDao;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.promotions.model.AbstractPromotionModel;
import de.hybris.platform.promotions.model.AbstractPromotionRestrictionModel;
import de.hybris.platform.promotions.model.OrderPromotionModel;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test for {@link DefaultCommercePromotionRestrictionService}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultCommercePromotionRestrictionServiceTest
{
	@Mock
	protected AbstractPromotionModel abstractPromotionModel;
	@Mock
	protected OrderPromotionModel orderPromotionModel;
	@Mock
	protected CommercePromotionRestrictionDao commercePromotionRestrictionDao;
	@Mock
	protected PromotionOrderRestrictionModel promotionOrderRestrictionModel;
	@Mock
	protected AbstractPromotionRestrictionModel abstractPromotionRestrictionModel;
	@Mock
	protected AbstractOrderModel abstractOrderModel;
	@Mock
	protected CartModel cartModel;
	@Mock
	protected ModelService modelService;
	protected DefaultCommercePromotionRestrictionService commercePromotionRestrictionService;
	protected List<AbstractPromotionRestrictionModel> abstractPromotionRestrictionList;
	protected List<PromotionOrderRestrictionModel> promotionOrderRestrictionList;
	protected PromotionOrderRestrictionModel promotionOrderRestrictionModelImpl;

	@Before
	public void setUp()
	{
		commercePromotionRestrictionService = new DefaultCommercePromotionRestrictionService();
		commercePromotionRestrictionService.setModelService(modelService);
		commercePromotionRestrictionService.setCommercePromotionRestrictionDao(commercePromotionRestrictionDao);

		abstractPromotionRestrictionList = new ArrayList<AbstractPromotionRestrictionModel>();
		abstractPromotionRestrictionList.add(abstractPromotionRestrictionModel);

		promotionOrderRestrictionList = new ArrayList<PromotionOrderRestrictionModel>();
		promotionOrderRestrictionList.add(promotionOrderRestrictionModel);

		promotionOrderRestrictionModelImpl = new PromotionOrderRestrictionModel();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPromotionRestrictionsWithNullParameter()
	{
		commercePromotionRestrictionService.getPromotionRestrictions(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPromotionOrderRestrictionWithNullParameter()
	{
		commercePromotionRestrictionService.getPromotionOrderRestriction(null);
	}

	@Test(expected = UnknownIdentifierException.class)
	public void testGetPromotionOrderRestrictionWithNotExistPromotion()
	{
		given(commercePromotionRestrictionDao.findPromotionOrderRestriction(orderPromotionModel)).willReturn(
				new ArrayList<PromotionOrderRestrictionModel>());
		commercePromotionRestrictionService.getPromotionOrderRestriction(orderPromotionModel);
	}

	@Test(expected = AmbiguousIdentifierException.class)
	public void testGetPromotionOrderRestrictionWithAmbiguousData()
	{
		given(commercePromotionRestrictionDao.findPromotionOrderRestriction(orderPromotionModel)).willReturn(
				Arrays.asList(promotionOrderRestrictionModel, promotionOrderRestrictionModel));
		commercePromotionRestrictionService.getPromotionOrderRestriction(orderPromotionModel);
	}

	@Test
	public void testGetPromotionRestrictions()
	{
		given(commercePromotionRestrictionDao.findPromotionRestriction(abstractPromotionModel)).willReturn(
				abstractPromotionRestrictionList);
		Assert.assertEquals(commercePromotionRestrictionService.getPromotionRestrictions(abstractPromotionModel),
				abstractPromotionRestrictionList);
	}

	@Test
	public void testGetPromotionOrderRestrictions()
	{
		given(commercePromotionRestrictionDao.findPromotionOrderRestriction(orderPromotionModel)).willReturn(
				promotionOrderRestrictionList);
		Assert.assertEquals(commercePromotionRestrictionService.getPromotionOrderRestriction(orderPromotionModel),
				promotionOrderRestrictionModel);
	}

	@Test
	public void testAddOrderToRestrictionWithNotUniqueOrder()
	{
		final Collection<AbstractOrderModel> orders = new HashSet<AbstractOrderModel>();
		orders.add(abstractOrderModel);
		promotionOrderRestrictionModelImpl.setOrders(orders);
		commercePromotionRestrictionService.addOrderToRestriction(promotionOrderRestrictionModelImpl, abstractOrderModel);

		Assert.assertEquals(1, promotionOrderRestrictionModelImpl.getOrders().size());
		Assert.assertTrue(promotionOrderRestrictionModelImpl.getOrders().contains(abstractOrderModel));
	}

	@Test
	public void testAddOrderToRestrictionWithUniqueOrder()
	{
		final Collection<AbstractOrderModel> orders = new HashSet<AbstractOrderModel>();
		orders.add(abstractOrderModel);
		promotionOrderRestrictionModelImpl.setOrders(orders);
		commercePromotionRestrictionService.addOrderToRestriction(promotionOrderRestrictionModelImpl, cartModel);

		Assert.assertEquals(2, promotionOrderRestrictionModelImpl.getOrders().size());
		Assert.assertTrue(promotionOrderRestrictionModelImpl.getOrders().containsAll(Arrays.asList(abstractOrderModel, cartModel)));
	}
}
