/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.entitlementservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.entitlementservices.enums.EntitlementTimeUnit;
import de.hybris.platform.entitlementservices.model.EntitlementModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type ProductEntitlement first defined at extension entitlementservices.
 */
@SuppressWarnings("all")
public class ProductEntitlementModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProductEntitlement";
	
	/**<i>Generated relation code constant for relation <code>Product2ProductEntitlementsRelation</code> defining source attribute <code>subscriptionProduct</code> in extension <code>entitlementservices</code>.</i>*/
	public static final String _PRODUCT2PRODUCTENTITLEMENTSRELATION = "Product2ProductEntitlementsRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.id</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.description</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.catalogVersion</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String CATALOGVERSION = "catalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.timeUnit</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String TIMEUNIT = "timeUnit";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.timeUnitStart</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String TIMEUNITSTART = "timeUnitStart";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.timeUnitDuration</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String TIMEUNITDURATION = "timeUnitDuration";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.conditionString</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String CONDITIONSTRING = "conditionString";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.conditionPath</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String CONDITIONPATH = "conditionPath";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.conditionGeo</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String CONDITIONGEO = "conditionGeo";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.quantity</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String QUANTITY = "quantity";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.subscriptionProduct</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String SUBSCRIPTIONPRODUCT = "subscriptionProduct";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductEntitlement.entitlement</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String ENTITLEMENT = "entitlement";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProductEntitlementModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProductEntitlementModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _entitlement initial attribute declared by type <code>ProductEntitlement</code> at extension <code>entitlementservices</code>
	 * @param _subscriptionProduct initial attribute declared by type <code>ProductEntitlement</code> at extension <code>entitlementservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProductEntitlementModel(final EntitlementModel _entitlement, final ProductModel _subscriptionProduct)
	{
		super();
		setEntitlement(_entitlement);
		setSubscriptionProduct(_subscriptionProduct);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>ProductEntitlement</code> at extension <code>entitlementservices</code>
	 * @param _entitlement initial attribute declared by type <code>ProductEntitlement</code> at extension <code>entitlementservices</code>
	 * @param _id initial attribute declared by type <code>ProductEntitlement</code> at extension <code>entitlementservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _subscriptionProduct initial attribute declared by type <code>ProductEntitlement</code> at extension <code>entitlementservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProductEntitlementModel(final CatalogVersionModel _catalogVersion, final EntitlementModel _entitlement, final String _id, final ItemModel _owner, final ProductModel _subscriptionProduct)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setEntitlement(_entitlement);
		setId(_id);
		setOwner(_owner);
		setSubscriptionProduct(_subscriptionProduct);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.catalogVersion</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.conditionGeo</code> attribute defined at extension <code>entitlementservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the conditionGeo - Geo Condition
	 */
	@Accessor(qualifier = "conditionGeo", type = Accessor.Type.GETTER)
	public Collection<String> getConditionGeo()
	{
		return getPersistenceContext().getPropertyValue(CONDITIONGEO);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.conditionPath</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the conditionPath - Path Condition
	 */
	@Accessor(qualifier = "conditionPath", type = Accessor.Type.GETTER)
	public String getConditionPath()
	{
		return getPersistenceContext().getPropertyValue(CONDITIONPATH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.conditionString</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the conditionString - String Condition
	 */
	@Accessor(qualifier = "conditionString", type = Accessor.Type.GETTER)
	public String getConditionString()
	{
		return getPersistenceContext().getPropertyValue(CONDITIONSTRING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getDescription(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.entitlement</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the entitlement
	 */
	@Accessor(qualifier = "entitlement", type = Accessor.Type.GETTER)
	public EntitlementModel getEntitlement()
	{
		return getPersistenceContext().getPropertyValue(ENTITLEMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.id</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.quantity</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the quantity - Quantity
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.GETTER)
	public Integer getQuantity()
	{
		return getPersistenceContext().getPropertyValue(QUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.subscriptionProduct</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the subscriptionProduct
	 */
	@Accessor(qualifier = "subscriptionProduct", type = Accessor.Type.GETTER)
	public ProductModel getSubscriptionProduct()
	{
		return getPersistenceContext().getPropertyValue(SUBSCRIPTIONPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.timeUnit</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the timeUnit - Time Unit
	 */
	@Accessor(qualifier = "timeUnit", type = Accessor.Type.GETTER)
	public EntitlementTimeUnit getTimeUnit()
	{
		return getPersistenceContext().getPropertyValue(TIMEUNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.timeUnitDuration</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the timeUnitDuration - Duration
	 */
	@Accessor(qualifier = "timeUnitDuration", type = Accessor.Type.GETTER)
	public Integer getTimeUnitDuration()
	{
		return getPersistenceContext().getPropertyValue(TIMEUNITDURATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductEntitlement.timeUnitStart</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the timeUnitStart - Start
	 */
	@Accessor(qualifier = "timeUnitStart", type = Accessor.Type.GETTER)
	public Integer getTimeUnitStart()
	{
		return getPersistenceContext().getPropertyValue(TIMEUNITSTART);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>ProductEntitlement.catalogVersion</code> attribute defined at extension <code>entitlementservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.SETTER)
	public void setCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.conditionGeo</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the conditionGeo - Geo Condition
	 */
	@Accessor(qualifier = "conditionGeo", type = Accessor.Type.SETTER)
	public void setConditionGeo(final Collection<String> value)
	{
		getPersistenceContext().setPropertyValue(CONDITIONGEO, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.conditionPath</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the conditionPath - Path Condition
	 */
	@Accessor(qualifier = "conditionPath", type = Accessor.Type.SETTER)
	public void setConditionPath(final String value)
	{
		getPersistenceContext().setPropertyValue(CONDITIONPATH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.conditionString</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the conditionString - String Condition
	 */
	@Accessor(qualifier = "conditionString", type = Accessor.Type.SETTER)
	public void setConditionString(final String value)
	{
		getPersistenceContext().setPropertyValue(CONDITIONSTRING, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		setDescription(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.entitlement</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the entitlement
	 */
	@Accessor(qualifier = "entitlement", type = Accessor.Type.SETTER)
	public void setEntitlement(final EntitlementModel value)
	{
		getPersistenceContext().setPropertyValue(ENTITLEMENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>ProductEntitlement.id</code> attribute defined at extension <code>entitlementservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.quantity</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the quantity - Quantity
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.SETTER)
	public void setQuantity(final Integer value)
	{
		getPersistenceContext().setPropertyValue(QUANTITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.subscriptionProduct</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the subscriptionProduct
	 */
	@Accessor(qualifier = "subscriptionProduct", type = Accessor.Type.SETTER)
	public void setSubscriptionProduct(final ProductModel value)
	{
		getPersistenceContext().setPropertyValue(SUBSCRIPTIONPRODUCT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.timeUnit</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the timeUnit - Time Unit
	 */
	@Accessor(qualifier = "timeUnit", type = Accessor.Type.SETTER)
	public void setTimeUnit(final EntitlementTimeUnit value)
	{
		getPersistenceContext().setPropertyValue(TIMEUNIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.timeUnitDuration</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the timeUnitDuration - Duration
	 */
	@Accessor(qualifier = "timeUnitDuration", type = Accessor.Type.SETTER)
	public void setTimeUnitDuration(final Integer value)
	{
		getPersistenceContext().setPropertyValue(TIMEUNITDURATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductEntitlement.timeUnitStart</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the timeUnitStart - Start
	 */
	@Accessor(qualifier = "timeUnitStart", type = Accessor.Type.SETTER)
	public void setTimeUnitStart(final Integer value)
	{
		getPersistenceContext().setPropertyValue(TIMEUNITSTART, value);
	}
	
}
