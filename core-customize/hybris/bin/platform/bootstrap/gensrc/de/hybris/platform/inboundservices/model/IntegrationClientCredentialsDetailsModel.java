/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.inboundservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;

/**
 * Generated model class for type IntegrationClientCredentialsDetails first defined at extension inboundservices.
 * <p>
 * Extended OAuthClientDetails for Integration Services authentication that requires user and supports only
 *                 the client_credentials grant type.
 */
@SuppressWarnings("all")
public class IntegrationClientCredentialsDetailsModel extends OAuthClientDetailsModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationClientCredentialsDetails";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationClientCredentialsDetails.user</code> attribute defined at extension <code>inboundservices</code>. */
	public static final String USER = "user";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationClientCredentialsDetailsModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationClientCredentialsDetailsModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _clientId initial attribute declared by type <code>OAuthClientDetails</code> at extension <code>oauth2</code>
	 * @param _user initial attribute declared by type <code>IntegrationClientCredentialsDetails</code> at extension <code>inboundservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationClientCredentialsDetailsModel(final String _clientId, final EmployeeModel _user)
	{
		super();
		setClientId(_clientId);
		setUser(_user);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _clientId initial attribute declared by type <code>OAuthClientDetails</code> at extension <code>oauth2</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>IntegrationClientCredentialsDetails</code> at extension <code>inboundservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationClientCredentialsDetailsModel(final String _clientId, final ItemModel _owner, final EmployeeModel _user)
	{
		super();
		setClientId(_clientId);
		setOwner(_owner);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationClientCredentialsDetails.user</code> attribute defined at extension <code>inboundservices</code>. 
	 * @return the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.GETTER)
	public EmployeeModel getUser()
	{
		return getPersistenceContext().getPropertyValue(USER);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>IntegrationClientCredentialsDetails.user</code> attribute defined at extension <code>inboundservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.SETTER)
	public void setUser(final EmployeeModel value)
	{
		getPersistenceContext().setPropertyValue(USER, value);
	}
	
}
