/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.returns;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.ordermanagementwebservices.dto.returns.ReturnRequestWsDTO;
import java.util.List;


import java.util.Objects;
public  class ReturnSearchPageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnSearchPageWsDTO.returns</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<ReturnRequestWsDTO> returns;

	/** <i>Generated property</i> for <code>ReturnSearchPageWsDTO.sorts</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>ReturnSearchPageWsDTO.pagination</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private PaginationWsDTO pagination;
	
	public ReturnSearchPageWsDTO()
	{
		// default constructor
	}
	
	public void setReturns(final List<ReturnRequestWsDTO> returns)
	{
		this.returns = returns;
	}

	public List<ReturnRequestWsDTO> getReturns() 
	{
		return returns;
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