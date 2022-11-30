/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.warehousingwebservices.dto.product.StockLevelWsDto;
import java.util.List;


import java.util.Objects;
public  class StockLevelSearchPageWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StockLevelSearchPageWsDto.sorts</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>StockLevelSearchPageWsDto.pagination</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private PaginationWsDTO pagination;

	/** <i>Generated property</i> for <code>StockLevelSearchPageWsDto.stockLevels</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<StockLevelWsDto> stockLevels;
	
	public StockLevelSearchPageWsDto()
	{
		// default constructor
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	
	public void setStockLevels(final List<StockLevelWsDto> stockLevels)
	{
		this.stockLevels = stockLevels;
	}

	public List<StockLevelWsDto> getStockLevels() 
	{
		return stockLevels;
	}
	

}