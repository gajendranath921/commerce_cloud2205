/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
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
 * Specifies properties of the CMS workflow decision.
 */
@ApiModel(value="CMSWorkflowDecision", description="Specifies properties of the CMS workflow decision.")
public  class CMSWorkflowDecisionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="code", example="PageTranslationSendDEForReview") 	
	private String code;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name", example="{\"en\": \"Send for Review\", \"fr\": \"Envoyer pour examen\"}") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="description", example="{\"en\": \"Decision for sending DE language for review\", \"fr\": \"D\u00e9cision d'envoyer la langue DE pour examen\"}") 	
	private Map<String,String> description;
	
	public CMSWorkflowDecisionWsDTO()
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
	
	public void setDescription(final Map<String,String> description)
	{
		this.description = description;
	}

	public Map<String,String> getDescription() 
	{
		return description;
	}
	

}