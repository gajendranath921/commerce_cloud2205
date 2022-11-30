/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bcommercefacades.company.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class B2BUnitNodeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.id</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.name</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.parent</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String parent;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.active</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private boolean active;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.children</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private List<B2BUnitNodeData> children;
	
	public B2BUnitNodeData()
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
	
	public void setParent(final String parent)
	{
		this.parent = parent;
	}

	public String getParent() 
	{
		return parent;
	}
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

	public boolean isActive() 
	{
		return active;
	}
	
	public void setChildren(final List<B2BUnitNodeData> children)
	{
		this.children = children;
	}

	public List<B2BUnitNodeData> getChildren() 
	{
		return children;
	}
	

}