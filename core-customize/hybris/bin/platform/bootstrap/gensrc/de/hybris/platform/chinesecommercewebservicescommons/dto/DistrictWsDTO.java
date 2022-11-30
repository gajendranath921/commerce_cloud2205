/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * data object of district
 */
@ApiModel(value="District", description="data object of district")
public  class DistrictWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** ISO 3166-1 alpha-2 standard, e.g.[countryIso]-[regionNumber]-[cityNumber]-[districtNumber]<br/><br/><i>Generated property</i> for <code>DistrictWsDTO.isocode</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="isocode", value="ISO 3166-1 alpha-2 standard, e.g.[countryIso]-[regionNumber]-[cityNumber]-[districtNumber]") 	
	private String isocode;

	/** name of district<br/><br/><i>Generated property</i> for <code>DistrictWsDTO.name</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="name", value="name of district", example="Dongcheng District") 	
	private String name;
	
	public DistrictWsDTO()
	{
		// default constructor
	}
	
	public void setIsocode(final String isocode)
	{
		this.isocode = isocode;
	}

	public String getIsocode() 
	{
		return isocode;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}