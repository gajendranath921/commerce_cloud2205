/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionsfacades.data;

import java.io.Serializable;


import java.util.Objects;
/**
 * CRUD permission values for any specific principal and type.
 */
public  class PermissionValuesData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Specifies if permission to read the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesData.read</code> property defined at extension <code>permissionsfacades</code>. */
	
	private Boolean read;

	/** Specifies if permission to create the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesData.create</code> property defined at extension <code>permissionsfacades</code>. */
	
	private Boolean create;

	/** Specifies if permission to update the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesData.change</code> property defined at extension <code>permissionsfacades</code>. */
	
	private Boolean change;

	/** Specifies if permission to delete the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesData.remove</code> property defined at extension <code>permissionsfacades</code>. */
	
	private Boolean remove;

	/** Specifies if permission to change permissions on the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesData.changerights</code> property defined at extension <code>permissionsfacades</code>. */
	
	private Boolean changerights;
	
	public PermissionValuesData()
	{
		// default constructor
	}
	
	public void setRead(final Boolean read)
	{
		this.read = read;
	}

	public Boolean getRead() 
	{
		return read;
	}
	
	public void setCreate(final Boolean create)
	{
		this.create = create;
	}

	public Boolean getCreate() 
	{
		return create;
	}
	
	public void setChange(final Boolean change)
	{
		this.change = change;
	}

	public Boolean getChange() 
	{
		return change;
	}
	
	public void setRemove(final Boolean remove)
	{
		this.remove = remove;
	}

	public Boolean getRemove() 
	{
		return remove;
	}
	
	public void setChangerights(final Boolean changerights)
	{
		this.changerights = changerights;
	}

	public Boolean getChangerights() 
	{
		return changerights;
	}
	

}