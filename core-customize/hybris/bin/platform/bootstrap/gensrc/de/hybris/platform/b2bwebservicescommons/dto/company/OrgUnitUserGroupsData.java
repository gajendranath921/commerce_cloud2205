/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUserGroupData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.search.pagedata.SortData;
import java.util.List;


import java.util.Objects;
public  class OrgUnitUserGroupsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrgUnitUserGroupsData.orgUnitUserGroups</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<B2BUserGroupData> orgUnitUserGroups;

	/** <i>Generated property</i> for <code>OrgUnitUserGroupsData.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<SortData> sorts;

	/** <i>Generated property</i> for <code>OrgUnitUserGroupsData.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private PaginationData pagination;
	
	public OrgUnitUserGroupsData()
	{
		// default constructor
	}
	
	public void setOrgUnitUserGroups(final List<B2BUserGroupData> orgUnitUserGroups)
	{
		this.orgUnitUserGroups = orgUnitUserGroups;
	}

	public List<B2BUserGroupData> getOrgUnitUserGroups() 
	{
		return orgUnitUserGroups;
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