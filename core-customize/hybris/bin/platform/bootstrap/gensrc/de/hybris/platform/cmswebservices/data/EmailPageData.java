/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the page email.
 *
 * @deprecated no longer needed
 */
@ApiModel(value="EmailPageData", description="Specifies properties of the page email.")
@Deprecated(since = "6.6", forRemoval = true)
public  class EmailPageData extends AbstractPageData 

{



	/** <i>Generated property</i> for <code>EmailPageData.fromEmail</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="fromEmail") 	
	private Map<String,String> fromEmail;

	/** <i>Generated property</i> for <code>EmailPageData.fromName</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="fromName") 	
	private Map<String,String> fromName;
	
	public EmailPageData()
	{
		// default constructor
	}
	
	public void setFromEmail(final Map<String,String> fromEmail)
	{
		this.fromEmail = fromEmail;
	}

	public Map<String,String> getFromEmail() 
	{
		return fromEmail;
	}
	
	public void setFromName(final Map<String,String> fromName)
	{
		this.fromName = fromName;
	}

	public Map<String,String> getFromName() 
	{
		return fromName;
	}
	

}