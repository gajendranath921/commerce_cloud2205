/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.store.data;

import java.io.Serializable;
import de.hybris.platform.commerceservices.store.data.GeoPoint;


import java.util.Objects;
public  class UserLocationData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserLocationData.searchTerm</code> property defined at extension <code>acceleratorservices</code>. */
	
	private String searchTerm;

	/** <i>Generated property</i> for <code>UserLocationData.point</code> property defined at extension <code>acceleratorservices</code>. */
	
	private GeoPoint point;
	
	public UserLocationData()
	{
		// default constructor
	}
	
	public void setSearchTerm(final String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	public String getSearchTerm() 
	{
		return searchTerm;
	}
	
	public void setPoint(final GeoPoint point)
	{
		this.point = point;
	}

	public GeoPoint getPoint() 
	{
		return point;
	}
	

}