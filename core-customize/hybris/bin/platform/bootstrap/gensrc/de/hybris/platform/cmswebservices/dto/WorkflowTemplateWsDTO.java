/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the workflow template.
 */
@ApiModel(value="WorkflowTemplate", description="Specifies properties of the workflow template.")
public  class WorkflowTemplateWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowTemplateWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="code", example="000000RS") 	
	private String code;

	/** <i>Generated property</i> for <code>WorkflowTemplateWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name", example="{\"en\": \"Page Translation\", \"fr\": \"Traduction de pages\"}") 	
	private Map<String,String> name;
	
	public WorkflowTemplateWsDTO()
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
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

	public Map<String,String> getName() 
	{
		return name;
	}
	

}