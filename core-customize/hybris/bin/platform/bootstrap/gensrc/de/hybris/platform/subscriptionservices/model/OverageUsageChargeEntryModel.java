/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionservices.model;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.model.UsageChargeEntryModel;

/**
 * Generated model class for type OverageUsageChargeEntry first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class OverageUsageChargeEntryModel extends UsageChargeEntryModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OverageUsageChargeEntry";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OverageUsageChargeEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OverageUsageChargeEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OverageUsageChargeEntryModel(final Double _price)
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
	public OverageUsageChargeEntryModel(final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final Double _price)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setPrice(_price);
	}
	
	
}
