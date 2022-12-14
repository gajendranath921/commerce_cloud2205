/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.order.strategies.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.enums.QuoteState;
import de.hybris.platform.core.model.order.QuoteEntryModel;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.order.strategies.ordercloning.CloneAbstractOrderStrategy;
import de.hybris.platform.servicelayer.type.TypeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultCreateQuoteSnapshotStrategyTest
{
	@InjectMocks
	private final DefaultCreateQuoteSnapshotStrategy defaultCreateQuoteSnapshotStrategy = new DefaultCreateQuoteSnapshotStrategy();

	@Mock
	private TypeService typeService;
	@Mock
	private CloneAbstractOrderStrategy cloneAbstractOrderStrategy;

	@Test
	public void shouldCreateQuoteSnapshot()
	{
		final QuoteModel cloneResult = new QuoteModel();
		final QuoteModel quoteModel = cloneResult;
		quoteModel.setState(QuoteState.DRAFT);
		final Integer version = Integer.valueOf(1);
		quoteModel.setVersion(version);
		final String quoteCode = "00002";
		quoteModel.setCode(quoteCode);

		final ComposedTypeModel composedTypeModel = mock(ComposedTypeModel.class);
		Mockito.lenient().when(typeService.getComposedTypeForClass(any(Class.class))).thenReturn(composedTypeModel);
		given(cloneAbstractOrderStrategy.clone(null, null, quoteModel, quoteCode, QuoteModel.class, QuoteEntryModel.class))
				.willReturn(cloneResult);

		final QuoteModel quoteCloneResult = defaultCreateQuoteSnapshotStrategy
				.createQuoteSnapshot(quoteModel, QuoteState.SUBMITTED);

		assertNotNull("Quote clone result is null", quoteCloneResult);
		assertEquals("Quote code is wrong", quoteCode, quoteCloneResult.getCode());
		assertEquals("Quote state is wrong", QuoteState.SUBMITTED, quoteCloneResult.getState());
		assertEquals("Version is not increased by 1", Integer.valueOf(version.intValue() + 1), quoteCloneResult.getVersion());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateQuoteSnapshotIfQuoteIsNull()
	{
		defaultCreateQuoteSnapshotStrategy.createQuoteSnapshot(null, QuoteState.SUBMITTED);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateQuoteSnapshotIfQuoteStateIsNull()
	{
		defaultCreateQuoteSnapshotStrategy.createQuoteSnapshot(new QuoteModel(), null);
	}
}
