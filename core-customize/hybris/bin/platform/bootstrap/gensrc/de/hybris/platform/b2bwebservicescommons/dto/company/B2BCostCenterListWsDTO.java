/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a cost center list
 */
@ApiModel(value="B2BCostCenterList", description="Representation of a cost center list")
public  class B2BCostCenterListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of cost centers<br/><br/><i>Generated property</i> for <code>B2BCostCenterListWsDTO.costCenters</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="costCenters", value="List of cost centers") 	
	private List<B2BCostCenterWsDTO> costCenters;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>B2BCostCenterListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="sorts", value="List of sorts") 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>B2BCostCenterListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="pagination", value="Pagination items") 	
	private PaginationWsDTO pagination;
	
	public B2BCostCenterListWsDTO()
	{
		// default constructor
	}
	
	public void setCostCenters(final List<B2BCostCenterWsDTO> costCenters)
	{
		this.costCenters = costCenters;
	}

	public List<B2BCostCenterWsDTO> getCostCenters() 
	{
		return costCenters;
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