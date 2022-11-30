/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Decision for an order approval
 */
@ApiModel(value="OrderApprovalDecision", description="Decision for an order approval")
public  class OrderApprovalDecisionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Decision from the approver when approving/rejecting an order. Typical decisions are: APPROVE, REJECT<br/><br/><i>Generated property</i> for <code>OrderApprovalDecisionWsDTO.decision</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="decision", value="Decision from the approver when approving/rejecting an order. Typical decisions are: APPROVE, REJECT", required=true, example="APPROVE") 	
	private String decision;

	/** Any comments the approver (or the workflow system) adds when approving/rejecting an order.<br/><br/><i>Generated property</i> for <code>OrderApprovalDecisionWsDTO.comment</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="comment", value="Any comments the approver (or the workflow system) adds when approving/rejecting an order.", example="Rejected because montly budget was exceeded") 	
	private String comment;
	
	public OrderApprovalDecisionWsDTO()
	{
		// default constructor
	}
	
	public void setDecision(final String decision)
	{
		this.decision = decision;
	}

	public String getDecision() 
	{
		return decision;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	

}