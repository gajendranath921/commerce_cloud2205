/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the user group.
 */
@ApiModel(value="UserGroupWsDTO", description="Specifies properties of the user group.")
public  class UserGroupWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserGroupWsDTO.uid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="uid", example="admin") 	
	private String uid;

	/** <i>Generated property</i> for <code>UserGroupWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name") 	
	private Map<String, String> name;
	
	public UserGroupWsDTO()
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
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	

}