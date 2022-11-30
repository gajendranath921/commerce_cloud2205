/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import de.hybris.platform.smarteditwebservices.data.SmarteditLanguageData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * List of languages
 */
@ApiModel(value="SmarteditLanguageListData", description="List of languages")
public  class SmarteditLanguageListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The list of language data<br/><br/><i>Generated property</i> for <code>SmarteditLanguageListData.languages</code> property defined at extension <code>smarteditwebservices</code>. */
@ApiModelProperty(name="languages", value="The list of language data", required=true) 	
	private List<SmarteditLanguageData> languages;
	
	public SmarteditLanguageListData()
	{
		// default constructor
	}
	
	public void setLanguages(final List<SmarteditLanguageData> languages)
	{
		this.languages = languages;
	}

	public List<SmarteditLanguageData> getLanguages() 
	{
		return languages;
	}
	

}