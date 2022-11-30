/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * List type of permissions for any specific principal.
 */
@ApiModel(value="TypePermissionsList", description="List type of permissions for any specific principal.")
public  class TypePermissionsListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** ID of the principal to replace the permissions<br/><br/><i>Generated property</i> for <code>TypePermissionsListWsDTO.principalUid</code> property defined at extension <code>permissionswebservices</code>. */
@ApiModelProperty(name="principalUid", value="ID of the principal to replace the permissions", required=true) 	
	private String principalUid;

	/** List type of permissions for any specific principal.<br/><br/><i>Generated property</i> for <code>TypePermissionsListWsDTO.permissionsList</code> property defined at extension <code>permissionswebservices</code>. */
@ApiModelProperty(name="permissionsList", value="List type of permissions for any specific principal.", required=true) 	
	private List<TypePermissionsWsDTO> permissionsList;
	
	public TypePermissionsListWsDTO()
	{
		// default constructor
	}
	
	public void setPrincipalUid(final String principalUid)
	{
		this.principalUid = principalUid;
	}

	public String getPrincipalUid() 
	{
		return principalUid;
	}
	
	public void setPermissionsList(final List<TypePermissionsWsDTO> permissionsList)
	{
		this.permissionsList = permissionsList;
	}

	public List<TypePermissionsWsDTO> getPermissionsList() 
	{
		return permissionsList;
	}
	

}