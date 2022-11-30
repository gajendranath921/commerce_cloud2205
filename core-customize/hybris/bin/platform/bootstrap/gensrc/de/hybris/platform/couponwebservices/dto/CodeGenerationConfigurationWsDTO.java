/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Code generation configuration
 */
@ApiModel(value="codeGenerationConfiguration", description="Code generation configuration")
public  class CodeGenerationConfigurationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.name</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.codeSeparator</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="codeSeparator") 	
	private String codeSeparator;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.couponPartCount</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="couponPartCount") 	
	private Integer couponPartCount;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.couponPartLength</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="couponPartLength") 	
	private Integer couponPartLength;
	
	public CodeGenerationConfigurationWsDTO()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setCodeSeparator(final String codeSeparator)
	{
		this.codeSeparator = codeSeparator;
	}

	public String getCodeSeparator() 
	{
		return codeSeparator;
	}
	
	public void setCouponPartCount(final Integer couponPartCount)
	{
		this.couponPartCount = couponPartCount;
	}

	public Integer getCouponPartCount() 
	{
		return couponPartCount;
	}
	
	public void setCouponPartLength(final Integer couponPartLength)
	{
		this.couponPartLength = couponPartLength;
	}

	public Integer getCouponPartLength() 
	{
		return couponPartLength;
	}
	

}