/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.namedquery.service.impl;


import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.exceptions.InvalidNamedQueryException;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class NamedQueryFactoryTest
{

	private static final String QUERY = "QUERY";
	private static final String QUERY_NAME = "QUERY_NAME";
	@Mock
	Map<String, String> namedQueryDefinitionMap;

	@InjectMocks
	DefaultNamedQueryFactory namedQueryFactory;

	@Test(expected = InvalidNamedQueryException.class)
	public void testInvalidNamedQueryException() throws InvalidNamedQueryException
	{
		Mockito.when(namedQueryDefinitionMap.containsKey(Mockito.anyString())).thenReturn(false);
		namedQueryFactory.getNamedQuery(Mockito.anyString());
	}

	@Test
	public void testRetrieveNamedQuery() throws InvalidNamedQueryException
	{
		Mockito.when(namedQueryDefinitionMap.containsKey(Mockito.anyString())).thenReturn(true);
		Mockito.when(namedQueryDefinitionMap.get(Mockito.anyString())).thenReturn(QUERY);

		final String resultingQuery = namedQueryFactory.getNamedQuery(QUERY_NAME);
		Assert.assertEquals(QUERY, resultingQuery);
	}
}
