/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.FutureStockData;
import java.util.List;


import java.util.Objects;
public  class ProductFutureStocksData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductFutureStocksData.productCode</code> property defined at extension <code>commercewebservices</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>ProductFutureStocksData.futureStocks</code> property defined at extension <code>commercewebservices</code>. */
	
	private List<FutureStockData> futureStocks;
	
	public ProductFutureStocksData()
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
	
	public void setFutureStocks(final List<FutureStockData> futureStocks)
	{
		this.futureStocks = futureStocks;
	}

	public List<FutureStockData> getFutureStocks() 
	{
		return futureStocks;
	}
	

}