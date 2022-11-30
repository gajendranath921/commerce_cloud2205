/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.dto;

import java.io.Serializable;
import java.util.Set;


import java.util.Objects;
/**
 * Export entity.
 */
public  class ExportEntity  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Postman request URL.<br/><br/><i>Generated property</i> for <code>ExportEntity.requestUrl</code> property defined at extension <code>odata2services</code>. */
	
	private String requestUrl;

	/** Postman request bodies.<br/><br/><i>Generated property</i> for <code>ExportEntity.requestBodies</code> property defined at extension <code>odata2services</code>. */
	
	private Set<String> requestBodies;
	
	public ExportEntity()
	{
		// default constructor
	}
	
	public void setRequestUrl(final String requestUrl)
	{
		this.requestUrl = requestUrl;
	}

	public String getRequestUrl() 
	{
		return requestUrl;
	}
	
	public void setRequestBodies(final Set<String> requestBodies)
	{
		this.requestBodies = requestBodies;
	}

	public Set<String> getRequestBodies() 
	{
		return requestBodies;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final ExportEntity other = (ExportEntity) o;
		return Objects.equals(getRequestUrl(), other.getRequestUrl());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = requestUrl;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}