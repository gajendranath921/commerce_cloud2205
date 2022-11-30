/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.savedorderforms.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.savedorderforms.model.OrderFormEntryModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type OrderForm first defined at extension savedorderforms.
 */
@SuppressWarnings("all")
public class OrderFormModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OrderForm";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderForm.code</code> attribute defined at extension <code>savedorderforms</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderForm.description</code> attribute defined at extension <code>savedorderforms</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderForm.user</code> attribute defined at extension <code>savedorderforms</code>. */
	public static final String USER = "user";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderForm.entries</code> attribute defined at extension <code>savedorderforms</code>. */
	public static final String ENTRIES = "entries";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderForm.currency</code> attribute defined at extension <code>savedorderforms</code>. */
	public static final String CURRENCY = "currency";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OrderFormModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OrderFormModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 * @param _currency initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 * @param _entries initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 * @param _user initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderFormModel(final String _code, final CurrencyModel _currency, final List<OrderFormEntryModel> _entries, final UserModel _user)
	{
		super();
		setCode(_code);
		setCurrency(_currency);
		setEntries(_entries);
		setUser(_user);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 * @param _currency initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 * @param _entries initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>OrderForm</code> at extension <code>savedorderforms</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderFormModel(final String _code, final CurrencyModel _currency, final List<OrderFormEntryModel> _entries, final ItemModel _owner, final UserModel _user)
	{
		super();
		setCode(_code);
		setCurrency(_currency);
		setEntries(_entries);
		setOwner(_owner);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderForm.code</code> attribute defined at extension <code>savedorderforms</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderForm.currency</code> attribute defined at extension <code>savedorderforms</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderForm.description</code> attribute defined at extension <code>savedorderforms</code>. 
	 * @return the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getPersistenceContext().getPropertyValue(DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderForm.entries</code> attribute defined at extension <code>savedorderforms</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the entries
	 */
	@Accessor(qualifier = "entries", type = Accessor.Type.GETTER)
	public List<OrderFormEntryModel> getEntries()
	{
		return getPersistenceContext().getPropertyValue(ENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderForm.user</code> attribute defined at extension <code>savedorderforms</code>. 
	 * @return the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.GETTER)
	public UserModel getUser()
	{
		return getPersistenceContext().getPropertyValue(USER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderForm.code</code> attribute defined at extension <code>savedorderforms</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderForm.currency</code> attribute defined at extension <code>savedorderforms</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderForm.description</code> attribute defined at extension <code>savedorderforms</code>. 
	 *  
	 * @param value the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(DESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderForm.entries</code> attribute defined at extension <code>savedorderforms</code>. 
	 *  
	 * @param value the entries
	 */
	@Accessor(qualifier = "entries", type = Accessor.Type.SETTER)
	public void setEntries(final List<OrderFormEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(ENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderForm.user</code> attribute defined at extension <code>savedorderforms</code>. 
	 *  
	 * @param value the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.SETTER)
	public void setUser(final UserModel value)
	{
		getPersistenceContext().setPropertyValue(USER, value);
	}
	
}
