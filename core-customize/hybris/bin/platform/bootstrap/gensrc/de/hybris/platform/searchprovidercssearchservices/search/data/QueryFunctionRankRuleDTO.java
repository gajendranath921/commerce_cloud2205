/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractQueryDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractRankRuleDTO;


import java.util.Objects;
public  class QueryFunctionRankRuleDTO extends AbstractRankRuleDTO 

{



	/** <i>Generated property</i> for <code>QueryFunctionRankRuleDTO.query</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private AbstractQueryDTO query;

	/** <i>Generated property</i> for <code>QueryFunctionRankRuleDTO.weight</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Float weight;
	
	public QueryFunctionRankRuleDTO()
	{
		// default constructor
	}
	
	public void setQuery(final AbstractQueryDTO query)
	{
		this.query = query;
	}

	public AbstractQueryDTO getQuery() 
	{
		return query;
	}
	
	public void setWeight(final Float weight)
	{
		this.weight = weight;
	}

	public Float getWeight() 
	{
		return weight;
	}
	

}