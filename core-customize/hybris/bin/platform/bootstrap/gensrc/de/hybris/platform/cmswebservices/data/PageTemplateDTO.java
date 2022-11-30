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


import java.util.Objects;
/**
 * Specifies properties of the page template for a given page.
 */
@ApiModel(value="PageTemplateDTO", description="Specifies properties of the page template for a given page.")
public  class PageTemplateDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTemplateDTO.pageTypeCode</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="pageTypeCode", example="ContentPage") 	
	private String pageTypeCode;

	/** <i>Generated property</i> for <code>PageTemplateDTO.active</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="active", example="true") 	
	private Boolean active;
	
	public PageTemplateDTO()
	{
		// default constructor
	}
	
	public void setPageTypeCode(final String pageTypeCode)
	{
		this.pageTypeCode = pageTypeCode;
	}

	public String getPageTypeCode() 
	{
		return pageTypeCode;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	

}