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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of an organizational approval process
 */
@ApiModel(value="B2BApprovalProcess", description="Representation of an organizational approval process")
public  class B2BApprovalProcessWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the Organizational Approval Process<br/><br/><i>Generated property</i> for <code>B2BApprovalProcessWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="code", value="Code of the Organizational Approval Process", required=true, example="accApproval") 	
	private String code;

	/** Name of the Organizational Approval Process<br/><br/><i>Generated property</i> for <code>B2BApprovalProcessWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="name", value="Name of the Organizational Approval Process", example="Escalation Approval with Merchant Check") 	
	private String name;
	
	public B2BApprovalProcessWsDTO()
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