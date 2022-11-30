/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
@ApiModel(value="itemSynchronization")
public  class ItemSynchronizationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ItemSynchronizationWsDTO.itemId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="itemId") 	
	private String itemId;

	/** <i>Generated property</i> for <code>ItemSynchronizationWsDTO.itemType</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="itemType") 	
	private String itemType;
	
	public ItemSynchronizationWsDTO()
	{
		// default constructor
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
	

}