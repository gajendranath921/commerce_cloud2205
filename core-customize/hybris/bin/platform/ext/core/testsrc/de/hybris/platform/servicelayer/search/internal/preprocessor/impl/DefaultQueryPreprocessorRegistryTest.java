/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.search.internal.preprocessor.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.internal.preprocessor.QueryPreprocessorRegistry;
import de.hybris.platform.servicelayer.search.preprocessor.QueryPreprocessor;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultQueryPreprocessorRegistryTest
{
	private final QueryPreprocessorRegistry registry = new DefaultQueryPreprocessorRegistry();
	@Mock
	private QueryPreprocessor preprocessor1;
	@Mock
	private QueryPreprocessor preprocessor2;
	@Mock
	private QueryPreprocessor preprocessor3;
	@Mock
	private FlexibleSearchQuery query;

	/**
	 * Test method for
	 * {@link de.hybris.platform.servicelayer.search.internal.preprocessor.impl.DefaultQueryPreprocessorRegistry#executeAllPreprocessors(FlexibleSearchQuery)}
	 * .
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenFlexibleSearchQueryIsNull()
	{
		registry.executeAllPreprocessors(null);
	}

	/**
	 * Test method for
	 * {@link de.hybris.platform.servicelayer.search.internal.preprocessor.impl.DefaultQueryPreprocessorRegistry#executeAllPreprocessors(FlexibleSearchQuery)}
	 * .
	 */
	@Test
	public void shouldIterateOverAllRegisteredPreprocessorsAndExecuteEachOfThem()
	{
		// given
		final Map<String, QueryPreprocessor> preprocessors = new HashMap<>();
		preprocessors.put("preprocessor1", preprocessor1);
		preprocessors.put("preprocessor2", preprocessor2);
		preprocessors.put("preprocessor3", preprocessor3);
		((DefaultQueryPreprocessorRegistry) registry).setQueryPreprocessors(preprocessors);

		// when
		registry.executeAllPreprocessors(query);

		// then
		verify(preprocessor1, times(1)).process(query);
		verify(preprocessor2, times(1)).process(query);
		verify(preprocessor3, times(1)).process(query);
	}
}
