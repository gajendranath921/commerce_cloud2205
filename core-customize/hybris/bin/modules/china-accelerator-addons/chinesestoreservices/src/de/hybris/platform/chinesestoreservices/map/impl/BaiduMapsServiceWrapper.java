/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesestoreservices.map.impl;

import de.hybris.platform.storelocator.GPS;
import de.hybris.platform.storelocator.data.AddressData;
import de.hybris.platform.storelocator.impl.CommerceMockGeoWebServiceWrapper;
import de.hybris.platform.storelocator.location.Location;
import de.hybris.platform.util.Config;

import org.springframework.beans.factory.annotation.Required;


/**
 * The wrapper that performs communication with baidu geo-location services
 */
public class BaiduMapsServiceWrapper extends CommerceMockGeoWebServiceWrapper
{
	private static final String BAIDU_GEOCODING_URL = "baidu.geocoding.url";
	private static final String BAIDU_RESPONSE_OUTPUT = "baidu.response.output";
	private static final String BAIDU_API_KEY = "baiduApiKey";
	private static final String BAIDU_RESPONSE_OUTPUT_MODE = "json";

	private static final String BAIDU_GEOCODING_URL_DEFAULT = "https://api.map.baidu.com/geocoder";


	private BaiduMapTools baiduMapTools;


	@Required
	public void setBaiduMapTools(final BaiduMapTools baiduMapTools)
	{
		this.baiduMapTools = baiduMapTools;
	}

	protected BaiduMapTools getMapTools(final String url)

	{
		baiduMapTools.setBaseUrl(url);
		baiduMapTools.setOutput(Config.getString(BAIDU_RESPONSE_OUTPUT, BAIDU_RESPONSE_OUTPUT_MODE));
		baiduMapTools.setBaiduKey(Config.getString(BAIDU_API_KEY, null));


		return baiduMapTools;
	}

	protected BaiduMapTools getMapTools()

	{
		return baiduMapTools;
	}


	@Override
	public String formatAddress(final Location address)
	{
		return getMapTools().getAddressQuery(address.getAddressData());
	}


	@Override
	public GPS geocodeAddress(final Location location)
	{
		final BaiduMapTools mapTools = getMapTools(Config.getString(BAIDU_GEOCODING_URL, BAIDU_GEOCODING_URL_DEFAULT));

		return mapTools.geocodeAddress(location);
	}


	@Override
	public GPS geocodeAddress(final AddressData address)
	{
		final BaiduMapTools mapTools = getMapTools(Config.getString(BAIDU_GEOCODING_URL, BAIDU_GEOCODING_URL_DEFAULT));

		return mapTools.geocodeAddress(address);
	}


}
