/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearchbackoffice.data.AsCategoryData;
import java.util.List;


import java.util.Objects;
public  class AsCategoryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsCategoryData.code</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>AsCategoryData.name</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>AsCategoryData.virtual</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean virtual;

	/** <i>Generated property</i> for <code>AsCategoryData.children</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private List<AsCategoryData> children;
	
	public AsCategoryData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setVirtual(final boolean virtual)
	{
		this.virtual = virtual;
	}

	public boolean isVirtual() 
	{
		return virtual;
	}
	
	public void setChildren(final List<AsCategoryData> children)
	{
		this.children = children;
	}

	public List<AsCategoryData> getChildren() 
	{
		return children;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final AsCategoryData other = (AsCategoryData) o;
		return Objects.equals(getCode(), other.getCode())

			&& Objects.equals(getName(), other.getName())

			&& Objects.equals(isVirtual(), other.isVirtual())

			&& Objects.equals(getChildren(), other.getChildren());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = code;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = name;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = virtual;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = children;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}