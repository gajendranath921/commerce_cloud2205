/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.AbstractPageWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
@ApiModel(value="homepage")
public  class HomePageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>HomePageWsDTO.current</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="current") 	
	private AbstractPageWsDTO current;

	/** <i>Generated property</i> for <code>HomePageWsDTO.old</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="old") 	
	private AbstractPageWsDTO old;

	/** <i>Generated property</i> for <code>HomePageWsDTO.fallback</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="fallback") 	
	private AbstractPageWsDTO fallback;
	
	public HomePageWsDTO()
	{
		// default constructor
	}
	
	public void setCurrent(final AbstractPageWsDTO current)
	{
		this.current = current;
	}

	public AbstractPageWsDTO getCurrent() 
	{
		return current;
	}
	
	public void setOld(final AbstractPageWsDTO old)
	{
		this.old = old;
	}

	public AbstractPageWsDTO getOld() 
	{
		return old;
	}
	
	public void setFallback(final AbstractPageWsDTO fallback)
	{
		this.fallback = fallback;
	}

	public AbstractPageWsDTO getFallback() 
	{
		return fallback;
	}
	

}