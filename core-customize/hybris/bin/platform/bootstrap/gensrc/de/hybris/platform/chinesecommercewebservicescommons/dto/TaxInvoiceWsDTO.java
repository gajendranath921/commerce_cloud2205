/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * data type of tax invoice
 */
@ApiModel(value="TaxInvoice", description="data type of tax invoice")
public  class TaxInvoiceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** recipient type<br/><br/><i>Generated property</i> for <code>TaxInvoiceWsDTO.recipientType</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="recipientType", value="recipient type", example="INDIVIDUAL") 	
	private String recipientType;

	/** name of recipient<br/><br/><i>Generated property</i> for <code>TaxInvoiceWsDTO.recipient</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="recipient", value="name of recipient") 	
	private String recipient;

	/** taxpayer identification number<br/><br/><i>Generated property</i> for <code>TaxInvoiceWsDTO.taxpayerID</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="taxpayerID", value="taxpayer identification number") 	
	private String taxpayerID;
	
	public TaxInvoiceWsDTO()
	{
		// default constructor
	}
	
	public void setRecipientType(final String recipientType)
	{
		this.recipientType = recipientType;
	}

	public String getRecipientType() 
	{
		return recipientType;
	}
	
	public void setRecipient(final String recipient)
	{
		this.recipient = recipient;
	}

	public String getRecipient() 
	{
		return recipient;
	}
	
	public void setTaxpayerID(final String taxpayerID)
	{
		this.taxpayerID = taxpayerID;
	}

	public String getTaxpayerID() 
	{
		return taxpayerID;
	}
	

}