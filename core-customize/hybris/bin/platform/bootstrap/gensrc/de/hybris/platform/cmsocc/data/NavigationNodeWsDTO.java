/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsocc.data;

import java.io.Serializable;
import de.hybris.platform.cmsocc.data.NavigationEntryWsDTO;
import de.hybris.platform.cmsocc.data.NavigationNodeWsDTO;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;


import java.util.Objects;
@XmlRootElement
            @XmlAccessorType(XmlAccessType.FIELD)
public  class NavigationNodeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.uid</code> property defined at extension <code>cmsocc</code>. */
	
	private String uid;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.uuid</code> property defined at extension <code>cmsocc</code>. */
	
	private String uuid;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.name</code> property defined at extension <code>cmsocc</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.position</code> property defined at extension <code>cmsocc</code>. */
	
	private Integer position;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.entries</code> property defined at extension <code>cmsocc</code>. */
	
	private List<NavigationEntryWsDTO> entries;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.children</code> property defined at extension <code>cmsocc</code>. */
	
	private List<NavigationNodeWsDTO> children;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.title</code> property defined at extension <code>cmsocc</code>. */
	
	private String title;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.localizedTitle</code> property defined at extension <code>cmsocc</code>. */
	
	private String localizedTitle;
	
	public NavigationNodeWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

	public Integer getPosition() 
	{
		return position;
	}
	
	public void setEntries(final List<NavigationEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<NavigationEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
	public void setChildren(final List<NavigationNodeWsDTO> children)
	{
		this.children = children;
	}

	public List<NavigationNodeWsDTO> getChildren() 
	{
		return children;
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	
	public void setLocalizedTitle(final String localizedTitle)
	{
		this.localizedTitle = localizedTitle;
	}

	public String getLocalizedTitle() 
	{
		return localizedTitle;
	}
	

}