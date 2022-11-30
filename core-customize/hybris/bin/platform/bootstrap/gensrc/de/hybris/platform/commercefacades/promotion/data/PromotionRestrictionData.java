/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.promotion.data;

import java.io.Serializable;


import java.util.Objects;
public  class PromotionRestrictionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PromotionRestrictionData.restrictionType</code> property defined at extension <code>commercefacades</code>. */
	
	private String restrictionType;

	/** <i>Generated property</i> for <code>PromotionRestrictionData.description</code> property defined at extension <code>commercefacades</code>. */
	
	private String description;
	
	public PromotionRestrictionData()
	{
		// default constructor
	}
	
	public void setRestrictionType(final String restrictionType)
	{
		this.restrictionType = restrictionType;
	}

	public String getRestrictionType() 
	{
		return restrictionType;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	

}