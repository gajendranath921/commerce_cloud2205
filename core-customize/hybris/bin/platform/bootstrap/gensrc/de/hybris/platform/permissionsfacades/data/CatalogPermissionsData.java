/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionsfacades.data;

import java.io.Serializable;
import de.hybris.platform.permissionsfacades.data.SyncPermissionsData;
import java.util.List;
import java.util.Map;


import java.util.Objects;
public  class CatalogPermissionsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.catalogId</code> property defined at extension <code>permissionsfacades</code>. */
	
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.catalogVersion</code> property defined at extension <code>permissionsfacades</code>. */
	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.permissions</code> property defined at extension <code>permissionsfacades</code>. */
	
	private Map<String, String> permissions;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.syncPermissions</code> property defined at extension <code>permissionsfacades</code>. */
	
	private List<SyncPermissionsData> syncPermissions;
	
	public CatalogPermissionsData()
	{
		// default constructor
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setPermissions(final Map<String, String> permissions)
	{
		this.permissions = permissions;
	}

	public Map<String, String> getPermissions() 
	{
		return permissions;
	}
	
	public void setSyncPermissions(final List<SyncPermissionsData> syncPermissions)
	{
		this.syncPermissions = syncPermissions;
	}

	public List<SyncPermissionsData> getSyncPermissions() 
	{
		return syncPermissions;
	}
	

}