/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractQueryDTO;
import java.util.List;


import java.util.Objects;
public  class OrQueryDTO extends AbstractQueryDTO 

{



	/** <i>Generated property</i> for <code>OrQueryDTO.queries</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<AbstractQueryDTO> queries;
	
	public OrQueryDTO()
	{
		// default constructor
	}
	
	public void setQueries(final List<AbstractQueryDTO> queries)
	{
		this.queries = queries;
	}

	public List<AbstractQueryDTO> getQueries() 
	{
		return queries;
	}
	

}