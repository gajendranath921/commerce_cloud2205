/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
@ApiModel(value="CMSWorkflowEditableItemListWsDTO")
public  class CMSWorkflowEditableItemListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowEditableItemListWsDTO.editableItems</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="editableItems") 	
	private List<CMSWorkflowEditableItemWsDTO> editableItems;
	
	public CMSWorkflowEditableItemListWsDTO()
	{
		// default constructor
	}
	
	public void setEditableItems(final List<CMSWorkflowEditableItemWsDTO> editableItems)
	{
		this.editableItems = editableItems;
	}

	public List<CMSWorkflowEditableItemWsDTO> getEditableItems() 
	{
		return editableItems;
	}
	

}