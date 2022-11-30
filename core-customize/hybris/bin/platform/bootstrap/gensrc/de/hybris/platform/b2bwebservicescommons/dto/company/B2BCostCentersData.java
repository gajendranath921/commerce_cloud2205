/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bcommercefacades.company.data.B2BCostCenterData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.search.pagedata.SortData;
import java.util.List;


import java.util.Objects;
public  class B2BCostCentersData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BCostCentersData.costCenters</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<B2BCostCenterData> costCenters;

	/** <i>Generated property</i> for <code>B2BCostCentersData.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<SortData> sorts;

	/** <i>Generated property</i> for <code>B2BCostCentersData.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private PaginationData pagination;
	
	public B2BCostCentersData()
	{
		// default constructor
	}
	
	public void setCostCenters(final List<B2BCostCenterData> costCenters)
	{
		this.costCenters = costCenters;
	}

	public List<B2BCostCenterData> getCostCenters() 
	{
		return costCenters;
	}
	
	public void setSorts(final List<SortData> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortData> getSorts() 
	{
		return sorts;
	}
	
	public void setPagination(final PaginationData pagination)
	{
		this.pagination = pagination;
	}

	public PaginationData getPagination() 
	{
		return pagination;
	}
	

}