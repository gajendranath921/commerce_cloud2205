/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
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
 * Ticket category
 */
@ApiModel(value="TicketCategory", description="Ticket category")
public  class TicketCategoryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Localised category name<br/><br/><i>Generated property</i> for <code>TicketCategoryWsDTO.name</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="name", value="Localised category name", example="Enquiry") 	
	private String name;

	/** Category id<br/><br/><i>Generated property</i> for <code>TicketCategoryWsDTO.id</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="id", value="Category id", required=true, example="ENQUIRY") 	
	private String id;
	
	public TicketCategoryWsDTO()
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