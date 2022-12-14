/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.provider.impl;

import static org.junit.Assert.fail;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.ValueRange;
import de.hybris.platform.solrfacetsearch.config.ValueRangeSet;
import de.hybris.platform.solrfacetsearch.config.ValueRangeSets;
import de.hybris.platform.solrfacetsearch.config.ValueRangeType;
import de.hybris.platform.solrfacetsearch.config.ValueRanges;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.RangeNameProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultRangeNameProviderTest
{
	private static final String RANGE_0_49 = "0-49";
	private static final String RANGE_20_99 = "20-99";
	private static final String RANGE_40_99 = "40-99";
	private static final String USD_QUALIFIER = "USD";
	private static final String DOUBLE_PROPERTY_NAME = "price";

	private RangeNameProvider rangeNameProvider;

	@Mock
	private IndexedProperty doubleProperty;

	@Before
	public void setUp() throws Exception
	{
		rangeNameProvider = new DefaultRangeNameProvider();
		prepareMockObjects();
	}

	@Test
	public void getRangeNameListTest()
	{
		final Object valueFromOneRange_10 = Double.valueOf(10.0);
		final Object valueFromTwoRanges_30 = Double.valueOf(30.0);
		final Object valueFromThreeRanges_45 = Double.valueOf(45.0);

		try
		{
			List<String> rangeNameList = rangeNameProvider.getRangeNameList(doubleProperty, valueFromOneRange_10, USD_QUALIFIER);
			Assertions.assertThat(rangeNameList).contains(RANGE_0_49);

			rangeNameList = rangeNameProvider.getRangeNameList(doubleProperty, valueFromTwoRanges_30, USD_QUALIFIER);
			Assertions.assertThat(rangeNameList).contains(RANGE_0_49, RANGE_20_99);

			rangeNameList = rangeNameProvider.getRangeNameList(doubleProperty, valueFromThreeRanges_45, USD_QUALIFIER);
			Assertions.assertThat(rangeNameList).contains(RANGE_0_49, RANGE_20_99, RANGE_40_99);
		}
		catch (final FieldValueProviderException e)
		{
			fail();
		}
	}

	@Test
	public void getRangeNameForNonMultivaluePropertyTest()
	{
		final Object valueFromThreeRanges_45 = Double.valueOf(45.0);

		Mockito.when(Boolean.valueOf(doubleProperty.isMultiValue())).thenReturn(Boolean.FALSE);

		List<String> rangeNameList;
		try
		{
			rangeNameList = rangeNameProvider.getRangeNameList(doubleProperty, valueFromThreeRanges_45, USD_QUALIFIER);
			Assertions.assertThat(rangeNameList).contains(RANGE_0_49);

		}
		catch (final FieldValueProviderException e)
		{
			fail();
		}

	}

	private void prepareMockObjects()
	{
		final List<ValueRange> valueRangesUSD = new ArrayList<ValueRange>();
		valueRangesUSD.add(ValueRanges.createValueRange(RANGE_0_49, Double.valueOf(0.0), Double.valueOf(49.0)));
		valueRangesUSD.add(ValueRanges.createValueRange(RANGE_20_99, Double.valueOf(20.0), Double.valueOf(99.0)));
		valueRangesUSD.add(ValueRanges.createValueRange(RANGE_40_99, Double.valueOf(40.0), Double.valueOf(99.0)));
		final ValueRangeSet valueRangeSetUSD = ValueRangeSets.createValueRangeSet(USD_QUALIFIER, valueRangesUSD);


		//Mockito.when(Boolean.valueOf(IndexedProperties.isRanged(doubleProperty))).thenReturn(Boolean.TRUE);
		Mockito.when(Boolean.valueOf(doubleProperty.isMultiValue())).thenReturn(Boolean.TRUE);
		Mockito.when(doubleProperty.getValueRangeSets()).thenReturn(Collections.singletonMap(USD_QUALIFIER, valueRangeSetUSD));
		Mockito.when(doubleProperty.getType()).thenReturn(ValueRangeType.DOUBLE.toString());
		Mockito.when(doubleProperty.getName()).thenReturn(DOUBLE_PROPERTY_NAME);
	}
}
