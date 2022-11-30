/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.quote.QuoteWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Quote result list.
 */
@ApiModel(value="QuoteList", description="Representation of a Quote result list.")
public  class QuoteListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of quotes.<br/><br/><i>Generated property</i> for <code>QuoteListWsDTO.quotes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="quotes", value="List of quotes.") 	
	private List<QuoteWsDTO> quotes;

	/** Pagination of quotes list.<br/><br/><i>Generated property</i> for <code>QuoteListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="pagination", value="Pagination of quotes list.") 	
	private PaginationWsDTO pagination;
	
	public QuoteListWsDTO()
	{
		// default constructor
	}
	
	public void setQuotes(final List<QuoteWsDTO> quotes)
	{
		this.quotes = quotes;
	}

	public List<QuoteWsDTO> getQuotes() 
	{
		return quotes;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	

}