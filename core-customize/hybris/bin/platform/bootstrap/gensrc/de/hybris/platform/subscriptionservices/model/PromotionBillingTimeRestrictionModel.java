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
import de.hybris.platform.promotions.model.AbstractPromotionRestrictionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.model.BillingTimeModel;
import java.util.Collection;

/**
 * Generated model class for type PromotionBillingTimeRestriction first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class PromotionBillingTimeRestrictionModel extends AbstractPromotionRestrictionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PromotionBillingTimeRestriction";
	
	/** <i>Generated constant</i> - Attribute key of <code>PromotionBillingTimeRestriction.positive</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String POSITIVE = "positive";
	
	/** <i>Generated constant</i> - Attribute key of <code>PromotionBillingTimeRestriction.billingTimes</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGTIMES = "billingTimes";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PromotionBillingTimeRestrictionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PromotionBillingTimeRestrictionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PromotionBillingTimeRestrictionModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PromotionBillingTimeRestriction.billingTimes</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the billingTimes - The billing frequencies/events the promotion is not applied for
	 */
	@Accessor(qualifier = "billingTimes", type = Accessor.Type.GETTER)
	public Collection<BillingTimeModel> getBillingTimes()
	{
		return getPersistenceContext().getPropertyValue(BILLINGTIMES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PromotionBillingTimeRestriction.positive</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the positive - Specifies if this restriction is a positive (true) or negative (false) one.
	 */
	@Accessor(qualifier = "positive", type = Accessor.Type.GETTER)
	public Boolean getPositive()
	{
		return getPersistenceContext().getPropertyValue(POSITIVE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PromotionBillingTimeRestriction.billingTimes</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingTimes - The billing frequencies/events the promotion is not applied for
	 */
	@Accessor(qualifier = "billingTimes", type = Accessor.Type.SETTER)
	public void setBillingTimes(final Collection<BillingTimeModel> value)
	{
		getPersistenceContext().setPropertyValue(BILLINGTIMES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PromotionBillingTimeRestriction.positive</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the positive - Specifies if this restriction is a positive (true) or negative (false) one.
	 */
	@Accessor(qualifier = "positive", type = Accessor.Type.SETTER)
	public void setPositive(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(POSITIVE, value);
	}
	
}
