/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractQueryDTO;


import java.util.Objects;
public  class AbstractExpressionQueryDTO extends AbstractQueryDTO 

{



	/** <i>Generated property</i> for <code>AbstractExpressionQueryDTO.expression</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String expression;

	/** <i>Generated property</i> for <code>AbstractExpressionQueryDTO.languageId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String languageId;

	/** <i>Generated property</i> for <code>AbstractExpressionQueryDTO.qualifierId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String qualifierId;
	
	public AbstractExpressionQueryDTO()
	{
		// default constructor
	}
	
	public void setExpression(final String expression)
	{
		this.expression = expression;
	}

	public String getExpression() 
	{
		return expression;
	}
	
	public void setLanguageId(final String languageId)
	{
		this.languageId = languageId;
	}

	public String getLanguageId() 
	{
		return languageId;
	}
	
	public void setQualifierId(final String qualifierId)
	{
		this.qualifierId = qualifierId;
	}

	public String getQualifierId() 
	{
		return qualifierId;
	}
	

}