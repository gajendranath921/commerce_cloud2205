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
package de.hybris.platform.ruledefinitions.conditions;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.ruledefinitions.AmountOperator;
import de.hybris.platform.ruleengineservices.compiler.RuleCompilerContext;
import de.hybris.platform.ruleengineservices.compiler.RuleIrCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrEmptyCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrGroupCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrGroupOperator;
import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;
import de.hybris.platform.ruleengineservices.rule.data.RuleConditionData;
import de.hybris.platform.ruleengineservices.rule.data.RuleConditionDefinitionData;
import de.hybris.platform.ruleengineservices.rule.data.RuleParameterData;
import org.apache.commons.collections.MapUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class RuleProductPriceConditionTranslatorTest
{
	private static final String ORDER_ENTRY_RAO_VAR = "orderEntryRaoVariable";
	private static final String CART_RAO_VAR = "cartRaoVariable";
	private static final String AVAILABLE_QUANTITY_VAR = "availableQuantity";

	@InjectMocks
	private RuleProductPriceConditionTranslator translator;

	@Mock
	private RuleCompilerContext context;
	@Mock
	private RuleConditionData condition;
	@Mock
	private RuleConditionDefinitionData conditionDefinition;
	@Mock
	private Map<String, RuleParameterData> parameters;
	@Mock
	private RuleParameterData operatorParameter;
	@Mock
	private RuleParameterData valueParameter;
	@Mock
	private RuleConditionConsumptionSupport consumptionSupport;

	@Before
	public void setUp()
	{
		Mockito.lenient().when(condition.getParameters()).thenReturn(parameters);
		Mockito.lenient().when(parameters.get(RuleProductPriceConditionTranslator.OPERATOR_PARAM)).thenReturn(operatorParameter);
		Mockito.lenient().when(parameters.get(RuleProductPriceConditionTranslator.VALUE_PARAM)).thenReturn(valueParameter);
		Mockito.lenient().when(context.generateVariable(OrderEntryRAO.class)).thenReturn(ORDER_ENTRY_RAO_VAR);
		Mockito.lenient().when(context.generateVariable(CartRAO.class)).thenReturn(CART_RAO_VAR);
		Mockito.lenient().when(operatorParameter.getValue()).thenReturn(AmountOperator.GREATER_THAN);

	}

	@Test
	public void testTranslateOperatorParamNull()
	{
		Mockito.lenient().when(parameters.get(RuleProductPriceConditionTranslator.OPERATOR_PARAM)).thenReturn(null);
		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);

		assertThat(ruleIrCondition, instanceOf(RuleIrEmptyCondition.class));
	}

	@Test
	public void testTranslateValueParamNull()
	{
		Mockito.lenient().when(parameters.get(RuleProductPriceConditionTranslator.VALUE_PARAM)).thenReturn(null);
		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);

		assertThat(ruleIrCondition, instanceOf(RuleIrEmptyCondition.class));
	}

	@Test
	public void testTranslateOperatorNull()
	{
		Mockito.lenient().when(operatorParameter.getValue()).thenReturn(null);
		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);

		assertThat(ruleIrCondition, instanceOf(RuleIrEmptyCondition.class));
	}

	@Test
	public void testTranslateValueNull()
	{
		Mockito.lenient().when(valueParameter.getValue()).thenReturn(null);
		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);

		assertThat(ruleIrCondition, instanceOf(RuleIrEmptyCondition.class));
	}

	@Test
	public void testTranslateValueEmpty()
	{
		Mockito.lenient().when(valueParameter.getValue()).thenReturn(MapUtils.EMPTY_MAP);
		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);

		assertThat(ruleIrCondition, instanceOf(RuleIrEmptyCondition.class));
	}

	@Test
	public void testTranslate()
	{
		final Map<String, BigDecimal> value = new HashMap<>();
		value.put("USD", new BigDecimal(600));
		value.put("EUR", new BigDecimal(500));

		Mockito.lenient().when(valueParameter.getValue()).thenReturn(value);

		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);
		assertThat(ruleIrCondition, instanceOf(RuleIrGroupCondition.class));

		final RuleIrGroupCondition irGroupCondition = (RuleIrGroupCondition) ruleIrCondition;
		assertEquals(2, irGroupCondition.getChildren().size());
		assertEquals(RuleIrGroupOperator.OR, irGroupCondition.getOperator());

		checkConditionChild(irGroupCondition.getChildren().get(0));
		checkConditionChild(irGroupCondition.getChildren().get(1));
	}

	protected void checkConditionChild(final RuleIrCondition condition)
	{
		assertThat(condition, instanceOf(RuleIrGroupCondition.class));

		final RuleIrGroupCondition irCurrencyGroupCondition = (RuleIrGroupCondition) condition;
		assertEquals(RuleIrGroupOperator.AND, irCurrencyGroupCondition.getOperator());
		final List<RuleIrCondition> irCurrencyGroupConditionChildren = irCurrencyGroupCondition.getChildren();
		assertEquals(3, irCurrencyGroupConditionChildren.size());

		verify(consumptionSupport, atLeast(1)).newProductConsumedCondition(context, ORDER_ENTRY_RAO_VAR);
	}

	@Test
	public void testTranslateNullKeyInValue()
	{
		final Map<String, BigDecimal> value = new HashMap<String, BigDecimal>();
		value.put(null, new BigDecimal(600));
		value.put("EUR", new BigDecimal(500));

		Mockito.lenient().when(valueParameter.getValue()).thenReturn(value);

		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);
		assertThat(ruleIrCondition, instanceOf(RuleIrGroupCondition.class));

		final RuleIrGroupCondition irGroupCondition = (RuleIrGroupCondition) ruleIrCondition;
		assertEquals(1, irGroupCondition.getChildren().size());
		assertEquals(RuleIrGroupOperator.OR, irGroupCondition.getOperator());

		checkConditionChild(irGroupCondition.getChildren().get(0));
	}

	@Test
	public void testTranslateNullValueInValue()
	{
		final Map<String, BigDecimal> value = new HashMap<String, BigDecimal>();
		value.put("USD", null);
		value.put("EUR", new BigDecimal(500));

		Mockito.lenient().when(valueParameter.getValue()).thenReturn(value);

		final RuleIrCondition ruleIrCondition = translator.translate(context, condition, conditionDefinition);
		assertThat(ruleIrCondition, instanceOf(RuleIrGroupCondition.class));

		final RuleIrGroupCondition irGroupCondition = (RuleIrGroupCondition) ruleIrCondition;
		assertEquals(1, irGroupCondition.getChildren().size());
		assertEquals(RuleIrGroupOperator.OR, irGroupCondition.getOperator());

		checkConditionChild(irGroupCondition.getChildren().get(0));
	}
}
