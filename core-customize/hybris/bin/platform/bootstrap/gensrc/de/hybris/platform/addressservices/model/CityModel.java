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
import de.hybris.platform.addressservices.model.DistrictModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.C2LItemModel;
import de.hybris.platform.core.model.c2l.RegionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type City first defined at extension chineseaddressservices.
 */
@SuppressWarnings("all")
public class CityModel extends C2LItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "City";
	
	/**<i>Generated relation code constant for relation <code>Region2CitiesRelation</code> defining source attribute <code>region</code> in extension <code>chineseaddressservices</code>.</i>*/
	public static final String _REGION2CITIESRELATION = "Region2CitiesRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>City.regionPOS</code> attribute defined at extension <code>chineseaddressservices</code>. */
	public static final String REGIONPOS = "regionPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>City.region</code> attribute defined at extension <code>chineseaddressservices</code>. */
	public static final String REGION = "region";
	
	/** <i>Generated constant</i> - Attribute key of <code>City.districts</code> attribute defined at extension <code>chineseaddressservices</code>. */
	public static final String DISTRICTS = "districts";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CityModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CityModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>City</code> at extension <code>chineseaddressservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CityModel(final String _isocode)
	{
		super();
		setIsocode(_isocode);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>City</code> at extension <code>chineseaddressservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CityModel(final String _isocode, final ItemModel _owner)
	{
		super();
		setIsocode(_isocode);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.districts</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the districts
	 */
	@Accessor(qualifier = "districts", type = Accessor.Type.GETTER)
	public List<DistrictModel> getDistricts()
	{
		return getPersistenceContext().getPropertyValue(DISTRICTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>City.region</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 * @return the region
	 */
	@Accessor(qualifier = "region", type = Accessor.Type.GETTER)
	public RegionModel getRegion()
	{
		return getPersistenceContext().getPropertyValue(REGION);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>City.districts</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 *  
	 * @param value the districts
	 */
	@Accessor(qualifier = "districts", type = Accessor.Type.SETTER)
	public void setDistricts(final List<DistrictModel> value)
	{
		getPersistenceContext().setPropertyValue(DISTRICTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>City.region</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 *  
	 * @param value the region
	 */
	@Accessor(qualifier = "region", type = Accessor.Type.SETTER)
	public void setRegion(final RegionModel value)
	{
		getPersistenceContext().setPropertyValue(REGION, value);
	}
	
}
