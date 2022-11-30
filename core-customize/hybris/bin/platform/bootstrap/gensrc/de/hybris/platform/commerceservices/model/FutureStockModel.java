/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Date;

/**
 * Generated model class for type FutureStock first defined at extension commerceservices.
 */
@SuppressWarnings("all")
public class FutureStockModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "FutureStock";
	
	/** <i>Generated constant</i> - Attribute key of <code>FutureStock.productCode</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String PRODUCTCODE = "productCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>FutureStock.quantity</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String QUANTITY = "quantity";
	
	/** <i>Generated constant</i> - Attribute key of <code>FutureStock.date</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String DATE = "date";
	
	/** <i>Generated constant</i> - Attribute key of <code>FutureStock.products</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String PRODUCTS = "products";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public FutureStockModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public FutureStockModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _productCode initial attribute declared by type <code>FutureStock</code> at extension <code>commerceservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public FutureStockModel(final String _productCode)
	{
		super();
		setProductCode(_productCode);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _productCode initial attribute declared by type <code>FutureStock</code> at extension <code>commerceservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public FutureStockModel(final ItemModel _owner, final String _productCode)
	{
		super();
		setOwner(_owner);
		setProductCode(_productCode);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FutureStock.date</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the date - Data on which the product will be available
	 */
	@Accessor(qualifier = "date", type = Accessor.Type.GETTER)
	public Date getDate()
	{
		return getPersistenceContext().getPropertyValue(DATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FutureStock.productCode</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the productCode
	 */
	@Accessor(qualifier = "productCode", type = Accessor.Type.GETTER)
	public String getProductCode()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FutureStock.products</code> attribute defined at extension <code>commerceservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the products
	 */
	@Accessor(qualifier = "products", type = Accessor.Type.GETTER)
	public Collection<ProductModel> getProducts()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FutureStock.quantity</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the quantity - Amount that will be available
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.GETTER)
	public Integer getQuantity()
	{
		return getPersistenceContext().getPropertyValue(QUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>FutureStock.date</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the date - Data on which the product will be available
	 */
	@Accessor(qualifier = "date", type = Accessor.Type.SETTER)
	public void setDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(DATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>FutureStock.productCode</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the productCode
	 */
	@Accessor(qualifier = "productCode", type = Accessor.Type.SETTER)
	public void setProductCode(final String value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTCODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>FutureStock.products</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the products
	 */
	@Accessor(qualifier = "products", type = Accessor.Type.SETTER)
	public void setProducts(final Collection<ProductModel> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>FutureStock.quantity</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the quantity - Amount that will be available
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.SETTER)
	public void setQuantity(final Integer value)
	{
		getPersistenceContext().setPropertyValue(QUANTITY, value);
	}
	
}
