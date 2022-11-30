/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketAssociatedObjectWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Represents a list of ticket associated objects.
 */
@ApiModel(value="TicketAssociatedObjectList", description="Represents a list of ticket associated objects.")
public  class TicketAssociatedObjectListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketAssociatedObjectListWsDTO.ticketAssociatedObjects</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="ticketAssociatedObjects") 	
	private List<TicketAssociatedObjectWsDTO> ticketAssociatedObjects;
	
	public TicketAssociatedObjectListWsDTO()
	{
		// default constructor
	}
	
	public void setTicketAssociatedObjects(final List<TicketAssociatedObjectWsDTO> ticketAssociatedObjects)
	{
		this.ticketAssociatedObjects = ticketAssociatedObjects;
	}

	public List<TicketAssociatedObjectWsDTO> getTicketAssociatedObjects() 
	{
		return ticketAssociatedObjects;
	}
	

}