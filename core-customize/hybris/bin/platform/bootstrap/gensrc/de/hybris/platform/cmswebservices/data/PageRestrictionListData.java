/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.PageRestrictionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available page restrictions.
 */
@ApiModel(value="PageRestrictionListData", description="Specifies a list of available page restrictions.")
public  class PageRestrictionListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageRestrictionListData.pageRestrictionList</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="pageRestrictionList") 	
	private List<PageRestrictionData> pageRestrictionList;
	
	public PageRestrictionListData()
	{
		// default constructor
	}
	
	public void setPageRestrictionList(final List<PageRestrictionData> pageRestrictionList)
	{
		this.pageRestrictionList = pageRestrictionList;
	}

	public List<PageRestrictionData> getPageRestrictionList() 
	{
		return pageRestrictionList;
	}
	

}