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
import de.hybris.platform.b2b.model.B2BRegistrationProcessModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type B2BRegistrationApprovedProcess first defined at extension b2bcommerce.
 * <p>
 * Process for approved B2B user registration.
 */
@SuppressWarnings("all")
public class B2BRegistrationApprovedProcessModel extends B2BRegistrationProcessModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BRegistrationApprovedProcess";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistrationApprovedProcess.passwordResetToken</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String PASSWORDRESETTOKEN = "passwordResetToken";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BRegistrationApprovedProcessModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BRegistrationApprovedProcessModel(final ItemModelContext ctx)
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
	public B2BRegistrationApprovedProcessModel(final String _code, final String _processDefinitionName)
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
	public B2BRegistrationApprovedProcessModel(final String _code, final ItemModel _owner, final String _processDefinitionName)
	{
		super();
		setCode(_code);
		setOwner(_owner);
		setProcessDefinitionName(_processDefinitionName);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistrationApprovedProcess.passwordResetToken</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the passwordResetToken - Indicates the password reset token.
	 */
	@Accessor(qualifier = "passwordResetToken", type = Accessor.Type.GETTER)
	public String getPasswordResetToken()
	{
		return getPersistenceContext().getPropertyValue(PASSWORDRESETTOKEN);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistrationApprovedProcess.passwordResetToken</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the passwordResetToken - Indicates the password reset token.
	 */
	@Accessor(qualifier = "passwordResetToken", type = Accessor.Type.SETTER)
	public void setPasswordResetToken(final String value)
	{
		getPersistenceContext().setPropertyValue(PASSWORDRESETTOKEN, value);
	}
	
}
