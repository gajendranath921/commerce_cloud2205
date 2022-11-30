/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.ConsignmentStatus;
import de.hybris.platform.commercefacades.order.data.ConsignmentEntryData;
import de.hybris.platform.commercefacades.order.data.DeliveryModeData;
import de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.consignmenttrackingfacades.delivery.data.CarrierData;
import de.hybris.platform.consignmenttrackingservices.delivery.data.ConsignmentEventData;
import de.hybris.platform.warehousingfacades.order.data.PackagingInfoData;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class ConsignmentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsignmentData.code</code> property defined at extension <code>commercefacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>ConsignmentData.trackingID</code> property defined at extension <code>commercefacades</code>. */
	
	private String trackingID;

	/** <i>Generated property</i> for <code>ConsignmentData.status</code> property defined at extension <code>commercefacades</code>. */
	
	private ConsignmentStatus status;

	/** <i>Generated property</i> for <code>ConsignmentData.statusDate</code> property defined at extension <code>commercefacades</code>. */
	
	private Date statusDate;

	/** <i>Generated property</i> for <code>ConsignmentData.entries</code> property defined at extension <code>commercefacades</code>. */
	
	private List<ConsignmentEntryData> entries;

	/** <i>Generated property</i> for <code>ConsignmentData.shippingAddress</code> property defined at extension <code>commercefacades</code>. */
	
	private AddressData shippingAddress;

	/** <i>Generated property</i> for <code>ConsignmentData.deliveryPointOfService</code> property defined at extension <code>commercefacades</code>. */
	
	private PointOfServiceData deliveryPointOfService;

	/** <i>Generated property</i> for <code>ConsignmentData.statusDisplay</code> property defined at extension <code>acceleratorfacades</code>. */
	
	private String statusDisplay;

	/** <i>Generated property</i> for <code>ConsignmentData.carrierDetails</code> property defined at extension <code>consignmenttrackingfacades</code>. */
	
	private CarrierData carrierDetails;

	/** <i>Generated property</i> for <code>ConsignmentData.trackingEvents</code> property defined at extension <code>consignmenttrackingfacades</code>. */
	
	private List<ConsignmentEventData> trackingEvents;

	/** <i>Generated property</i> for <code>ConsignmentData.createDate</code> property defined at extension <code>consignmenttrackingfacades</code>. */
	
	private Date createDate;

	/** <i>Generated property</i> for <code>ConsignmentData.targetShipDate</code> property defined at extension <code>consignmenttrackingfacades</code>. */
	
	private Date targetShipDate;

	/** <i>Generated property</i> for <code>ConsignmentData.targetArrivalDate</code> property defined at extension <code>consignmenttrackingfacades</code>. */
	
	private Date targetArrivalDate;

	/** <i>Generated property</i> for <code>ConsignmentData.orderCode</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String orderCode;

	/** <i>Generated property</i> for <code>ConsignmentData.shippingDate</code> property defined at extension <code>warehousingfacades</code>. */
	
	private Date shippingDate;

	/** <i>Generated property</i> for <code>ConsignmentData.deliveryMode</code> property defined at extension <code>warehousingfacades</code>. */
	
	private DeliveryModeData deliveryMode;

	/** <i>Generated property</i> for <code>ConsignmentData.warehouseCode</code> property defined at extension <code>warehousingfacades</code>. */
	
	private String warehouseCode;

	/** <i>Generated property</i> for <code>ConsignmentData.packagingInfo</code> property defined at extension <code>warehousingfacades</code>. */
	
	private PackagingInfoData packagingInfo;
	
	public ConsignmentData()
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
	
	public void setTrackingID(final String trackingID)
	{
		this.trackingID = trackingID;
	}

	public String getTrackingID() 
	{
		return trackingID;
	}
	
	public void setStatus(final ConsignmentStatus status)
	{
		this.status = status;
	}

	public ConsignmentStatus getStatus() 
	{
		return status;
	}
	
	public void setStatusDate(final Date statusDate)
	{
		this.statusDate = statusDate;
	}

	public Date getStatusDate() 
	{
		return statusDate;
	}
	
	public void setEntries(final List<ConsignmentEntryData> entries)
	{
		this.entries = entries;
	}

	public List<ConsignmentEntryData> getEntries() 
	{
		return entries;
	}
	
	public void setShippingAddress(final AddressData shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public AddressData getShippingAddress() 
	{
		return shippingAddress;
	}
	
	public void setDeliveryPointOfService(final PointOfServiceData deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}

	public PointOfServiceData getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setCarrierDetails(final CarrierData carrierDetails)
	{
		this.carrierDetails = carrierDetails;
	}

	public CarrierData getCarrierDetails() 
	{
		return carrierDetails;
	}
	
	public void setTrackingEvents(final List<ConsignmentEventData> trackingEvents)
	{
		this.trackingEvents = trackingEvents;
	}

	public List<ConsignmentEventData> getTrackingEvents() 
	{
		return trackingEvents;
	}
	
	public void setCreateDate(final Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	
	public void setTargetShipDate(final Date targetShipDate)
	{
		this.targetShipDate = targetShipDate;
	}

	public Date getTargetShipDate() 
	{
		return targetShipDate;
	}
	
	public void setTargetArrivalDate(final Date targetArrivalDate)
	{
		this.targetArrivalDate = targetArrivalDate;
	}

	public Date getTargetArrivalDate() 
	{
		return targetArrivalDate;
	}
	
	public void setOrderCode(final String orderCode)
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	
	public void setShippingDate(final Date shippingDate)
	{
		this.shippingDate = shippingDate;
	}

	public Date getShippingDate() 
	{
		return shippingDate;
	}
	
	public void setDeliveryMode(final DeliveryModeData deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}

	public DeliveryModeData getDeliveryMode() 
	{
		return deliveryMode;
	}
	
	public void setWarehouseCode(final String warehouseCode)
	{
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseCode() 
	{
		return warehouseCode;
	}
	
	public void setPackagingInfo(final PackagingInfoData packagingInfo)
	{
		this.packagingInfo = packagingInfo;
	}

	public PackagingInfoData getPackagingInfo() 
	{
		return packagingInfo;
	}
	

}