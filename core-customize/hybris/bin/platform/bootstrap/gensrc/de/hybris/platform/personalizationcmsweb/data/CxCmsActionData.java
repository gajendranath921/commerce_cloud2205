/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationcmsweb.data;

import de.hybris.platform.personalizationfacades.data.ActionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Action details
 */
@ApiModel(value="action", description="Action details")
public  class CxCmsActionData extends ActionData 

{



	/** ID of the component<br/><br/><i>Generated property</i> for <code>CxCmsActionData.componentId</code> property defined at extension <code>personalizationcmsweb</code>. */
@ApiModelProperty(name="componentId", value="ID of the component") 	
	private String componentId;

	/** Identifier of the component's catalog<br/><br/><i>Generated property</i> for <code>CxCmsActionData.componentCatalog</code> property defined at extension <code>personalizationcmsweb</code>. */
@ApiModelProperty(name="componentCatalog", value="Identifier of the component's catalog") 	
	private String componentCatalog;

	/** ID of the component's container<br/><br/><i>Generated property</i> for <code>CxCmsActionData.containerId</code> property defined at extension <code>personalizationcmsweb</code>. */
@ApiModelProperty(name="containerId", value="ID of the component's container") 	
	private String containerId;
	
	public CxCmsActionData()
	{
		// default constructor
	}
	
	public void setComponentId(final String componentId)
	{
		this.componentId = componentId;
	}

	public String getComponentId() 
	{
		return componentId;
	}
	
	public void setComponentCatalog(final String componentCatalog)
	{
		this.componentCatalog = componentCatalog;
	}

	public String getComponentCatalog() 
	{
		return componentCatalog;
	}
	
	public void setContainerId(final String containerId)
	{
		this.containerId = containerId;
	}

	public String getContainerId() 
	{
		return containerId;
	}
	

}