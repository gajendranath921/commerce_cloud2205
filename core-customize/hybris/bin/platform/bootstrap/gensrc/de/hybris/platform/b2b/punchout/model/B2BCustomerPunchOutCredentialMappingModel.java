/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.punchout.model.PunchOutCredentialModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type B2BCustomerPunchOutCredentialMapping first defined at extension b2bpunchout.
 */
@SuppressWarnings("all")
public class B2BCustomerPunchOutCredentialMappingModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BCustomerPunchOutCredentialMapping";
	
	/**<i>Generated relation code constant for relation <code>PunchOutCredential2B2BCustomerPunchOutCredentialMapping</code> defining source attribute <code>credentials</code> in extension <code>b2bpunchout</code>.</i>*/
	public static final String _PUNCHOUTCREDENTIAL2B2BCUSTOMERPUNCHOUTCREDENTIALMAPPING = "PunchOutCredential2B2BCustomerPunchOutCredentialMapping";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomerPunchOutCredentialMapping.b2bCustomer</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String B2BCUSTOMER = "b2bCustomer";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomerPunchOutCredentialMapping.credentials</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String CREDENTIALS = "credentials";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BCustomerPunchOutCredentialMappingModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BCustomerPunchOutCredentialMappingModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _b2bCustomer initial attribute declared by type <code>B2BCustomerPunchOutCredentialMapping</code> at extension <code>b2bpunchout</code>
	 * @param _credentials initial attribute declared by type <code>B2BCustomerPunchOutCredentialMapping</code> at extension <code>b2bpunchout</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BCustomerPunchOutCredentialMappingModel(final B2BCustomerModel _b2bCustomer, final Set<PunchOutCredentialModel> _credentials)
	{
		super();
		setB2bCustomer(_b2bCustomer);
		setCredentials(_credentials);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _b2bCustomer initial attribute declared by type <code>B2BCustomerPunchOutCredentialMapping</code> at extension <code>b2bpunchout</code>
	 * @param _credentials initial attribute declared by type <code>B2BCustomerPunchOutCredentialMapping</code> at extension <code>b2bpunchout</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BCustomerPunchOutCredentialMappingModel(final B2BCustomerModel _b2bCustomer, final Set<PunchOutCredentialModel> _credentials, final ItemModel _owner)
	{
		super();
		setB2bCustomer(_b2bCustomer);
		setCredentials(_credentials);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomerPunchOutCredentialMapping.b2bCustomer</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the b2bCustomer
	 */
	@Accessor(qualifier = "b2bCustomer", type = Accessor.Type.GETTER)
	public B2BCustomerModel getB2bCustomer()
	{
		return getPersistenceContext().getPropertyValue(B2BCUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomerPunchOutCredentialMapping.credentials</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the credentials
	 */
	@Accessor(qualifier = "credentials", type = Accessor.Type.GETTER)
	public Set<PunchOutCredentialModel> getCredentials()
	{
		return getPersistenceContext().getPropertyValue(CREDENTIALS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomerPunchOutCredentialMapping.b2bCustomer</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the b2bCustomer
	 */
	@Accessor(qualifier = "b2bCustomer", type = Accessor.Type.SETTER)
	public void setB2bCustomer(final B2BCustomerModel value)
	{
		getPersistenceContext().setPropertyValue(B2BCUSTOMER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomerPunchOutCredentialMapping.credentials</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the credentials
	 */
	@Accessor(qualifier = "credentials", type = Accessor.Type.SETTER)
	public void setCredentials(final Set<PunchOutCredentialModel> value)
	{
		getPersistenceContext().setPropertyValue(CREDENTIALS, value);
	}
	
}
