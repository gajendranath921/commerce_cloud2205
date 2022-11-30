/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type AbstractIntegrationObjectItemAttribute first defined at extension integrationservices.
 * <p>
 * The parent class of other Integration Object Attributes.
 */
@SuppressWarnings("all")
public class AbstractIntegrationObjectItemAttributeModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AbstractIntegrationObjectItemAttribute";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractIntegrationObjectItemAttribute.attributeName</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ATTRIBUTENAME = "attributeName";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractIntegrationObjectItemAttribute.autoCreate</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String AUTOCREATE = "autoCreate";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractIntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String RETURNINTEGRATIONOBJECTITEM = "returnIntegrationObjectItem";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AbstractIntegrationObjectItemAttributeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AbstractIntegrationObjectItemAttributeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractIntegrationObjectItemAttributeModel(final String _attributeName)
	{
		super();
		setAttributeName(_attributeName);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractIntegrationObjectItemAttributeModel(final String _attributeName, final ItemModel _owner)
	{
		super();
		setAttributeName(_attributeName);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractIntegrationObjectItemAttribute.attributeName</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the attributeName
	 */
	@Accessor(qualifier = "attributeName", type = Accessor.Type.GETTER)
	public String getAttributeName()
	{
		return getPersistenceContext().getPropertyValue(ATTRIBUTENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractIntegrationObjectItemAttribute.autoCreate</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the autoCreate
	 */
	@Accessor(qualifier = "autoCreate", type = Accessor.Type.GETTER)
	public Boolean getAutoCreate()
	{
		return getPersistenceContext().getPropertyValue(AUTOCREATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractIntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the returnIntegrationObjectItem
	 */
	@Accessor(qualifier = "returnIntegrationObjectItem", type = Accessor.Type.GETTER)
	public IntegrationObjectItemModel getReturnIntegrationObjectItem()
	{
		return getPersistenceContext().getPropertyValue(RETURNINTEGRATIONOBJECTITEM);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractIntegrationObjectItemAttribute.attributeName</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the attributeName
	 */
	@Accessor(qualifier = "attributeName", type = Accessor.Type.SETTER)
	public void setAttributeName(final String value)
	{
		getPersistenceContext().setPropertyValue(ATTRIBUTENAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractIntegrationObjectItemAttribute.autoCreate</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the autoCreate
	 */
	@Accessor(qualifier = "autoCreate", type = Accessor.Type.SETTER)
	public void setAutoCreate(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(AUTOCREATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractIntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the returnIntegrationObjectItem
	 */
	@Accessor(qualifier = "returnIntegrationObjectItem", type = Accessor.Type.SETTER)
	public void setReturnIntegrationObjectItem(final IntegrationObjectItemModel value)
	{
		getPersistenceContext().setPropertyValue(RETURNINTEGRATIONOBJECTITEM, value);
	}
	
}
