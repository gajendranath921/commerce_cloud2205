/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.configurablebundleservices.interceptor.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.configurablebundleservices.model.PickExactlyNBundleSelectionCriteriaModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test that the pick exactly N selection criteria has at least 1 selection
 */
@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class PickExactlyNBundleSelectionCriteriaValidateInterceptorTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	private InterceptorContext ctx;

	@Test
	public void validateSelectionNumberGreaterThanOrEqual1() throws InterceptorException
	{
		callInterceptor(Integer.valueOf(1));
	}

	/**
	 * @throws InterceptorException
	 * 
	 */
	private void callInterceptor(final Integer n) throws InterceptorException
	{
		final PickExactlyNBundleSelectionCriteriaValidateInterceptor interceptor = new PickExactlyNBundleSelectionCriteriaValidateInterceptor();
		final PickExactlyNBundleSelectionCriteriaModel model = new PickExactlyNBundleSelectionCriteriaModel();
		model.setN(n);

		interceptor.onValidate(model, ctx);
	}

	@Test
	public void validateSelectionNumberLesserThan1() throws InterceptorException
	{
		thrown.expect(InterceptorException.class);
		thrown.expectMessage("number must be greater than or equal to 1");

		callInterceptor(Integer.valueOf(0));

	}
}
