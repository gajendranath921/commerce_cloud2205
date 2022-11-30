/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.jalo;

import de.hybris.platform.integrationservices.constants.IntegrationservicesConstants;
import de.hybris.platform.integrationservices.jalo.IntegrationObject;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem InboundChannelConfiguration}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedInboundChannelConfiguration extends GenericItem
{
	/** Qualifier of the <code>InboundChannelConfiguration.integrationObject</code> attribute **/
	public static final String INTEGRATIONOBJECT = "integrationObject";
	/** Qualifier of the <code>InboundChannelConfiguration.authenticationType</code> attribute **/
	public static final String AUTHENTICATIONTYPE = "authenticationType";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(INTEGRATIONOBJECT, AttributeMode.INITIAL);
		tmp.put(AUTHENTICATIONTYPE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundChannelConfiguration.authenticationType</code> attribute.
	 * @return the authenticationType - Type of authentication for an integration object in an Inbound request, which can be of
	 *                         a type defined in the AuthenticationType Enum
	 */
	public EnumerationValue getAuthenticationType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, AUTHENTICATIONTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundChannelConfiguration.authenticationType</code> attribute.
	 * @return the authenticationType - Type of authentication for an integration object in an Inbound request, which can be of
	 *                         a type defined in the AuthenticationType Enum
	 */
	public EnumerationValue getAuthenticationType()
	{
		return getAuthenticationType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>InboundChannelConfiguration.authenticationType</code> attribute. 
	 * @param value the authenticationType - Type of authentication for an integration object in an Inbound request, which can be of
	 *                         a type defined in the AuthenticationType Enum
	 */
	public void setAuthenticationType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, AUTHENTICATIONTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>InboundChannelConfiguration.authenticationType</code> attribute. 
	 * @param value the authenticationType - Type of authentication for an integration object in an Inbound request, which can be of
	 *                         a type defined in the AuthenticationType Enum
	 */
	public void setAuthenticationType(final EnumerationValue value)
	{
		setAuthenticationType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundChannelConfiguration.integrationObject</code> attribute.
	 * @return the integrationObject - Integration Object configured with authentication for an Inbound Request
	 */
	public IntegrationObject getIntegrationObject(final SessionContext ctx)
	{
		return (IntegrationObject)getProperty( ctx, INTEGRATIONOBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundChannelConfiguration.integrationObject</code> attribute.
	 * @return the integrationObject - Integration Object configured with authentication for an Inbound Request
	 */
	public IntegrationObject getIntegrationObject()
	{
		return getIntegrationObject( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>InboundChannelConfiguration.integrationObject</code> attribute. 
	 * @param value the integrationObject - Integration Object configured with authentication for an Inbound Request
	 */
	public void setIntegrationObject(final SessionContext ctx, final IntegrationObject value)
	{
		setProperty(ctx, INTEGRATIONOBJECT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>InboundChannelConfiguration.integrationObject</code> attribute. 
	 * @param value the integrationObject - Integration Object configured with authentication for an Inbound Request
	 */
	public void setIntegrationObject(final IntegrationObject value)
	{
		setIntegrationObject( getSession().getSessionContext(), value );
	}
	
}
