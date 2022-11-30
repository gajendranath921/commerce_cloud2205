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
import java.util.Locale;

/**
 * Generated model class for type BillingTime first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class BillingTimeModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "BillingTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingTime.code</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingTime.nameInCart</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAMEINCART = "nameInCart";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingTime.nameInOrder</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAMEINORDER = "nameInOrder";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingTime.description</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingTime.order</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ORDER = "order";
	
	/** <i>Generated constant</i> - Attribute key of <code>BillingTime.cartAware</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CARTAWARE = "cartAware";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public BillingTimeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public BillingTimeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>BillingTime</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BillingTimeModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>BillingTime</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BillingTimeModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.cartAware</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the cartAware - Cart Aware
	 */
	@Accessor(qualifier = "cartAware", type = Accessor.Type.GETTER)
	public Boolean getCartAware()
	{
		return getPersistenceContext().getPropertyValue(CARTAWARE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.code</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the code - Code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.description</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getDescription(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.description</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @param loc the value localization key 
	 * @return the description - Description
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(DESCRIPTION, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.nameInCart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the nameInCart - Name of frequency in cart
	 */
	@Accessor(qualifier = "nameInCart", type = Accessor.Type.GETTER)
	public String getNameInCart()
	{
		return getNameInCart(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.nameInCart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @param loc the value localization key 
	 * @return the nameInCart - Name of frequency in cart
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "nameInCart", type = Accessor.Type.GETTER)
	public String getNameInCart(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAMEINCART, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.nameInOrder</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the nameInOrder - Name of frequency in order
	 */
	@Accessor(qualifier = "nameInOrder", type = Accessor.Type.GETTER)
	public String getNameInOrder()
	{
		return getNameInOrder(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.nameInOrder</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @param loc the value localization key 
	 * @return the nameInOrder - Name of frequency in order
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "nameInOrder", type = Accessor.Type.GETTER)
	public String getNameInOrder(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAMEINORDER, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BillingTime.order</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the order - Sequence
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.GETTER)
	public Integer getOrder()
	{
		return getPersistenceContext().getPropertyValue(ORDER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.cartAware</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the cartAware - Cart Aware
	 */
	@Accessor(qualifier = "cartAware", type = Accessor.Type.SETTER)
	public void setCartAware(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(CARTAWARE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>BillingTime.code</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the code - Code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.description</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		setDescription(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.description</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the description - Description
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(DESCRIPTION, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.nameInCart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the nameInCart - Name of frequency in cart
	 */
	@Accessor(qualifier = "nameInCart", type = Accessor.Type.SETTER)
	public void setNameInCart(final String value)
	{
		setNameInCart(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.nameInCart</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the nameInCart - Name of frequency in cart
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "nameInCart", type = Accessor.Type.SETTER)
	public void setNameInCart(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAMEINCART, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.nameInOrder</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the nameInOrder - Name of frequency in order
	 */
	@Accessor(qualifier = "nameInOrder", type = Accessor.Type.SETTER)
	public void setNameInOrder(final String value)
	{
		setNameInOrder(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.nameInOrder</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the nameInOrder - Name of frequency in order
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "nameInOrder", type = Accessor.Type.SETTER)
	public void setNameInOrder(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAMEINORDER, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BillingTime.order</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the order - Sequence
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.SETTER)
	public void setOrder(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ORDER, value);
	}
	
}
