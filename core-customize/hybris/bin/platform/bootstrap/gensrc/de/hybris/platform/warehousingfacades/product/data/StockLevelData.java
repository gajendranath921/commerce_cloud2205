/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingfacades.product.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.InStockStatus;
import de.hybris.platform.warehousingfacades.storelocator.data.WarehouseData;
import java.util.Date;


import java.util.Objects;
public  class StockLevelData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StockLevelData.productCode</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>StockLevelData.bin</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String bin;

	/** <i>Generated property</i> for <code>StockLevelData.initialQuantityOnHand</code> property defined at extension <code>warehousingfacades</code>. */
	
	private Integer initialQuantityOnHand;

	/** <i>Generated property</i> for <code>StockLevelData.releaseDate</code> property defined at extension <code>warehousingfacades</code>. */
	
	private Date releaseDate;

	/** <i>Generated property</i> for <code>StockLevelData.inStockStatus</code> property defined at extension <code>warehousingfacades</code>. */
	
	private InStockStatus inStockStatus;

	/** <i>Generated property</i> for <code>StockLevelData.warehouse</code> property defined at extension <code>warehousingfacades</code>. */
	
	private WarehouseData warehouse;
	
	public StockLevelData()
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
	
	public void setInStockStatus(final InStockStatus inStockStatus)
	{
		this.inStockStatus = inStockStatus;
	}

	public InStockStatus getInStockStatus() 
	{
		return inStockStatus;
	}
	
	public void setWarehouse(final WarehouseData warehouse)
	{
		this.warehouse = warehouse;
	}

	public WarehouseData getWarehouse() 
	{
		return warehouse;
	}
	

}