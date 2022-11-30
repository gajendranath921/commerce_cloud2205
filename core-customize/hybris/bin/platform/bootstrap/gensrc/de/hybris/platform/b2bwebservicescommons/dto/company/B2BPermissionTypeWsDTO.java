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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Order Approval Permission Type data. Typical permission types are: B2BBudgetExceededPermission, B2BOrderThresholdTimespanPermission and B2BOrderThresholdPermission
 */
@ApiModel(value="OrderApprovalPermissionType", description="Request body fields required and optional to operate on Order Approval Permission Type data. Typical permission types are: B2BBudgetExceededPermission, B2BOrderThresholdTimespanPermission and B2BOrderThresholdPermission")
public  class B2BPermissionTypeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the Order Approval Permission Type<br/><br/><i>Generated property</i> for <code>B2BPermissionTypeWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="code", value="Code of the Order Approval Permission Type", required=true, example="B2BOrderThresholdTimespanPermission") 	
	private String code;

	/** Name of the Order Approval Permission Type<br/><br/><i>Generated property</i> for <code>B2BPermissionTypeWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="name", value="Name of the Order Approval Permission Type", example="Allowed Order Threshold (per timespan)") 	
	private String name;
	
	public B2BPermissionTypeWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}