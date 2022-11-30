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
public  class SyncPermissionsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncPermissionsData.targetCatalogVersion</code> property defined at extension <code>permissionsfacades</code>. */
	
	private String targetCatalogVersion;

	/** <i>Generated property</i> for <code>SyncPermissionsData.canSynchronize</code> property defined at extension <code>permissionsfacades</code>. */
	
	private boolean canSynchronize;
	
	public SyncPermissionsData()
	{
		// default constructor
	}
	
	public void setTargetCatalogVersion(final String targetCatalogVersion)
	{
		this.targetCatalogVersion = targetCatalogVersion;
	}

	public String getTargetCatalogVersion() 
	{
		return targetCatalogVersion;
	}
	
	public void setCanSynchronize(final boolean canSynchronize)
	{
		this.canSynchronize = canSynchronize;
	}

	public boolean isCanSynchronize() 
	{
		return canSynchronize;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final SyncPermissionsData other = (SyncPermissionsData) o;
		return Objects.equals(getTargetCatalogVersion(), other.getTargetCatalogVersion())

			&& Objects.equals(isCanSynchronize(), other.isCanSynchronize());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = targetCatalogVersion;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = canSynchronize;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}