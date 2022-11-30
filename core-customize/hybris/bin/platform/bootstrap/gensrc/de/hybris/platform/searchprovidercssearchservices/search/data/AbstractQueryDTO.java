/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
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
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.AndQueryDTO.class, name = "and"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.OrQueryDTO.class, name = "or"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.NotQueryDTO.class, name = "not"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.EqualQueryDTO.class, name = "eq"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.NotEqualQueryDTO.class, name = "ne"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.MatchTermQueryDTO.class, name = "matchTerm"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.MatchTermsQueryDTO.class, name = "matchTerms"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.MatchQueryDTO.class, name = "match"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.GreaterThanOrEqualQueryDTO.class, name = "ge"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.GreaterThanQueryDTO.class, name = "gt"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.LessThanOrEqualQueryDTO.class, name = "le"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.LessThanQueryDTO.class, name = "lt"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.RangeQueryDTO.class, name = "range"),
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.ExistsQueryDTO.class, name = "exists")
			})
public  class AbstractQueryDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;
	
	public AbstractQueryDTO()
	{
		// default constructor
	}
	

}