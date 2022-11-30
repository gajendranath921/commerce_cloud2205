/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Specifies a restriction type that can be applied to a given page type.
 */
@ApiModel(value="PageTypeRestrictionTypeData", description="Specifies a restriction type that can be applied to a given page type.")
public  class PageTypeRestrictionTypeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTypeRestrictionTypeData.pageType</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="pageType", example="ContentPage") 	
	private String pageType;

	/** <i>Generated property</i> for <code>PageTypeRestrictionTypeData.restrictionType</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="restrictionType", example="CMSUserGroupRestriction") 	
	private String restrictionType;
	
	public PageTypeRestrictionTypeData()
	{
		// default constructor
	}
	
	public void setPageType(final String pageType)
	{
		this.pageType = pageType;
	}

	public String getPageType() 
	{
		return pageType;
	}
	
	public void setRestrictionType(final String restrictionType)
	{
		this.restrictionType = restrictionType;
	}

	public String getRestrictionType() 
	{
		return restrictionType;
	}
	

}