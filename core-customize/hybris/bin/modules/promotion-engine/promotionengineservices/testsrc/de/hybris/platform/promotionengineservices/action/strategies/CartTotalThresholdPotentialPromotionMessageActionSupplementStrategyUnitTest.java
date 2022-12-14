/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.promotionengineservices.action.strategies;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.droolsruleengineservices.compiler.impl.DefaultDroolsRuleActionContext;
import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.DisplayMessageRAO;
import de.hybris.platform.ruleengineservices.rule.evaluation.RuleActionContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;



@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class CartTotalThresholdPotentialPromotionMessageActionSupplementStrategyUnitTest
{
	private static final String UUID = "234234-dfged-23423sdfr23-sdfwer23-edrwe";

	private static final BigDecimal CONDITION_ORDER_TOTAL_THRESHOLD = new BigDecimal("1000.00");

	private static final BigDecimal CART_SUB_TOTAL = new BigDecimal("100.00");

	@InjectMocks
	private CartTotalThresholdPotentialPromotionMessageActionSupplementStrategy strategy;

	@Mock
	private DisplayMessageRAO displayMessageRAO;

	private RuleActionContext context;

	@Mock
	private CartRAO cartRao;

	Map<String, Object> srcParameters1 = new HashMap<>();

	@Before
	public void setUp()
	{
		context = new DefaultDroolsRuleActionContext(new HashMap<String, Object>()
		{
			{
				put(CartRAO.class.getName(), cartRao);
			}
		}, null);
		context.setParameters(srcParameters1);
		Mockito.lenient().when(cartRao.getCurrencyIsoCode()).thenReturn("USD");
		Mockito.lenient().when(cartRao.getSubTotal()).thenReturn(CART_SUB_TOTAL);

		srcParameters1.put(CartTotalThresholdPotentialPromotionMessageActionSupplementStrategy.CART_TOTAL_THRESHOLD_PARAMETER,
				new HashMap<String, BigDecimal>()
				{
					{
						put("USD", CONDITION_ORDER_TOTAL_THRESHOLD);
						put("JPY", new BigDecimal("20000"));
					}
				});
		srcParameters1.put(CartTotalThresholdPotentialPromotionMessageActionSupplementStrategy.CART_TOTAL_THRESHOLD_PARAMETER_UUID,
				UUID);
	}

	@Test
	public void testShouldPerformActionForOrderThreshold()
	{
		final HashMap<String, Object> targetParams = new HashMap<>();
		Mockito.lenient().when(displayMessageRAO.getParameters()).thenReturn(targetParams);
		Assert.assertTrue(strategy.shouldPerformAction(displayMessageRAO, context));
		Assert.assertEquals(CONDITION_ORDER_TOTAL_THRESHOLD.subtract(CART_SUB_TOTAL), targetParams.get(UUID));
	}

	@Test
	public void testShouldPerformActionCartSubtotalOverConditionThreshold()
	{
		Mockito.lenient().when(cartRao.getSubTotal()).thenReturn(CONDITION_ORDER_TOTAL_THRESHOLD.add(new BigDecimal("10")));
		final HashMap<String, Object> targetParams = new HashMap<>();
		Mockito.lenient().when(displayMessageRAO.getParameters()).thenReturn(targetParams);
		Assert.assertFalse(strategy.shouldPerformAction(displayMessageRAO, context));
		Assert.assertFalse(targetParams.containsKey(UUID));
	}
}
