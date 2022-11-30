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
import de.hybris.platform.subscriptionservices.enums.UsageChargeType;
import de.hybris.platform.subscriptionservices.model.UsageChargeModel;
import de.hybris.platform.subscriptionservices.model.UsageUnitModel;

/**
 * Generated model class for type PerUnitUsageCharge first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class PerUnitUsageChargeModel extends UsageChargeModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PerUnitUsageCharge";
	
	/** <i>Generated constant</i> - Attribute key of <code>PerUnitUsageCharge.usageChargeType</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String USAGECHARGETYPE = "usageChargeType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PerUnitUsageChargeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PerUnitUsageChargeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _usageUnit initial attribute declared by type <code>UsageCharge</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PerUnitUsageChargeModel(final UsageUnitModel _usageUnit)
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
	public PerUnitUsageChargeModel(final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final UsageUnitModel _usageUnit)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setUsageUnit(_usageUnit);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PerUnitUsageCharge.usageChargeType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the usageChargeType - Usage Charge Type
	 */
	@Accessor(qualifier = "usageChargeType", type = Accessor.Type.GETTER)
	public UsageChargeType getUsageChargeType()
	{
		return getPersistenceContext().getPropertyValue(USAGECHARGETYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PerUnitUsageCharge.usageChargeType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the usageChargeType - Usage Charge Type
	 */
	@Accessor(qualifier = "usageChargeType", type = Accessor.Type.SETTER)
	public void setUsageChargeType(final UsageChargeType value)
	{
		getPersistenceContext().setPropertyValue(USAGECHARGETYPE, value);
	}
	
}
