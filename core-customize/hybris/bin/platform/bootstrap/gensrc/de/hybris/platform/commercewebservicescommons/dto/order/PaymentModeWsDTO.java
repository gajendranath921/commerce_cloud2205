/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of a Payment Mode
 */
@ApiModel(value="PaymentMode", description="Representation of a Payment Mode")
public  class PaymentModeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Payment mode code<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="code", value="Payment mode code") 	
	private String code;

	/** Payment mode name<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="name", value="Payment mode name") 	
	private String name;

	/** Payment mode description<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="description", value="Payment mode description") 	
	private String description;

	/** Logo url of payment mode<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.pspLogoUrl</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="pspLogoUrl", value="Logo url of payment mode", example="/medias/wechatpay.png?context=CONTEXT") 	
	private String pspLogoUrl;
	
	public PaymentModeWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
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
	
	public void setPspLogoUrl(final String pspLogoUrl)
	{
		this.pspLogoUrl = pspLogoUrl;
	}

	public String getPspLogoUrl() 
	{
		return pspLogoUrl;
	}
	

}