/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of data used for user creation operations. Consists of fields used to create customer
 */
@ApiModel(value="OrgCustomerCreation", description="Representation of data used for user creation operations. Consists of fields used to create customer")
public  class OrgCustomerCreationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Email of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.email</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="email", value="Email of the user", example="akiro.nakamura@rustic-hw.com") 	
	private String email;

	/** First name of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.firstName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="firstName", value="First name of the user", example="Akiro") 	
	private String firstName;

	/** Last name of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.lastName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="lastName", value="Last name of the user", example="Nakamura") 	
	private String lastName;

	/** Code of the user's title<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.titleCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="titleCode", value="Code of the user's title", example="mr") 	
	private String titleCode;

	/** The unit of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orgUnit", value="The unit of the user", example="Rustic") 	
	private B2BUnitWsDTO orgUnit;

	/** List of organizational approvers<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.roles</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="roles", value="List of organizational approvers") 	
	private List<String> roles;
	
	public OrgCustomerCreationWsDTO()
	{
		// default constructor
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	public String getTitleCode() 
	{
		return titleCode;
	}
	
	public void setOrgUnit(final B2BUnitWsDTO orgUnit)
	{
		this.orgUnit = orgUnit;
	}

	public B2BUnitWsDTO getOrgUnit() 
	{
		return orgUnit;
	}
	
	public void setRoles(final List<String> roles)
	{
		this.roles = roles;
	}

	public List<String> getRoles() 
	{
		return roles;
	}
	

}