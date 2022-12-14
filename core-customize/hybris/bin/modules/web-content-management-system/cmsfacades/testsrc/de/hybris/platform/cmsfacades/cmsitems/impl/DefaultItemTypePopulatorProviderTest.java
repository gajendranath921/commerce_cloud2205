/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class DefaultItemTypePopulatorProviderTest
{

	private static final String CHILD_TYPE = "CHILD_TYPE";
	private static final String PARENT_TYPE = "PARENT_TYPE";
	private static final String INVALID_TYPE = "INVALID_TYPE";
	
	@Mock
	private TypeService typeService;
	
	@InjectMocks
	private DefaultItemTypePopulatorProvider itemTypePopulatorProvider;

	private Map<String, Populator<Map<String, Object>, ItemModel>> populatorsMap = new HashMap<>();

	@Mock
	private ComposedTypeModel parentComposedType;
	
	@Mock
	private ComposedTypeModel childComposedType;
	@Mock
	private Populator<Map<String, Object>, ItemModel> childPopulator;
	@Mock
	private Populator<Map<String, Object>, ItemModel> parentPopulator;

	@Before
	public void setup() 
	{
		when(childComposedType.getSuperType()).thenReturn(parentComposedType);
		when(childComposedType.getCode()).thenReturn(CHILD_TYPE);
		
		when(parentComposedType.getCode()).thenReturn(PARENT_TYPE);
		
		when(typeService.getComposedTypeForCode(PARENT_TYPE)).thenReturn(parentComposedType);
		when(typeService.getComposedTypeForCode(CHILD_TYPE)).thenReturn(childComposedType);

		when(typeService.getComposedTypeForCode(INVALID_TYPE)).thenThrow(UnknownIdentifierException.class);

		itemTypePopulatorProvider.setPopulatorsMap(populatorsMap);
	}
	
	@Test
	public void testWhenTypeCodeIsInvalid_shouldReturnEmptyPopulator()
	{
		final Optional<Populator<Map<String, Object>, ItemModel>> itemTypePopulator = itemTypePopulatorProvider
				.getItemTypePopulator(INVALID_TYPE);
		assertThat(itemTypePopulator.isPresent(), is(false));
	}
	
	@Test
	public void testWhenChildTypeHasPopulator_shouldReturnChildPopulator()
	{
		populatorsMap.put(CHILD_TYPE, childPopulator);
		final Optional<Populator<Map<String, Object>, ItemModel>> itemTypePopulator = itemTypePopulatorProvider
				.getItemTypePopulator(CHILD_TYPE);
		assertThat(itemTypePopulator.isPresent(), is(true));
		assertThat(itemTypePopulator.get(), is(childPopulator));
	}


	@Test
	public void testWhenParentTypeHasPopulator_shouldReturnParentPopulator()
	{
		populatorsMap.put(PARENT_TYPE, parentPopulator);
		
		final Optional<Populator<Map<String, Object>, ItemModel>> itemTypePopulator = itemTypePopulatorProvider
				.getItemTypePopulator(CHILD_TYPE);
		assertThat(itemTypePopulator.isPresent(), is(true));
		assertThat(itemTypePopulator.get(), is(parentPopulator));
	}

	@Test
	public void testWhenNoPopulatorWasFound_shouldReturnEmptyPopulator()
	{
		final Optional<Populator<Map<String, Object>, ItemModel>> itemTypePopulator = itemTypePopulatorProvider
				.getItemTypePopulator(CHILD_TYPE);
		assertThat(itemTypePopulator.isPresent(), is(false));
	}
}
