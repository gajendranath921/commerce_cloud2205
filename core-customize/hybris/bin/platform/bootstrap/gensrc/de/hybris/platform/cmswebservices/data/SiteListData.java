/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;


import java.util.Objects;
/**
 * Specified a list of available sites.
 */
@ApiModel(value="SiteListData", description="Specified a list of available sites.")
public  class SiteListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SiteListData.sites</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="sites") 	
	private Collection<SiteData> sites;
	
	public SiteListData()
	{
		// default constructor
	}
	
	public void setSites(final Collection<SiteData> sites)
	{
		this.sites = sites;
	}

	public Collection<SiteData> getSites() 
	{
		return sites;
	}
	

}