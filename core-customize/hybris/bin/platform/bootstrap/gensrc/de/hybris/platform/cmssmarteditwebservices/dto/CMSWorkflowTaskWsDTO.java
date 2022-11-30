/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
@ApiModel(value="CMSWorkflowTaskWsDTO")
public  class CMSWorkflowTaskWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowTaskWsDTO.action</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="action") 	
	private CMSWorkflowActionWsDTO action;

	/** <i>Generated property</i> for <code>CMSWorkflowTaskWsDTO.attachments</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="attachments") 	
	private List<CMSWorkflowAttachmentData> attachments;
	
	public CMSWorkflowTaskWsDTO()
	{
		// default constructor
	}
	
	public void setAction(final CMSWorkflowActionWsDTO action)
	{
		this.action = action;
	}

	public CMSWorkflowActionWsDTO getAction() 
	{
		return action;
	}
	
	public void setAttachments(final List<CMSWorkflowAttachmentData> attachments)
	{
		this.attachments = attachments;
	}

	public List<CMSWorkflowAttachmentData> getAttachments() 
	{
		return attachments;
	}
	

}