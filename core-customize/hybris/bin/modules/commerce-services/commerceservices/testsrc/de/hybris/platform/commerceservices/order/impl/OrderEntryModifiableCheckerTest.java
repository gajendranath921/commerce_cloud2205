/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.order.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 *
 * 
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class OrderEntryModifiableCheckerTest
{
	private final OrderEntryModifiableChecker checker = new OrderEntryModifiableChecker();

	@Mock(lenient = true)
	public AbstractOrderEntryModel model;

	@Test
	public void testGiveAwayFalseBasePriceNull()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(null);
		BDDMockito.given(model.getGiveAway()).willReturn(Boolean.FALSE);

		Assert.assertTrue(checker.canModify(model));
	}

	@Test
	public void testGiveAwayFalseBasePriceZero()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(Double.valueOf(0.0));
		BDDMockito.given(model.getGiveAway()).willReturn(Boolean.FALSE);

		Assert.assertTrue(checker.canModify(model));
	}

	@Test
	public void testGiveAwayFalseBasePriceNotNull()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(Double.valueOf(10.0));
		BDDMockito.given(model.getGiveAway()).willReturn(Boolean.FALSE);

		Assert.assertTrue(checker.canModify(model));
	}


	@Test
	public void testGiveAwayTrueBasePriceNull()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(null);
		BDDMockito.given(model.getGiveAway()).willReturn(Boolean.TRUE);

		Assert.assertFalse(checker.canModify(model));
	}

	@Test
	public void testGiveAwayTrueBasePriceZero()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(Double.valueOf(0.0));
		BDDMockito.given(model.getGiveAway()).willReturn(Boolean.TRUE);

		Assert.assertFalse(checker.canModify(model));
	}

	@Test
	public void testGiveAwayTrueBasePriceNotNull()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(Double.valueOf(10.0));
		BDDMockito.given(model.getGiveAway()).willReturn(Boolean.TRUE);

		Assert.assertFalse(checker.canModify(model));
	}


	@Test
	public void testGiveAwayNullBasePriceNull()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(null);
		BDDMockito.given(model.getGiveAway()).willReturn(null);

		Assert.assertTrue(checker.canModify(model));
	}

	@Test
	public void testGiveAwayNullBasePriceZero()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(Double.valueOf(0.0));
		BDDMockito.given(model.getGiveAway()).willReturn(null);

		Assert.assertTrue(checker.canModify(model));
	}

	@Test
	public void testGiveAwayNullBasePriceNotNull()
	{

		BDDMockito.given(model.getBasePrice()).willReturn(Double.valueOf(10.0));
		BDDMockito.given(model.getGiveAway()).willReturn(null);

		Assert.assertTrue(checker.canModify(model));
	}

}
