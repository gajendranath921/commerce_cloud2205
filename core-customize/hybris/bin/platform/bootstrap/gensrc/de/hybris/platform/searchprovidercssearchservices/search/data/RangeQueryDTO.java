/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractExpressionQueryDTO;


import java.util.Objects;
public  class RangeQueryDTO extends AbstractExpressionQueryDTO 

{



	/** <i>Generated property</i> for <code>RangeQueryDTO.from</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Object from;

	/** <i>Generated property</i> for <code>RangeQueryDTO.includeFrom</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean includeFrom;

	/** <i>Generated property</i> for <code>RangeQueryDTO.to</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Object to;

	/** <i>Generated property</i> for <code>RangeQueryDTO.includeTo</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean includeTo;
	
	public RangeQueryDTO()
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
	
	public void setIncludeFrom(final Boolean includeFrom)
	{
		this.includeFrom = includeFrom;
	}

	public Boolean getIncludeFrom() 
	{
		return includeFrom;
	}
	
	public void setTo(final Object to)
	{
		this.to = to;
	}

	public Object getTo() 
	{
		return to;
	}
	
	public void setIncludeTo(final Boolean includeTo)
	{
		this.includeTo = includeTo;
	}

	public Boolean getIncludeTo() 
	{
		return includeTo;
	}
	

}