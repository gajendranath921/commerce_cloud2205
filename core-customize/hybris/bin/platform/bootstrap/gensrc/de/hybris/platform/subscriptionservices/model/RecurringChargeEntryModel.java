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
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.model.ChargeEntryModel;
import de.hybris.platform.subscriptionservices.model.SubscriptionPricePlanModel;

/**
 * Generated model class for type RecurringChargeEntry first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class RecurringChargeEntryModel extends ChargeEntryModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "RecurringChargeEntry";
	
	/**<i>Generated relation code constant for relation <code>SubscriptionPricePlan2RecurringChargeEntryRelation</code> defining source attribute <code>subscriptionPricePlanRecurring</code> in extension <code>subscriptionservices</code>.</i>*/
	public static final String _SUBSCRIPTIONPRICEPLAN2RECURRINGCHARGEENTRYRELATION = "SubscriptionPricePlan2RecurringChargeEntryRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>RecurringChargeEntry.cycleStart</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CYCLESTART = "cycleStart";
	
	/** <i>Generated constant</i> - Attribute key of <code>RecurringChargeEntry.cycleEnd</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CYCLEEND = "cycleEnd";
	
	/** <i>Generated constant</i> - Attribute key of <code>RecurringChargeEntry.subscriptionPricePlanRecurring</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String SUBSCRIPTIONPRICEPLANRECURRING = "subscriptionPricePlanRecurring";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public RecurringChargeEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public RecurringChargeEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _cycleStart initial attribute declared by type <code>RecurringChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public RecurringChargeEntryModel(final Integer _cycleStart, final Double _price)
	{
		super();
		setCycleStart(_cycleStart);
		setPrice(_price);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _cycleStart initial attribute declared by type <code>RecurringChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _id initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public RecurringChargeEntryModel(final CatalogVersionModel _catalogVersion, final Integer _cycleStart, final String _id, final ItemModel _owner, final Double _price)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCycleStart(_cycleStart);
		setId(_id);
		setOwner(_owner);
		setPrice(_price);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RecurringChargeEntry.cycleEnd</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the cycleEnd - CycleEnd
	 */
	@Accessor(qualifier = "cycleEnd", type = Accessor.Type.GETTER)
	public Integer getCycleEnd()
	{
		return getPersistenceContext().getPropertyValue(CYCLEEND);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RecurringChargeEntry.cycleStart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the cycleStart - CycleStart
	 */
	@Accessor(qualifier = "cycleStart", type = Accessor.Type.GETTER)
	public Integer getCycleStart()
	{
		return getPersistenceContext().getPropertyValue(CYCLESTART);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RecurringChargeEntry.subscriptionPricePlanRecurring</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the subscriptionPricePlanRecurring
	 */
	@Accessor(qualifier = "subscriptionPricePlanRecurring", type = Accessor.Type.GETTER)
	public SubscriptionPricePlanModel getSubscriptionPricePlanRecurring()
	{
		return getPersistenceContext().getPropertyValue(SUBSCRIPTIONPRICEPLANRECURRING);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>RecurringChargeEntry.cycleEnd</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the cycleEnd - CycleEnd
	 */
	@Accessor(qualifier = "cycleEnd", type = Accessor.Type.SETTER)
	public void setCycleEnd(final Integer value)
	{
		getPersistenceContext().setPropertyValue(CYCLEEND, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>RecurringChargeEntry.cycleStart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the cycleStart - CycleStart
	 */
	@Accessor(qualifier = "cycleStart", type = Accessor.Type.SETTER)
	public void setCycleStart(final Integer value)
	{
		getPersistenceContext().setPropertyValue(CYCLESTART, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>RecurringChargeEntry.subscriptionPricePlanRecurring</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the subscriptionPricePlanRecurring
	 */
	@Accessor(qualifier = "subscriptionPricePlanRecurring", type = Accessor.Type.SETTER)
	public void setSubscriptionPricePlanRecurring(final SubscriptionPricePlanModel value)
	{
		getPersistenceContext().setPropertyValue(SUBSCRIPTIONPRICEPLANRECURRING, value);
	}
	
}
