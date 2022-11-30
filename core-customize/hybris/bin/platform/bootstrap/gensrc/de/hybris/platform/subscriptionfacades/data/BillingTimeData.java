/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class BillingTimeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BillingTimeData.code</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>BillingTimeData.name</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>BillingTimeData.nameInOrder</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String nameInOrder;

	/** <i>Generated property</i> for <code>BillingTimeData.description</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>BillingTimeData.orderNumber</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private int orderNumber;
	
	public BillingTimeData()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setNameInOrder(final String nameInOrder)
	{
		this.nameInOrder = nameInOrder;
	}

	public String getNameInOrder() 
	{
		return nameInOrder;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setOrderNumber(final int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public int getOrderNumber() 
	{
		return orderNumber;
	}
	

}