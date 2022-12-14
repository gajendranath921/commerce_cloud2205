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
package de.hybris.platform.ruleengineservices.calculation;

import de.hybris.order.calculation.strategies.CalculationStrategies;
import de.hybris.order.calculation.strategies.impl.DefaultRoundingStrategy;
import de.hybris.order.calculation.strategies.impl.DefaultTaxRoundingStrategy;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.ruleengineservices.calculation.impl.CheapestEntriesSelectionStrategy;
import de.hybris.platform.ruleengineservices.calculation.impl.DefaultPriceAdjustmentStrategy;
import de.hybris.platform.ruleengineservices.calculation.impl.DefaultMinimumAmountValidationStrategy;
import de.hybris.platform.ruleengineservices.calculation.impl.DefaultNumberedLineItemLookupStrategy;
import de.hybris.platform.ruleengineservices.calculation.impl.DefaultRuleEngineCalculationService;
import de.hybris.platform.ruleengineservices.configuration.Switch;
import de.hybris.platform.ruleengineservices.configuration.SwitchService;
import de.hybris.platform.ruleengineservices.converters.AbstractOrderRaoToCurrencyConverter;
import de.hybris.platform.ruleengineservices.converters.AbstractOrderRaoToOrderConverter;
import de.hybris.platform.ruleengineservices.converters.OrderEntryRaoToNumberedLineItemConverter;
import de.hybris.platform.ruleengineservices.enums.OrderEntrySelectionStrategy;
import de.hybris.platform.ruleengineservices.rao.AbstractActionedRAO;
import de.hybris.platform.ruleengineservices.rao.AbstractOrderRAO;
import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.DiscountRAO;
import de.hybris.platform.ruleengineservices.rao.EntriesSelectionStrategyRPD;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;

import de.hybris.platform.ruleengineservices.rao.util.DefaultRaoService;
import de.hybris.platform.ruleengineservices.rule.evaluation.actions.impl.DefaultRAOConsumptionSupport;
import de.hybris.platform.ruleengineservices.rule.evaluation.actions.impl.DefaultRAOLookupService;
import de.hybris.platform.ruleengineservices.util.CurrencyUtils;
import de.hybris.platform.ruleengineservices.util.OrderUtils;
import de.hybris.platform.ruleengineservices.util.RaoUtils;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.mockito.Mockito;


