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
import de.hybris.platform.subscriptionservices.model.UsageChargeModel;
import de.hybris.platform.subscriptionservices.model.UsageUnitModel;

/**
 * Generated model class for type VolumeUsageCharge first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class VolumeUsageChargeModel extends UsageChargeModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "VolumeUsageCharge";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public VolumeUsageChargeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public VolumeUsageChargeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _usageUnit initial attribute declared by type <code>UsageCharge</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public VolumeUsageChargeModel(final UsageUnitModel _usageUnit)
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
	public VolumeUsageChargeModel(final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final UsageUnitModel _usageUnit)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setUsageUnit(_usageUnit);
	}
	
	
}
