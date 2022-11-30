/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import de.hybris.platform.cmswebservices.data.ComposedTypeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Specifies property of the page type.
 */
@ApiModel(value="PageTypeData", description="Specifies property of the page type.")
public  class PageTypeData extends ComposedTypeData 

{



	/** <i>Generated property</i> for <code>PageTypeData.type</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="type", example="ContentPage") 	
	private String type;
	
	public PageTypeData()
	{
		// default constructor
	}
	
	/**
	 * @deprecated no longer needed
	 */
	@Deprecated(since = "1811", forRemoval = true)
	public void setType(final String type)
	{
		this.type = type;
	}

	/**
	 * @deprecated no longer needed
	 */
	@Deprecated(since = "1811", forRemoval = true)
	public String getType() 
	{
		return type;
	}
	

}