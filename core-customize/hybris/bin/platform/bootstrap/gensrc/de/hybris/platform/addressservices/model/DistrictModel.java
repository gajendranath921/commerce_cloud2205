/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.addressservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.addressservices.model.CityModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.C2LItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type District first defined at extension chineseaddressservices.
 */
@SuppressWarnings("all")
public class DistrictModel extends C2LItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "District";
	
	/**<i>Generated relation code constant for relation <code>City2DistrictsRelation</code> defining source attribute <code>city</code> in extension <code>chineseaddressservices</code>.</i>*/
	public static final String _CITY2DISTRICTSRELATION = "City2DistrictsRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>District.cityPOS</code> attribute defined at extension <code>chineseaddressservices</code>. */
	public static final String CITYPOS = "cityPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>District.city</code> attribute defined at extension <code>chineseaddressservices</code>. */
	public static final String CITY = "city";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public DistrictModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public DistrictModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>District</code> at extension <code>chineseaddressservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public DistrictModel(final String _isocode)
	{
		super();
		setIsocode(_isocode);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>District</code> at extension <code>chineseaddressservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public DistrictModel(final String _isocode, final ItemModel _owner)
	{
		super();
		setIsocode(_isocode);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>District.city</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 * @return the city
	 */
	@Accessor(qualifier = "city", type = Accessor.Type.GETTER)
	public CityModel getCity()
	{
		return getPersistenceContext().getPropertyValue(CITY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>District.city</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 *  
	 * @param value the city
	 */
	@Accessor(qualifier = "city", type = Accessor.Type.SETTER)
	public void setCity(final CityModel value)
	{
		getPersistenceContext().setPropertyValue(CITY, value);
	}
	
}
