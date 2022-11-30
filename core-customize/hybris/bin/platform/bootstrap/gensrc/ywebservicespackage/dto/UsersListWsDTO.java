/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import ywebservicespackage.dto.UserWsDTO;


import java.util.Objects;
/**
 * User list
 */
@ApiModel(value="usersList", description="User list")
public  class UsersListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UsersListWsDTO.users</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="users") 	
	private List<UserWsDTO> users;
	
	public UsersListWsDTO()
	{
		// default constructor
	}
	
	public void setUsers(final List<UserWsDTO> users)
	{
		this.users = users;
	}

	public List<UserWsDTO> getUsers() 
	{
		return users;
	}
	

}