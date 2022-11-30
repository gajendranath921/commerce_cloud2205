/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.admin.data;

import java.io.Serializable;


import java.util.Objects;
public  class IndexDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>IndexDTO.indexTypeId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String indexTypeId;

	/** <i>Generated property</i> for <code>IndexDTO.active</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean active;
	
	public IndexDTO()
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
	
	public void setIndexTypeId(final String indexTypeId)
	{
		this.indexTypeId = indexTypeId;
	}

	public String getIndexTypeId() 
	{
		return indexTypeId;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final IndexDTO other = (IndexDTO) o;
		return Objects.equals(getIndexTypeId(), other.getIndexTypeId());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = indexTypeId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}