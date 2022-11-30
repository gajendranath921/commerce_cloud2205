/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Action for the quote.
 */
@ApiModel(value="QuoteAction", description="Action for the quote.")
public  class QuoteActionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** User's actions with the quote. Typical actions are: CANCEL, SUBMIT, ACCEPT, APPROVE, REJECT.<br/><br/><i>Generated property</i> for <code>QuoteActionWsDTO.action</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="action", value="User's actions with the quote. Typical actions are: CANCEL, SUBMIT, ACCEPT, APPROVE, REJECT.", required=true, example="SUBMIT") 	
	private String action;
	
	public QuoteActionWsDTO()
	{
		// default constructor
	}
	
	public void setAction(final String action)
	{
		this.action = action;
	}

	public String getAction() 
	{
		return action;
	}
	

}