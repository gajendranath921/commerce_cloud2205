/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.ybackoffice.jalo;

import static org.junit.Assert.assertTrue;

import de.hybris.platform.testframework.HybrisJUnit4TransactionalTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * JUnit Tests for the Ybackoffice extension
 */
public class YBackofficeTest extends HybrisJUnit4TransactionalTest
{
	@Before
	public void setUp()
	{
		// implement here code executed before each test
	}

	@After
	public void tearDown()
	{
		// implement here code executed after each test
	}

	/**
	 * This is a sample test method.
	 */
	@Test
	public void testYbackoffice()
	{
		final boolean testTrue = true;
		assertTrue("true is not true", testTrue);
	}
}
