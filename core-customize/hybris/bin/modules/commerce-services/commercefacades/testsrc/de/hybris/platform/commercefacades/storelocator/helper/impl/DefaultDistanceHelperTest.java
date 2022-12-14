/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.storelocator.helper.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.enums.DistanceUnit;
import de.hybris.platform.commercefacades.storelocator.helpers.impl.DefaultDistanceHelper;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;
import de.hybris.platform.storelocator.pos.PointOfServiceService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test suite for {@link DefaultDistanceHelperTest}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultDistanceHelperTest
{
	private static final double DISTANCE_KM = 100;
	private static final double DISTANCE_MILES = 99.78;
	private static final String FORMATTED_DISTANCE_KM = "100 km";
	private static final String FORMATTED_DISTANCE_MILES = "62 miles";
	private static final String LOCATION_NAME = "location";


	@Mock
	private PointOfServiceService pointOfServiceService;
	@Mock
	private EnumerationService enumerationService;

	private DefaultDistanceHelper defaultDistanceHelper;

	@Before
	public void setUp()
	{
		given(enumerationService.getEnumerationName(DistanceUnit.KM)).willReturn("km");
		given(enumerationService.getEnumerationName(DistanceUnit.MILES)).willReturn("miles");

		defaultDistanceHelper = new DefaultDistanceHelper();
		defaultDistanceHelper.setEnumerationService(enumerationService);
		defaultDistanceHelper.setPointOfServiceService(pointOfServiceService);
	}


	@Test
	public void testGetDistanceStringMetric()
	{
		final BaseStoreModel baseStoreModel = mock(BaseStoreModel.class);

		given(baseStoreModel.getStorelocatorDistanceUnit()).willReturn(DistanceUnit.KM);

		final String result = defaultDistanceHelper.getDistanceStringForStore(baseStoreModel, DISTANCE_KM);

		Assert.assertEquals(FORMATTED_DISTANCE_KM, result);
	}


	@Test
	public void testGetDistanceStringImperial()
	{
		final BaseStoreModel baseStoreModel = mock(BaseStoreModel.class);

		given(baseStoreModel.getStorelocatorDistanceUnit()).willReturn(DistanceUnit.MILES);

		final String result = defaultDistanceHelper.getDistanceStringForStore(baseStoreModel, DISTANCE_MILES);

		Assert.assertEquals(FORMATTED_DISTANCE_MILES, result);
	}


	@Test
	public void testGetDistanceString()
	{
		final BaseStoreModel baseStoreModel = mock(BaseStoreModel.class);
		final PointOfServiceModel pointOfServiceModel = mock(PointOfServiceModel.class);

		given(pointOfServiceModel.getBaseStore()).willReturn(baseStoreModel);
		given(baseStoreModel.getStorelocatorDistanceUnit()).willReturn(DistanceUnit.KM);
		given(pointOfServiceService.getPointOfServiceForName(LOCATION_NAME)).willReturn(pointOfServiceModel);

		final String result = defaultDistanceHelper.getDistanceStringForLocation(LOCATION_NAME, DISTANCE_KM);

		Assert.assertEquals(FORMATTED_DISTANCE_KM, result);
	}
}
