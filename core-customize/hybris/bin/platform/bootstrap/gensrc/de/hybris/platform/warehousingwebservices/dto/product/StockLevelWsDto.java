/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.product;

import java.io.Serializable;
import de.hybris.platform.warehousingwebservices.dto.store.WarehouseWsDto;
import java.util.Date;


import java.util.Objects;
public  class StockLevelWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StockLevelWsDto.productCode</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>StockLevelWsDto.bin</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String bin;

	/** <i>Generated property</i> for <code>StockLevelWsDto.initialQuantityOnHand</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private Integer initialQuantityOnHand;

	/** <i>Generated property</i> for <code>StockLevelWsDto.releaseDate</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private Date releaseDate;

	/** <i>Generated property</i> for <code>StockLevelWsDto.inStockStatus</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String inStockStatus;

	/** <i>Generated property</i> for <code>StockLevelWsDto.warehouse</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private WarehouseWsDto warehouse;
	
	public StockLevelWsDto()
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
	
	public void setBin(final String bin)
	{
		this.bin = bin;
	}

	public String getBin() 
	{
		return bin;
	}
	
	public void setInitialQuantityOnHand(final Integer initialQuantityOnHand)
	{
		this.initialQuantityOnHand = initialQuantityOnHand;
	}

	public Integer getInitialQuantityOnHand() 
	{
		return initialQuantityOnHand;
	}
	
	public void setReleaseDate(final Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public Date getReleaseDate() 
	{
		return releaseDate;
	}
	
	public void setInStockStatus(final String inStockStatus)
	{
		this.inStockStatus = inStockStatus;
	}

	public String getInStockStatus() 
	{
		return inStockStatus;
	}
	
	public void setWarehouse(final WarehouseWsDto warehouse)
	{
		this.warehouse = warehouse;
	}

	public WarehouseWsDto getWarehouse() 
	{
		return warehouse;
	}
	

}