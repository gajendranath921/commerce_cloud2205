/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.dto;

import java.io.Serializable;
import java.util.Set;


import java.util.Objects;
/**
 * Integration object bundle.
 */
public  class IntegrationObjectBundleEntity  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Integration object code.<br/><br/><i>Generated property</i> for <code>IntegrationObjectBundleEntity.integrationObjectCode</code> property defined at extension <code>odata2services</code>. */
	
	private String integrationObjectCode;

	/** Integration object root item instances identifiers (PKs).<br/><br/><i>Generated property</i> for <code>IntegrationObjectBundleEntity.rootItemInstancePks</code> property defined at extension <code>odata2services</code>. */
	
	private Set<String> rootItemInstancePks;
	
	public IntegrationObjectBundleEntity()
	{
		// default constructor
	}
	
	public void setIntegrationObjectCode(final String integrationObjectCode)
	{
		this.integrationObjectCode = integrationObjectCode;
	}

	public String getIntegrationObjectCode() 
	{
		return integrationObjectCode;
	}
	
	public void setRootItemInstancePks(final Set<String> rootItemInstancePks)
	{
		this.rootItemInstancePks = rootItemInstancePks;
	}

	public Set<String> getRootItemInstancePks() 
	{
		return rootItemInstancePks;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final IntegrationObjectBundleEntity other = (IntegrationObjectBundleEntity) o;
		return Objects.equals(getIntegrationObjectCode(), other.getIntegrationObjectCode());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = integrationObjectCode;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}