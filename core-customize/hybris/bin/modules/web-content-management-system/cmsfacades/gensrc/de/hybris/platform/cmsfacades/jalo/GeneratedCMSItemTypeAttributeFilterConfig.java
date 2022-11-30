/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.jalo;

import de.hybris.platform.cmsfacades.constants.CmsfacadesConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cmsfacades.jalo.CMSItemTypeAttributeFilterConfig CMSItemTypeAttributeFilterConfig}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedCMSItemTypeAttributeFilterConfig extends GenericItem
{
	/** Qualifier of the <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute **/
	public static final String TYPECODE = "typeCode";
	/** Qualifier of the <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute **/
	public static final String MODE = "mode";
	/** Qualifier of the <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute **/
	public static final String ATTRIBUTES = "attributes";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(TYPECODE, AttributeMode.INITIAL);
		tmp.put(MODE, AttributeMode.INITIAL);
		tmp.put(ATTRIBUTES, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute.
	 * @return the attributes
	 */
	public String getAttributes(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute.
	 * @return the attributes
	 */
	public String getAttributes()
	{
		return getAttributes( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute. 
	 * @param value the attributes
	 */
	public void setAttributes(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ATTRIBUTES,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSItemTypeAttributeFilterConfig.attributes</code> attribute. 
	 * @param value the attributes
	 */
	public void setAttributes(final String value)
	{
		setAttributes( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute.
	 * @return the mode
	 */
	public String getMode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, MODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute.
	 * @return the mode
	 */
	public String getMode()
	{
		return getMode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute. 
	 * @param value the mode
	 */
	public void setMode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, MODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSItemTypeAttributeFilterConfig.mode</code> attribute. 
	 * @param value the mode
	 */
	public void setMode(final String value)
	{
		setMode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute.
	 * @return the typeCode
	 */
	public String getTypeCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TYPECODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute.
	 * @return the typeCode
	 */
	public String getTypeCode()
	{
		return getTypeCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute. 
	 * @param value the typeCode
	 */
	public void setTypeCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TYPECODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSItemTypeAttributeFilterConfig.typeCode</code> attribute. 
	 * @param value the typeCode
	 */
	public void setTypeCode(final String value)
	{
		setTypeCode( getSession().getSessionContext(), value );
	}
	
}
