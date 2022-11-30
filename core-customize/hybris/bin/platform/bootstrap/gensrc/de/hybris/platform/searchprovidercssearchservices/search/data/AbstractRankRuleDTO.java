/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import java.util.Objects;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
			@JsonSubTypes({
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.PromotedHitsRankRuleDTO.class, name = "promotedHits"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.QueryFunctionRankRuleDTO.class, name = "queryFunction")
			})
public  class AbstractRankRuleDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;
	
	public AbstractRankRuleDTO()
	{
		// default constructor
	}
	

}