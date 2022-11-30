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
import de.hybris.platform.core.model.type.TypeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type IntegrationObjectVirtualAttributeDescriptor first defined at extension integrationservices.
 * <p>
 * An Integration Object Item Attribute that exists virtually and handles persistence/retrieval logic by executing the specified logic in the logicLocation.
 */
@SuppressWarnings("all")
public class IntegrationObjectVirtualAttributeDescriptorModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObjectVirtualAttributeDescriptor";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectVirtualAttributeDescriptor.code</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectVirtualAttributeDescriptor.logicLocation</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String LOGICLOCATION = "logicLocation";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectVirtualAttributeDescriptor.type</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String TYPE = "type";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectVirtualAttributeDescriptorModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectVirtualAttributeDescriptorModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObjectVirtualAttributeDescriptor</code> at extension <code>integrationservices</code>
	 * @param _logicLocation initial attribute declared by type <code>IntegrationObjectVirtualAttributeDescriptor</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectVirtualAttributeDescriptorModel(final String _code, final String _logicLocation)
	{
		super();
		setCode(_code);
		setLogicLocation(_logicLocation);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObjectVirtualAttributeDescriptor</code> at extension <code>integrationservices</code>
	 * @param _logicLocation initial attribute declared by type <code>IntegrationObjectVirtualAttributeDescriptor</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectVirtualAttributeDescriptorModel(final String _code, final String _logicLocation, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setLogicLocation(_logicLocation);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectVirtualAttributeDescriptor.code</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectVirtualAttributeDescriptor.logicLocation</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the logicLocation - Specifies where the logic is located. Acceptable values are of this format:
	 *                         model://scriptModelCode
	 */
	@Accessor(qualifier = "logicLocation", type = Accessor.Type.GETTER)
	public String getLogicLocation()
	{
		return getPersistenceContext().getPropertyValue(LOGICLOCATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectVirtualAttributeDescriptor.type</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the type - The logic's return or input type. The return type will be used as the type in the schema for the attribute.
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public TypeModel getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>IntegrationObjectVirtualAttributeDescriptor.code</code> attribute defined at extension <code>integrationservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectVirtualAttributeDescriptor.logicLocation</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the logicLocation - Specifies where the logic is located. Acceptable values are of this format:
	 *                         model://scriptModelCode
	 */
	@Accessor(qualifier = "logicLocation", type = Accessor.Type.SETTER)
	public void setLogicLocation(final String value)
	{
		getPersistenceContext().setPropertyValue(LOGICLOCATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectVirtualAttributeDescriptor.type</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the type - The logic's return or input type. The return type will be used as the type in the schema for the attribute.
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final TypeModel value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
}
