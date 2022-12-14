/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationcms.customization.dao.impl;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CxCustomizationDaoCatalogParamStrategyLocaleTest
{

	private static final String CURRENT = "current";
	private static final String PARENTS = "parents";
	private static final String ALL = "all";

	private static final String MESSAGE = "toLowerCase mismatched expected word";

	@Before
	public void setup()
	{
		Locale.setDefault(Locale.ROOT);
	}


	@Test
	public void currentTest()
	{
		final String actual = "CURRENT";

		switch (actual.toLowerCase())
		{
			case CURRENT:
				break;
			default:
				Assert.fail(MESSAGE);
		}

	}


	@Test
	public void parentsTest()
	{
		final String actual = "PARENTS";

		switch (actual.toLowerCase())
		{
			case PARENTS:
				break;
			default:
				Assert.fail(MESSAGE);
		}

	}

	@Test
	public void allTest()
	{
		final String actual = "ALL";

		switch (actual.toLowerCase())
		{
			case ALL:
				break;
			default:
				Assert.fail(MESSAGE);
		}

	}
}
