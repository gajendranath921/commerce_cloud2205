/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.apiregistryservices.model.ConsumedDestinationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.searchservices.model.AbstractSnSearchProviderConfigurationModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type CSSearchSnSearchProviderConfiguration first defined at extension searchprovidercssearchservices.
 */
@SuppressWarnings("all")
public class CSSearchSnSearchProviderConfigurationModel extends AbstractSnSearchProviderConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CSSearchSnSearchProviderConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>CSSearchSnSearchProviderConfiguration.consumedDestination</code> attribute defined at extension <code>searchprovidercssearchservices</code>. */
	public static final String CONSUMEDDESTINATION = "consumedDestination";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CSSearchSnSearchProviderConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CSSearchSnSearchProviderConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _consumedDestination initial attribute declared by type <code>CSSearchSnSearchProviderConfiguration</code> at extension <code>searchprovidercssearchservices</code>
	 * @param _id initial attribute declared by type <code>AbstractSnSearchProviderConfiguration</code> at extension <code>searchservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CSSearchSnSearchProviderConfigurationModel(final ConsumedDestinationModel _consumedDestination, final String _id)
	{
		super();
		setConsumedDestination(_consumedDestination);
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _consumedDestination initial attribute declared by type <code>CSSearchSnSearchProviderConfiguration</code> at extension <code>searchprovidercssearchservices</code>
	 * @param _id initial attribute declared by type <code>AbstractSnSearchProviderConfiguration</code> at extension <code>searchservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CSSearchSnSearchProviderConfigurationModel(final ConsumedDestinationModel _consumedDestination, final String _id, final ItemModel _owner)
	{
		super();
		setConsumedDestination(_consumedDestination);
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CSSearchSnSearchProviderConfiguration.consumedDestination</code> attribute defined at extension <code>searchprovidercssearchservices</code>. 
	 * @return the consumedDestination
	 */
	@Accessor(qualifier = "consumedDestination", type = Accessor.Type.GETTER)
	public ConsumedDestinationModel getConsumedDestination()
	{
		return getPersistenceContext().getPropertyValue(CONSUMEDDESTINATION);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CSSearchSnSearchProviderConfiguration.consumedDestination</code> attribute defined at extension <code>searchprovidercssearchservices</code>. 
	 *  
	 * @param value the consumedDestination
	 */
	@Accessor(qualifier = "consumedDestination", type = Accessor.Type.SETTER)
	public void setConsumedDestination(final ConsumedDestinationModel value)
	{
		getPersistenceContext().setPropertyValue(CONSUMEDDESTINATION, value);
	}
	
}
