/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.storesession.LanguageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an User
 */
@ApiModel(value="User", description="Representation of an User")
public  class UserWsDTO extends PrincipalWsDTO 

{



	/** User address<br/><br/><i>Generated property</i> for <code>UserWsDTO.defaultAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="defaultAddress", value="User address") 	
	private AddressWsDTO defaultAddress;

	/** User title code<br/><br/><i>Generated property</i> for <code>UserWsDTO.titleCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="titleCode", value="User title code") 	
	private String titleCode;

	/** User title<br/><br/><i>Generated property</i> for <code>UserWsDTO.title</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="title", value="User title") 	
	private String title;

	/** User first name<br/><br/><i>Generated property</i> for <code>UserWsDTO.firstName</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="firstName", value="User first name") 	
	private String firstName;

	/** User last name<br/><br/><i>Generated property</i> for <code>UserWsDTO.lastName</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="lastName", value="User last name") 	
	private String lastName;

	/** User preferred currency<br/><br/><i>Generated property</i> for <code>UserWsDTO.currency</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="currency", value="User preferred currency") 	
	private CurrencyWsDTO currency;

	/** User preferred language<br/><br/><i>Generated property</i> for <code>UserWsDTO.language</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="language", value="User preferred language") 	
	private LanguageWsDTO language;

	/** User identifier<br/><br/><i>Generated property</i> for <code>UserWsDTO.displayUid</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="displayUid", value="User identifier") 	
	private String displayUid;

	/** Customer identifier<br/><br/><i>Generated property</i> for <code>UserWsDTO.customerId</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="customerId", value="Customer identifier") 	
	private String customerId;

	/** Deactivation date<br/><br/><i>Generated property</i> for <code>UserWsDTO.deactivationDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="deactivationDate", value="Deactivation date") 	
	private Date deactivationDate;

	/** The unit of the User<br/><br/><i>Generated property</i> for <code>UserWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orgUnit", value="The unit of the User", example="Rustic") 	
	private B2BUnitWsDTO orgUnit;

	/** <i>Generated property</i> for <code>UserWsDTO.roles</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="roles") 	
	private List<String> roles;

	/** List of organizational approvers<br/><br/><i>Generated property</i> for <code>UserWsDTO.approvers</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="approvers", value="List of organizational approvers") 	
	private List<UserWsDTO> approvers;

	/** Boolean flag of whether the user is selected<br/><br/><i>Generated property</i> for <code>UserWsDTO.selected</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="selected", value="Boolean flag of whether the user is selected", example="true") 	
	private Boolean selected;

	/** Boolean flag of whether the user is active/enabled or not<br/><br/><i>Generated property</i> for <code>UserWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="active", value="Boolean flag of whether the user is active/enabled or not", example="true") 	
	private Boolean active;

	/** Email of the user<br/><br/><i>Generated property</i> for <code>UserWsDTO.email</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="email", value="Email of the user", example="mark.rivers@rustic-hw.com") 	
	private String email;

	/** Mobile Number<br/><br/><i>Generated property</i> for <code>UserWsDTO.mobileNumber</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="mobileNumber", value="Mobile Number") 	
	private String mobileNumber;

	/** Email Language<br/><br/><i>Generated property</i> for <code>UserWsDTO.emailLanguage</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="emailLanguage", value="Email Language") 	
	private String emailLanguage;
	
	public UserWsDTO()
	{
		// default constructor
	}
	
	public void setDefaultAddress(final AddressWsDTO defaultAddress)
	{
		this.defaultAddress = defaultAddress;
	}

	public AddressWsDTO getDefaultAddress() 
	{
		return defaultAddress;
	}
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	public String getTitleCode() 
	{
		return titleCode;
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
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
	
	public void setCurrency(final CurrencyWsDTO currency)
	{
		this.currency = currency;
	}

	public CurrencyWsDTO getCurrency() 
	{
		return currency;
	}
	
	public void setLanguage(final LanguageWsDTO language)
	{
		this.language = language;
	}

	public LanguageWsDTO getLanguage() 
	{
		return language;
	}
	
	public void setDisplayUid(final String displayUid)
	{
		this.displayUid = displayUid;
	}

	public String getDisplayUid() 
	{
		return displayUid;
	}
	
	public void setCustomerId(final String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerId() 
	{
		return customerId;
	}
	
	public void setDeactivationDate(final Date deactivationDate)
	{
		this.deactivationDate = deactivationDate;
	}

	public Date getDeactivationDate() 
	{
		return deactivationDate;
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
	
	public void setApprovers(final List<UserWsDTO> approvers)
	{
		this.approvers = approvers;
	}

	public List<UserWsDTO> getApprovers() 
	{
		return approvers;
	}
	
	public void setSelected(final Boolean selected)
	{
		this.selected = selected;
	}

	public Boolean getSelected() 
	{
		return selected;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setMobileNumber(final String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() 
	{
		return mobileNumber;
	}
	
	public void setEmailLanguage(final String emailLanguage)
	{
		this.emailLanguage = emailLanguage;
	}

	public String getEmailLanguage() 
	{
		return emailLanguage;
	}
	

}