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
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.model.BillingTimeModel;
import de.hybris.platform.subscriptionservices.model.SubscriptionPricePlanModel;
import de.hybris.platform.subscriptionservices.model.UsageChargeEntryModel;
import de.hybris.platform.subscriptionservices.model.UsageUnitModel;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type UsageCharge first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class UsageChargeModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "UsageCharge";
	
	/**<i>Generated relation code constant for relation <code>SubscriptionPricePlan2UsageChargeRelation</code> defining source attribute <code>subscriptionPricePlanUsage</code> in extension <code>subscriptionservices</code>.</i>*/
	public static final String _SUBSCRIPTIONPRICEPLAN2USAGECHARGERELATION = "SubscriptionPricePlan2UsageChargeRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.id</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.catalogVersion</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CATALOGVERSION = "catalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.name</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.currency</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.billingTime</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGTIME = "billingTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.usageUnit</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String USAGEUNIT = "usageUnit";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.subscriptionPricePlanUsage</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String SUBSCRIPTIONPRICEPLANUSAGE = "subscriptionPricePlanUsage";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageCharge.usageChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String USAGECHARGEENTRIES = "usageChargeEntries";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public UsageChargeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public UsageChargeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _usageUnit initial attribute declared by type <code>UsageCharge</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public UsageChargeModel(final UsageUnitModel _usageUnit)
	{
		super();
		setUsageUnit(_usageUnit);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>UsageCharge</code> at extension <code>subscriptionservices</code>
	 * @param _id initial attribute declared by type <code>UsageCharge</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _usageUnit initial attribute declared by type <code>UsageCharge</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public UsageChargeModel(final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final UsageUnitModel _usageUnit)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setUsageUnit(_usageUnit);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.billingTime</code> dynamic attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingTime - Billing Time
	 */
	@Accessor(qualifier = "billingTime", type = Accessor.Type.GETTER)
	public BillingTimeModel getBillingTime()
	{
		return getPersistenceContext().getDynamicValue(this,BILLINGTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.catalogVersion</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.currency</code> dynamic attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the currency - Currency from parent
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getDynamicValue(this,CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.id</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.subscriptionPricePlanUsage</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the subscriptionPricePlanUsage
	 */
	@Accessor(qualifier = "subscriptionPricePlanUsage", type = Accessor.Type.GETTER)
	public SubscriptionPricePlanModel getSubscriptionPricePlanUsage()
	{
		return getPersistenceContext().getPropertyValue(SUBSCRIPTIONPRICEPLANUSAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.usageChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the usageChargeEntries
	 */
	@Accessor(qualifier = "usageChargeEntries", type = Accessor.Type.GETTER)
	public Collection<UsageChargeEntryModel> getUsageChargeEntries()
	{
		return getPersistenceContext().getPropertyValue(USAGECHARGEENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageCharge.usageUnit</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the usageUnit - Usage Unit
	 */
	@Accessor(qualifier = "usageUnit", type = Accessor.Type.GETTER)
	public UsageUnitModel getUsageUnit()
	{
		return getPersistenceContext().getPropertyValue(USAGEUNIT);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>UsageCharge.catalogVersion</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.SETTER)
	public void setCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>UsageCharge.id</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UsageCharge.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>UsageCharge.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>UsageCharge.subscriptionPricePlanUsage</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the subscriptionPricePlanUsage
	 */
	@Accessor(qualifier = "subscriptionPricePlanUsage", type = Accessor.Type.SETTER)
	public void setSubscriptionPricePlanUsage(final SubscriptionPricePlanModel value)
	{
		getPersistenceContext().setPropertyValue(SUBSCRIPTIONPRICEPLANUSAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UsageCharge.usageChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the usageChargeEntries
	 */
	@Accessor(qualifier = "usageChargeEntries", type = Accessor.Type.SETTER)
	public void setUsageChargeEntries(final Collection<UsageChargeEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(USAGECHARGEENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UsageCharge.usageUnit</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the usageUnit - Usage Unit
	 */
	@Accessor(qualifier = "usageUnit", type = Accessor.Type.SETTER)
	public void setUsageUnit(final UsageUnitModel value)
	{
		getPersistenceContext().setPropertyValue(USAGEUNIT, value);
	}
	
}
