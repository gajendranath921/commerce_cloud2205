/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.order.strategies.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.QuoteEntryModel;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.order.InvalidCartException;
import de.hybris.platform.order.strategies.ordercloning.CloneAbstractOrderStrategy;
import de.hybris.platform.servicelayer.keygenerator.KeyGenerator;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultCreateQuoteFromCartStrategyTest
{
	@InjectMocks
	private final DefaultCreateQuoteFromCartStrategy defaultCreateQuoteFromCartStrategy = new DefaultCreateQuoteFromCartStrategy();

	@Mock
	private TypeService typeService;
	@Mock
	private CloneAbstractOrderStrategy cloneAbstractOrderStrategy;
	@Mock
	private KeyGenerator keyGenerator;
	@Mock
	private ModelService modelService;

	@Test
	public void shouldCreateQuoteFromCart() throws InvalidCartException
	{
		final CartModel cartModel = new CartModel();

		final ComposedTypeModel composedTypeModel = mock(ComposedTypeModel.class);
		final String quoteCode = "quoteCode";
		Mockito.lenient().when(typeService.getComposedTypeForClass(any(Class.class))).thenReturn(composedTypeModel);
		given(defaultCreateQuoteFromCartStrategy.generateCode()).willReturn(quoteCode);
		given(cloneAbstractOrderStrategy.clone(null, null, cartModel, quoteCode, QuoteModel.class, QuoteEntryModel.class))
				.willReturn(new QuoteModel());

		final QuoteModel quote = defaultCreateQuoteFromCartStrategy.createQuoteFromCart(cartModel);

		assertNotNull("Quote is null", quote);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateQuoteFromQuoteIfCartIsNull()
	{
		defaultCreateQuoteFromCartStrategy.createQuoteFromCart(null);
	}
}
