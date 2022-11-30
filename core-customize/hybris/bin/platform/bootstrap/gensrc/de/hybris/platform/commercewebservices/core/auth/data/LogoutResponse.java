/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.auth.data;

import java.io.Serializable;


import java.util.Objects;
public  class LogoutResponse  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>LogoutResponse.success</code> property defined at extension <code>commercewebservices</code>. */
	
	private boolean success;
	
	public LogoutResponse()
	{
		// default constructor
	}
	
	public void setSuccess(final boolean success)
	{
		this.success = success;
	}

	public boolean isSuccess() 
	{
		return success;
	}
	

}