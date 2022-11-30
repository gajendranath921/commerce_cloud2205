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
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;

/**
 * Generated model class for type PriceRowsValidConstraint first defined at extension subscriptionservices.
 * <p>
 * Custom constraint which checks if the priceRowsValid attribute is true.
 */
@SuppressWarnings("all")
public class PriceRowsValidConstraintModel extends AttributeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PriceRowsValidConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>PriceRowsValidConstraint.priceRowType</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String PRICEROWTYPE = "priceRowType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PriceRowsValidConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PriceRowsValidConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>PriceRowsValidConstraint</code> at extension <code>subscriptionservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _priceRowType initial attribute declared by type <code>PriceRowsValidConstraint</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PriceRowsValidConstraintModel(final Class _annotation, final String _id, final String _priceRowType)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setPriceRowType(_priceRowType);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>PriceRowsValidConstraint</code> at extension <code>subscriptionservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _priceRowType initial attribute declared by type <code>PriceRowsValidConstraint</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PriceRowsValidConstraintModel(final Class _annotation, final String _id, final ItemModel _owner, final String _priceRowType)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setOwner(_owner);
		setPriceRowType(_priceRowType);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PriceRowsValidConstraint.priceRowType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the priceRowType - The price row type
	 */
	@Accessor(qualifier = "priceRowType", type = Accessor.Type.GETTER)
	public String getPriceRowType()
	{
		return getPersistenceContext().getPropertyValue(PRICEROWTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PriceRowsValidConstraint.priceRowType</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the priceRowType - The price row type
	 */
	@Accessor(qualifier = "priceRowType", type = Accessor.Type.SETTER)
	public void setPriceRowType(final String value)
	{
		getPersistenceContext().setPropertyValue(PRICEROWTYPE, value);
	}
	
}
