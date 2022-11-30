/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.FutureStockWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Product Future Stocks
 */
@ApiModel(value="ProductFutureStocks", description="Representation of a Product Future Stocks")
public  class ProductFutureStocksWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Product identifier<br/><br/><i>Generated property</i> for <code>ProductFutureStocksWsDTO.productCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="productCode", value="Product identifier", example="3318057") 	
	private String productCode;

	/** List of future stocks<br/><br/><i>Generated property</i> for <code>ProductFutureStocksWsDTO.futureStocks</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="futureStocks", value="List of future stocks") 	
	private List<FutureStockWsDTO> futureStocks;
	
	public ProductFutureStocksWsDTO()
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
	
	public void setFutureStocks(final List<FutureStockWsDTO> futureStocks)
	{
		this.futureStocks = futureStocks;
	}

	public List<FutureStockWsDTO> getFutureStocks() 
	{
		return futureStocks;
	}
	

}