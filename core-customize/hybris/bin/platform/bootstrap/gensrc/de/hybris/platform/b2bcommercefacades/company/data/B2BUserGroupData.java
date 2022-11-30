/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bcommercefacades.company.data;

import de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.commercefacades.user.data.UserGroupData;
import java.util.List;


import java.util.Objects;
public  class B2BUserGroupData extends UserGroupData 

{



	/** <i>Generated property</i> for <code>B2BUserGroupData.roles</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private List<String> roles;

	/** <i>Generated property</i> for <code>B2BUserGroupData.unit</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private B2BUnitData unit;

	/** <i>Generated property</i> for <code>B2BUserGroupData.selected</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private boolean selected;

	/** <i>Generated property</i> for <code>B2BUserGroupData.normalizedId</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String normalizedId;

	/** <i>Generated property</i> for <code>B2BUserGroupData.editable</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private boolean editable;

	/** <i>Generated property</i> for <code>B2BUserGroupData.permissions</code> property defined at extension <code>b2bapprovalprocessfacades</code>. */
	
	private List<B2BPermissionData> permissions;
	
	public B2BUserGroupData()
	{
		// default constructor
	}
	
	public void setRoles(final List<String> roles)
	{
		this.roles = roles;
	}

	public List<String> getRoles() 
	{
		return roles;
	}
	
	public void setUnit(final B2BUnitData unit)
	{
		this.unit = unit;
	}

	public B2BUnitData getUnit() 
	{
		return unit;
	}
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

	public boolean isSelected() 
	{
		return selected;
	}
	
	public void setNormalizedId(final String normalizedId)
	{
		this.normalizedId = normalizedId;
	}

	public String getNormalizedId() 
	{
		return normalizedId;
	}
	
	public void setEditable(final boolean editable)
	{
		this.editable = editable;
	}

	public boolean isEditable() 
	{
		return editable;
	}
	
	public void setPermissions(final List<B2BPermissionData> permissions)
	{
		this.permissions = permissions;
	}

	public List<B2BPermissionData> getPermissions() 
	{
		return permissions;
	}
	

}