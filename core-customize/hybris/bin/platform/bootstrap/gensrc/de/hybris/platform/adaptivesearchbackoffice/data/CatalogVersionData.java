/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;


import java.util.Objects;
public  class CatalogVersionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogVersionData.catalogId</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogVersionData.version</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String version;
	
	public CatalogVersionData()
	{
		// default constructor
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

	public String getVersion() 
	{
		return version;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final CatalogVersionData other = (CatalogVersionData) o;
		return Objects.equals(getCatalogId(), other.getCatalogId())

			&& Objects.equals(getVersion(), other.getVersion());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = catalogId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = version;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}