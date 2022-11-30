/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class CategoryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CategoryData.code</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>CategoryData.path</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private List<String> path;
	
	public CategoryData()
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
	
	public void setPath(final List<String> path)
	{
		this.path = path;
	}

	public List<String> getPath() 
	{
		return path;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final CategoryData other = (CategoryData) o;
		return Objects.equals(getCode(), other.getCode())

			&& Objects.equals(getPath(), other.getPath());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = code;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = path;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}