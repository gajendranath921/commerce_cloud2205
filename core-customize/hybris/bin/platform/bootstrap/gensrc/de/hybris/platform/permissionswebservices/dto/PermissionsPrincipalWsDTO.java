/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Principal DTO
 */
@ApiModel(value="PermissionsPrincipal", description="Principal DTO")
public  class PermissionsPrincipalWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Principal identifier<br/><br/><i>Generated property</i> for <code>PermissionsPrincipalWsDTO.principalUid</code> property defined at extension <code>permissionswebservices</code>. */
@ApiModelProperty(name="principalUid", value="Principal identifier", required=true) 	
	private String principalUid;
	
	public PermissionsPrincipalWsDTO()
	{
		// default constructor
	}
	
	public void setPrincipalUid(final String principalUid)
	{
		this.principalUid = principalUid;
	}

	public String getPrincipalUid() 
	{
		return principalUid;
	}
	

}