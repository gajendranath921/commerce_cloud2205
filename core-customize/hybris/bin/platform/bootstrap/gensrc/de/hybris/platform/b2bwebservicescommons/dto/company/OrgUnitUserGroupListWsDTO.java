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
import de.hybris.platform.b2bwebservicescommons.dto.company.OrgUnitUserGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an user list used in organizational units
 */
@ApiModel(value="OrgUnitUserGroupList", description="Representation of an user list used in organizational units")
public  class OrgUnitUserGroupListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of organizational unit user groups<br/><br/><i>Generated property</i> for <code>OrgUnitUserGroupListWsDTO.orgUnitUserGroups</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orgUnitUserGroups", value="List of organizational unit user groups", required=true) 	
	private List<OrgUnitUserGroupWsDTO> orgUnitUserGroups;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>OrgUnitUserGroupListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="sorts", value="List of sorts", required=true) 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>OrgUnitUserGroupListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="pagination", value="Pagination items", required=true) 	
	private PaginationWsDTO pagination;
	
	public OrgUnitUserGroupListWsDTO()
	{
		// default constructor
	}
	
	public void setOrgUnitUserGroups(final List<OrgUnitUserGroupWsDTO> orgUnitUserGroups)
	{
		this.orgUnitUserGroups = orgUnitUserGroups;
	}

	public List<OrgUnitUserGroupWsDTO> getOrgUnitUserGroups() 
	{
		return orgUnitUserGroups;
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