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
import de.hybris.platform.addressservices.jalo.District;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LItem;
import de.hybris.platform.jalo.c2l.Region;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.addressservices.jalo.City City}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedCity extends C2LItem
{
	/** Qualifier of the <code>City.regionPOS</code> attribute **/
	public static final String REGIONPOS = "regionPOS";
	/** Qualifier of the <code>City.region</code> attribute **/
	public static final String REGION = "region";
	/** Qualifier of the <code>City.districts</code> attribute **/
	public static final String DISTRICTS = "districts";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n REGION's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedCity> REGIONHANDLER = new BidirectionalOneToManyHandler<GeneratedCity>(
	ChineseaddressservicesConstants.TC.CITY,
	false,
	"region",
	"regionPOS",
	true,
	true,
	CollectionType.LIST
	);
	/**
	* {@link OneToManyHandler} for handling 1:n DISTRICTS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<District> DISTRICTSHANDLER = new OneToManyHandler<District>(
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
		tmp.put(REGIONPOS, AttributeMode.INITIAL);
		tmp.put(REGION, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		REGIONHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.districts</code> attribute.
	 * @return the districts
	 */
	public List<District> getDistricts(final SessionContext ctx)
	{
		return (List<District>)DISTRICTSHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.districts</code> attribute.
	 * @return the districts
	 */
	public List<District> getDistricts()
	{
		return getDistricts( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.districts</code> attribute. 
	 * @param value the districts
	 */
	public void setDistricts(final SessionContext ctx, final List<District> value)
	{
		DISTRICTSHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.districts</code> attribute. 
	 * @param value the districts
	 */
	public void setDistricts(final List<District> value)
	{
		setDistricts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to districts. 
	 * @param value the item to add to districts
	 */
	public void addToDistricts(final SessionContext ctx, final District value)
	{
		DISTRICTSHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to districts. 
	 * @param value the item to add to districts
	 */
	public void addToDistricts(final District value)
	{
		addToDistricts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from districts. 
	 * @param value the item to remove from districts
	 */
	public void removeFromDistricts(final SessionContext ctx, final District value)
	{
		DISTRICTSHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from districts. 
	 * @param value the item to remove from districts
	 */
	public void removeFromDistricts(final District value)
	{
		removeFromDistricts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.region</code> attribute.
	 * @return the region
	 */
	public Region getRegion(final SessionContext ctx)
	{
		return (Region)getProperty( ctx, REGION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.region</code> attribute.
	 * @return the region
	 */
	public Region getRegion()
	{
		return getRegion( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.region</code> attribute. 
	 * @param value the region
	 */
	public void setRegion(final SessionContext ctx, final Region value)
	{
		REGIONHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.region</code> attribute. 
	 * @param value the region
	 */
	public void setRegion(final Region value)
	{
		setRegion( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.regionPOS</code> attribute.
	 * @return the regionPOS
	 */
	 Integer getRegionPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, REGIONPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.regionPOS</code> attribute.
	 * @return the regionPOS
	 */
	 Integer getRegionPOS()
	{
		return getRegionPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.regionPOS</code> attribute. 
	 * @return the regionPOS
	 */
	 int getRegionPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getRegionPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.regionPOS</code> attribute. 
	 * @return the regionPOS
	 */
	 int getRegionPOSAsPrimitive()
	{
		return getRegionPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.regionPOS</code> attribute. 
	 * @param value the regionPOS
	 */
	 void setRegionPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, REGIONPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.regionPOS</code> attribute. 
	 * @param value the regionPOS
	 */
	 void setRegionPOS(final Integer value)
	{
		setRegionPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.regionPOS</code> attribute. 
	 * @param value the regionPOS
	 */
	 void setRegionPOS(final SessionContext ctx, final int value)
	{
		setRegionPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>City.regionPOS</code> attribute. 
	 * @param value the regionPOS
	 */
	 void setRegionPOS(final int value)
	{
		setRegionPOS( getSession().getSessionContext(), value );
	}
	
}
