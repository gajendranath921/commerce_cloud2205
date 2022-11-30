/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.service.data;

import java.io.Serializable;
import de.hybris.platform.core.model.order.CartModel;


import java.util.Objects;
public  class CommerceSaveCartResult  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The CartModel that was saved<br/><br/><i>Generated property</i> for <code>CommerceSaveCartResult.savedCart</code> property defined at extension <code>commerceservices</code>. */
	
	private CartModel savedCart;
	
	public CommerceSaveCartResult()
	{
		// default constructor
	}
	
	public void setSavedCart(final CartModel savedCart)
	{
		this.savedCart = savedCart;
	}

	public CartModel getSavedCart() 
	{
		return savedCart;
	}
	

}