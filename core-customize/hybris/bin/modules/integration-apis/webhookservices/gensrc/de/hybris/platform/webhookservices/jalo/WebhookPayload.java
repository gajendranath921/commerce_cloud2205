/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webhookservices.jalo;

import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type WebhookPayload.
 */
@SLDSafe
@SuppressWarnings({"unused","cast"})
public class WebhookPayload extends GenericItem
{
	/** Qualifier of the <code>WebhookPayload.data</code> attribute **/
	public static final String DATA = "data";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(DATA, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>WebhookPayload.data</code> attribute.
	 * @return the data - Payload to be sent to a webhook
	 */
	public Map<String,Object> getAllData(final SessionContext ctx)
	{
		Map<String,Object> map = (Map<String,Object>)getProperty( ctx, "data".intern());
		return map != null ? map : Collections.EMPTY_MAP;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>WebhookPayload.data</code> attribute.
	 * @return the data - Payload to be sent to a webhook
	 */
	public Map<String,Object> getAllData()
	{
		return getAllData( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>WebhookPayload.data</code> attribute. 
	 * @param value the data - Payload to be sent to a webhook
	 */
	public void setAllData(final SessionContext ctx, final Map<String,Object> value)
	{
		setProperty(ctx, "data".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>WebhookPayload.data</code> attribute. 
	 * @param value the data - Payload to be sent to a webhook
	 */
	public void setAllData(final Map<String,Object> value)
	{
		setAllData( getSession().getSessionContext(), value );
	}
	
}
