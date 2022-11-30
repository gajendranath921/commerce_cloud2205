/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.store;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.store.PointOfServiceWsDTO;
import java.util.List;


import java.util.Objects;
public  class PointOfServiceSearchPageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PointOfServiceSearchPageWsDTO.pointsOfService</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<PointOfServiceWsDTO> pointsOfService;

	/** <i>Generated property</i> for <code>PointOfServiceSearchPageWsDTO.sorts</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>PointOfServiceSearchPageWsDTO.pagination</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private PaginationWsDTO pagination;
	
	public PointOfServiceSearchPageWsDTO()
	{
		// default constructor
	}
	
	public void setPointsOfService(final List<PointOfServiceWsDTO> pointsOfService)
	{
		this.pointsOfService = pointsOfService;
	}

	public List<PointOfServiceWsDTO> getPointsOfService() 
	{
		return pointsOfService;
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