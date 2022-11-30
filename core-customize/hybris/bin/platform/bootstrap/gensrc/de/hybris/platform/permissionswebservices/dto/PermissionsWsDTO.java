/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Permissions for principal
 */
@ApiModel(value="Permissions", description="Permissions for principal")
public  class PermissionsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Principal identifier<br/><br/><i>Generated property</i> for <code>PermissionsWsDTO.id</code> property defined at extension <code>permissionswebservices</code>. */
@ApiModelProperty(name="id", value="Principal identifier", required=true) 	
	private String id;

	/** Permissions map.<br/><br/><i>Generated property</i> for <code>PermissionsWsDTO.permissions</code> property defined at extension <code>permissionswebservices</code>. */
@ApiModelProperty(name="permissions", value="Permissions map.") 	
	private Map<String, String> permissions;
	
	public PermissionsWsDTO()
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
	
	public void setPermissions(final Map<String, String> permissions)
	{
		this.permissions = permissions;
	}

	public Map<String, String> getPermissions() 
	{
		return permissions;
	}
	

}