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
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BApprovalProcessWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an organizational approval process list
 */
@ApiModel(value="B2BApprovalProcessList", description="Representation of an organizational approval process list")
public  class B2BApprovalProcessListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Organizational Approval Process<br/><br/><i>Generated property</i> for <code>B2BApprovalProcessListWsDTO.approvalProcesses</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="approvalProcesses", value="List of Organizational Approval Process", required=true) 	
	private List<B2BApprovalProcessWsDTO> approvalProcesses;
	
	public B2BApprovalProcessListWsDTO()
	{
		// default constructor
	}
	
	public void setApprovalProcesses(final List<B2BApprovalProcessWsDTO> approvalProcesses)
	{
		this.approvalProcesses = approvalProcesses;
	}

	public List<B2BApprovalProcessWsDTO> getApprovalProcesses() 
	{
		return approvalProcesses;
	}
	

}