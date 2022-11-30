/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.storesession.data.LanguageData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available languages.
 */
@ApiModel(value="LanguageListData", description="Specifies a list of available languages.")
public  class LanguageListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>LanguageListData.languages</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="languages") 	
	private List<LanguageData> languages;
	
	public LanguageListData()
	{
		// default constructor
	}
	
	public void setLanguages(final List<LanguageData> languages)
	{
		this.languages = languages;
	}

	public List<LanguageData> getLanguages() 
	{
		return languages;
	}
	

}