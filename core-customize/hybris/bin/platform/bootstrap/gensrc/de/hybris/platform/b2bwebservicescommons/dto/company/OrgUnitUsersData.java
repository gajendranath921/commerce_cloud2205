/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.search.pagedata.SortData;
import java.util.List;


import java.util.Objects;
public  class OrgUnitUsersData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrgUnitUsersData.users</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<CustomerData> users;

	/** <i>Generated property</i> for <code>OrgUnitUsersData.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<SortData> sorts;

	/** <i>Generated property</i> for <code>OrgUnitUsersData.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private PaginationData pagination;
	
	public OrgUnitUsersData()
	{
		// default constructor
	}
	
	public void setUsers(final List<CustomerData> users)
	{
		this.users = users;
	}

	public List<CustomerData> getUsers() 
	{
		return users;
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