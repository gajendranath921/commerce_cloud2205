/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import de.hybris.platform.b2bwebservicescommons.dto.company.OrgCustomerCreationWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of data used for user modification operations. Consists of fields used to modify customer
 */
@ApiModel(value="OrgCustomerModification", description="Representation of data used for user modification operations. Consists of fields used to modify customer")
public  class OrgCustomerModificationWsDTO extends OrgCustomerCreationWsDTO 

{



	/** Boolean flag of whether the user is active/enabled or not<br/><br/><i>Generated property</i> for <code>OrgCustomerModificationWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="active", value="Boolean flag of whether the user is active/enabled or not", example="true") 	
	private Boolean active;

	/** Password of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerModificationWsDTO.password</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="password", value="Password of the user") 	
	private String password;
	
	public OrgCustomerModificationWsDTO()
	{
		// default constructor
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	

}