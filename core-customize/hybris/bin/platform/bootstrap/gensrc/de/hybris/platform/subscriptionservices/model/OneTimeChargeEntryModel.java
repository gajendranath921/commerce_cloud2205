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
import de.hybris.platform.subscriptionservices.model.BillingEventModel;
import de.hybris.platform.subscriptionservices.model.ChargeEntryModel;
import de.hybris.platform.subscriptionservices.model.SubscriptionPricePlanModel;
import java.util.Locale;

/**
 * Generated model class for type OneTimeChargeEntry first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class OneTimeChargeEntryModel extends ChargeEntryModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OneTimeChargeEntry";
	
	/**<i>Generated relation code constant for relation <code>SubscriptionPricePlan2OneTimeChargeEntryRelation</code> defining source attribute <code>subscriptionPricePlanOneTime</code> in extension <code>subscriptionservices</code>.</i>*/
	public static final String _SUBSCRIPTIONPRICEPLAN2ONETIMECHARGEENTRYRELATION = "SubscriptionPricePlan2OneTimeChargeEntryRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>OneTimeChargeEntry.name</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>OneTimeChargeEntry.billingEvent</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGEVENT = "billingEvent";
	
	/** <i>Generated constant</i> - Attribute key of <code>OneTimeChargeEntry.subscriptionPricePlanOneTime</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String SUBSCRIPTIONPRICEPLANONETIME = "subscriptionPricePlanOneTime";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OneTimeChargeEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OneTimeChargeEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _billingEvent initial attribute declared by type <code>OneTimeChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OneTimeChargeEntryModel(final BillingEventModel _billingEvent, final Double _price)
	{
		super();
		setBillingEvent(_billingEvent);
		setPrice(_price);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _billingEvent initial attribute declared by type <code>OneTimeChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _catalogVersion initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _id initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OneTimeChargeEntryModel(final BillingEventModel _billingEvent, final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final Double _price)
	{
		super();
		setBillingEvent(_billingEvent);
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setPrice(_price);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OneTimeChargeEntry.billingEvent</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingEvent - Billing Event
	 */
	@Accessor(qualifier = "billingEvent", type = Accessor.Type.GETTER)
	public BillingEventModel getBillingEvent()
	{
		return getPersistenceContext().getPropertyValue(BILLINGEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OneTimeChargeEntry.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>OneTimeChargeEntry.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @param loc the value localization key 
	 * @return the name - Name
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OneTimeChargeEntry.subscriptionPricePlanOneTime</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the subscriptionPricePlanOneTime
	 */
	@Accessor(qualifier = "subscriptionPricePlanOneTime", type = Accessor.Type.GETTER)
	public SubscriptionPricePlanModel getSubscriptionPricePlanOneTime()
	{
		return getPersistenceContext().getPropertyValue(SUBSCRIPTIONPRICEPLANONETIME);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OneTimeChargeEntry.billingEvent</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingEvent - Billing Event
	 */
	@Accessor(qualifier = "billingEvent", type = Accessor.Type.SETTER)
	public void setBillingEvent(final BillingEventModel value)
	{
		getPersistenceContext().setPropertyValue(BILLINGEVENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OneTimeChargeEntry.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>OneTimeChargeEntry.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OneTimeChargeEntry.subscriptionPricePlanOneTime</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the subscriptionPricePlanOneTime
	 */
	@Accessor(qualifier = "subscriptionPricePlanOneTime", type = Accessor.Type.SETTER)
	public void setSubscriptionPricePlanOneTime(final SubscriptionPricePlanModel value)
	{
		getPersistenceContext().setPropertyValue(SUBSCRIPTIONPRICEPLANONETIME, value);
	}
	
}
