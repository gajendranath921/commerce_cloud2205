/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.returns.data;

import java.io.Serializable;
import java.math.BigDecimal;


import java.util.Objects;
public  class ReturnEntryModificationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnEntryModificationWsDTO.productCode</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>ReturnEntryModificationWsDTO.deliveryModeCode</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String deliveryModeCode;

	/** <i>Generated property</i> for <code>ReturnEntryModificationWsDTO.refundAmount</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private BigDecimal refundAmount;
	
	public ReturnEntryModificationWsDTO()
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
	
	public void setDeliveryModeCode(final String deliveryModeCode)
	{
		this.deliveryModeCode = deliveryModeCode;
	}

	public String getDeliveryModeCode() 
	{
		return deliveryModeCode;
	}
	
	public void setRefundAmount(final BigDecimal refundAmount)
	{
		this.refundAmount = refundAmount;
	}

	public BigDecimal getRefundAmount() 
	{
		return refundAmount;
	}
	

}