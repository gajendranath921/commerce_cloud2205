/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Chinese payment request
 */
@ApiModel(value="chinesePaymentRequest", description="Chinese payment request")
public  class ChinesePaymentRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Chinese payment request url, different payment modes use different parameters in the request url<br/><br/><i>Generated property</i> for <code>ChinesePaymentRequestWsDTO.url</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="url", value="Chinese payment request url, different payment modes use different parameters in the request url", example="https://mapi.alipay.com/gateway.do?body=ProductDescription&subject=ProductName&sign_type=MD5&notify_url=http://api.test.alipay.net&out_trade_no=6741334835157966&return_url=http://api.test.alipay.net/atinterface/receive_return.htm&sign=dc3d42f405d7e738ab35344449e2d9f7&buyer_id=2088002007018955&total_fee=100&service=create_direct_pay_by_user&partner=2088101568338364&seller_id=2088002007018966&payment_type=1&qr_pay_mode=1&_input_charset=gbk") 	
	private String url;

	/** Chinese payment request expired date<br/><br/><i>Generated property</i> for <code>ChinesePaymentRequestWsDTO.expiredDate</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="expiredDate", value="Chinese payment request expired date") 	
	private Date expiredDate;

	/** Order data<br/><br/><i>Generated property</i> for <code>ChinesePaymentRequestWsDTO.order</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="order", value="Order data") 	
	private OrderWsDTO order;
	
	public ChinesePaymentRequestWsDTO()
	{
		// default constructor
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setExpiredDate(final Date expiredDate)
	{
		this.expiredDate = expiredDate;
	}

	public Date getExpiredDate() 
	{
		return expiredDate;
	}
	
	public void setOrder(final OrderWsDTO order)
	{
		this.order = order;
	}

	public OrderWsDTO getOrder() 
	{
		return order;
	}
	

}