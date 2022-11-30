/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.order;

import java.io.Serializable;


import java.util.Objects;
public  class OrderCancelEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderCancelEntryWsDTO.orderEntryNumber</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String orderEntryNumber;

	/** <i>Generated property</i> for <code>OrderCancelEntryWsDTO.cancelQuantity</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private Long cancelQuantity;

	/** <i>Generated property</i> for <code>OrderCancelEntryWsDTO.notes</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String notes;

	/** <i>Generated property</i> for <code>OrderCancelEntryWsDTO.cancelReason</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String cancelReason;
	
	public OrderCancelEntryWsDTO()
	{
		// default constructor
	}
	
	public void setOrderEntryNumber(final String orderEntryNumber)
	{
		this.orderEntryNumber = orderEntryNumber;
	}

	public String getOrderEntryNumber() 
	{
		return orderEntryNumber;
	}
	
	public void setCancelQuantity(final Long cancelQuantity)
	{
		this.cancelQuantity = cancelQuantity;
	}

	public Long getCancelQuantity() 
	{
		return cancelQuantity;
	}
	
	public void setNotes(final String notes)
	{
		this.notes = notes;
	}

	public String getNotes() 
	{
		return notes;
	}
	
	public void setCancelReason(final String cancelReason)
	{
		this.cancelReason = cancelReason;
	}

	public String getCancelReason() 
	{
		return cancelReason;
	}
	

}