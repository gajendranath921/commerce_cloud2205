/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.addressservices.jalo;

import de.hybris.platform.addressservices.constants.ChineseaddressservicesConstants;
import de.hybris.platform.addressservices.jalo.City;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LItem;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.addressservices.jalo.District District}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedDistrict extends C2LItem
{
	/** Qualifier of the <code>District.cityPOS</code> attribute **/
	public static final String CITYPOS = "cityPOS";
	/** Qualifier of the <code>District.city</code> attribute **/
	public static final String CITY = "city";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n CITY's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedDistrict> CITYHANDLER = new BidirectionalOneToManyHandler<GeneratedDistrict>(
	ChineseaddressservicesConstants.TC.DISTRICT,
	false,
	"city",
	"cityPOS",
	true,
	true,
	CollectionType.LIST
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(C2LItem.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CITYPOS, AttributeMode.INITIAL);
		tmp.put(CITY, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>District.city</code> attribute.
	 * @return the city
	 */
	public City getCity(final SessionContext ctx)
	{
		return (City)getProperty( ctx, CITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>District.city</code> attribute.
	 * @return the city
	 */
	public City getCity()
	{
		return getCity( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>District.city</code> attribute. 
	 * @param value the city
	 */
	public void setCity(final SessionContext ctx, final City value)
	{
		CITYHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>District.city</code> attribute. 
	 * @param value the city
	 */
	public void setCity(final City value)
	{
		setCity( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>District.cityPOS</code> attribute.
	 * @return the cityPOS
	 */
	 Integer getCityPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, CITYPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>District.cityPOS</code> attribute.
	 * @return the cityPOS
	 */
	 Integer getCityPOS()
	{
		return getCityPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>District.cityPOS</code> attribute. 
	 * @return the cityPOS
	 */
	 int getCityPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getCityPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>District.cityPOS</code> attribute. 
	 * @return the cityPOS
	 */
	 int getCityPOSAsPrimitive()
	{
		return getCityPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>District.cityPOS</code> attribute. 
	 * @param value the cityPOS
	 */
	 void setCityPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, CITYPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>District.cityPOS</code> attribute. 
	 * @param value the cityPOS
	 */
	 void setCityPOS(final Integer value)
	{
		setCityPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>District.cityPOS</code> attribute. 
	 * @param value the cityPOS
	 */
	 void setCityPOS(final SessionContext ctx, final int value)
	{
		setCityPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>District.cityPOS</code> attribute. 
	 * @param value the cityPOS
	 */
	 void setCityPOS(final int value)
	{
		setCityPOS( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		CITYHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
}
