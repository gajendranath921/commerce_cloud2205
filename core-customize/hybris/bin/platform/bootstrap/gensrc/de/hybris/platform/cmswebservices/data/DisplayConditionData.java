/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.OptionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
@ApiModel(value="DisplayConditionData")
public  class DisplayConditionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DisplayConditionData.options</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="options", example="[{\"id\" : \"VARIATION\", \"label\" : \"page.displaycondition.variation\"}]") 	
	private List<OptionData> options;

	/** <i>Generated property</i> for <code>DisplayConditionData.typecode</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="typecode", example="ProductPage") 	
	private String typecode;
	
	public DisplayConditionData()
	{
		// default constructor
	}
	
	public void setOptions(final List<OptionData> options)
	{
		this.options = options;
	}

	public List<OptionData> getOptions() 
	{
		return options;
	}
	
	public void setTypecode(final String typecode)
	{
		this.typecode = typecode;
	}

	public String getTypecode() 
	{
		return typecode;
	}
	

}