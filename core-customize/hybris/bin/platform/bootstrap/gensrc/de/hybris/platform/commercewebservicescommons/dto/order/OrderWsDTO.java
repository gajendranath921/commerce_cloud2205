/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionResultWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.AbstractOrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.ConsignmentWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Order
 */
@ApiModel(value="Order", description="Representation of an Order")
public  class OrderWsDTO extends AbstractOrderWsDTO 

{



	/** Date of order creation<br/><br/><i>Generated property</i> for <code>OrderWsDTO.created</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="created", value="Date of order creation") 	
	private Date created;

	/** Status of order<br/><br/><i>Generated property</i> for <code>OrderWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="status", value="Status of order") 	
	private String status;

	/** Status display<br/><br/><i>Generated property</i> for <code>OrderWsDTO.statusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="statusDisplay", value="Status display") 	
	private String statusDisplay;

	/** Flag showing if customer is Guest customer<br/><br/><i>Generated property</i> for <code>OrderWsDTO.guestCustomer</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="guestCustomer", value="Flag showing if customer is Guest customer") 	
	private Boolean guestCustomer;

	/** List of consignment<br/><br/><i>Generated property</i> for <code>OrderWsDTO.consignments</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="consignments", value="List of consignment") 	
	private List<ConsignmentWsDTO> consignments;

	/** Order delivery status<br/><br/><i>Generated property</i> for <code>OrderWsDTO.deliveryStatus</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="deliveryStatus", value="Order delivery status") 	
	private String deliveryStatus;

	/** Order delivery status display<br/><br/><i>Generated property</i> for <code>OrderWsDTO.deliveryStatusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="deliveryStatusDisplay", value="Order delivery status display") 	
	private String deliveryStatusDisplay;

	/** List of unconsigned order entries<br/><br/><i>Generated property</i> for <code>OrderWsDTO.unconsignedEntries</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="unconsignedEntries", value="List of unconsigned order entries") 	
	private List<OrderEntryWsDTO> unconsignedEntries;

	/** Boolean flag showing if order is cancellable<br/><br/><i>Generated property</i> for <code>OrderWsDTO.cancellable</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="cancellable", value="Boolean flag showing if order is cancellable", example="true") 	
	private Boolean cancellable;

	/** Boolean flag showing if order is returnable<br/><br/><i>Generated property</i> for <code>OrderWsDTO.returnable</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="returnable", value="Boolean flag showing if order is returnable", example="true") 	
	private Boolean returnable;

	/** <i>Generated property</i> for <code>OrderWsDTO.totalUnitCount</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="totalUnitCount") 	
	private Integer totalUnitCount;

	/** Purchase order number<br/><br/><i>Generated property</i> for <code>OrderWsDTO.purchaseOrderNumber</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="purchaseOrderNumber", value="Purchase order number") 	
	private String purchaseOrderNumber;

	/** Customer who placed the order<br/><br/><i>Generated property</i> for <code>OrderWsDTO.orgCustomer</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orgCustomer", value="Customer who placed the order") 	
	private UserWsDTO orgCustomer;

	/** Cost Center associated with the order<br/><br/><i>Generated property</i> for <code>OrderWsDTO.costCenter</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="costCenter", value="Cost Center associated with the order") 	
	private B2BCostCenterWsDTO costCenter;

	/** Results of permissions associated with the order<br/><br/><i>Generated property</i> for <code>OrderWsDTO.permissionResults</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="permissionResults", value="Results of permissions associated with the order") 	
	private List<B2BPermissionResultWsDTO> permissionResults;

	/** <i>Generated property</i> for <code>OrderWsDTO.paymentAddress</code> property defined at extension <code>ordermanagementwebservices</code>. */
@ApiModelProperty(name="paymentAddress") 	
	private AddressWsDTO paymentAddress;
	
	public OrderWsDTO()
	{
		// default constructor
	}
	
	public void setCreated(final Date created)
	{
		this.created = created;
	}

	public Date getCreated() 
	{
		return created;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setGuestCustomer(final Boolean guestCustomer)
	{
		this.guestCustomer = guestCustomer;
	}

	public Boolean getGuestCustomer() 
	{
		return guestCustomer;
	}
	
	public void setConsignments(final List<ConsignmentWsDTO> consignments)
	{
		this.consignments = consignments;
	}

	public List<ConsignmentWsDTO> getConsignments() 
	{
		return consignments;
	}
	
	public void setDeliveryStatus(final String deliveryStatus)
	{
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryStatus() 
	{
		return deliveryStatus;
	}
	
	public void setDeliveryStatusDisplay(final String deliveryStatusDisplay)
	{
		this.deliveryStatusDisplay = deliveryStatusDisplay;
	}

	public String getDeliveryStatusDisplay() 
	{
		return deliveryStatusDisplay;
	}
	
	public void setUnconsignedEntries(final List<OrderEntryWsDTO> unconsignedEntries)
	{
		this.unconsignedEntries = unconsignedEntries;
	}

	public List<OrderEntryWsDTO> getUnconsignedEntries() 
	{
		return unconsignedEntries;
	}
	
	public void setCancellable(final Boolean cancellable)
	{
		this.cancellable = cancellable;
	}

	public Boolean getCancellable() 
	{
		return cancellable;
	}
	
	public void setReturnable(final Boolean returnable)
	{
		this.returnable = returnable;
	}

	public Boolean getReturnable() 
	{
		return returnable;
	}
	
	public void setTotalUnitCount(final Integer totalUnitCount)
	{
		this.totalUnitCount = totalUnitCount;
	}

	public Integer getTotalUnitCount() 
	{
		return totalUnitCount;
	}
	
	public void setPurchaseOrderNumber(final String purchaseOrderNumber)
	{
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public String getPurchaseOrderNumber() 
	{
		return purchaseOrderNumber;
	}
	
	public void setOrgCustomer(final UserWsDTO orgCustomer)
	{
		this.orgCustomer = orgCustomer;
	}

	public UserWsDTO getOrgCustomer() 
	{
		return orgCustomer;
	}
	
	public void setCostCenter(final B2BCostCenterWsDTO costCenter)
	{
		this.costCenter = costCenter;
	}

	public B2BCostCenterWsDTO getCostCenter() 
	{
		return costCenter;
	}
	
	public void setPermissionResults(final List<B2BPermissionResultWsDTO> permissionResults)
	{
		this.permissionResults = permissionResults;
	}

	public List<B2BPermissionResultWsDTO> getPermissionResults() 
	{
		return permissionResults;
	}
	
	public void setPaymentAddress(final AddressWsDTO paymentAddress)
	{
		this.paymentAddress = paymentAddress;
	}

	public AddressWsDTO getPaymentAddress() 
	{
		return paymentAddress;
	}
	

}