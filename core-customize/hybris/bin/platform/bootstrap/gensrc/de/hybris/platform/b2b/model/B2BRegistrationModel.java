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
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.c2l.RegionModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.store.BaseStoreModel;

/**
 * Generated model class for type B2BRegistration first defined at extension b2bcommerce.
 * <p>
 * Representation of B2B user registration.
 */
@SuppressWarnings("all")
public class B2BRegistrationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BRegistration";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.baseSite</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String BASESITE = "baseSite";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.language</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String LANGUAGE = "language";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.currency</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.baseStore</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String BASESTORE = "baseStore";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.title</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String TITLE = "title";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.name</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.email</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String EMAIL = "email";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.position</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String POSITION = "position";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.telephone</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String TELEPHONE = "telephone";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.telephoneExtension</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String TELEPHONEEXTENSION = "telephoneExtension";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyName</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMPANYNAME = "companyName";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressStreet</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMPANYADDRESSSTREET = "companyAddressStreet";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressStreetLine2</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMPANYADDRESSSTREETLINE2 = "companyAddressStreetLine2";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressCity</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMPANYADDRESSCITY = "companyAddressCity";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressPostalCode</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMPANYADDRESSPOSTALCODE = "companyAddressPostalCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressRegion</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMPANYADDRESSREGION = "companyAddressRegion";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressCountry</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMPANYADDRESSCOUNTRY = "companyAddressCountry";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.message</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String MESSAGE = "message";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.rejectReason</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String REJECTREASON = "rejectReason";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.defaultB2BUnit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String DEFAULTB2BUNIT = "defaultB2BUnit";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BRegistrationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BRegistrationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseSite initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _baseStore initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _email initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _language initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _name initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BRegistrationModel(final BaseSiteModel _baseSite, final BaseStoreModel _baseStore, final CurrencyModel _currency, final String _email, final LanguageModel _language, final String _name)
	{
		super();
		setBaseSite(_baseSite);
		setBaseStore(_baseStore);
		setCurrency(_currency);
		setEmail(_email);
		setLanguage(_language);
		setName(_name);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseSite initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _baseStore initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _email initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _language initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _name initial attribute declared by type <code>B2BRegistration</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BRegistrationModel(final BaseSiteModel _baseSite, final BaseStoreModel _baseStore, final CurrencyModel _currency, final String _email, final LanguageModel _language, final String _name, final ItemModel _owner)
	{
		super();
		setBaseSite(_baseSite);
		setBaseStore(_baseStore);
		setCurrency(_currency);
		setEmail(_email);
		setLanguage(_language);
		setName(_name);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.baseSite</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the baseSite - Indicates the base site on which the user is registered.
	 */
	@Accessor(qualifier = "baseSite", type = Accessor.Type.GETTER)
	public BaseSiteModel getBaseSite()
	{
		return getPersistenceContext().getPropertyValue(BASESITE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.baseStore</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the baseStore - Indicates the base store on which the user is registered.
	 */
	@Accessor(qualifier = "baseStore", type = Accessor.Type.GETTER)
	public BaseStoreModel getBaseStore()
	{
		return getPersistenceContext().getPropertyValue(BASESTORE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressCity</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the companyAddressCity - Indicates the city of the user's company.
	 */
	@Accessor(qualifier = "companyAddressCity", type = Accessor.Type.GETTER)
	public String getCompanyAddressCity()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSCITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressCountry</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the companyAddressCountry - Indicates the country of the user's company.
	 */
	@Accessor(qualifier = "companyAddressCountry", type = Accessor.Type.GETTER)
	public CountryModel getCompanyAddressCountry()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSCOUNTRY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressPostalCode</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the companyAddressPostalCode - Indicates the postal code of the user's company.
	 */
	@Accessor(qualifier = "companyAddressPostalCode", type = Accessor.Type.GETTER)
	public String getCompanyAddressPostalCode()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSPOSTALCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressRegion</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the companyAddressRegion - Indicates the region of the user's company.
	 */
	@Accessor(qualifier = "companyAddressRegion", type = Accessor.Type.GETTER)
	public RegionModel getCompanyAddressRegion()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSREGION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressStreet</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the companyAddressStreet - Indicates the address of the user's company.
	 */
	@Accessor(qualifier = "companyAddressStreet", type = Accessor.Type.GETTER)
	public String getCompanyAddressStreet()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSSTREET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressStreetLine2</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the companyAddressStreetLine2 - Indicates the address line 2 of the user's company.
	 */
	@Accessor(qualifier = "companyAddressStreetLine2", type = Accessor.Type.GETTER)
	public String getCompanyAddressStreetLine2()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSSTREETLINE2);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyName</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the companyName - Indicates the user's company name.
	 */
	@Accessor(qualifier = "companyName", type = Accessor.Type.GETTER)
	public String getCompanyName()
	{
		return getPersistenceContext().getPropertyValue(COMPANYNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the currency - Indicates the curency used by the user.
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.defaultB2BUnit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the defaultB2BUnit - Indicates the B2B unit assigned to the user.
	 */
	@Accessor(qualifier = "defaultB2BUnit", type = Accessor.Type.GETTER)
	public B2BUnitModel getDefaultB2BUnit()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTB2BUNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.email</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the email - Indicates the email address of the user.
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.GETTER)
	public String getEmail()
	{
		return getPersistenceContext().getPropertyValue(EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.language</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the language - Indicates the language used by the user.
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.GETTER)
	public LanguageModel getLanguage()
	{
		return getPersistenceContext().getPropertyValue(LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.message</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the message - Indicates the message the user provides.
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.GETTER)
	public String getMessage()
	{
		return getPersistenceContext().getPropertyValue(MESSAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.name</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the name - Indicates the name of the user.
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.position</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the position - Indicates the position of the user.
	 */
	@Accessor(qualifier = "position", type = Accessor.Type.GETTER)
	public String getPosition()
	{
		return getPersistenceContext().getPropertyValue(POSITION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.rejectReason</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the rejectReason - Indicates the reason why the registration is rejected.
	 */
	@Accessor(qualifier = "rejectReason", type = Accessor.Type.GETTER)
	public String getRejectReason()
	{
		return getPersistenceContext().getPropertyValue(REJECTREASON);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.telephone</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the telephone - Indicates the telephone of the user.
	 */
	@Accessor(qualifier = "telephone", type = Accessor.Type.GETTER)
	public String getTelephone()
	{
		return getPersistenceContext().getPropertyValue(TELEPHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.telephoneExtension</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the telephoneExtension - Indicates the telephone extension of the user.
	 */
	@Accessor(qualifier = "telephoneExtension", type = Accessor.Type.GETTER)
	public String getTelephoneExtension()
	{
		return getPersistenceContext().getPropertyValue(TELEPHONEEXTENSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.title</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the title - Indicates the title of the user.
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.GETTER)
	public TitleModel getTitle()
	{
		return getPersistenceContext().getPropertyValue(TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.baseSite</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the baseSite - Indicates the base site on which the user is registered.
	 */
	@Accessor(qualifier = "baseSite", type = Accessor.Type.SETTER)
	public void setBaseSite(final BaseSiteModel value)
	{
		getPersistenceContext().setPropertyValue(BASESITE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.baseStore</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the baseStore - Indicates the base store on which the user is registered.
	 */
	@Accessor(qualifier = "baseStore", type = Accessor.Type.SETTER)
	public void setBaseStore(final BaseStoreModel value)
	{
		getPersistenceContext().setPropertyValue(BASESTORE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressCity</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the companyAddressCity - Indicates the city of the user's company.
	 */
	@Accessor(qualifier = "companyAddressCity", type = Accessor.Type.SETTER)
	public void setCompanyAddressCity(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSCITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressCountry</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the companyAddressCountry - Indicates the country of the user's company.
	 */
	@Accessor(qualifier = "companyAddressCountry", type = Accessor.Type.SETTER)
	public void setCompanyAddressCountry(final CountryModel value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSCOUNTRY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressPostalCode</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the companyAddressPostalCode - Indicates the postal code of the user's company.
	 */
	@Accessor(qualifier = "companyAddressPostalCode", type = Accessor.Type.SETTER)
	public void setCompanyAddressPostalCode(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSPOSTALCODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressRegion</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the companyAddressRegion - Indicates the region of the user's company.
	 */
	@Accessor(qualifier = "companyAddressRegion", type = Accessor.Type.SETTER)
	public void setCompanyAddressRegion(final RegionModel value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSREGION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressStreet</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the companyAddressStreet - Indicates the address of the user's company.
	 */
	@Accessor(qualifier = "companyAddressStreet", type = Accessor.Type.SETTER)
	public void setCompanyAddressStreet(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSSTREET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressStreetLine2</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the companyAddressStreetLine2 - Indicates the address line 2 of the user's company.
	 */
	@Accessor(qualifier = "companyAddressStreetLine2", type = Accessor.Type.SETTER)
	public void setCompanyAddressStreetLine2(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSSTREETLINE2, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyName</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the companyName - Indicates the user's company name.
	 */
	@Accessor(qualifier = "companyName", type = Accessor.Type.SETTER)
	public void setCompanyName(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the currency - Indicates the curency used by the user.
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.defaultB2BUnit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the defaultB2BUnit - Indicates the B2B unit assigned to the user.
	 */
	@Accessor(qualifier = "defaultB2BUnit", type = Accessor.Type.SETTER)
	public void setDefaultB2BUnit(final B2BUnitModel value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTB2BUNIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.email</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the email - Indicates the email address of the user.
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.SETTER)
	public void setEmail(final String value)
	{
		getPersistenceContext().setPropertyValue(EMAIL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.language</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the language - Indicates the language used by the user.
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.SETTER)
	public void setLanguage(final LanguageModel value)
	{
		getPersistenceContext().setPropertyValue(LANGUAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.message</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the message - Indicates the message the user provides.
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.SETTER)
	public void setMessage(final String value)
	{
		getPersistenceContext().setPropertyValue(MESSAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.name</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the name - Indicates the name of the user.
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.position</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the position - Indicates the position of the user.
	 */
	@Accessor(qualifier = "position", type = Accessor.Type.SETTER)
	public void setPosition(final String value)
	{
		getPersistenceContext().setPropertyValue(POSITION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.rejectReason</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the rejectReason - Indicates the reason why the registration is rejected.
	 */
	@Accessor(qualifier = "rejectReason", type = Accessor.Type.SETTER)
	public void setRejectReason(final String value)
	{
		getPersistenceContext().setPropertyValue(REJECTREASON, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.telephone</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the telephone - Indicates the telephone of the user.
	 */
	@Accessor(qualifier = "telephone", type = Accessor.Type.SETTER)
	public void setTelephone(final String value)
	{
		getPersistenceContext().setPropertyValue(TELEPHONE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.telephoneExtension</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the telephoneExtension - Indicates the telephone extension of the user.
	 */
	@Accessor(qualifier = "telephoneExtension", type = Accessor.Type.SETTER)
	public void setTelephoneExtension(final String value)
	{
		getPersistenceContext().setPropertyValue(TELEPHONEEXTENSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.title</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the title - Indicates the title of the user.
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.SETTER)
	public void setTitle(final TitleModel value)
	{
		getPersistenceContext().setPropertyValue(TITLE, value);
	}
	
}
