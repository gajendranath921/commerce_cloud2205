/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.stocklevel;

import java.io.Serializable;


import java.util.Objects;
public  class StockLevelAdjustmentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StockLevelAdjustmentWsDTO.reason</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String reason;

	/** <i>Generated property</i> for <code>StockLevelAdjustmentWsDTO.quantity</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private Long quantity;

	/** <i>Generated property</i> for <code>StockLevelAdjustmentWsDTO.comment</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String comment;
	
	public StockLevelAdjustmentWsDTO()
	{
		// default constructor
	}
	
	public void setReason(final String reason)
	{
		this.reason = reason;
	}

	public String getReason() 
	{
		return reason;
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
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