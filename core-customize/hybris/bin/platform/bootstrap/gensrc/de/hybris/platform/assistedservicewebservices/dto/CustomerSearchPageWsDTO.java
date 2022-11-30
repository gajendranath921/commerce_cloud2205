/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import java.util.List;


import java.util.Objects;
public  class CustomerSearchPageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CustomerSearchPageWsDTO.sorts</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>CustomerSearchPageWsDTO.pagination</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private PaginationWsDTO pagination;

	/** <i>Generated property</i> for <code>CustomerSearchPageWsDTO.entries</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private List<UserWsDTO> entries;
	
	public CustomerSearchPageWsDTO()
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
	
	public void setEntries(final List<UserWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<UserWsDTO> getEntries() 
	{
		return entries;
	}
	

}