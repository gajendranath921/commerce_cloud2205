/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.returns;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.ordermanagementwebservices.dto.returns.ReturnEntryWsDTO;
import java.util.List;


import java.util.Objects;
public  class ReturnEntrySearchPageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnEntrySearchPageWsDTO.sorts</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>ReturnEntrySearchPageWsDTO.pagination</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private PaginationWsDTO pagination;

	/** <i>Generated property</i> for <code>ReturnEntrySearchPageWsDTO.returnEntries</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<ReturnEntryWsDTO> returnEntries;
	
	public ReturnEntrySearchPageWsDTO()
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
	
	public void setReturnEntries(final List<ReturnEntryWsDTO> returnEntries)
	{
		this.returnEntries = returnEntries;
	}

	public List<ReturnEntryWsDTO> getReturnEntries() 
	{
		return returnEntries;
	}
	

}