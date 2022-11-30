/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.store.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.store.data.StoreCountData;
import java.util.List;


import java.util.Objects;
public  class StoreCountListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StoreCountListData.countriesAndRegionsStoreCount</code> property defined at extension <code>commercewebservices</code>. */
	
	private List<StoreCountData> countriesAndRegionsStoreCount;
	
	public StoreCountListData()
	{
		// default constructor
	}
	
	public void setCountriesAndRegionsStoreCount(final List<StoreCountData> countriesAndRegionsStoreCount)
	{
		this.countriesAndRegionsStoreCount = countriesAndRegionsStoreCount;
	}

	public List<StoreCountData> getCountriesAndRegionsStoreCount() 
	{
		return countriesAndRegionsStoreCount;
	}
	

}