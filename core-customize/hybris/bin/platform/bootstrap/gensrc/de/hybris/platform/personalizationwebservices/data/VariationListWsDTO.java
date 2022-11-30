/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.VariationData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * List of variations
 */
@ApiModel(value="VariationList", description="List of variations")
public  class VariationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of variations<br/><br/><i>Generated property</i> for <code>VariationListWsDTO.variations</code> property defined at extension <code>personalizationwebservices</code>. */
@ApiModelProperty(name="variations", value="List of variations") 	
	private List<VariationData> variations;
	
	public VariationListWsDTO()
	{
		// default constructor
	}
	
	public void setVariations(final List<VariationData> variations)
	{
		this.variations = variations;
	}

	public List<VariationData> getVariations() 
	{
		return variations;
	}
	

}