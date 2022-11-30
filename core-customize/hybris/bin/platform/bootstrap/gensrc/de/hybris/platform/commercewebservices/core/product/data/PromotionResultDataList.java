/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.PromotionResultData;
import java.util.List;


import java.util.Objects;
public  class PromotionResultDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PromotionResultDataList.promotions</code> property defined at extension <code>commercewebservices</code>. */
	
	private List<PromotionResultData> promotions;
	
	public PromotionResultDataList()
	{
		// default constructor
	}
	
	public void setPromotions(final List<PromotionResultData> promotions)
	{
		this.promotions = promotions;
	}

	public List<PromotionResultData> getPromotions() 
	{
		return promotions;
	}
	

}