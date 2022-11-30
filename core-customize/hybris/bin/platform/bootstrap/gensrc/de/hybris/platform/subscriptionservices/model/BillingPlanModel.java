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
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.enums.BillingCycleType;
import de.hybris.platform.subscriptionservices.model.BillingFrequencyModel;
import java.util.Locale;

/**
 * Generated model class for type BillingPlan first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class BillingPlanModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "BillingPlan";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingPlan.id</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingPlan.name</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingPlan.billingCycleDay</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGCYCLEDAY = "billingCycleDay";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingPlan.billingCycleType</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGCYCLETYPE = "billingCycleType";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingPlan.billingFrequency</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGFREQUENCY = "billingFrequency";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public BillingPlanModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public BillingPlanModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>BillingPlan</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BillingPlanModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>BillingPlan</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BillingPlanModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingPlan.billingCycleDay</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingCycleDay - Billing Cycle Day
	 */
	@Accessor(qualifier = "billingCycleDay", type = Accessor.Type.GETTER)
	public Integer getBillingCycleDay()
	{
		return getPersistenceContext().getPropertyValue(BILLINGCYCLEDAY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingPlan.billingCycleType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingCycleType - Billing Cycle Type
	 */
	@Accessor(qualifier = "billingCycleType", type = Accessor.Type.GETTER)
	public BillingCycleType getBillingCycleType()
	{
		return getPersistenceContext().getPropertyValue(BILLINGCYCLETYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingPlan.billingFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingFrequency - Billing Frequency
	 */
	@Accessor(qualifier = "billingFrequency", type = Accessor.Type.GETTER)
	public BillingFrequencyModel getBillingFrequency()
	{
		return getPersistenceContext().getPropertyValue(BILLINGFREQUENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingPlan.id</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingPlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingPlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>BillingPlan.billingCycleDay</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingCycleDay - Billing Cycle Day
	 */
	@Accessor(qualifier = "billingCycleDay", type = Accessor.Type.SETTER)
	public void setBillingCycleDay(final Integer value)
	{
		getPersistenceContext().setPropertyValue(BILLINGCYCLEDAY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingPlan.billingCycleType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingCycleType - Billing Cycle Type
	 */
	@Accessor(qualifier = "billingCycleType", type = Accessor.Type.SETTER)
	public void setBillingCycleType(final BillingCycleType value)
	{
		getPersistenceContext().setPropertyValue(BILLINGCYCLETYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingPlan.billingFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingFrequency - Billing Frequency
	 */
	@Accessor(qualifier = "billingFrequency", type = Accessor.Type.SETTER)
	public void setBillingFrequency(final BillingFrequencyModel value)
	{
		getPersistenceContext().setPropertyValue(BILLINGFREQUENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>BillingPlan.id</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingPlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>BillingPlan.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	
}
