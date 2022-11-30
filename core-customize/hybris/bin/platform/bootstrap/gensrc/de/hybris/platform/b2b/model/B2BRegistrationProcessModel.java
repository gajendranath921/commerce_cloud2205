/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.model.B2BRegistrationModel;
import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type B2BRegistrationProcess first defined at extension b2bcommerce.
 * <p>
 * Process for B2B user registration.
 */
@SuppressWarnings("all")
public class B2BRegistrationProcessModel extends StoreFrontCustomerProcessModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BRegistrationProcess";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistrationProcess.registration</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String REGISTRATION = "registration";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BRegistrationProcessModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BRegistrationProcessModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 * @param _processDefinitionName initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BRegistrationProcessModel(final String _code, final String _processDefinitionName)
	{
		super();
		setCode(_code);
		setProcessDefinitionName(_processDefinitionName);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _processDefinitionName initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BRegistrationProcessModel(final String _code, final ItemModel _owner, final String _processDefinitionName)
	{
		super();
		setCode(_code);
		setOwner(_owner);
		setProcessDefinitionName(_processDefinitionName);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistrationProcess.registration</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the registration - related B2B registration
	 */
	@Accessor(qualifier = "registration", type = Accessor.Type.GETTER)
	public B2BRegistrationModel getRegistration()
	{
		return getPersistenceContext().getPropertyValue(REGISTRATION);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistrationProcess.registration</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the registration - related B2B registration
	 */
	@Accessor(qualifier = "registration", type = Accessor.Type.SETTER)
	public void setRegistration(final B2BRegistrationModel value)
	{
		getPersistenceContext().setPropertyValue(REGISTRATION, value);
	}
	
}
