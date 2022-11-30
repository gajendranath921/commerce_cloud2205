/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.search.data.SortExpressionDTO;
import java.util.List;


import java.util.Objects;
public  class SortDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SortDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SortDTO.name</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>SortDTO.applyPromotedHits</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean applyPromotedHits;

	/** <i>Generated property</i> for <code>SortDTO.highlightPromotedHits</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean highlightPromotedHits;

	/** <i>Generated property</i> for <code>SortDTO.expressions</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<SortExpressionDTO> expressions;
	
	public SortDTO()
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
	
	public void setApplyPromotedHits(final Boolean applyPromotedHits)
	{
		this.applyPromotedHits = applyPromotedHits;
	}

	public Boolean getApplyPromotedHits() 
	{
		return applyPromotedHits;
	}
	
	public void setHighlightPromotedHits(final Boolean highlightPromotedHits)
	{
		this.highlightPromotedHits = highlightPromotedHits;
	}

	public Boolean getHighlightPromotedHits() 
	{
		return highlightPromotedHits;
	}
	
	public void setExpressions(final List<SortExpressionDTO> expressions)
	{
		this.expressions = expressions;
	}

	public List<SortExpressionDTO> getExpressions() 
	{
		return expressions;
	}
	

}