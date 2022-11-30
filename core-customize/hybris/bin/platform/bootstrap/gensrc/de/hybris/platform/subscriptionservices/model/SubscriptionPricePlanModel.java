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
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.model.OneTimeChargeEntryModel;
import de.hybris.platform.subscriptionservices.model.RecurringChargeEntryModel;
import de.hybris.platform.subscriptionservices.model.UsageChargeModel;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type SubscriptionPricePlan first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class SubscriptionPricePlanModel extends PriceRowModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SubscriptionPricePlan";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionPricePlan.name</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionPricePlan.validationMessages</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String VALIDATIONMESSAGES = "validationMessages";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionPricePlan.oneTimeChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ONETIMECHARGEENTRIES = "oneTimeChargeEntries";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionPricePlan.recurringChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String RECURRINGCHARGEENTRIES = "recurringChargeEntries";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionPricePlan.usageCharges</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String USAGECHARGES = "usageCharges";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SubscriptionPricePlanModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SubscriptionPricePlanModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>PriceRow</code> at extension <code>europe1</code>
	 * @param _price initial attribute declared by type <code>SubscriptionPricePlan</code> at extension <code>subscriptionservices</code>
	 * @param _unit initial attribute declared by type <code>PriceRow</code> at extension <code>europe1</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SubscriptionPricePlanModel(final CurrencyModel _currency, final Double _price, final UnitModel _unit)
	{
		super();
		setCurrency(_currency);
		setPrice(_price);
		setUnit(_unit);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>PriceRow</code> at extension <code>europe1</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _pg initial attribute declared by type <code>PriceRow</code> at extension <code>europe1</code>
	 * @param _price initial attribute declared by type <code>SubscriptionPricePlan</code> at extension <code>subscriptionservices</code>
	 * @param _product initial attribute declared by type <code>PriceRow</code> at extension <code>europe1</code>
	 * @param _productId initial attribute declared by type <code>PDTRow</code> at extension <code>europe1</code>
	 * @param _unit initial attribute declared by type <code>PriceRow</code> at extension <code>europe1</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SubscriptionPricePlanModel(final CurrencyModel _currency, final ItemModel _owner, final ProductPriceGroup _pg, final Double _price, final ProductModel _product, final String _productId, final UnitModel _unit)
	{
		super();
		setCurrency(_currency);
		setOwner(_owner);
		setPg(_pg);
		setPrice(_price);
		setProduct(_product);
		setProductId(_productId);
		setUnit(_unit);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionPricePlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionPricePlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>SubscriptionPricePlan.oneTimeChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the oneTimeChargeEntries
	 */
	@Accessor(qualifier = "oneTimeChargeEntries", type = Accessor.Type.GETTER)
	public Collection<OneTimeChargeEntryModel> getOneTimeChargeEntries()
	{
		return getPersistenceContext().getPropertyValue(ONETIMECHARGEENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionPricePlan.recurringChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the recurringChargeEntries
	 */
	@Accessor(qualifier = "recurringChargeEntries", type = Accessor.Type.GETTER)
	public Collection<RecurringChargeEntryModel> getRecurringChargeEntries()
	{
		return getPersistenceContext().getPropertyValue(RECURRINGCHARGEENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionPricePlan.usageCharges</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the usageCharges
	 */
	@Accessor(qualifier = "usageCharges", type = Accessor.Type.GETTER)
	public Collection<UsageChargeModel> getUsageCharges()
	{
		return getPersistenceContext().getPropertyValue(USAGECHARGES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionPricePlan.validationMessages</code> dynamic attribute defined at extension <code>subscriptionservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the validationMessages - Validation Messages
	 */
	@Accessor(qualifier = "validationMessages", type = Accessor.Type.GETTER)
	public Collection<String> getValidationMessages()
	{
		return getPersistenceContext().getDynamicValue(this,VALIDATIONMESSAGES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionPricePlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionPricePlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>SubscriptionPricePlan.oneTimeChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the oneTimeChargeEntries
	 */
	@Accessor(qualifier = "oneTimeChargeEntries", type = Accessor.Type.SETTER)
	public void setOneTimeChargeEntries(final Collection<OneTimeChargeEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(ONETIMECHARGEENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionPricePlan.recurringChargeEntries</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the recurringChargeEntries
	 */
	@Accessor(qualifier = "recurringChargeEntries", type = Accessor.Type.SETTER)
	public void setRecurringChargeEntries(final Collection<RecurringChargeEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(RECURRINGCHARGEENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionPricePlan.usageCharges</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the usageCharges
	 */
	@Accessor(qualifier = "usageCharges", type = Accessor.Type.SETTER)
	public void setUsageCharges(final Collection<UsageChargeModel> value)
	{
		getPersistenceContext().setPropertyValue(USAGECHARGES, value);
	}
	
}
