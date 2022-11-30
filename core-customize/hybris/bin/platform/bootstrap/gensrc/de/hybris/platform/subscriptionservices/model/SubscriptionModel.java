/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type Subscription first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class SubscriptionModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Subscription";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.id</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.name</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.description</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.productCode</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String PRODUCTCODE = "productCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.orderNumber</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ORDERNUMBER = "orderNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.orderEntryNumber</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ORDERENTRYNUMBER = "orderEntryNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.billingsystemId</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGSYSTEMID = "billingsystemId";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.startDate</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String STARTDATE = "startDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.endDate</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ENDDATE = "endDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.renewalType</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String RENEWALTYPE = "renewalType";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.subscriptionStatus</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String SUBSCRIPTIONSTATUS = "subscriptionStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.cancellable</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CANCELLABLE = "cancellable";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.billingFrequency</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGFREQUENCY = "billingFrequency";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.contractDuration</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CONTRACTDURATION = "contractDuration";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.contractFrequency</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CONTRACTFREQUENCY = "contractFrequency";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.placedOn</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String PLACEDON = "placedOn";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.cancelledDate</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CANCELLEDDATE = "cancelledDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Subscription.customerId</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CUSTOMERID = "customerId";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SubscriptionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SubscriptionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>Subscription</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SubscriptionModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>Subscription</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SubscriptionModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.billingFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingFrequency - Billing Frequency
	 */
	@Accessor(qualifier = "billingFrequency", type = Accessor.Type.GETTER)
	public String getBillingFrequency()
	{
		return getPersistenceContext().getPropertyValue(BILLINGFREQUENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.billingsystemId</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingsystemId - Billingsystem Identifier
	 */
	@Accessor(qualifier = "billingsystemId", type = Accessor.Type.GETTER)
	public String getBillingsystemId()
	{
		return getPersistenceContext().getPropertyValue(BILLINGSYSTEMID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.cancellable</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the cancellable - Cancellable
	 */
	@Accessor(qualifier = "cancellable", type = Accessor.Type.GETTER)
	public Boolean getCancellable()
	{
		return getPersistenceContext().getPropertyValue(CANCELLABLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.cancelledDate</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the cancelledDate - Cancellation Date
	 */
	@Accessor(qualifier = "cancelledDate", type = Accessor.Type.GETTER)
	public Date getCancelledDate()
	{
		return getPersistenceContext().getPropertyValue(CANCELLEDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.contractDuration</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the contractDuration - Contract Duration
	 */
	@Accessor(qualifier = "contractDuration", type = Accessor.Type.GETTER)
	public Integer getContractDuration()
	{
		return getPersistenceContext().getPropertyValue(CONTRACTDURATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.contractFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the contractFrequency - Contract Frequency
	 */
	@Accessor(qualifier = "contractFrequency", type = Accessor.Type.GETTER)
	public String getContractFrequency()
	{
		return getPersistenceContext().getPropertyValue(CONTRACTFREQUENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.customerId</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the customerId - Customer Id
	 */
	@Accessor(qualifier = "customerId", type = Accessor.Type.GETTER)
	public String getCustomerId()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.description</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getPersistenceContext().getPropertyValue(DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.endDate</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the endDate - Enddate
	 */
	@Accessor(qualifier = "endDate", type = Accessor.Type.GETTER)
	public Date getEndDate()
	{
		return getPersistenceContext().getPropertyValue(ENDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.id</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.orderEntryNumber</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the orderEntryNumber - Order Entry Identifier
	 */
	@Accessor(qualifier = "orderEntryNumber", type = Accessor.Type.GETTER)
	public Integer getOrderEntryNumber()
	{
		return getPersistenceContext().getPropertyValue(ORDERENTRYNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.orderNumber</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the orderNumber - Order Identifier
	 */
	@Accessor(qualifier = "orderNumber", type = Accessor.Type.GETTER)
	public String getOrderNumber()
	{
		return getPersistenceContext().getPropertyValue(ORDERNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.placedOn</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the placedOn - Placed on
	 */
	@Accessor(qualifier = "placedOn", type = Accessor.Type.GETTER)
	public Date getPlacedOn()
	{
		return getPersistenceContext().getPropertyValue(PLACEDON);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.productCode</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the productCode - Product Code
	 */
	@Accessor(qualifier = "productCode", type = Accessor.Type.GETTER)
	public String getProductCode()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.renewalType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the renewalType - Renewal Type
	 */
	@Accessor(qualifier = "renewalType", type = Accessor.Type.GETTER)
	public String getRenewalType()
	{
		return getPersistenceContext().getPropertyValue(RENEWALTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.startDate</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the startDate - Startdate
	 */
	@Accessor(qualifier = "startDate", type = Accessor.Type.GETTER)
	public Date getStartDate()
	{
		return getPersistenceContext().getPropertyValue(STARTDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Subscription.subscriptionStatus</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the subscriptionStatus - Status
	 */
	@Accessor(qualifier = "subscriptionStatus", type = Accessor.Type.GETTER)
	public String getSubscriptionStatus()
	{
		return getPersistenceContext().getPropertyValue(SUBSCRIPTIONSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.billingFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingFrequency - Billing Frequency
	 */
	@Accessor(qualifier = "billingFrequency", type = Accessor.Type.SETTER)
	public void setBillingFrequency(final String value)
	{
		getPersistenceContext().setPropertyValue(BILLINGFREQUENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.billingsystemId</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingsystemId - Billingsystem Identifier
	 */
	@Accessor(qualifier = "billingsystemId", type = Accessor.Type.SETTER)
	public void setBillingsystemId(final String value)
	{
		getPersistenceContext().setPropertyValue(BILLINGSYSTEMID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.cancellable</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the cancellable - Cancellable
	 */
	@Accessor(qualifier = "cancellable", type = Accessor.Type.SETTER)
	public void setCancellable(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(CANCELLABLE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.cancelledDate</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the cancelledDate - Cancellation Date
	 */
	@Accessor(qualifier = "cancelledDate", type = Accessor.Type.SETTER)
	public void setCancelledDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(CANCELLEDDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.contractDuration</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the contractDuration - Contract Duration
	 */
	@Accessor(qualifier = "contractDuration", type = Accessor.Type.SETTER)
	public void setContractDuration(final Integer value)
	{
		getPersistenceContext().setPropertyValue(CONTRACTDURATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.contractFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the contractFrequency - Contract Frequency
	 */
	@Accessor(qualifier = "contractFrequency", type = Accessor.Type.SETTER)
	public void setContractFrequency(final String value)
	{
		getPersistenceContext().setPropertyValue(CONTRACTFREQUENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.customerId</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the customerId - Customer Id
	 */
	@Accessor(qualifier = "customerId", type = Accessor.Type.SETTER)
	public void setCustomerId(final String value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.description</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(DESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.endDate</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the endDate - Enddate
	 */
	@Accessor(qualifier = "endDate", type = Accessor.Type.SETTER)
	public void setEndDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(ENDDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Subscription.id</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.orderEntryNumber</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the orderEntryNumber - Order Entry Identifier
	 */
	@Accessor(qualifier = "orderEntryNumber", type = Accessor.Type.SETTER)
	public void setOrderEntryNumber(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ORDERENTRYNUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.orderNumber</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the orderNumber - Order Identifier
	 */
	@Accessor(qualifier = "orderNumber", type = Accessor.Type.SETTER)
	public void setOrderNumber(final String value)
	{
		getPersistenceContext().setPropertyValue(ORDERNUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.placedOn</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the placedOn - Placed on
	 */
	@Accessor(qualifier = "placedOn", type = Accessor.Type.SETTER)
	public void setPlacedOn(final Date value)
	{
		getPersistenceContext().setPropertyValue(PLACEDON, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.productCode</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the productCode - Product Code
	 */
	@Accessor(qualifier = "productCode", type = Accessor.Type.SETTER)
	public void setProductCode(final String value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTCODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.renewalType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the renewalType - Renewal Type
	 */
	@Accessor(qualifier = "renewalType", type = Accessor.Type.SETTER)
	public void setRenewalType(final String value)
	{
		getPersistenceContext().setPropertyValue(RENEWALTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.startDate</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the startDate - Startdate
	 */
	@Accessor(qualifier = "startDate", type = Accessor.Type.SETTER)
	public void setStartDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(STARTDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Subscription.subscriptionStatus</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the subscriptionStatus - Status
	 */
	@Accessor(qualifier = "subscriptionStatus", type = Accessor.Type.SETTER)
	public void setSubscriptionStatus(final String value)
	{
		getPersistenceContext().setPropertyValue(SUBSCRIPTIONSTATUS, value);
	}
	
}
