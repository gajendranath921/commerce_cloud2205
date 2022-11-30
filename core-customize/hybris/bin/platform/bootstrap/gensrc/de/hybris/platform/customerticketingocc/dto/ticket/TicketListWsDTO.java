/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Represents a list of ticket results.
 */
@ApiModel(value="TicketList", description="Represents a list of ticket results.")
public  class TicketListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of tickets<br/><br/><i>Generated property</i> for <code>TicketListWsDTO.tickets</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="tickets", value="List of tickets") 	
	private List<TicketWsDTO> tickets;

	/** Pagination of ticket list<br/><br/><i>Generated property</i> for <code>TicketListWsDTO.pagination</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="pagination", value="Pagination of ticket list") 	
	private PaginationWsDTO pagination;

	/** Sorts of ticket list<br/><br/><i>Generated property</i> for <code>TicketListWsDTO.sorts</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="sorts", value="Sorts of ticket list") 	
	private List<SortWsDTO> sorts;
	
	public TicketListWsDTO()
	{
		// default constructor
	}
	
	public void setTickets(final List<TicketWsDTO> tickets)
	{
		this.tickets = tickets;
	}

	public List<TicketWsDTO> getTickets() 
	{
		return tickets;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
	}
	

}