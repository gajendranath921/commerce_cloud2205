/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.order.OrderApprovalRecordWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.order.TriggerWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Details of one specific order approval
 */
@ApiModel(value="OrderApproval", description="Details of one specific order approval")
public  class OrderApprovalWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code that identifies the approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="code", value="Code that identifies the approval.", required=true, example="00000005") 	
	private String code;

	/** Order linked to this approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.order</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="order", value="Order linked to this approval.") 	
	private OrderWsDTO order;

	/** Boolean flag which states whether an approval decision is required.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.approvalDecisionRequired</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="approvalDecisionRequired", value="Boolean flag which states whether an approval decision is required.") 	
	private Boolean approvalDecisionRequired;

	/** Customer approval records related to this order approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.customerOrderApprovalRecords</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="customerOrderApprovalRecords", value="Customer approval records related to this order approval.") 	
	private List<OrderApprovalRecordWsDTO> customerOrderApprovalRecords;

	/** Merchant approval records related to this order approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.merchantOrderApprovalRecords</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="merchantOrderApprovalRecords", value="Merchant approval records related to this order approval.") 	
	private List<OrderApprovalRecordWsDTO> merchantOrderApprovalRecords;

	/** Replenishment trigger if this is an approval for a replenishment order.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.trigger</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="trigger", value="Replenishment trigger if this is an approval for a replenishment order.") 	
	private TriggerWsDTO trigger;
	
	public OrderApprovalWsDTO()
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
	
	public void setOrder(final OrderWsDTO order)
	{
		this.order = order;
	}

	public OrderWsDTO getOrder() 
	{
		return order;
	}
	
	public void setApprovalDecisionRequired(final Boolean approvalDecisionRequired)
	{
		this.approvalDecisionRequired = approvalDecisionRequired;
	}

	public Boolean getApprovalDecisionRequired() 
	{
		return approvalDecisionRequired;
	}
	
	public void setCustomerOrderApprovalRecords(final List<OrderApprovalRecordWsDTO> customerOrderApprovalRecords)
	{
		this.customerOrderApprovalRecords = customerOrderApprovalRecords;
	}

	public List<OrderApprovalRecordWsDTO> getCustomerOrderApprovalRecords() 
	{
		return customerOrderApprovalRecords;
	}
	
	public void setMerchantOrderApprovalRecords(final List<OrderApprovalRecordWsDTO> merchantOrderApprovalRecords)
	{
		this.merchantOrderApprovalRecords = merchantOrderApprovalRecords;
	}

	public List<OrderApprovalRecordWsDTO> getMerchantOrderApprovalRecords() 
	{
		return merchantOrderApprovalRecords;
	}
	
	public void setTrigger(final TriggerWsDTO trigger)
	{
		this.trigger = trigger;
	}

	public TriggerWsDTO getTrigger() 
	{
		return trigger;
	}
	

}