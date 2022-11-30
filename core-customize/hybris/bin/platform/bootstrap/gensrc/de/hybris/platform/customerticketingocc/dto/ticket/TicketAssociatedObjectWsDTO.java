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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Represents an object that can be associated with a ticket. The object could be a cart or an order item.
 */
@ApiModel(value="TicketAssociatedObject", description="Represents an object that can be associated with a ticket. The object could be a cart or an order item.")
public  class TicketAssociatedObjectWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Associated object code<br/><br/><i>Generated property</i> for <code>TicketAssociatedObjectWsDTO.code</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="code", value="Associated object code", required=true, example="00001000") 	
	private String code;

	/** Type of associated objects, Cart or Order<br/><br/><i>Generated property</i> for <code>TicketAssociatedObjectWsDTO.type</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="type", value="Type of associated objects, Cart or Order", required=true, example="Cart") 	
	private String type;

	/** Last modified time<br/><br/><i>Generated property</i> for <code>TicketAssociatedObjectWsDTO.modifiedAt</code> property defined at extension <code>customerticketingocc</code>. */
@ApiModelProperty(name="modifiedAt", value="Last modified time", example="2021-01-13T10:06:57+0000") 	
	private Date modifiedAt;
	
	public TicketAssociatedObjectWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setModifiedAt(final Date modifiedAt)
	{
		this.modifiedAt = modifiedAt;
	}

	public Date getModifiedAt() 
	{
		return modifiedAt;
	}
	

}