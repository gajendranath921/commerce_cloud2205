/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Language data
 */
@ApiModel(value="languageData", description="Language data")
public  class SmarteditLanguageData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The name of the language data<br/><br/><i>Generated property</i> for <code>SmarteditLanguageData.name</code> property defined at extension <code>smarteditwebservices</code>. */
@ApiModelProperty(name="name", value="The name of the language data", required=true, example="English") 	
	private String name;

	/** The iso code of the language data<br/><br/><i>Generated property</i> for <code>SmarteditLanguageData.isoCode</code> property defined at extension <code>smarteditwebservices</code>. */
@ApiModelProperty(name="isoCode", value="The iso code of the language data", required=true, example="en") 	
	private String isoCode;
	
	public SmarteditLanguageData()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setIsoCode(final String isoCode)
	{
		this.isoCode = isoCode;
	}

	public String getIsoCode() 
	{
		return isoCode;
	}
	

}