/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.NavigationEntryData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the navigation node.
 */
@ApiModel(value="NavigationNodeData", description="Specifies properties of the navigation node.")
public  class NavigationNodeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationNodeData.uid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="uid", example="ElectronicsNavNode") 	
	private String uid;

	/** <i>Generated property</i> for <code>NavigationNodeData.uuid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="uuid") 	
	private String uuid;

	/** <i>Generated property</i> for <code>NavigationNodeData.itemType</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="itemType", example="CMSNavigationNode") 	
	private String itemType;

	/** <i>Generated property</i> for <code>NavigationNodeData.parentUid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="parentUid", example="SiteRootNode") 	
	private String parentUid;

	/** <i>Generated property</i> for <code>NavigationNodeData.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name", example="My Account") 	
	private String name;

	/** <i>Generated property</i> for <code>NavigationNodeData.title</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="title", example="{\"EN\" : \"Homepage\", \"DE\" : \"Startseite\"}") 	
	private Map<String,String> title;

	/** <i>Generated property</i> for <code>NavigationNodeData.hasChildren</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="hasChildren", example="false") 	
	private Boolean hasChildren;

	/** <i>Generated property</i> for <code>NavigationNodeData.position</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="position", example="3") 	
	private Integer position;

	/** <i>Generated property</i> for <code>NavigationNodeData.entries</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="entries") 	
	private List<NavigationEntryData> entries;
	
	public NavigationNodeData()
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
	
	public void setItemType(final String itemType)
	{
		this.itemType = itemType;
	}

	public String getItemType() 
	{
		return itemType;
	}
	
	public void setParentUid(final String parentUid)
	{
		this.parentUid = parentUid;
	}

	public String getParentUid() 
	{
		return parentUid;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setTitle(final Map<String,String> title)
	{
		this.title = title;
	}

	public Map<String,String> getTitle() 
	{
		return title;
	}
	
	public void setHasChildren(final Boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}

	public Boolean getHasChildren() 
	{
		return hasChildren;
	}
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

	public Integer getPosition() 
	{
		return position;
	}
	
	public void setEntries(final List<NavigationEntryData> entries)
	{
		this.entries = entries;
	}

	public List<NavigationEntryData> getEntries() 
	{
		return entries;
	}
	

}