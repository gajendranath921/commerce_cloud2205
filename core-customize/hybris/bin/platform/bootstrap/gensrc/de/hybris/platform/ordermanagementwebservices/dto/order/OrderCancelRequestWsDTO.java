/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.order;

import java.io.Serializable;
import de.hybris.platform.ordermanagementwebservices.dto.order.OrderCancelEntryWsDTO;
import java.util.List;


import java.util.Objects;
public  class OrderCancelRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderCancelRequestWsDTO.entries</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<OrderCancelEntryWsDTO> entries;

	/** <i>Generated property</i> for <code>OrderCancelRequestWsDTO.userId</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String userId;
	
	public OrderCancelRequestWsDTO()
	{
		// default constructor
	}
	
	public void setEntries(final List<OrderCancelEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<OrderCancelEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
	public void setUserId(final String userId)
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	

}