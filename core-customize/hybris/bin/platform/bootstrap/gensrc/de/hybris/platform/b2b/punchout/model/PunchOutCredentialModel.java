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
import de.hybris.platform.b2b.punchout.model.B2BCustomerPunchOutCredentialMappingModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type PunchOutCredential first defined at extension b2bpunchout.
 */
@SuppressWarnings("all")
public class PunchOutCredentialModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PunchOutCredential";
	
	/** <i>Generated constant</i> - Attribute key of <code>PunchOutCredential.code</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>PunchOutCredential.identity</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String IDENTITY = "identity";
	
	/** <i>Generated constant</i> - Attribute key of <code>PunchOutCredential.domain</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String DOMAIN = "domain";
	
	/** <i>Generated constant</i> - Attribute key of <code>PunchOutCredential.sharedsecret</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String SHAREDSECRET = "sharedsecret";
	
	/** <i>Generated constant</i> - Attribute key of <code>PunchOutCredential.B2BCustomerPunchOutCredentialMapping</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String B2BCUSTOMERPUNCHOUTCREDENTIALMAPPING = "B2BCustomerPunchOutCredentialMapping";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PunchOutCredentialModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PunchOutCredentialModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>PunchOutCredential</code> at extension <code>b2bpunchout</code>
	 * @param _domain initial attribute declared by type <code>PunchOutCredential</code> at extension <code>b2bpunchout</code>
	 * @param _identity initial attribute declared by type <code>PunchOutCredential</code> at extension <code>b2bpunchout</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PunchOutCredentialModel(final String _code, final String _domain, final String _identity)
	{
		super();
		setCode(_code);
		setDomain(_domain);
		setIdentity(_identity);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>PunchOutCredential</code> at extension <code>b2bpunchout</code>
	 * @param _domain initial attribute declared by type <code>PunchOutCredential</code> at extension <code>b2bpunchout</code>
	 * @param _identity initial attribute declared by type <code>PunchOutCredential</code> at extension <code>b2bpunchout</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PunchOutCredentialModel(final String _code, final String _domain, final String _identity, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setDomain(_domain);
		setIdentity(_identity);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PunchOutCredential.B2BCustomerPunchOutCredentialMapping</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the B2BCustomerPunchOutCredentialMapping
	 */
	@Accessor(qualifier = "B2BCustomerPunchOutCredentialMapping", type = Accessor.Type.GETTER)
	public B2BCustomerPunchOutCredentialMappingModel getB2BCustomerPunchOutCredentialMapping()
	{
		return getPersistenceContext().getPropertyValue(B2BCUSTOMERPUNCHOUTCREDENTIALMAPPING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PunchOutCredential.code</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PunchOutCredential.domain</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the domain
	 */
	@Accessor(qualifier = "domain", type = Accessor.Type.GETTER)
	public String getDomain()
	{
		return getPersistenceContext().getPropertyValue(DOMAIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PunchOutCredential.identity</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the identity
	 */
	@Accessor(qualifier = "identity", type = Accessor.Type.GETTER)
	public String getIdentity()
	{
		return getPersistenceContext().getPropertyValue(IDENTITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PunchOutCredential.sharedsecret</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the sharedsecret
	 */
	@Accessor(qualifier = "sharedsecret", type = Accessor.Type.GETTER)
	public String getSharedsecret()
	{
		return getPersistenceContext().getPropertyValue(SHAREDSECRET);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PunchOutCredential.B2BCustomerPunchOutCredentialMapping</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the B2BCustomerPunchOutCredentialMapping
	 */
	@Accessor(qualifier = "B2BCustomerPunchOutCredentialMapping", type = Accessor.Type.SETTER)
	public void setB2BCustomerPunchOutCredentialMapping(final B2BCustomerPunchOutCredentialMappingModel value)
	{
		getPersistenceContext().setPropertyValue(B2BCUSTOMERPUNCHOUTCREDENTIALMAPPING, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PunchOutCredential.code</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PunchOutCredential.domain</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the domain
	 */
	@Accessor(qualifier = "domain", type = Accessor.Type.SETTER)
	public void setDomain(final String value)
	{
		getPersistenceContext().setPropertyValue(DOMAIN, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PunchOutCredential.identity</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the identity
	 */
	@Accessor(qualifier = "identity", type = Accessor.Type.SETTER)
	public void setIdentity(final String value)
	{
		getPersistenceContext().setPropertyValue(IDENTITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PunchOutCredential.sharedsecret</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the sharedsecret
	 */
	@Accessor(qualifier = "sharedsecret", type = Accessor.Type.SETTER)
	public void setSharedsecret(final String value)
	{
		getPersistenceContext().setPropertyValue(SHAREDSECRET, value);
	}
	
}
