/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.frontend.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.sap.productconfig.facades.CsticData;

import org.junit.Before;
import org.junit.Test;


@UnitTest
public class MandatoryFieldErrorTest
{
	private MandatoryFieldError classUnderTest;
	private MandatoryFieldError other;

	@Before
	public void setUp()
	{
		final CsticData cstic = new CsticData();
		classUnderTest = new MandatoryFieldError(cstic, "fieldName", "rejectedValue", new String[]
		{ "100" }, "defaultMessage");
		other = new MandatoryFieldError(cstic, "fieldName", "rejectedValue", new String[]
		{ "100" }, "defaultMessage");

	}

	@Test
	public void testSame()
	{
		assertEquals(classUnderTest.hashCode(), classUnderTest.hashCode());
	}

	@Test
	public void testEqual()
	{
		assertEquals(classUnderTest, other);
		assertEquals(classUnderTest.hashCode(), other.hashCode());
	}

	@Test
	public void testUnEqual()
	{
		other = new MandatoryFieldError(new CsticData(), "fieldName", "rejectedValue", new String[]
		{ "100" }, "defaultMessage");
		assertNotEquals(classUnderTest, other);
	}

}
