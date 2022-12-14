/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.search.comparators;

import de.hybris.platform.acceleratorservices.store.LocalStorePreferencesService;
import de.hybris.platform.commerceservices.storefinder.data.PointOfServiceDistanceData;
import de.hybris.platform.commerceservices.util.AbstractComparator;
import de.hybris.platform.storelocator.pos.PointOfServiceService;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


public class PointOfServiceDistanceComparator extends AbstractComparator<String> implements Serializable
{
	private static final long serialVersionUID = -3676621945952972017L;
	private transient PointOfServiceService pointOfServiceService;
	private transient LocalStorePreferencesService localStorePreferencesService;

	protected PointOfServiceService getPointOfServiceService()
	{
		return pointOfServiceService;
	}

	@Required
	public void setPointOfServiceService(final PointOfServiceService pointOfServiceService)
	{
		this.pointOfServiceService = pointOfServiceService;
	}

	protected LocalStorePreferencesService getLocalStorePreferencesService()
	{
		return localStorePreferencesService;
	}

	@Required
	public void setLocalStorePreferencesService(final LocalStorePreferencesService localStorePreferencesService)
	{
		this.localStorePreferencesService = localStorePreferencesService;
	}

	@Override
	protected int compareInstances(final String value1, final String value2)
	{
		if (getLocalStorePreferencesService() != null)
		{
			final List<PointOfServiceDistanceData> locations = getLocalStorePreferencesService().getAllPointsOfService();
			if (locations != null && !locations.isEmpty())
			{
				return compareDistances(value1, value2, locations);
			}
		}
		return compareValues(value1, value2, false);
	}

	protected int compareDistances(final String value1, final String value2, final List<PointOfServiceDistanceData> locations)
	{
		PointOfServiceDistanceData result1 = null;
		PointOfServiceDistanceData result2 = null;
		for (final PointOfServiceDistanceData location : locations)
		{
			if (location != null && location.getPointOfService() != null)
			{
				result1 = getPointOfServiceDistanceData(value1, result1, location);
				result2 = getPointOfServiceDistanceData(value2, result2, location);
			}
		}
		if (result1 != null && result2 != null)
		{
			return getResult(value1, value2, result1, result2);
		}
		return compareValues(value1, value2, false);
	}

	protected int getResult(final String value1, final String value2, final PointOfServiceDistanceData result1,
			final PointOfServiceDistanceData result2)
	{
		int result = compareValues(result1.getDistanceKm(), result2.getDistanceKm());
		if (EQUAL == result)
		{
			result = compareValues(value1, value2, false);
		}
		return result;
	}

	protected PointOfServiceDistanceData getPointOfServiceDistanceData(final String value, PointOfServiceDistanceData result,
			final PointOfServiceDistanceData location)
	{
		return value.equals(location.getPointOfService().getName()) ? location : result;
	}
}
