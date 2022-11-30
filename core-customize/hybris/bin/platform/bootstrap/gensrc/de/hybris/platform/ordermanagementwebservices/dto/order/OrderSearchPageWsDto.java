/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import java.util.List;


import java.util.Objects;
public  class OrderSearchPageWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderSearchPageWsDto.orders</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<OrderWsDTO> orders;

	/** <i>Generated property</i> for <code>OrderSearchPageWsDto.sorts</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>OrderSearchPageWsDto.pagination</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private PaginationWsDTO pagination;
	
	public OrderSearchPageWsDto()
	{
		// default constructor
	}
	
	public void setOrders(final List<OrderWsDTO> orders)
	{
		this.orders = orders;
	}

	public List<OrderWsDTO> getOrders() 
	{
		return orders;
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
	

}