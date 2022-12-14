/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.dataimport.batch.converter;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jalo.Item;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test for {@link PriceTranslator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class PriceTranslatorTest
{
	private PriceTranslator translator;
	@Mock
	private Item item;

	@Before
	public void setUp()
	{
		translator = new PriceTranslator();
	}

	@Test
	public void testNull()
	{
		Assert.assertNull(translator.importValue(null, item));
	}

	@Test
	public void testEmpty()
	{
		Assert.assertNull(translator.importValue("", item));
	}

	@Test
	public void testNumberFormat()
	{
		Assert.assertNull(translator.importValue("abc", item));
		Assert.assertTrue(translator.wasUnresolved());
	}

	@Test
	public void testNegativeValue()
	{
		Assert.assertEquals(translator.importValue("-10", item), Double.valueOf(-10));
		Assert.assertTrue(translator.wasUnresolved());
	}

	@Test
	public void testPositiveValue()
	{
		Assert.assertEquals(translator.importValue("10", item), Double.valueOf(10));
		Assert.assertFalse(translator.wasUnresolved());
	}

	@Test
	public void testZero()
	{
		Assert.assertEquals(translator.importValue("0", item), Double.valueOf(0));
		Assert.assertFalse(translator.wasUnresolved());
	}

}
