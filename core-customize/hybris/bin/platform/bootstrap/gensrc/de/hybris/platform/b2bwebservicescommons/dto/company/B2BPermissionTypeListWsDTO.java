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
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionTypeWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Order Approval Permission Type list
 */
@ApiModel(value="OrderApprovalPermissionTypeList", description="Representation of an Order Approval Permission Type list")
public  class B2BPermissionTypeListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Order Approval Permission Types<br/><br/><i>Generated property</i> for <code>B2BPermissionTypeListWsDTO.orderApprovalPermissionTypes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orderApprovalPermissionTypes", value="List of Order Approval Permission Types", required=true) 	
	private List<B2BPermissionTypeWsDTO> orderApprovalPermissionTypes;
	
	public B2BPermissionTypeListWsDTO()
	{
		// default constructor
	}
	
	public void setOrderApprovalPermissionTypes(final List<B2BPermissionTypeWsDTO> orderApprovalPermissionTypes)
	{
		this.orderApprovalPermissionTypes = orderApprovalPermissionTypes;
	}

	public List<B2BPermissionTypeWsDTO> getOrderApprovalPermissionTypes() 
	{
		return orderApprovalPermissionTypes;
	}
	

}