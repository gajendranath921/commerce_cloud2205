/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.sap.productconfig.occ.CsticWsDTO;
import de.hybris.platform.sap.productconfig.occ.GroupWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a group in the context of the product configuration
 */
@ApiModel(value="CCPGroup", description="Representation of a group in the context of the product configuration")
public  class GroupWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Group Identifier<br/><br/><i>Generated property</i> for <code>GroupWsDTO.id</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="id", value="Group Identifier", example="1-CONF_LAPTOP.AUDIO") 	
	private String id;

	/** Language independent group name<br/><br/><i>Generated property</i> for <code>GroupWsDTO.name</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="name", value="Language independent group name", example="AUDIO") 	
	private String name;

	/** Language dependent group description<br/><br/><i>Generated property</i> for <code>GroupWsDTO.description</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="description", value="Language dependent group description", example="Audio Options") 	
	private String description;

	/** Group contains attributes. False if the group represents a non-configurable leaf in the configuration hierarchy<br/><br/><i>Generated property</i> for <code>GroupWsDTO.configurable</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="configurable", value="Group contains attributes. False if the group represents a non-configurable leaf in the configuration hierarchy", example="true") 	
	private boolean configurable;

	/** Group is consistent, meaning it contains no conflicts<br/><br/><i>Generated property</i> for <code>GroupWsDTO.consistent</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="consistent", value="Group is consistent, meaning it contains no conflicts", example="true") 	
	private boolean consistent;

	/** Group is complete, meaning each mandatory attribute has been specified<br/><br/><i>Generated property</i> for <code>GroupWsDTO.complete</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="complete", value="Group is complete, meaning each mandatory attribute has been specified", example="true") 	
	private boolean complete;

	/** INSTANCE<br/><br/><i>Generated property</i> for <code>GroupWsDTO.groupType</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="groupType", value="INSTANCE") 	
	private String groupType;

	/** List of attributes<br/><br/><i>Generated property</i> for <code>GroupWsDTO.attributes</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="attributes", value="List of attributes") 	
	private List<CsticWsDTO> attributes;

	/** List of subordinate groups<br/><br/><i>Generated property</i> for <code>GroupWsDTO.subGroups</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="subGroups", value="List of subordinate groups") 	
	private List<GroupWsDTO> subGroups;
	
	public GroupWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setConfigurable(final boolean configurable)
	{
		this.configurable = configurable;
	}

	public boolean isConfigurable() 
	{
		return configurable;
	}
	
	public void setConsistent(final boolean consistent)
	{
		this.consistent = consistent;
	}

	public boolean isConsistent() 
	{
		return consistent;
	}
	
	public void setComplete(final boolean complete)
	{
		this.complete = complete;
	}

	public boolean isComplete() 
	{
		return complete;
	}
	
	public void setGroupType(final String groupType)
	{
		this.groupType = groupType;
	}

	public String getGroupType() 
	{
		return groupType;
	}
	
	public void setAttributes(final List<CsticWsDTO> attributes)
	{
		this.attributes = attributes;
	}

	public List<CsticWsDTO> getAttributes() 
	{
		return attributes;
	}
	
	public void setSubGroups(final List<GroupWsDTO> subGroups)
	{
		this.subGroups = subGroups;
	}

	public List<GroupWsDTO> getSubGroups() 
	{
		return subGroups;
	}
	

}