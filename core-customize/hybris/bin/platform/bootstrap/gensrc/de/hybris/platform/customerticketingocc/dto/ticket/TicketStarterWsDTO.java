/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketAssociatedObjectWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketCategoryWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of objects containing a set of fields for ticket creation.
 */
@ApiModel(value="TicketStarter", description="Representation of objects containing a set of fields for ticket creation.")
public  class TicketStarterWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** subject of ticket<br/><br/><i>Generated property</i> for <code>TicketStarterWsDTO.subject</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="subject", value="subject of ticket", required=true, example="My drill is broken.") 	
	private String subject;

	/** Detailed description of your question<br/><br/><i>Generated property</i> for <code>TicketStarterWsDTO.message</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="message", value="Detailed description of your question", required=true, example="It is broken when I receive it. Please send one replacement to me.") 	
	private String message;

	/** <i>Generated property</i> for <code>TicketStarterWsDTO.ticketCategory</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="ticketCategory", required=true) 	
	private TicketCategoryWsDTO ticketCategory;

	/** <i>Generated property</i> for <code>TicketStarterWsDTO.associatedTo</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="associatedTo") 	
	private TicketAssociatedObjectWsDTO associatedTo;
	
	public TicketStarterWsDTO()
	{
		// default constructor
	}
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setTicketCategory(final TicketCategoryWsDTO ticketCategory)
	{
		this.ticketCategory = ticketCategory;
	}

	public TicketCategoryWsDTO getTicketCategory() 
	{
		return ticketCategory;
	}
	
	public void setAssociatedTo(final TicketAssociatedObjectWsDTO associatedTo)
	{
		this.associatedTo = associatedTo;
	}

	public TicketAssociatedObjectWsDTO getAssociatedTo() 
	{
		return associatedTo;
	}
	

}