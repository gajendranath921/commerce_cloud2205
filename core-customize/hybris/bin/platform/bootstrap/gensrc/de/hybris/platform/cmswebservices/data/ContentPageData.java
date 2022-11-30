/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Specifies properties of the content page.
 *
 * @deprecated no longer needed
 */
@ApiModel(value="ContentPageData", description="Specifies properties of the content page.")
@Deprecated(since = "6.6", forRemoval = true)
public  class ContentPageData extends AbstractPageData 

{



	/** <i>Generated property</i> for <code>ContentPageData.label</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="label") 	
	private String label;

	/** <i>Generated property</i> for <code>ContentPageData.path</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="path") 	
	private String path;
	
	public ContentPageData()
	{
		// default constructor
	}
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	
	public void setPath(final String path)
	{
		this.path = path;
	}

	public String getPath() 
	{
		return path;
	}
	

}