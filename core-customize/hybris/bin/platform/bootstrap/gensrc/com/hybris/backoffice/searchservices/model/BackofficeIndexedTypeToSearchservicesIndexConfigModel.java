/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.backoffice.searchservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.searchservices.model.SnIndexConfigurationModel;
import de.hybris.platform.searchservices.model.SnIndexTypeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type BackofficeIndexedTypeToSearchservicesIndexConfig first defined at extension backofficesearchservices.
 */
@SuppressWarnings("all")
public class BackofficeIndexedTypeToSearchservicesIndexConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "BackofficeIndexedTypeToSearchservicesIndexConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.indexedType</code> attribute defined at extension <code>backofficesearchservices</code>. */
	public static final String INDEXEDTYPE = "indexedType";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.snIndexConfiguration</code> attribute defined at extension <code>backofficesearchservices</code>. */
	public static final String SNINDEXCONFIGURATION = "snIndexConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.snIndexType</code> attribute defined at extension <code>backofficesearchservices</code>. */
	public static final String SNINDEXTYPE = "snIndexType";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.active</code> attribute defined at extension <code>backofficesearchservices</code>. */
	public static final String ACTIVE = "active";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public BackofficeIndexedTypeToSearchservicesIndexConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public BackofficeIndexedTypeToSearchservicesIndexConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _indexedType initial attribute declared by type <code>BackofficeIndexedTypeToSearchservicesIndexConfig</code> at extension <code>backofficesearchservices</code>
	 * @param _snIndexConfiguration initial attribute declared by type <code>BackofficeIndexedTypeToSearchservicesIndexConfig</code> at extension <code>backofficesearchservices</code>
	 * @param _snIndexType initial attribute declared by type <code>BackofficeIndexedTypeToSearchservicesIndexConfig</code> at extension <code>backofficesearchservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BackofficeIndexedTypeToSearchservicesIndexConfigModel(final ComposedTypeModel _indexedType, final SnIndexConfigurationModel _snIndexConfiguration, final SnIndexTypeModel _snIndexType)
	{
		super();
		setIndexedType(_indexedType);
		setSnIndexConfiguration(_snIndexConfiguration);
		setSnIndexType(_snIndexType);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _indexedType initial attribute declared by type <code>BackofficeIndexedTypeToSearchservicesIndexConfig</code> at extension <code>backofficesearchservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _snIndexConfiguration initial attribute declared by type <code>BackofficeIndexedTypeToSearchservicesIndexConfig</code> at extension <code>backofficesearchservices</code>
	 * @param _snIndexType initial attribute declared by type <code>BackofficeIndexedTypeToSearchservicesIndexConfig</code> at extension <code>backofficesearchservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BackofficeIndexedTypeToSearchservicesIndexConfigModel(final ComposedTypeModel _indexedType, final ItemModel _owner, final SnIndexConfigurationModel _snIndexConfiguration, final SnIndexTypeModel _snIndexType)
	{
		super();
		setIndexedType(_indexedType);
		setOwner(_owner);
		setSnIndexConfiguration(_snIndexConfiguration);
		setSnIndexType(_snIndexType);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeIndexedTypeToSearchservicesIndexConfig.indexedType</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 * @return the indexedType
	 */
	@Accessor(qualifier = "indexedType", type = Accessor.Type.GETTER)
	public ComposedTypeModel getIndexedType()
	{
		return getPersistenceContext().getPropertyValue(INDEXEDTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeIndexedTypeToSearchservicesIndexConfig.snIndexConfiguration</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 * @return the snIndexConfiguration
	 */
	@Accessor(qualifier = "snIndexConfiguration", type = Accessor.Type.GETTER)
	public SnIndexConfigurationModel getSnIndexConfiguration()
	{
		return getPersistenceContext().getPropertyValue(SNINDEXCONFIGURATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeIndexedTypeToSearchservicesIndexConfig.snIndexType</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 * @return the snIndexType
	 */
	@Accessor(qualifier = "snIndexType", type = Accessor.Type.GETTER)
	public SnIndexTypeModel getSnIndexType()
	{
		return getPersistenceContext().getPropertyValue(SNINDEXTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeIndexedTypeToSearchservicesIndexConfig.active</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 * @return the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.GETTER)
	public boolean isActive()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(ACTIVE));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.active</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 *  
	 * @param value the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.SETTER)
	public void setActive(final boolean value)
	{
		getPersistenceContext().setPropertyValue(ACTIVE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.indexedType</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 *  
	 * @param value the indexedType
	 */
	@Accessor(qualifier = "indexedType", type = Accessor.Type.SETTER)
	public void setIndexedType(final ComposedTypeModel value)
	{
		getPersistenceContext().setPropertyValue(INDEXEDTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.snIndexConfiguration</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 *  
	 * @param value the snIndexConfiguration
	 */
	@Accessor(qualifier = "snIndexConfiguration", type = Accessor.Type.SETTER)
	public void setSnIndexConfiguration(final SnIndexConfigurationModel value)
	{
		getPersistenceContext().setPropertyValue(SNINDEXCONFIGURATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeIndexedTypeToSearchservicesIndexConfig.snIndexType</code> attribute defined at extension <code>backofficesearchservices</code>. 
	 *  
	 * @param value the snIndexType
	 */
	@Accessor(qualifier = "snIndexType", type = Accessor.Type.SETTER)
	public void setSnIndexType(final SnIndexTypeModel value)
	{
		getPersistenceContext().setPropertyValue(SNINDEXTYPE, value);
	}
	
}
