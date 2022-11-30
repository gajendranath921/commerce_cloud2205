/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.jalo;

import de.hybris.platform.b2b.constants.B2BCommerceConstants;
import de.hybris.platform.b2b.jalo.B2BRegistrationProcess;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.commerceservices.jalo.process.StoreFrontCustomerProcess B2BRegistrationRejectedProcess}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedB2BRegistrationRejectedProcess extends B2BRegistrationProcess
{
	/** Qualifier of the <code>B2BRegistrationRejectedProcess.rejectReason</code> attribute **/
	public static final String REJECTREASON = "rejectReason";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(B2BRegistrationProcess.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(REJECTREASON, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistrationRejectedProcess.rejectReason</code> attribute.
	 * @return the rejectReason - Indicates the reject reason.
	 */
	public String getRejectReason(final SessionContext ctx)
	{
		return (String)getProperty( ctx, REJECTREASON);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistrationRejectedProcess.rejectReason</code> attribute.
	 * @return the rejectReason - Indicates the reject reason.
	 */
	public String getRejectReason()
	{
		return getRejectReason( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>B2BRegistrationRejectedProcess.rejectReason</code> attribute. 
	 * @param value the rejectReason - Indicates the reject reason.
	 */
	public void setRejectReason(final SessionContext ctx, final String value)
	{
		setProperty(ctx, REJECTREASON,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>B2BRegistrationRejectedProcess.rejectReason</code> attribute. 
	 * @param value the rejectReason - Indicates the reject reason.
	 */
	public void setRejectReason(final String value)
	{
		setRejectReason( getSession().getSessionContext(), value );
	}
	
}
