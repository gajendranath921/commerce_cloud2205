/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;

/**
 * Generated model class for type UsageUnit first defined at extension subscriptionservices.
 */
@SuppressWarnings("all")
public class UsageUnitModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "UsageUnit";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageUnit.id</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageUnit.name</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageUnit.namePlural</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String NAMEPLURAL = "namePlural";
	
	/** <i>Generated constant</i> - Attribute key of <code>UsageUnit.accumulative</code> attribute defined at extension <code>subscriptionservices</code>. */
	public static final String ACCUMULATIVE = "accumulative";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public UsageUnitModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public UsageUnitModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>UsageUnit</code> at extension <code>subscriptionservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public UsageUnitModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>UsageUnit</code> at extension <code>subscriptionservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public UsageUnitModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageUnit.accumulative</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the accumulative - Accumulative
	 */
	@Accessor(qualifier = "accumulative", type = Accessor.Type.GETTER)
	public Boolean getAccumulative()
	{
		return getPersistenceContext().getPropertyValue(ACCUMULATIVE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageUnit.id</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageUnit.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageUnit.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @param loc the value localization key 
	 * @return the name - Name
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageUnit.namePlural</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @return the namePlural - Name (Plural)
	 */
	@Accessor(qualifier = "namePlural", type = Accessor.Type.GETTER)
	public String getNamePlural()
	{
		return getNamePlural(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>UsageUnit.namePlural</code> attribute defined at extension <code>subscriptionservices</code>. 
	 * @param loc the value localization key 
	 * @return the namePlural - Name (Plural)
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "namePlural", type = Accessor.Type.GETTER)
	public String getNamePlural(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAMEPLURAL, loc);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UsageUnit.accumulative</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the accumulative - Accumulative
	 */
	@Accessor(qualifier = "accumulative", type = Accessor.Type.SETTER)
	public void setAccumulative(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(ACCUMULATIVE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>UsageUnit.id</code> attribute defined at extension <code>subscriptionservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UsageUnit.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>UsageUnit.name</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the name - Name
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UsageUnit.namePlural</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the namePlural - Name (Plural)
	 */
	@Accessor(qualifier = "namePlural", type = Accessor.Type.SETTER)
	public void setNamePlural(final String value)
	{
		setNamePlural(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>UsageUnit.namePlural</code> attribute defined at extension <code>subscriptionservices</code>. 
	 *  
	 * @param value the namePlural - Name (Plural)
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "namePlural", type = Accessor.Type.SETTER)
	public void setNamePlural(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAMEPLURAL, loc, value);
	}
	
}
