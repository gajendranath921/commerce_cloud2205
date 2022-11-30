/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractBucketRequestDTO;


import java.util.Objects;
public  class RangeBucketRequestDTO extends AbstractBucketRequestDTO 

{



	/** <i>Generated property</i> for <code>RangeBucketRequestDTO.from</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Object from;

	/** <i>Generated property</i> for <code>RangeBucketRequestDTO.to</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Object to;
	
	public RangeBucketRequestDTO()
	{
		// default constructor
	}
	
	public void setFrom(final Object from)
	{
		this.from = from;
	}

	public Object getFrom() 
	{
		return from;
	}
	
	public void setTo(final Object to)
	{
		this.to = to;
	}

	public Object getTo() 
	{
		return to;
	}
	

}