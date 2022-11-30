/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;


import java.util.Objects;
/**
 * Specifies properties of the CMS version on creation.
 */
public abstract  class CMSCreateVersionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSCreateVersionWsDTO.createVersion</code> property defined at extension <code>cmswebservices</code>. */
	
	private Boolean createVersion;

	/** <i>Generated property</i> for <code>CMSCreateVersionWsDTO.versionLabel</code> property defined at extension <code>cmswebservices</code>. */
	
	private String versionLabel;
	
	public CMSCreateVersionWsDTO()
	{
		// default constructor
	}
	
	public void setCreateVersion(final Boolean createVersion)
	{
		this.createVersion = createVersion;
	}

	public Boolean getCreateVersion() 
	{
		return createVersion;
	}
	
	public void setVersionLabel(final String versionLabel)
	{
		this.versionLabel = versionLabel;
	}

	public String getVersionLabel() 
	{
		return versionLabel;
	}
	

}