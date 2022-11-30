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
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.enums.TermOfServiceFrequency;
import de.hybris.platform.subscriptionservices.enums.TermOfServiceRenewal;
import de.hybris.platform.subscriptionservices.model.BillingPlanModel;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type SubscriptionTerm first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class SubscriptionTermModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SubscriptionTerm";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.id</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.name</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.termOfServiceNumber</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String TERMOFSERVICENUMBER = "termOfServiceNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.cancellable</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CANCELLABLE = "cancellable";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.termOfServiceRenewal</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String TERMOFSERVICERENEWAL = "termOfServiceRenewal";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.termOfServiceFrequency</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String TERMOFSERVICEFREQUENCY = "termOfServiceFrequency";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.billingPlan</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGPLAN = "billingPlan";
	
	/** <i>Generated constant</i> - Attribute key of <code>SubscriptionTerm.subscriptionProducts</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String SUBSCRIPTIONPRODUCTS = "subscriptionProducts";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SubscriptionTermModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SubscriptionTermModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SubscriptionTerm</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SubscriptionTermModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SubscriptionTerm</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SubscriptionTermModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.billingPlan</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingPlan - Billing Plan
	 */
	@Accessor(qualifier = "billingPlan", type = Accessor.Type.GETTER)
	public BillingPlanModel getBillingPlan()
	{
		return getPersistenceContext().getPropertyValue(BILLINGPLAN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.cancellable</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the cancellable - Cancellable
	 */
	@Accessor(qualifier = "cancellable", type = Accessor.Type.GETTER)
	public Boolean getCancellable()
	{
		return getPersistenceContext().getPropertyValue(CANCELLABLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.id</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.subscriptionProducts</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the subscriptionProducts
	 */
	@Accessor(qualifier = "subscriptionProducts", type = Accessor.Type.GETTER)
	public Collection<ProductModel> getSubscriptionProducts()
	{
		return getPersistenceContext().getPropertyValue(SUBSCRIPTIONPRODUCTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.termOfServiceFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the termOfServiceFrequency - Term of Service Frequency
	 */
	@Accessor(qualifier = "termOfServiceFrequency", type = Accessor.Type.GETTER)
	public TermOfServiceFrequency getTermOfServiceFrequency()
	{
		return getPersistenceContext().getPropertyValue(TERMOFSERVICEFREQUENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.termOfServiceNumber</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the termOfServiceNumber - Term of Service Number
	 */
	@Accessor(qualifier = "termOfServiceNumber", type = Accessor.Type.GETTER)
	public Integer getTermOfServiceNumber()
	{
		return getPersistenceContext().getPropertyValue(TERMOFSERVICENUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SubscriptionTerm.termOfServiceRenewal</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the termOfServiceRenewal - Term of Service Renewal
	 */
	@Accessor(qualifier = "termOfServiceRenewal", type = Accessor.Type.GETTER)
	public TermOfServiceRenewal getTermOfServiceRenewal()
	{
		return getPersistenceContext().getPropertyValue(TERMOFSERVICERENEWAL);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.billingPlan</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the billingPlan - Billing Plan
	 */
	@Accessor(qualifier = "billingPlan", type = Accessor.Type.SETTER)
	public void setBillingPlan(final BillingPlanModel value)
	{
		getPersistenceContext().setPropertyValue(BILLINGPLAN, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.cancellable</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the cancellable - Cancellable
	 */
	@Accessor(qualifier = "cancellable", type = Accessor.Type.SETTER)
	public void setCancellable(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(CANCELLABLE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SubscriptionTerm.id</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.name</code> attribute defined at extension <code>subscriptionservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.subscriptionProducts</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the subscriptionProducts
	 */
	@Accessor(qualifier = "subscriptionProducts", type = Accessor.Type.SETTER)
	public void setSubscriptionProducts(final Collection<ProductModel> value)
	{
		getPersistenceContext().setPropertyValue(SUBSCRIPTIONPRODUCTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.termOfServiceFrequency</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the termOfServiceFrequency - Term of Service Frequency
	 */
	@Accessor(qualifier = "termOfServiceFrequency", type = Accessor.Type.SETTER)
	public void setTermOfServiceFrequency(final TermOfServiceFrequency value)
	{
		getPersistenceContext().setPropertyValue(TERMOFSERVICEFREQUENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.termOfServiceNumber</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the termOfServiceNumber - Term of Service Number
	 */
	@Accessor(qualifier = "termOfServiceNumber", type = Accessor.Type.SETTER)
	public void setTermOfServiceNumber(final Integer value)
	{
		getPersistenceContext().setPropertyValue(TERMOFSERVICENUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SubscriptionTerm.termOfServiceRenewal</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the termOfServiceRenewal - Term of Service Renewal
	 */
	@Accessor(qualifier = "termOfServiceRenewal", type = Accessor.Type.SETTER)
	public void setTermOfServiceRenewal(final TermOfServiceRenewal value)
	{
		getPersistenceContext().setPropertyValue(TERMOFSERVICERENEWAL, value);
	}
	
}
