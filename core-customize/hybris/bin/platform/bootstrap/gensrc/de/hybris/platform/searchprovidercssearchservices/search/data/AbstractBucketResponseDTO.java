/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;


import java.util.Objects;
public abstract  class AbstractBucketResponseDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractBucketResponseDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>AbstractBucketResponseDTO.name</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>AbstractBucketResponseDTO.count</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer count;
	
	public AbstractBucketResponseDTO()
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
	
	public void setCount(final Integer count)
	{
		this.count = count;
	}

	public Integer getCount() 
	{
		return count;
	}
	

}