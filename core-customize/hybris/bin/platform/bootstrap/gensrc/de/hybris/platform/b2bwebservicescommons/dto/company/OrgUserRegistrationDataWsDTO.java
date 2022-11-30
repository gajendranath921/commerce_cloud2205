/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of data used for user registration operations. Consists of fields used to apply to create new
			customer
		
 */
@ApiModel(value="OrgUserRegistrationData", description="Representation of data used for user registration operations. Consists of fields used to apply to create new customer")
public  class OrgUserRegistrationDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the user's title<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.titleCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="titleCode", value="Code of the user's title", required=false, example="mr") 	
	private String titleCode;

	/** First name of the user<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.firstName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="firstName", value="First name of the user", required=true, example="akiro") 	
	private String firstName;

	/** Last name of the user<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.lastName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="lastName", value="Last name of the user", required=true, example="nakamura") 	
	private String lastName;

	/** Email of the user<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.email</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="email", value="Email of the user", required=true, example="akiro.nakamura@rustic-hw.com") 	
	private String email;

	/** Contains info to approver, usually composed by UI with a template<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.message</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="message", value="Contains info to approver, usually composed by UI with a template", required=false, example="Department:Ground support; Position:Chief safe guard; Report to: steve jackson; comments: Please create new account for me") 	
	private String message;
	
	public OrgUserRegistrationDataWsDTO()
	{
		// default constructor
	}
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	public String getTitleCode() 
	{
		return titleCode;
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
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	

}