/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.suggest.data;

import java.io.Serializable;


import java.util.Objects;
public  class SuggestQueryDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SuggestQueryDTO.query</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String query;

	/** <i>Generated property</i> for <code>SuggestQueryDTO.limit</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer limit;
	
	public SuggestQueryDTO()
	{
		// default constructor
	}
	
	public void setQuery(final String query)
	{
		this.query = query;
	}

	public String getQuery() 
	{
		return query;
	}
	
	public void setLimit(final Integer limit)
	{
		this.limit = limit;
	}

	public Integer getLimit() 
	{
		return limit;
	}
	

}