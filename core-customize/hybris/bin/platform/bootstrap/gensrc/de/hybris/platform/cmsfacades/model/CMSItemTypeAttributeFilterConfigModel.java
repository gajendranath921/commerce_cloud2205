/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type CMSItemTypeAttributeFilterConfig first defined at extension cmsfacades.
 */
@SuppressWarnings("all")
public class CMSItemTypeAttributeFilterConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CMSItemTypeAttributeFilterConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute defined at extension <code>cmsfacades</code>. */
	public static final String TYPECODE = "typeCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute defined at extension <code>cmsfacades</code>. */
	public static final String MODE = "mode";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute defined at extension <code>cmsfacades</code>. */
	public static final String ATTRIBUTES = "attributes";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CMSItemTypeAttributeFilterConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CMSItemTypeAttributeFilterConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributes initial attribute declared by type <code>CMSItemTypeAttributeFilterConfig</code> at extension <code>cmsfacades</code>
	 * @param _mode initial attribute declared by type <code>CMSItemTypeAttributeFilterConfig</code> at extension <code>cmsfacades</code>
	 * @param _typeCode initial attribute declared by type <code>CMSItemTypeAttributeFilterConfig</code> at extension <code>cmsfacades</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CMSItemTypeAttributeFilterConfigModel(final String _attributes, final String _mode, final String _typeCode)
	{
		super();
		setAttributes(_attributes);
		setMode(_mode);
		setTypeCode(_typeCode);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributes initial attribute declared by type <code>CMSItemTypeAttributeFilterConfig</code> at extension <code>cmsfacades</code>
	 * @param _mode initial attribute declared by type <code>CMSItemTypeAttributeFilterConfig</code> at extension <code>cmsfacades</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _typeCode initial attribute declared by type <code>CMSItemTypeAttributeFilterConfig</code> at extension <code>cmsfacades</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CMSItemTypeAttributeFilterConfigModel(final String _attributes, final String _mode, final ItemModel _owner, final String _typeCode)
	{
		super();
		setAttributes(_attributes);
		setMode(_mode);
		setOwner(_owner);
		setTypeCode(_typeCode);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute defined at extension <code>cmsfacades</code>. 
	 * @return the attributes
	 */
	@Accessor(qualifier = "attributes", type = Accessor.Type.GETTER)
	public String getAttributes()
	{
		return getPersistenceContext().getPropertyValue(ATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute defined at extension <code>cmsfacades</code>. 
	 * @return the mode
	 */
	@Accessor(qualifier = "mode", type = Accessor.Type.GETTER)
	public String getMode()
	{
		return getPersistenceContext().getPropertyValue(MODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute defined at extension <code>cmsfacades</code>. 
	 * @return the typeCode
	 */
	@Accessor(qualifier = "typeCode", type = Accessor.Type.GETTER)
	public String getTypeCode()
	{
		return getPersistenceContext().getPropertyValue(TYPECODE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute defined at extension <code>cmsfacades</code>. 
	 *  
	 * @param value the attributes
	 */
	@Accessor(qualifier = "attributes", type = Accessor.Type.SETTER)
	public void setAttributes(final String value)
	{
		getPersistenceContext().setPropertyValue(ATTRIBUTES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute defined at extension <code>cmsfacades</code>. 
	 *  
	 * @param value the mode
	 */
	@Accessor(qualifier = "mode", type = Accessor.Type.SETTER)
	public void setMode(final String value)
	{
		getPersistenceContext().setPropertyValue(MODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute defined at extension <code>cmsfacades</code>. 
	 *  
	 * @param value the typeCode
	 */
	@Accessor(qualifier = "typeCode", type = Accessor.Type.SETTER)
	public void setTypeCode(final String value)
	{
		getPersistenceContext().setPropertyValue(TYPECODE, value);
	}
	
}
