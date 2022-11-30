/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
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
 * Specifies properties of the navigation entry.
 */
@ApiModel(value="NavigationEntryData", description="Specifies properties of the navigation entry.")
public  class NavigationEntryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationEntryData.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name", example="My Account") 	
	private String name;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemId</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="itemId", example="DigitalCompactsCategoryLink") 	
	private String itemId;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemType</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="itemType", example="CMSNavigationNode") 	
	private String itemType;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemSuperType</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="itemSuperType", example="AbstractCMSComponent") 	
	private String itemSuperType;
	
	public NavigationEntryData()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setItemId(final String itemId)
	{
		this.itemId = itemId;
	}

	public String getItemId() 
	{
		return itemId;
	}
	
	public void setItemType(final String itemType)
	{
		this.itemType = itemType;
	}

	public String getItemType() 
	{
		return itemType;
	}
	
	public void setItemSuperType(final String itemSuperType)
	{
		this.itemSuperType = itemSuperType;
	}

	public String getItemSuperType() 
	{
		return itemSuperType;
	}
	

}