/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.navigations.impl;



import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cmsfacades.data.NavigationEntryTypeData;
import de.hybris.platform.cmsfacades.navigationentrytypes.impl.DefaultNavigationEntryTypesFacade;
import de.hybris.platform.cmsfacades.navigations.service.NavigationEntryConverterRegistry;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class DefaultNavigationEntryTypesFacadeTest
{

	private static final String TYPE_1 = "type1";
	private static final String TYPE_2 = "type2";

	@Mock
	private NavigationEntryConverterRegistry navigationEntryConverterRegistry;

	@InjectMocks
	private DefaultNavigationEntryTypesFacade defaultNavigationEntryTypesFacade;

	@Before
	public void setup()
	{
		final Optional<List<String>> supportedTypes = Optional.of(Arrays.asList(TYPE_1, TYPE_2));
		when(navigationEntryConverterRegistry.getSupportedItemTypes()).thenReturn(supportedTypes);
	}

	@Test
	public void testGetSupportedItemTypes()
	{
		final List<NavigationEntryTypeData> navigationEntryTypes = defaultNavigationEntryTypesFacade.getNavigationEntryTypes();
		assertThat(navigationEntryTypes.size(), is(2));
		assertThat(navigationEntryTypes.get(0).getItemType(), is(TYPE_1));
		assertThat(navigationEntryTypes.get(1).getItemType(), is(TYPE_2));
	}
}
