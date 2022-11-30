/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationservices;

import java.io.Serializable;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.personalizationservices.data.CxAbstractActionResult;


import java.util.Objects;
public  class CxContext  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CxContext.user</code> property defined at extension <code>personalizationservices</code>. */
	
	private UserModel user;

	/** <i>Generated property</i> for <code>CxContext.actionResult</code> property defined at extension <code>personalizationservices</code>. */
	
	private CxAbstractActionResult actionResult;
	
	public CxContext()
	{
		// default constructor
	}
	
	public void setUser(final UserModel user)
	{
		this.user = user;
	}

	public UserModel getUser() 
	{
		return user;
	}
	
	public void setActionResult(final CxAbstractActionResult actionResult)
	{
		this.actionResult = actionResult;
	}

	public CxAbstractActionResult getActionResult() 
	{
		return actionResult;
	}
	

}