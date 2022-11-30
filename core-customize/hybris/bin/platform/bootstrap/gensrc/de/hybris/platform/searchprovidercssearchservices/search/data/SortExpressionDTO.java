/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;


import java.util.Objects;
public  class SortExpressionDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SortExpressionDTO.expression</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String expression;

	/** <i>Generated property</i> for <code>SortExpressionDTO.ascending</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean ascending;
	
	public SortExpressionDTO()
	{
		// default constructor
	}
	
	public void setExpression(final String expression)
	{
		this.expression = expression;
	}

	public String getExpression() 
	{
		return expression;
	}
	
	public void setAscending(final Boolean ascending)
	{
		this.ascending = ascending;
	}

	public Boolean getAscending() 
	{
		return ascending;
	}
	

}