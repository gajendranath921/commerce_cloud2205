/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.warehousing.enums.DeclineReason;


import java.util.Objects;
public  class DeclineEntryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeclineEntryData.productCode</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>DeclineEntryData.quantity</code> property defined at extension <code>warehousingfacades</code>. */
	
	private Long quantity;

	/** <i>Generated property</i> for <code>DeclineEntryData.reallocationWarehouseCode</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String reallocationWarehouseCode;

	/** <i>Generated property</i> for <code>DeclineEntryData.reason</code> property defined at extension <code>warehousingfacades</code>. */
	
	private DeclineReason reason;

	/** <i>Generated property</i> for <code>DeclineEntryData.comment</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String comment;
	
	public DeclineEntryData()
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
	
	public void setReason(final DeclineReason reason)
	{
		this.reason = reason;
	}

	public DeclineReason getReason() 
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