/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.merchandising.jalo;

import com.hybris.merchandising.constants.MerchandisingservicesConstants;
import com.hybris.merchandising.jalo.MerchProductDirectoryConfig;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.hybris.merchandising.jalo.MerchSynchronization MerchSynchronization}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedMerchSynchronization extends GenericItem
{
	/** Qualifier of the <code>MerchSynchronization.operationId</code> attribute **/
	public static final String OPERATIONID = "operationId";
	/** Qualifier of the <code>MerchSynchronization.config</code> attribute **/
	public static final String CONFIG = "config";
	/** Qualifier of the <code>MerchSynchronization.type</code> attribute **/
	public static final String TYPE = "type";
	/** Qualifier of the <code>MerchSynchronization.status</code> attribute **/
	public static final String STATUS = "status";
	/** Qualifier of the <code>MerchSynchronization.startTime</code> attribute **/
	public static final String STARTTIME = "startTime";
	/** Qualifier of the <code>MerchSynchronization.endTime</code> attribute **/
	public static final String ENDTIME = "endTime";
	/** Qualifier of the <code>MerchSynchronization.numberOfProducts</code> attribute **/
	public static final String NUMBEROFPRODUCTS = "numberOfProducts";
	/** Qualifier of the <code>MerchSynchronization.details</code> attribute **/
	public static final String DETAILS = "details";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(OPERATIONID, AttributeMode.INITIAL);
		tmp.put(CONFIG, AttributeMode.INITIAL);
		tmp.put(TYPE, AttributeMode.INITIAL);
		tmp.put(STATUS, AttributeMode.INITIAL);
		tmp.put(STARTTIME, AttributeMode.INITIAL);
		tmp.put(ENDTIME, AttributeMode.INITIAL);
		tmp.put(NUMBEROFPRODUCTS, AttributeMode.INITIAL);
		tmp.put(DETAILS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.config</code> attribute.
	 * @return the config
	 */
	public MerchProductDirectoryConfig getConfig(final SessionContext ctx)
	{
		return (MerchProductDirectoryConfig)getProperty( ctx, CONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.config</code> attribute.
	 * @return the config
	 */
	public MerchProductDirectoryConfig getConfig()
	{
		return getConfig( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.config</code> attribute. 
	 * @param value the config
	 */
	public void setConfig(final SessionContext ctx, final MerchProductDirectoryConfig value)
	{
		setProperty(ctx, CONFIG,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.config</code> attribute. 
	 * @param value the config
	 */
	public void setConfig(final MerchProductDirectoryConfig value)
	{
		setConfig( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.details</code> attribute.
	 * @return the details
	 */
	public String getDetails(final SessionContext ctx)
	{
		return (String)getProperty( ctx, DETAILS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.details</code> attribute.
	 * @return the details
	 */
	public String getDetails()
	{
		return getDetails( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.details</code> attribute. 
	 * @param value the details
	 */
	public void setDetails(final SessionContext ctx, final String value)
	{
		setProperty(ctx, DETAILS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.details</code> attribute. 
	 * @param value the details
	 */
	public void setDetails(final String value)
	{
		setDetails( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.endTime</code> attribute.
	 * @return the endTime
	 */
	public Date getEndTime(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, ENDTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.endTime</code> attribute.
	 * @return the endTime
	 */
	public Date getEndTime()
	{
		return getEndTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.endTime</code> attribute. 
	 * @param value the endTime
	 */
	public void setEndTime(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, ENDTIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.endTime</code> attribute. 
	 * @param value the endTime
	 */
	public void setEndTime(final Date value)
	{
		setEndTime( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.numberOfProducts</code> attribute.
	 * @return the numberOfProducts
	 */
	public Long getNumberOfProducts(final SessionContext ctx)
	{
		return (Long)getProperty( ctx, NUMBEROFPRODUCTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.numberOfProducts</code> attribute.
	 * @return the numberOfProducts
	 */
	public Long getNumberOfProducts()
	{
		return getNumberOfProducts( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.numberOfProducts</code> attribute. 
	 * @return the numberOfProducts
	 */
	public long getNumberOfProductsAsPrimitive(final SessionContext ctx)
	{
		Long value = getNumberOfProducts( ctx );
		return value != null ? value.longValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.numberOfProducts</code> attribute. 
	 * @return the numberOfProducts
	 */
	public long getNumberOfProductsAsPrimitive()
	{
		return getNumberOfProductsAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.numberOfProducts</code> attribute. 
	 * @param value the numberOfProducts
	 */
	public void setNumberOfProducts(final SessionContext ctx, final Long value)
	{
		setProperty(ctx, NUMBEROFPRODUCTS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.numberOfProducts</code> attribute. 
	 * @param value the numberOfProducts
	 */
	public void setNumberOfProducts(final Long value)
	{
		setNumberOfProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.numberOfProducts</code> attribute. 
	 * @param value the numberOfProducts
	 */
	public void setNumberOfProducts(final SessionContext ctx, final long value)
	{
		setNumberOfProducts( ctx,Long.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.numberOfProducts</code> attribute. 
	 * @param value the numberOfProducts
	 */
	public void setNumberOfProducts(final long value)
	{
		setNumberOfProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.operationId</code> attribute.
	 * @return the operationId - Operation id
	 */
	public String getOperationId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, OPERATIONID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.operationId</code> attribute.
	 * @return the operationId - Operation id
	 */
	public String getOperationId()
	{
		return getOperationId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.operationId</code> attribute. 
	 * @param value the operationId - Operation id
	 */
	protected void setOperationId(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+OPERATIONID+"' is not changeable", 0 );
		}
		setProperty(ctx, OPERATIONID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.operationId</code> attribute. 
	 * @param value the operationId - Operation id
	 */
	protected void setOperationId(final String value)
	{
		setOperationId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.startTime</code> attribute.
	 * @return the startTime
	 */
	public Date getStartTime(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STARTTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.startTime</code> attribute.
	 * @return the startTime
	 */
	public Date getStartTime()
	{
		return getStartTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.startTime</code> attribute. 
	 * @param value the startTime
	 */
	public void setStartTime(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STARTTIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.startTime</code> attribute. 
	 * @param value the startTime
	 */
	public void setStartTime(final Date value)
	{
		setStartTime( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.status</code> attribute.
	 * @return the status
	 */
	public String getStatus(final SessionContext ctx)
	{
		return (String)getProperty( ctx, STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.status</code> attribute.
	 * @return the status
	 */
	public String getStatus()
	{
		return getStatus( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.status</code> attribute. 
	 * @param value the status
	 */
	public void setStatus(final SessionContext ctx, final String value)
	{
		setProperty(ctx, STATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.status</code> attribute. 
	 * @param value the status
	 */
	public void setStatus(final String value)
	{
		setStatus( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.type</code> attribute.
	 * @return the type
	 */
	public String getType(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.type</code> attribute.
	 * @return the type
	 */
	public String getType()
	{
		return getType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.type</code> attribute. 
	 * @param value the type
	 */
	public void setType(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MerchSynchronization.type</code> attribute. 
	 * @param value the type
	 */
	public void setType(final String value)
	{
		setType( getSession().getSessionContext(), value );
	}
	
}
