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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Ticket status
 */
@ApiModel(value="TicketStatus", description="Ticket status")
public  class TicketStatusWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Localised ticket status<br/><br/><i>Generated property</i> for <code>TicketStatusWsDTO.name</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="name", value="Localised ticket status", example="Closed") 	
	private String name;

	/** Ticket status id<br/><br/><i>Generated property</i> for <code>TicketStatusWsDTO.id</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="id", value="Ticket status id", required=true, example="CLOSED") 	
	private String id;
	
	public TicketStatusWsDTO()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	

}