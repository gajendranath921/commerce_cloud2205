/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available workflow templates.
 */
@ApiModel(value="WorkflowTemplateListWsDTO", description="Specifies a list of available workflow templates.")
public  class WorkflowTemplateListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowTemplateListWsDTO.templates</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="templates") 	
	private List<WorkflowTemplateWsDTO> templates;
	
	public WorkflowTemplateListWsDTO()
	{
		// default constructor
	}
	
	public void setTemplates(final List<WorkflowTemplateWsDTO> templates)
	{
		this.templates = templates;
	}

	public List<WorkflowTemplateWsDTO> getTemplates() 
	{
		return templates;
	}
	

}