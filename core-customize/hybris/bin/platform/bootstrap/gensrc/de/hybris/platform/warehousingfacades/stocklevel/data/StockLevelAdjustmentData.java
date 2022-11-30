/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingfacades.stocklevel.data;

import java.io.Serializable;
import de.hybris.platform.warehousing.enums.StockLevelAdjustmentReason;


import java.util.Objects;
public  class StockLevelAdjustmentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StockLevelAdjustmentData.reason</code> property defined at extension <code>warehousingfacades</code>. */
	
	private StockLevelAdjustmentReason reason;

	/** <i>Generated property</i> for <code>StockLevelAdjustmentData.quantity</code> property defined at extension <code>warehousingfacades</code>. */
	
	private Long quantity;

	/** <i>Generated property</i> for <code>StockLevelAdjustmentData.comment</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String comment;
	
	public StockLevelAdjustmentData()
	{
		// default constructor
	}
	
	public void setReason(final StockLevelAdjustmentReason reason)
	{
		this.reason = reason;
	}

	public StockLevelAdjustmentReason getReason() 
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