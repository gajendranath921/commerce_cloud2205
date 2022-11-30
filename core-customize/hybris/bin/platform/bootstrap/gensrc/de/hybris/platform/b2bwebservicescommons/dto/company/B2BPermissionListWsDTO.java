/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Order Approval Permission List
 */
@ApiModel(value="OrderApprovalPermissionList", description="Representation of a Order Approval Permission List")
public  class B2BPermissionListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Order Approval Permissions<br/><br/><i>Generated property</i> for <code>B2BPermissionListWsDTO.orderApprovalPermissions</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orderApprovalPermissions", value="List of Order Approval Permissions", required=true) 	
	private List<B2BPermissionWsDTO> orderApprovalPermissions;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>B2BPermissionListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="sorts", value="List of sorts", required=true) 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>B2BPermissionListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="pagination", value="Pagination items", required=true) 	
	private PaginationWsDTO pagination;
	
	public B2BPermissionListWsDTO()
	{
		// default constructor
	}
	
	public void setOrderApprovalPermissions(final List<B2BPermissionWsDTO> orderApprovalPermissions)
	{
		this.orderApprovalPermissions = orderApprovalPermissions;
	}

	public List<B2BPermissionWsDTO> getOrderApprovalPermissions() 
	{
		return orderApprovalPermissions;
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