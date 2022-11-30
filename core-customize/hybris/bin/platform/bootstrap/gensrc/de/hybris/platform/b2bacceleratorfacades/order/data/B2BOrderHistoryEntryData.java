/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import java.util.Date;


import java.util.Objects;
public  class B2BOrderHistoryEntryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BOrderHistoryEntryData.b2bOrderData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private OrderData b2bOrderData;

	/** <i>Generated property</i> for <code>B2BOrderHistoryEntryData.description</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>B2BOrderHistoryEntryData.timeStamp</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Date timeStamp;

	/** <i>Generated property</i> for <code>B2BOrderHistoryEntryData.previousOrderVersionData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private OrderData previousOrderVersionData;

	/** <i>Generated property</i> for <code>B2BOrderHistoryEntryData.ownerData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private PrincipalData ownerData;
	
	public B2BOrderHistoryEntryData()
	{
		// default constructor
	}
	
	public void setB2bOrderData(final OrderData b2bOrderData)
	{
		this.b2bOrderData = b2bOrderData;
	}

	public OrderData getB2bOrderData() 
	{
		return b2bOrderData;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setTimeStamp(final Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public Date getTimeStamp() 
	{
		return timeStamp;
	}
	
	public void setPreviousOrderVersionData(final OrderData previousOrderVersionData)
	{
		this.previousOrderVersionData = previousOrderVersionData;
	}

	public OrderData getPreviousOrderVersionData() 
	{
		return previousOrderVersionData;
	}
	
	public void setOwnerData(final PrincipalData ownerData)
	{
		this.ownerData = ownerData;
	}

	public PrincipalData getOwnerData() 
	{
		return ownerData;
	}
	

}