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
import de.hybris.platform.subscriptionservices.model.UsageChargeModel;

/**
 * Generated model class for type UsageChargeEntry first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class UsageChargeEntryModel extends ChargeEntryModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "UsageChargeEntry";
	
	/**<i>Generated relation code constant for relation <code>UsageCharge2UsageChargeEntryRelation</code> defining source attribute <code>usageCharge</code> in extension <code>subscriptionservices</code>.</i>*/
	public static final String _USAGECHARGE2USAGECHARGEENTRYRELATION = "UsageCharge2UsageChargeEntryRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageChargeEntry.usageCharge</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String USAGECHARGE = "usageCharge";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public UsageChargeEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public UsageChargeEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public UsageChargeEntryModel(final Double _price)
	{
		super();
		setPrice(_price);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _id initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public UsageChargeEntryModel(final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final Double _price)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setPrice(_price);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageChargeEntry.usageCharge</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the usageCharge
	 */
	@Accessor(qualifier = "usageCharge", type = Accessor.Type.GETTER)
	public UsageChargeModel getUsageCharge()
	{
		return getPersistenceContext().getPropertyValue(USAGECHARGE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UsageChargeEntry.usageCharge</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the usageCharge
	 */
	@Accessor(qualifier = "usageCharge", type = Accessor.Type.SETTER)
	public void setUsageCharge(final UsageChargeModel value)
	{
		getPersistenceContext().setPropertyValue(USAGECHARGE, value);
	}
	
}
