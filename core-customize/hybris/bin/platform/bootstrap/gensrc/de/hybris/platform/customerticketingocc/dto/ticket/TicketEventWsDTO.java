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
import de.hybris.platform.customerticketingocc.dto.ticket.TicketStatusWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of the ticket event object.
 */
@ApiModel(value="TicketEvent", description="Representation of the ticket event object.")
public  class TicketEventWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Name of the user who initiated this ticket event<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.author</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="author", value="Name of the user who initiated this ticket event", example="Mark Rivers") 	
	private String author;

	/** Datetime when this event is created <br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.createdAt</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="createdAt", value="Datetime when this event is created", example="2021-01-13T10:06:57+0000") 	
	private Date createdAt;

	/** Detailed description of your question<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.message</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="message", value="Detailed description of your question", required=true, example="It is broken when I receive it. Please send one replacement to me.") 	
	private String message;

	/** Whether this event is added by agent or not.<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.addedByAgent</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="addedByAgent", value="Whether this event is added by agent or not.", example="false") 	
	private Boolean addedByAgent;

	/** <i>Generated property</i> for <code>TicketEventWsDTO.toStatus</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="toStatus") 	
	private TicketStatusWsDTO toStatus;
	
	public TicketEventWsDTO()
	{
		// default constructor
	}
	
	public void setAuthor(final String author)
	{
		this.author = author;
	}

	public String getAuthor() 
	{
		return author;
	}
	
	public void setCreatedAt(final Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() 
	{
		return createdAt;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setAddedByAgent(final Boolean addedByAgent)
	{
		this.addedByAgent = addedByAgent;
	}

	public Boolean getAddedByAgent() 
	{
		return addedByAgent;
	}
	
	public void setToStatus(final TicketStatusWsDTO toStatus)
	{
		this.toStatus = toStatus;
	}

	public TicketStatusWsDTO getToStatus() 
	{
		return toStatus;
	}
	

}