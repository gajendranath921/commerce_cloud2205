/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.savedorderformsocc.dto;

import java.io.Serializable;
import de.hybris.platform.savedorderformsocc.dto.OrderFormWsDTO;
import java.util.List;


import java.util.Objects;
public  class OrderFormListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderFormListWsDTO.orderForms</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private List<OrderFormWsDTO> orderForms;
	
	public OrderFormListWsDTO()
	{
		// default constructor
	}
	
	public void setOrderForms(final List<OrderFormWsDTO> orderForms)
	{
		this.orderForms = orderForms;
	}

	public List<OrderFormWsDTO> getOrderForms() 
	{
		return orderForms;
	}
	

}