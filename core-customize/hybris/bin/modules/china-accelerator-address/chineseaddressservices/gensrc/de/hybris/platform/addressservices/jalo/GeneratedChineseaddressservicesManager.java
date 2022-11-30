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
import de.hybris.platform.addressservices.jalo.District;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LItem;
import de.hybris.platform.jalo.c2l.Region;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type <code>ChineseaddressservicesManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedChineseaddressservicesManager extends Extension
{
	/**
	* {@link OneToManyHandler} for handling 1:n CITIES's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<City> REGION2CITIESRELATIONCITIESHANDLER = new OneToManyHandler<City>(
	ChineseaddressservicesConstants.TC.CITY,
	false,
	"region",
	"regionPOS",
	true,
	true,
	CollectionType.LIST
	);
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("city", AttributeMode.INITIAL);
		tmp.put("cityDistrict", AttributeMode.INITIAL);
		tmp.put("fullname", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Address", Collections.unmodifiableMap(tmp));
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
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Region.cities</code> attribute.
	 * @return the cities
	 */
	public List<City> getCities(final SessionContext ctx, final Region item)
	{
		return (List<City>)REGION2CITIESRELATIONCITIESHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Region.cities</code> attribute.
	 * @return the cities
	 */
	public List<City> getCities(final Region item)
	{
		return getCities( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Region.cities</code> attribute. 
	 * @param value the cities
	 */
	public void setCities(final SessionContext ctx, final Region item, final List<City> value)
	{
		REGION2CITIESRELATIONCITIESHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Region.cities</code> attribute. 
	 * @param value the cities
	 */
	public void setCities(final Region item, final List<City> value)
	{
		setCities( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to cities. 
	 * @param value the item to add to cities
	 */
	public void addToCities(final SessionContext ctx, final Region item, final City value)
	{
		REGION2CITIESRELATIONCITIESHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to cities. 
	 * @param value the item to add to cities
	 */
	public void addToCities(final Region item, final City value)
	{
		addToCities( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from cities. 
	 * @param value the item to remove from cities
	 */
	public void removeFromCities(final SessionContext ctx, final Region item, final City value)
	{
		REGION2CITIESRELATIONCITIESHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from cities. 
	 * @param value the item to remove from cities
	 */
	public void removeFromCities(final Region item, final City value)
	{
		removeFromCities( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.city</code> attribute.
	 * @return the city - The city.
	 */
	public City getCity(final SessionContext ctx, final Address item)
	{
		return (City)item.getProperty( ctx, ChineseaddressservicesConstants.Attributes.Address.CITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.city</code> attribute.
	 * @return the city - The city.
	 */
	public City getCity(final Address item)
	{
		return getCity( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.city</code> attribute. 
	 * @param value the city - The city.
	 */
	public void setCity(final SessionContext ctx, final Address item, final City value)
	{
		item.setProperty(ctx, ChineseaddressservicesConstants.Attributes.Address.CITY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.city</code> attribute. 
	 * @param value the city - The city.
	 */
	public void setCity(final Address item, final City value)
	{
		setCity( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.cityDistrict</code> attribute.
	 * @return the cityDistrict - District of the city.
	 */
	public District getCityDistrict(final SessionContext ctx, final Address item)
	{
		return (District)item.getProperty( ctx, ChineseaddressservicesConstants.Attributes.Address.CITYDISTRICT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.cityDistrict</code> attribute.
	 * @return the cityDistrict - District of the city.
	 */
	public District getCityDistrict(final Address item)
	{
		return getCityDistrict( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.cityDistrict</code> attribute. 
	 * @param value the cityDistrict - District of the city.
	 */
	public void setCityDistrict(final SessionContext ctx, final Address item, final District value)
	{
		item.setProperty(ctx, ChineseaddressservicesConstants.Attributes.Address.CITYDISTRICT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.cityDistrict</code> attribute. 
	 * @param value the cityDistrict - District of the city.
	 */
	public void setCityDistrict(final Address item, final District value)
	{
		setCityDistrict( getSession().getSessionContext(), item, value );
	}
	
	public City createCity(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ChineseaddressservicesConstants.TC.CITY );
			return (City)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating City : "+e.getMessage(), 0 );
		}
	}
	
	public City createCity(final Map attributeValues)
	{
		return createCity( getSession().getSessionContext(), attributeValues );
	}
	
	public District createDistrict(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ChineseaddressservicesConstants.TC.DISTRICT );
			return (District)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating District : "+e.getMessage(), 0 );
		}
	}
	
	public District createDistrict(final Map attributeValues)
	{
		return createDistrict( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.fullname</code> attribute.
	 * @return the fullname - The full name in delivery address
	 */
	public String getFullname(final SessionContext ctx, final Address item)
	{
		return (String)item.getProperty( ctx, ChineseaddressservicesConstants.Attributes.Address.FULLNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.fullname</code> attribute.
	 * @return the fullname - The full name in delivery address
	 */
	public String getFullname(final Address item)
	{
		return getFullname( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.fullname</code> attribute. 
	 * @param value the fullname - The full name in delivery address
	 */
	public void setFullname(final SessionContext ctx, final Address item, final String value)
	{
		item.setProperty(ctx, ChineseaddressservicesConstants.Attributes.Address.FULLNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.fullname</code> attribute. 
	 * @param value the fullname - The full name in delivery address
	 */
	public void setFullname(final Address item, final String value)
	{
		setFullname( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return ChineseaddressservicesConstants.EXTENSIONNAME;
	}
	
}