@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractRuleEngineTest
{
	@Mock
	private CommonI18NService commonI18NService;

	@Mock
	private ModelService modelService;

	@Mock
	private SwitchService switchService;

	protected static final String USD = "USD";
	protected static final String EUR = "EUR";
	private DefaultRaoService raoService;
	private AbstractOrderRaoToOrderConverter cartRaoToOrderConverter;
	private DefaultRuleEngineCalculationService ruleEngineCalculationService;
	private AbstractOrderRaoToCurrencyConverter abstractOrderRaoToCurrencyConverter;
	private Map<OrderEntrySelectionStrategy, EntriesSelectionStrategy> unitForBundleSelectorStrategies;
	private DefaultRAOConsumptionSupport raoConsumptionSupport;
	private static int entryNumber = 0;

	@Before
	public void setUpAbstractRuleEngineTest()
	{
		final RaoUtils raoUtils = new RaoUtils();

		final OrderUtils orderUtils = new OrderUtils();
		orderUtils.setModelService(modelService);

		final CurrencyUtils currencyUtils = new CurrencyUtils();
		currencyUtils.setCommonI18NService(commonI18NService);

		final CurrencyModel currencyUSD = new CurrencyModel();
		currencyUSD.setDigits(2);
		currencyUSD.setIsocode(USD);

		final CurrencyModel currencyEUR = new CurrencyModel();
		currencyEUR.setDigits(3);
		currencyEUR.setIsocode(EUR);

		Mockito.lenient().when(commonI18NService.getCurrency(USD)).thenReturn(currencyUSD);
		Mockito.lenient().when(commonI18NService.getCurrency(EUR)).thenReturn(currencyEUR);

		raoService = newDefaultRaoService();
		abstractOrderRaoToCurrencyConverter = newAbstractOrderRaoToCurrencyConverter(currencyUtils);
		final OrderEntryRaoToNumberedLineItemConverter orderEntryRaoToNumberedLineItemConverter = newOrderEntryRaoToNumberedLineItemConverter(
				abstractOrderRaoToCurrencyConverter);
		cartRaoToOrderConverter = newCartRaoToOrderConverter(orderEntryRaoToNumberedLineItemConverter,
				abstractOrderRaoToCurrencyConverter, orderUtils, raoUtils);
		unitForBundleSelectorStrategies = newUnitForBundleSelectorStrategies();

		raoConsumptionSupport = new DefaultRAOConsumptionSupport();
		raoConsumptionSupport.setCurrencyUtils(currencyUtils);
		Mockito.lenient().when(switchService.isEnabled(Switch.CONSUMPTION)).thenReturn(true);
		raoConsumptionSupport.setSwitchService(switchService);
		raoConsumptionSupport.setEntriesSelectionStrategies(unitForBundleSelectorStrategies);
		raoConsumptionSupport.setRaoLookupService(new DefaultRAOLookupService());
		raoConsumptionSupport.setPriceAdjustmentStrategy(new DefaultPriceAdjustmentStrategy());
		final MinimumAmountValidationStrategy minimumAmountValidationStrategy = newMinimumAmountValidationStrategy();
		ruleEngineCalculationService = newRuleEngineCalculationService(cartRaoToOrderConverter,
				minimumAmountValidationStrategy, orderUtils, currencyUtils, raoUtils);
	}

	private MinimumAmountValidationStrategy newMinimumAmountValidationStrategy()
	{
		return new DefaultMinimumAmountValidationStrategy();
	}

	private DefaultRuleEngineCalculationService newRuleEngineCalculationService(
			final AbstractOrderRaoToOrderConverter abstractOrderRaoToOrderConverter,

			final MinimumAmountValidationStrategy minimumAmountValidationStrategy, final OrderUtils orderUtils,
			final CurrencyUtils currencyUtils, final RaoUtils raoUtils)

	{
		final DefaultRuleEngineCalculationService ruleEngineCalculationService = new DefaultRuleEngineCalculationService();
		ruleEngineCalculationService.setAbstractOrderRaoToOrderConverter(abstractOrderRaoToOrderConverter);
		ruleEngineCalculationService.setMinimumAmountValidationStrategy(minimumAmountValidationStrategy);
		ruleEngineCalculationService.setOrderUtils(orderUtils);
		ruleEngineCalculationService.setCurrencyUtils(currencyUtils);
		ruleEngineCalculationService.setRaoUtils(raoUtils);
		ruleEngineCalculationService.setLineItemLookupStrategy(new DefaultNumberedLineItemLookupStrategy());
		ruleEngineCalculationService.setConsumptionSupport(raoConsumptionSupport);
		return ruleEngineCalculationService;
	}

	private Map<OrderEntrySelectionStrategy, EntriesSelectionStrategy> newUnitForBundleSelectorStrategies()
	{
		final Map<OrderEntrySelectionStrategy, EntriesSelectionStrategy> result = new EnumMap<>(OrderEntrySelectionStrategy.class);
		result.put(OrderEntrySelectionStrategy.CHEAPEST, new CheapestEntriesSelectionStrategy());
		return result;
	}

	private AbstractOrderRaoToOrderConverter newCartRaoToOrderConverter(
			final OrderEntryRaoToNumberedLineItemConverter orderEntryRaoToNumberedLineItemConverter,
			final AbstractOrderRaoToCurrencyConverter cartRaoToCurrencyConverter, final OrderUtils orderUtils, final RaoUtils raoUtils)
	{
		final AbstractOrderRaoToOrderConverter cartRaoToOrderConverter = new AbstractOrderRaoToOrderConverter();
		cartRaoToOrderConverter.setOrderEntryRaoToNumberedLineItemConverter(orderEntryRaoToNumberedLineItemConverter);
		cartRaoToOrderConverter.setAbstractOrderRaoToCurrencyConverter(cartRaoToCurrencyConverter);
		final CalculationStrategies calculationStrategies = new CalculationStrategies();
		calculationStrategies.setRoundingStrategy(new DefaultRoundingStrategy());
		calculationStrategies.setTaxRoundingStrategy(new DefaultTaxRoundingStrategy());
		cartRaoToOrderConverter.setCalculationStrategies(calculationStrategies);
		cartRaoToOrderConverter.setOrderUtils(orderUtils);
		cartRaoToOrderConverter.setRaoUtils(raoUtils);
		return cartRaoToOrderConverter;
	}

	private OrderEntryRaoToNumberedLineItemConverter newOrderEntryRaoToNumberedLineItemConverter(
			final AbstractOrderRaoToCurrencyConverter cartRaoToCurrencyConverter)
	{
		final OrderEntryRaoToNumberedLineItemConverter orderEntryRaoToNumberedLineItemConverter = new OrderEntryRaoToNumberedLineItemConverter();
		orderEntryRaoToNumberedLineItemConverter.setAbstractOrderRaoToCurrencyConverter(cartRaoToCurrencyConverter);
		return orderEntryRaoToNumberedLineItemConverter;
	}

	private AbstractOrderRaoToCurrencyConverter newAbstractOrderRaoToCurrencyConverter(final CurrencyUtils currencyUtils)
	{
		final AbstractOrderRaoToCurrencyConverter abstractOrderRaoToCurrencyConverter = new AbstractOrderRaoToCurrencyConverter();
		abstractOrderRaoToCurrencyConverter.setCurrencyUtils(currencyUtils);
		return abstractOrderRaoToCurrencyConverter;
	}

	private DefaultRaoService newDefaultRaoService()
	{
		return new DefaultRaoService();
	}

	protected Set<OrderEntryRAO> set(final OrderEntryRAO... entries)
	{
		return new LinkedHashSet<>(Arrays.asList(entries));
	}

	protected CartRAO createCartRAO(final String code, final String currencyIso)
	{
		final CartRAO cart = raoService.createCart();
		cart.setCode(code);
		cart.setCurrencyIsoCode(currencyIso);
		return cart;
	}

	protected OrderEntryRAO createOrderEntryRAO(final AbstractOrderRAO order, final String basePrice, final String currencyIso,
			final int quantity)
	{
		return createOrderEntryRAO(order, basePrice, currencyIso, quantity, ++entryNumber);
	}

	protected OrderEntryRAO createOrderEntryRAO(final String basePrice, final String currencyIso, final int quantity,
			final int entryNumber)
	{
		return createOrderEntryRAO(null, basePrice, currencyIso, quantity, entryNumber);
	}

	protected OrderEntryRAO createOrderEntryRAO(final AbstractOrderRAO order, final String basePrice, final String currencyIso,
			final int quantity, final int entryNumber)
	{
		final OrderEntryRAO entry = raoService.createOrderEntry();
		entry.setOrder(order);
		entry.setCurrencyIsoCode(currencyIso);
		entry.setEntryNumber(Integer.valueOf(entryNumber));
		entry.setBasePrice(new BigDecimal(basePrice));
		entry.setPrice(new BigDecimal(basePrice));
		entry.setQuantity(quantity);
		entry.setProductCode("product01");
		return entry;
	}

	protected DiscountRAO createDiscount(final AbstractActionedRAO discountFor, final String discountValue,
			final String currencyIso)
	{
		final DiscountRAO discountRAO = new DiscountRAO();
		discountRAO.setCurrencyIsoCode(currencyIso);
		discountRAO.setValue(new BigDecimal(discountValue));
		discountFor.getActions().add(discountRAO);
		return discountRAO;
	}

	protected EntriesSelectionStrategyRPD createEntriesSelectionStrategyRPD(final OrderEntrySelectionStrategy strategy,
			final int quantity, final boolean isTargetOfAction, final OrderEntryRAO... orderEntryRAO)
	{
		final EntriesSelectionStrategyRPD rao = raoService.createEntriesSelectionStrategyRPD();
		rao.setSelectionStrategy(strategy);
		rao.setQuantity(quantity);
		rao.setOrderEntries(Arrays.asList(orderEntryRAO));
		rao.setTargetOfAction(isTargetOfAction);
		return rao;
	}

	protected DefaultRuleEngineCalculationService getRuleEngineCalculationService()
	{
		return ruleEngineCalculationService;
	}

	public void setRuleEngineCalculationService(final DefaultRuleEngineCalculationService ruleEngineCalculationService)
	{
		this.ruleEngineCalculationService = ruleEngineCalculationService;
	}

	protected DefaultRaoService getRaoService()
	{
		return raoService;
	}

	public void setRaoService(final DefaultRaoService raoService)
	{
		this.raoService = raoService;
	}

	protected AbstractOrderRaoToOrderConverter getCartRaoToOrderConverter()
	{
		return cartRaoToOrderConverter;
	}

	public void setCartRaoToOrderConverter(final AbstractOrderRaoToOrderConverter cartRaoToOrderConverter)
	{
		this.cartRaoToOrderConverter = cartRaoToOrderConverter;
	}

	protected AbstractOrderRaoToCurrencyConverter getAbstractOrderRaoToCurrencyConverter()
	{
		return abstractOrderRaoToCurrencyConverter;
	}

	public void setAbstractOrderRaoToCurrencyConverter(
			final AbstractOrderRaoToCurrencyConverter abstractOrderRaoToCurrencyConverter)
	{
		this.abstractOrderRaoToCurrencyConverter = abstractOrderRaoToCurrencyConverter;
	}

	protected Map<OrderEntrySelectionStrategy, EntriesSelectionStrategy> getUnitForBundleSelectorStrategies()
	{
		return unitForBundleSelectorStrategies;
	}

	public void setUnitForBundleSelectorStrategies(
			final Map<OrderEntrySelectionStrategy, EntriesSelectionStrategy> unitForBundleSelectorStrategies)
	{
		this.unitForBundleSelectorStrategies = unitForBundleSelectorStrategies;
	}
}
