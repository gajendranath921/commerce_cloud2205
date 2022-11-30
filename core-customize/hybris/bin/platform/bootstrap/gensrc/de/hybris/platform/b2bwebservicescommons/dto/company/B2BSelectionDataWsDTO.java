/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of object selection data
 */
@ApiModel(value="B2BSelectionData", description="Representation of object selection data")
public  class B2BSelectionDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The ID of the selected object<br/><br/><i>Generated property</i> for <code>B2BSelectionDataWsDTO.id</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="id", value="The ID of the selected object", example="Retail_2K") 	
	private String id;

	/** If the this object was selected<br/><br/><i>Generated property</i> for <code>B2BSelectionDataWsDTO.selected</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="selected", value="If the this object was selected", example="true") 	
	private boolean selected;

	/** If this object is active<br/><br/><i>Generated property</i> for <code>B2BSelectionDataWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="active", value="If this object is active", example="false") 	
	private boolean active;

	/** roles<br/><br/><i>Generated property</i> for <code>B2BSelectionDataWsDTO.roles</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="roles", value="roles") 	
	private List<String> roles;

	/** display roles<br/><br/><i>Generated property</i> for <code>B2BSelectionDataWsDTO.displayRoles</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="displayRoles", value="display roles") 	
	private List<String> displayRoles;

	/** The normalized code<br/><br/><i>Generated property</i> for <code>B2BSelectionDataWsDTO.normalizedCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="normalizedCode", value="The normalized code") 	
	private String normalizedCode;
	
	public B2BSelectionDataWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

	public boolean isSelected() 
	{
		return selected;
	}
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

	public boolean isActive() 
	{
		return active;
	}
	
	public void setRoles(final List<String> roles)
	{
		this.roles = roles;
	}

	public List<String> getRoles() 
	{
		return roles;
	}
	
	public void setDisplayRoles(final List<String> displayRoles)
	{
		this.displayRoles = displayRoles;
	}

	public List<String> getDisplayRoles() 
	{
		return displayRoles;
	}
	
	public void setNormalizedCode(final String normalizedCode)
	{
		this.normalizedCode = normalizedCode;
	}

	public String getNormalizedCode() 
	{
		return normalizedCode;
	}
	

}