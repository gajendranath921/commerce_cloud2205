/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking;

import java.io.Serializable;
import de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking.CarrierWsDTO;
import de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking.ConsignmentTrackingEventDataWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Consignment tracking data
 */
@ApiModel(value="consignmentTracking", description="Consignment tracking data")
public  class ConsignmentTrackingWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Consignment status<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.statusDisplay</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="statusDisplay", value="Consignment status", example="inTransit") 	
	private String statusDisplay;

	/** Carrier details<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.carrierDetails</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="carrierDetails", value="Carrier details") 	
	private CarrierWsDTO carrierDetails;

	/** Tracking identifier<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.trackingID</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="trackingID", value="Tracking identifier") 	
	private String trackingID;

	/** The tracking url provided by the carrier<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.trackingUrl</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="trackingUrl", value="The tracking url provided by the carrier") 	
	private String trackingUrl;

	/** Target arrival date<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.targetArrivalDate</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="targetArrivalDate", value="Target arrival date") 	
	private Date targetArrivalDate;

	/** Logistics tracking information<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.trackingEvents</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="trackingEvents", value="Logistics tracking information") 	
	private List<ConsignmentTrackingEventDataWsDTO> trackingEvents;
	
	public ConsignmentTrackingWsDTO()
	{
		// default constructor
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setCarrierDetails(final CarrierWsDTO carrierDetails)
	{
		this.carrierDetails = carrierDetails;
	}

	public CarrierWsDTO getCarrierDetails() 
	{
		return carrierDetails;
	}
	
	public void setTrackingID(final String trackingID)
	{
		this.trackingID = trackingID;
	}

	public String getTrackingID() 
	{
		return trackingID;
	}
	
	public void setTrackingUrl(final String trackingUrl)
	{
		this.trackingUrl = trackingUrl;
	}

	public String getTrackingUrl() 
	{
		return trackingUrl;
	}
	
	public void setTargetArrivalDate(final Date targetArrivalDate)
	{
		this.targetArrivalDate = targetArrivalDate;
	}

	public Date getTargetArrivalDate() 
	{
		return targetArrivalDate;
	}
	
	public void setTrackingEvents(final List<ConsignmentTrackingEventDataWsDTO> trackingEvents)
	{
		this.trackingEvents = trackingEvents;
	}

	public List<ConsignmentTrackingEventDataWsDTO> getTrackingEvents() 
	{
		return trackingEvents;
	}
	

}