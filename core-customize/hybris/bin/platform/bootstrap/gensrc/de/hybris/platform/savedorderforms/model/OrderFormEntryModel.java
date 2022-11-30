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
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OrderFormEntry first defined at extension savedorderforms.
 */
@SuppressWarnings("all")
public class OrderFormEntryModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OrderFormEntry";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderFormEntry.sku</code> attribute defined at extension <code>savedorderforms</code>. */
	public static final String SKU = "sku";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderFormEntry.quantity</code> attribute defined at extension <code>savedorderforms</code>. */
	public static final String QUANTITY = "quantity";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OrderFormEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OrderFormEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _sku initial attribute declared by type <code>OrderFormEntry</code> at extension <code>savedorderforms</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderFormEntryModel(final String _sku)
	{
		super();
		setSku(_sku);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _sku initial attribute declared by type <code>OrderFormEntry</code> at extension <code>savedorderforms</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderFormEntryModel(final ItemModel _owner, final String _sku)
	{
		super();
		setOwner(_owner);
		setSku(_sku);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderFormEntry.quantity</code> attribute defined at extension <code>savedorderforms</code>. 
	 * @return the quantity
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.GETTER)
	public Integer getQuantity()
	{
		return getPersistenceContext().getPropertyValue(QUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderFormEntry.sku</code> attribute defined at extension <code>savedorderforms</code>. 
	 * @return the sku
	 */
	@Accessor(qualifier = "sku", type = Accessor.Type.GETTER)
	public String getSku()
	{
		return getPersistenceContext().getPropertyValue(SKU);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderFormEntry.quantity</code> attribute defined at extension <code>savedorderforms</code>. 
	 *  
	 * @param value the quantity
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.SETTER)
	public void setQuantity(final Integer value)
	{
		getPersistenceContext().setPropertyValue(QUANTITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderFormEntry.sku</code> attribute defined at extension <code>savedorderforms</code>. 
	 *  
	 * @param value the sku
	 */
	@Accessor(qualifier = "sku", type = Accessor.Type.SETTER)
	public void setSku(final String value)
	{
		getPersistenceContext().setPropertyValue(SKU, value);
	}
	
}
