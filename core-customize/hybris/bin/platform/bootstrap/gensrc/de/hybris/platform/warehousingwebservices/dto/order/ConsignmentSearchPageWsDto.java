/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.ConsignmentWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import java.util.List;


import java.util.Objects;
public  class ConsignmentSearchPageWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsignmentSearchPageWsDto.consignments</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<ConsignmentWsDTO> consignments;

	/** <i>Generated property</i> for <code>ConsignmentSearchPageWsDto.sorts</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>ConsignmentSearchPageWsDto.pagination</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private PaginationWsDTO pagination;
	
	public ConsignmentSearchPageWsDto()
	{
		// default constructor
	}
	
	public void setConsignments(final List<ConsignmentWsDTO> consignments)
	{
		this.consignments = consignments;
	}

	public List<ConsignmentWsDTO> getConsignments() 
	{
		return consignments;
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