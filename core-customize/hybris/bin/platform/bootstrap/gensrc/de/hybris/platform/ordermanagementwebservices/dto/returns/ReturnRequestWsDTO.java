/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.returns;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.ordermanagementwebservices.dto.returns.ReturnEntryWsDTO;
import java.util.List;


import java.util.Objects;
public  class ReturnRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnRequestWsDTO.code</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>ReturnRequestWsDTO.rma</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String rma;

	/** <i>Generated property</i> for <code>ReturnRequestWsDTO.status</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String status;

	/** <i>Generated property</i> for <code>ReturnRequestWsDTO.order</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private OrderWsDTO order;

	/** <i>Generated property</i> for <code>ReturnRequestWsDTO.deliveryCost</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private PriceWsDTO deliveryCost;

	/** <i>Generated property</i> for <code>ReturnRequestWsDTO.returnEntries</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<ReturnEntryWsDTO> returnEntries;

	/** <i>Generated property</i> for <code>ReturnRequestWsDTO.refundDeliveryCost</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private Boolean refundDeliveryCost;
	
	public ReturnRequestWsDTO()
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
	
	public void setRma(final String rma)
	{
		this.rma = rma;
	}

	public String getRma() 
	{
		return rma;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setOrder(final OrderWsDTO order)
	{
		this.order = order;
	}

	public OrderWsDTO getOrder() 
	{
		return order;
	}
	
	public void setDeliveryCost(final PriceWsDTO deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

	public PriceWsDTO getDeliveryCost() 
	{
		return deliveryCost;
	}
	
	public void setReturnEntries(final List<ReturnEntryWsDTO> returnEntries)
	{
		this.returnEntries = returnEntries;
	}

	public List<ReturnEntryWsDTO> getReturnEntries() 
	{
		return returnEntries;
	}
	
	public void setRefundDeliveryCost(final Boolean refundDeliveryCost)
	{
		this.refundDeliveryCost = refundDeliveryCost;
	}

	public Boolean getRefundDeliveryCost() 
	{
		return refundDeliveryCost;
	}
	

}