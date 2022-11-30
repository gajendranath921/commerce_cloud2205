/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsocc.data;

import java.io.Serializable;
import de.hybris.platform.cmsocc.data.ComponentListWsDTO;
import java.util.Map;


import java.util.Objects;
public  class ContentSlotWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.slotId</code> property defined at extension <code>cmsocc</code>. */
	
	private String slotId;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.slotUuid</code> property defined at extension <code>cmsocc</code>. */
	
	private String slotUuid;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.position</code> property defined at extension <code>cmsocc</code>. */
	
	private String position;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.name</code> property defined at extension <code>cmsocc</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.slotShared</code> property defined at extension <code>cmsocc</code>. */
	
	private Boolean slotShared;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.slotStatus</code> property defined at extension <code>cmsocc</code>. */
	
	private String slotStatus;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.components</code> property defined at extension <code>cmsocc</code>. */
	
	private ComponentListWsDTO components;

	/** <i>Generated property</i> for <code>ContentSlotWsDTO.otherProperties</code> property defined at extension <code>cmsocc</code>. */
	
	private Map<String,Object> otherProperties;
	
	public ContentSlotWsDTO()
	{
		// default constructor
	}
	
	public void setSlotId(final String slotId)
	{
		this.slotId = slotId;
	}

	public String getSlotId() 
	{
		return slotId;
	}
	
	public void setSlotUuid(final String slotUuid)
	{
		this.slotUuid = slotUuid;
	}

	public String getSlotUuid() 
	{
		return slotUuid;
	}
	
	public void setPosition(final String position)
	{
		this.position = position;
	}

	public String getPosition() 
	{
		return position;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setSlotShared(final Boolean slotShared)
	{
		this.slotShared = slotShared;
	}

	public Boolean getSlotShared() 
	{
		return slotShared;
	}
	
	public void setSlotStatus(final String slotStatus)
	{
		this.slotStatus = slotStatus;
	}

	public String getSlotStatus() 
	{
		return slotStatus;
	}
	
	public void setComponents(final ComponentListWsDTO components)
	{
		this.components = components;
	}

	public ComponentListWsDTO getComponents() 
	{
		return components;
	}
	
	public void setOtherProperties(final Map<String,Object> otherProperties)
	{
		this.otherProperties = otherProperties;
	}

	public Map<String,Object> getOtherProperties() 
	{
		return otherProperties;
	}
	

}