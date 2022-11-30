/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.CardTypeData;
import java.util.List;


import java.util.Objects;
public  class CardTypeDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CardTypeDataList.cardTypes</code> property defined at extension <code>commercewebservices</code>. */
	
	private List<CardTypeData> cardTypes;
	
	public CardTypeDataList()
	{
		// default constructor
	}
	
	public void setCardTypes(final List<CardTypeData> cardTypes)
	{
		this.cardTypes = cardTypes;
	}

	public List<CardTypeData> getCardTypes() 
	{
		return cardTypes;
	}
	

}