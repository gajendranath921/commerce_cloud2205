/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.ConsignmentEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import java.util.List;


import java.util.Objects;
public  class ConsignmentEntrySearchPageWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsignmentEntrySearchPageWsDto.sorts</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>ConsignmentEntrySearchPageWsDto.pagination</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private PaginationWsDTO pagination;

	/** <i>Generated property</i> for <code>ConsignmentEntrySearchPageWsDto.consignmentEntries</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<ConsignmentEntryWsDTO> consignmentEntries;
	
	public ConsignmentEntrySearchPageWsDto()
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
	
	public void setConsignmentEntries(final List<ConsignmentEntryWsDTO> consignmentEntries)
	{
		this.consignmentEntries = consignmentEntries;
	}

	public List<ConsignmentEntryWsDTO> getConsignmentEntries() 
	{
		return consignmentEntries;
	}
	

}