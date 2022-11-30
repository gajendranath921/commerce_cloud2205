/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.RestrictionTypeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available restriction types.
 */
@ApiModel(value="RestrictionTypeListData", description="Specifies a list of available restriction types.")
public  class RestrictionTypeListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RestrictionTypeListData.restrictionTypes</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="restrictionTypes") 	
	private List<RestrictionTypeData> restrictionTypes;
	
	public RestrictionTypeListData()
	{
		// default constructor
	}
	
	public void setRestrictionTypes(final List<RestrictionTypeData> restrictionTypes)
	{
		this.restrictionTypes = restrictionTypes;
	}

	public List<RestrictionTypeData> getRestrictionTypes() 
	{
		return restrictionTypes;
	}
	

}