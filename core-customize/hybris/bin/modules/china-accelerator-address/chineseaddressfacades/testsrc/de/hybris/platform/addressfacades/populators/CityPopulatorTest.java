/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.addressfacades.populators;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.addressfacades.data.CityData;
import de.hybris.platform.addressservices.model.CityModel;
import de.hybris.platform.core.model.c2l.C2LItemModel;
import de.hybris.platform.servicelayer.i18n.I18NService;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class CityPopulatorTest
{
	private static final String CITY_ISOCODE = "CN-11-1";
	private static final String CITY_NAME = "Beijing";
	@Mock
	I18NService i18NService;

	private CityPopulator cityPopulator;

	@Before
	public void setUp()
	{
		cityPopulator = new CityPopulator();
		ReflectionTestUtils.setField(cityPopulator, "i18NService", i18NService);
	}

	@Test
	public void testCityPopulator()
	{
		final C2LItemModel cityModel = new CityModel();
		cityModel.setIsocode(CITY_ISOCODE);

		final Locale englishLocale = new Locale("en");
		cityModel.setName(CITY_NAME, englishLocale);

		final CityData cityData = new CityData();
		Mockito.when(i18NService.getCurrentLocale()).thenReturn(englishLocale);

		cityPopulator.populate(cityModel, cityData);

		Assert.assertEquals(CITY_ISOCODE, cityData.getCode());
		Assert.assertEquals(CITY_NAME, cityData.getName());
	}
}
