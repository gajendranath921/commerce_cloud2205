/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Language map for a given locale
 */
@ApiModel(value="languageMap", description="Language map for a given locale")
public  class TranslationMapData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The map of localized key-value pairs<br/><br/><i>Generated property</i> for <code>TranslationMapData.value</code> property defined at extension <code>smarteditwebservices</code>. */
@ApiModelProperty(name="value", value="The map of localized key-value pairs", required=true) 	
	private Map<String, String> value;
	
	public TranslationMapData()
	{
		// default constructor
	}
	
	public void setValue(final Map<String, String> value)
	{
		this.value = value;
	}

	public Map<String, String> getValue() 
	{
		return value;
	}
	

}