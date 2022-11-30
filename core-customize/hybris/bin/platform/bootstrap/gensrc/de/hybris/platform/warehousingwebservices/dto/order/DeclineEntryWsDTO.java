/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.order;

import java.io.Serializable;


import java.util.Objects;
public  class DeclineEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeclineEntryWsDTO.productCode</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>DeclineEntryWsDTO.quantity</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private Long quantity;

	/** <i>Generated property</i> for <code>DeclineEntryWsDTO.reallocationWarehouseCode</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String reallocationWarehouseCode;

	/** <i>Generated property</i> for <code>DeclineEntryWsDTO.reason</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String reason;

	/** <i>Generated property</i> for <code>DeclineEntryWsDTO.comment</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String comment;
	
	public DeclineEntryWsDTO()
	{
		// default constructor
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	
	public void setReallocationWarehouseCode(final String reallocationWarehouseCode)
	{
		this.reallocationWarehouseCode = reallocationWarehouseCode;
	}

	public String getReallocationWarehouseCode() 
	{
		return reallocationWarehouseCode;
	}
	
	public void setReason(final String reason)
	{
		this.reason = reason;
	}

	public String getReason() 
	{
		return reason;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	

}