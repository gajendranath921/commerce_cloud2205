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
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.subscriptionservices.model.BillingTimeModel;

/**
 * Generated model class for type ChargeEntry first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class ChargeEntryModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ChargeEntry";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChargeEntry.id</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChargeEntry.catalogVersion</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CATALOGVERSION = "catalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChargeEntry.price</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String PRICE = "price";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChargeEntry.currency</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChargeEntry.billingTime</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String BILLINGTIME = "billingTime";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ChargeEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ChargeEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _price initial attribute declared by type <code>ChargeEntry</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ChargeEntryModel(final Double _price)
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
	public ChargeEntryModel(final CatalogVersionModel _catalogVersion, final String _id, final ItemModel _owner, final Double _price)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setId(_id);
		setOwner(_owner);
		setPrice(_price);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChargeEntry.billingTime</code> dynamic attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the billingTime - Billing Time
	 */
	@Accessor(qualifier = "billingTime", type = Accessor.Type.GETTER)
	public BillingTimeModel getBillingTime()
	{
		return getPersistenceContext().getDynamicValue(this,BILLINGTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChargeEntry.catalogVersion</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChargeEntry.currency</code> dynamic attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the currency - Currency from parent
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getDynamicValue(this,CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChargeEntry.id</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChargeEntry.price</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the price - Price
	 */
	@Accessor(qualifier = "price", type = Accessor.Type.GETTER)
	public Double getPrice()
	{
		return getPersistenceContext().getPropertyValue(PRICE);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>ChargeEntry.catalogVersion</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.SETTER)
	public void setCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>ChargeEntry.id</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ChargeEntry.price</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the price - Price
	 */
	@Accessor(qualifier = "price", type = Accessor.Type.SETTER)
	public void setPrice(final Double value)
	{
		getPersistenceContext().setPropertyValue(PRICE, value);
	}
	
}
