/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies properties of the CMS workflow.
 */
@ApiModel(value="CMSWorkflowWsDTO", description="Specifies properties of the CMS workflow.")
public  class CMSWorkflowWsDTO extends CMSCreateVersionWsDTO 

{



	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.workflowCode</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="workflowCode", example="000000RV") 	
	private String workflowCode;

	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.templateCode</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="templateCode", example="PageTranslation") 	
	private String templateCode;

	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="description") 	
	private String description;

	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.attachments</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="attachments") 	
	private List<String> attachments;

	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.status</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="status", example="RUNNING") 	
	private String status;

	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.isAvailableForCurrentPrincipal</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="isAvailableForCurrentPrincipal", example="true") 	
	private Boolean isAvailableForCurrentPrincipal;

	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.actions</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="actions") 	
	private List<CMSWorkflowActionWsDTO> actions;

	/** <i>Generated property</i> for <code>CMSWorkflowWsDTO.canModifyItemInWorkflow</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="canModifyItemInWorkflow", example="true") 	
	private Boolean canModifyItemInWorkflow;
	
	public CMSWorkflowWsDTO()
	{
		// default constructor
	}
	
	public void setWorkflowCode(final String workflowCode)
	{
		this.workflowCode = workflowCode;
	}

	public String getWorkflowCode() 
	{
		return workflowCode;
	}
	
	public void setTemplateCode(final String templateCode)
	{
		this.templateCode = templateCode;
	}

	public String getTemplateCode() 
	{
		return templateCode;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setAttachments(final List<String> attachments)
	{
		this.attachments = attachments;
	}

	public List<String> getAttachments() 
	{
		return attachments;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setIsAvailableForCurrentPrincipal(final Boolean isAvailableForCurrentPrincipal)
	{
		this.isAvailableForCurrentPrincipal = isAvailableForCurrentPrincipal;
	}

	public Boolean getIsAvailableForCurrentPrincipal() 
	{
		return isAvailableForCurrentPrincipal;
	}
	
	public void setActions(final List<CMSWorkflowActionWsDTO> actions)
	{
		this.actions = actions;
	}

	public List<CMSWorkflowActionWsDTO> getActions() 
	{
		return actions;
	}
	
	public void setCanModifyItemInWorkflow(final Boolean canModifyItemInWorkflow)
	{
		this.canModifyItemInWorkflow = canModifyItemInWorkflow;
	}

	public Boolean getCanModifyItemInWorkflow() 
	{
		return canModifyItemInWorkflow;
	}
	

}