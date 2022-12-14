/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationyprofile.mapper.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.personalizationintegration.model.CxMapperScriptModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.google.common.collect.Sets;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultCxScriptConsumptionLayerMapperTest
{
	private static final String FIELD_1 = "field1";
	private static final String FIELD_2 = "field2";
	private static final String FIELD_3 = "field1.field3";
	private static final String FIELD_1_WITH_SPACE = " field1 ";

	private final DefaultCxScriptConsumptionLayerMapper scriptMapper = new DefaultCxScriptConsumptionLayerMapper();

	@Mock
	private FlexibleSearchService flexibleSearchService;

	private final CxMapperScriptModel script1 = new CxMapperScriptModel();
	private final CxMapperScriptModel script2 = new CxMapperScriptModel();

	@Before
	public void setUp()
	{
		scriptMapper.setFlexibleSearchService(flexibleSearchService);
		when(flexibleSearchService.getModelsByExample(any())).thenReturn(Arrays.asList(script1, script2));
	}

	@Test
	public void testGetRequiredFields()
	{
		//given
		script1.setRequiredFields(Sets.newHashSet(FIELD_1, FIELD_2));
		script2.setRequiredFields(Collections.singleton(FIELD_3));

		//when
		final Set<String> requiredFields = scriptMapper.getRequiredFields();

		//then
		assertEquals("Required fields are incorrenct", 3, requiredFields.size());
		assertTrue("Missing field", requiredFields.contains(FIELD_1));
		assertTrue("Missing field", requiredFields.contains(FIELD_2));
		assertTrue("Missing field", requiredFields.contains(FIELD_3));
	}

	@Test
	public void testSetMappersWithDuplicatedFields()
	{
		//given
		script1.setRequiredFields(Sets.newHashSet(FIELD_1, FIELD_2));
		script2.setRequiredFields(Arrays.asList(FIELD_3, FIELD_3, FIELD_2));
		when(flexibleSearchService.getModelsByExample(any())).thenReturn(Arrays.asList(script1, script2));

		//when
		final Set<String> requiredFields = scriptMapper.getRequiredFields();

		//then
		assertEquals("Required fields are incorrenct", 3, requiredFields.size());
		assertTrue("Missing field", requiredFields.contains(FIELD_1));
		assertTrue("Missing field", requiredFields.contains(FIELD_2));
		assertTrue("Missing field", requiredFields.contains(FIELD_3));
	}

	@Test
	public void testSetMappersWithFieldsContainingSpace()
	{
		//given
		script1.setRequiredFields(Sets.newHashSet(FIELD_1, FIELD_2));
		script2.setRequiredFields(Collections.singleton(FIELD_1_WITH_SPACE));
		when(flexibleSearchService.getModelsByExample(any())).thenReturn(Arrays.asList(script1, script2));

		//when
		final Set<String> requiredFields = scriptMapper.getRequiredFields();

		//then
		assertEquals("Required fields are incorrenct", 2, requiredFields.size());
		assertTrue("Missing field", requiredFields.contains(FIELD_1));
		assertTrue("Missing field", requiredFields.contains(FIELD_2));
	}
}
