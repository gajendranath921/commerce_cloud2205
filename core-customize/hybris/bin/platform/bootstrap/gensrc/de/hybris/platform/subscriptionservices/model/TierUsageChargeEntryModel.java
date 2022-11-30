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
import de.hybris.platform.subscriptionservices.model.UsageChargeEntryModel;

/**
 * Generated model class for type TierUsageChargeEntry first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class TierUsageChargeEntryModel extends UsageChargeEntryModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "TierUsageChargeEntry";
	
	/** <i>Generated constant</i> - Attribute key of <code>TierUsageChargeEntry.tierStart</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String TIERSTART = "tierStart";
	
	/** <i>Generated constant</i> - Attribute key of <code>TierUsageChargeEntry.tierEnd</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String TIEREND = "tierEnd";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public TierUsageChargeEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public TierUsageChargeEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _tierEnd initial attribute declared by type <code>TierUsageChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _tierStart initial attribute declared by type <code>TierUsageChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TierUsageChargeEntryModel(final Double _price, final Integer _tierEnd, final Integer _tierStart)
	{
		super();
		setPrice(_price);
		setTierEnd(_tierEnd);
		setTierStart(_tierStart);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _id initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _tierEnd initial attribute declared by type <code>TierUsageChargeEntry</code> at extension <code>subscriptionservices</code>
	 * @param _tierStart initial attribute declared by type <code>TierUsageChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TierUsageChargeEntryModel(final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final Double _price, final Integer _tierEnd, final Integer _tierStart)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setPrice(_price);
		setTierEnd(_tierEnd);
		setTierStart(_tierStart);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TierUsageChargeEntry.tierEnd</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the tierEnd - Tier End
	 */
	@Accessor(qualifier = "tierEnd", type = Accessor.Type.GETTER)
	public Integer getTierEnd()
	{
		return getPersistenceContext().getPropertyValue(TIEREND);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TierUsageChargeEntry.tierStart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the tierStart - Tier Start
	 */
	@Accessor(qualifier = "tierStart", type = Accessor.Type.GETTER)
	public Integer getTierStart()
	{
		return getPersistenceContext().getPropertyValue(TIERSTART);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TierUsageChargeEntry.tierEnd</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the tierEnd - Tier End
	 */
	@Accessor(qualifier = "tierEnd", type = Accessor.Type.SETTER)
	public void setTierEnd(final Integer value)
	{
		getPersistenceContext().setPropertyValue(TIEREND, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TierUsageChargeEntry.tierStart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the tierStart - Tier Start
	 */
	@Accessor(qualifier = "tierStart", type = Accessor.Type.SETTER)
	public void setTierStart(final Integer value)
	{
		getPersistenceContext().setPropertyValue(TIERSTART, value);
	}
	
}
