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
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.entitlementservices.model.ProductEntitlementModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type Entitlement first defined at extension entitlementservices.
 */
@SuppressWarnings("all")
public class EntitlementModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Entitlement";
	
	/**<i>Generated relation code constant for relation <code>ProductEntitlement2EntitlementRelation</code> defining source attribute <code>productEntitlements</code> in extension <code>entitlementservices</code>.</i>*/
	public static final String _PRODUCTENTITLEMENT2ENTITLEMENTRELATION = "ProductEntitlement2EntitlementRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>Entitlement.id</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>Entitlement.name</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>Entitlement.description</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>Entitlement.productEntitlements</code> attribute defined at extension <code>entitlementservices</code>. */
	public static final String PRODUCTENTITLEMENTS = "productEntitlements";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public EntitlementModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public EntitlementModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>Entitlement</code> at extension <code>entitlementservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public EntitlementModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>Entitlement</code> at extension <code>entitlementservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public EntitlementModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Entitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getDescription(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Entitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>Entitlement.id</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Entitlement.name</code> attribute defined at extension <code>entitlementservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Entitlement.name</code> attribute defined at extension <code>entitlementservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>Entitlement.productEntitlements</code> attribute defined at extension <code>entitlementservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the productEntitlements
	 */
	@Accessor(qualifier = "productEntitlements", type = Accessor.Type.GETTER)
	public Collection<ProductEntitlementModel> getProductEntitlements()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTENTITLEMENTS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Entitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the description - Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		setDescription(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Entitlement.description</code> attribute defined at extension <code>entitlementservices</code>. 
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
	 * <i>Generated method</i> - Initial setter of <code>Entitlement.id</code> attribute defined at extension <code>entitlementservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Entitlement.name</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Entitlement.name</code> attribute defined at extension <code>entitlementservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>Entitlement.productEntitlements</code> attribute defined at extension <code>entitlementservices</code>. 
	 *  
	 * @param value the productEntitlements
	 */
	@Accessor(qualifier = "productEntitlements", type = Accessor.Type.SETTER)
	public void setProductEntitlements(final Collection<ProductEntitlementModel> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTENTITLEMENTS, value);
	}
	
}
