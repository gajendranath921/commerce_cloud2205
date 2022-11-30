/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationyprofile.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.personalizationintegration.jalo.CxMapperScript;
import de.hybris.platform.personalizationservices.jalo.config.CxConfig;
import de.hybris.platform.personalizationyprofile.constants.PersonalizationyprofileConstants;
import de.hybris.platform.scripting.jalo.Script;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>PersonalizationyprofileManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedPersonalizationyprofileManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("requiredFields", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.personalizationintegration.jalo.CxMapperScript", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("orderMapperSegmentMap", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.personalizationservices.jalo.config.CxConfig", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	@Override
	public String getName()
	{
		return PersonalizationyprofileConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.orderMapperSegmentMap</code> attribute.
	 * @return the orderMapperSegmentMap - Map with configuration for OrderMapper
	 */
	public Map<String,BigDecimal> getAllOrderMapperSegmentMap(final SessionContext ctx, final CxConfig item)
	{
		Map<String,BigDecimal> map = (Map<String,BigDecimal>)item.getProperty( ctx, PersonalizationyprofileConstants.Attributes.CxConfig.ORDERMAPPERSEGMENTMAP);
		return map != null ? map : Collections.EMPTY_MAP;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.orderMapperSegmentMap</code> attribute.
	 * @return the orderMapperSegmentMap - Map with configuration for OrderMapper
	 */
	public Map<String,BigDecimal> getAllOrderMapperSegmentMap(final CxConfig item)
	{
		return getAllOrderMapperSegmentMap( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CxConfig.orderMapperSegmentMap</code> attribute. 
	 * @param value the orderMapperSegmentMap - Map with configuration for OrderMapper
	 */
	public void setAllOrderMapperSegmentMap(final SessionContext ctx, final CxConfig item, final Map<String,BigDecimal> value)
	{
		item.setProperty(ctx, PersonalizationyprofileConstants.Attributes.CxConfig.ORDERMAPPERSEGMENTMAP,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CxConfig.orderMapperSegmentMap</code> attribute. 
	 * @param value the orderMapperSegmentMap - Map with configuration for OrderMapper
	 */
	public void setAllOrderMapperSegmentMap(final CxConfig item, final Map<String,BigDecimal> value)
	{
		setAllOrderMapperSegmentMap( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxMapperScript.requiredFields</code> attribute.
	 * @return the requiredFields - Fields required for mapping data to segments
	 */
	public Collection<String> getRequiredFields(final SessionContext ctx, final CxMapperScript item)
	{
		Collection<String> coll = (Collection<String>)item.getProperty( ctx, PersonalizationyprofileConstants.Attributes.CxMapperScript.REQUIREDFIELDS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxMapperScript.requiredFields</code> attribute.
	 * @return the requiredFields - Fields required for mapping data to segments
	 */
	public Collection<String> getRequiredFields(final CxMapperScript item)
	{
		return getRequiredFields( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CxMapperScript.requiredFields</code> attribute. 
	 * @param value the requiredFields - Fields required for mapping data to segments
	 */
	public void setRequiredFields(final SessionContext ctx, final CxMapperScript item, final Collection<String> value)
	{
		item.setProperty(ctx, PersonalizationyprofileConstants.Attributes.CxMapperScript.REQUIREDFIELDS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CxMapperScript.requiredFields</code> attribute. 
	 * @param value the requiredFields - Fields required for mapping data to segments
	 */
	public void setRequiredFields(final CxMapperScript item, final Collection<String> value)
	{
		setRequiredFields( getSession().getSessionContext(), item, value );
	}
	
}
