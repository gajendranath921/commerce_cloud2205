/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bcommercefacades.company.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class B2BSelectionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BSelectionData.id</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>B2BSelectionData.selected</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private boolean selected;

	/** <i>Generated property</i> for <code>B2BSelectionData.active</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private boolean active;

	/** <i>Generated property</i> for <code>B2BSelectionData.roles</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private List<String> roles;

	/** <i>Generated property</i> for <code>B2BSelectionData.displayRoles</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private List<String> displayRoles;

	/** <i>Generated property</i> for <code>B2BSelectionData.normalizedCode</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String normalizedCode;
	
	public B2BSelectionData()
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