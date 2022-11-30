/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionsfacades.data;

import java.io.Serializable;
import java.util.Map;


import java.util.Objects;
public  class PermissionsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PermissionsData.id</code> property defined at extension <code>permissionsfacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>PermissionsData.permissions</code> property defined at extension <code>permissionsfacades</code>. */
	
	private Map<String, String> permissions;
	
	public PermissionsData()
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