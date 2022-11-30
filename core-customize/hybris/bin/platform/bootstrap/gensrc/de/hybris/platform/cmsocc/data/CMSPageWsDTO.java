/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsocc.data;

import java.io.Serializable;
import de.hybris.platform.cmsocc.data.ContentSlotListWsDTO;
import java.util.Map;


import java.util.Objects;
public  class CMSPageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.uid</code> property defined at extension <code>cmsocc</code>. */
	
	private String uid;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.uuid</code> property defined at extension <code>cmsocc</code>. */
	
	private String uuid;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.title</code> property defined at extension <code>cmsocc</code>. */
	
	private String title;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.template</code> property defined at extension <code>cmsocc</code>. */
	
	private String template;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.typeCode</code> property defined at extension <code>cmsocc</code>. */
	
	private String typeCode;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.name</code> property defined at extension <code>cmsocc</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.description</code> property defined at extension <code>cmsocc</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.robotTag</code> property defined at extension <code>cmsocc</code>. */
	
	private String robotTag;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.defaultPage</code> property defined at extension <code>cmsocc</code>. */
	
	private Boolean defaultPage;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.contentSlots</code> property defined at extension <code>cmsocc</code>. */
	
	private ContentSlotListWsDTO contentSlots;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.catalogVersionUuid</code> property defined at extension <code>cmsocc</code>. */
	
	private String catalogVersionUuid;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.otherProperties</code> property defined at extension <code>cmsocc</code>. */
	
	private Map<String,Object> otherProperties;
	
	public CMSPageWsDTO()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	
	public void setTemplate(final String template)
	{
		this.template = template;
	}

	public String getTemplate() 
	{
		return template;
	}
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

	public String getTypeCode() 
	{
		return typeCode;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setRobotTag(final String robotTag)
	{
		this.robotTag = robotTag;
	}

	public String getRobotTag() 
	{
		return robotTag;
	}
	
	public void setDefaultPage(final Boolean defaultPage)
	{
		this.defaultPage = defaultPage;
	}

	public Boolean getDefaultPage() 
	{
		return defaultPage;
	}
	
	public void setContentSlots(final ContentSlotListWsDTO contentSlots)
	{
		this.contentSlots = contentSlots;
	}

	public ContentSlotListWsDTO getContentSlots() 
	{
		return contentSlots;
	}
	
	public void setCatalogVersionUuid(final String catalogVersionUuid)
	{
		this.catalogVersionUuid = catalogVersionUuid;
	}

	public String getCatalogVersionUuid() 
	{
		return catalogVersionUuid;
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