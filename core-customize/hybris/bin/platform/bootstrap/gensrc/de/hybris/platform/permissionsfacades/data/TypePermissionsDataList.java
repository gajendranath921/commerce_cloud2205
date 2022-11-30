/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionsfacades.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
/**
 * List type of permissions for any specific principal.
 */
public  class TypePermissionsDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** ID of the principal to replace the permissions<br/><br/><i>Generated property</i> for <code>TypePermissionsDataList.principalUid</code> property defined at extension <code>permissionsfacades</code>. */
	
	private String principalUid;

	/** List type of permissions for any specific principal.<br/><br/><i>Generated property</i> for <code>TypePermissionsDataList.permissionsList</code> property defined at extension <code>permissionsfacades</code>. */
	
	private List<TypePermissionsData> permissionsList;
	
	public TypePermissionsDataList()
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
	
	public void setPermissionsList(final List<TypePermissionsData> permissionsList)
	{
		this.permissionsList = permissionsList;
	}

	public List<TypePermissionsData> getPermissionsList() 
	{
		return permissionsList;
	}
	

}