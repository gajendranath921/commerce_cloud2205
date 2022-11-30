/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.queues.data;

import java.io.Serializable;
import de.hybris.platform.commercewebservices.core.queues.data.ProductExpressUpdateElementData;
import java.util.List;


import java.util.Objects;
public  class ProductExpressUpdateElementDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductExpressUpdateElementDataList.productExpressUpdateElements</code> property defined at extension <code>commercewebservices</code>. */
	
	private List<ProductExpressUpdateElementData> productExpressUpdateElements;
	
	public ProductExpressUpdateElementDataList()
	{
		// default constructor
	}
	
	public void setProductExpressUpdateElements(final List<ProductExpressUpdateElementData> productExpressUpdateElements)
	{
		this.productExpressUpdateElements = productExpressUpdateElements;
	}

	public List<ProductExpressUpdateElementData> getProductExpressUpdateElements() 
	{
		return productExpressUpdateElements;
	}
	

}