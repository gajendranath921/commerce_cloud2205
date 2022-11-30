/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.backoffice.model;

import com.hybris.backoffice.enums.BackofficeSpecialCollectionType;
import com.hybris.backoffice.model.BackofficeObjectCollectionItemReferenceModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type BackofficeObjectSpecialCollection first defined at extension backoffice.
 */
@SuppressWarnings("all")
public class BackofficeObjectSpecialCollectionModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "BackofficeObjectSpecialCollection";
	
	/**<i>Generated relation code constant for relation <code>User2BackofficeObjectCollectionRelation</code> defining source attribute <code>user</code> in extension <code>backoffice</code>.</i>*/
	public static final String _USER2BACKOFFICEOBJECTCOLLECTIONRELATION = "User2BackofficeObjectCollectionRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeObjectSpecialCollection.collectionType</code> attribute defined at extension <code>backoffice</code>. */
	public static final String COLLECTIONTYPE = "collectionType";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeObjectSpecialCollection.user</code> attribute defined at extension <code>backoffice</code>. */
	public static final String USER = "user";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeObjectSpecialCollection.elements</code> attribute defined at extension <code>backoffice</code>. */
	public static final String ELEMENTS = "elements";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public BackofficeObjectSpecialCollectionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public BackofficeObjectSpecialCollectionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _collectionType initial attribute declared by type <code>BackofficeObjectSpecialCollection</code> at extension <code>backoffice</code>
	 * @param _user initial attribute declared by type <code>BackofficeObjectSpecialCollection</code> at extension <code>backoffice</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BackofficeObjectSpecialCollectionModel(final BackofficeSpecialCollectionType _collectionType, final UserModel _user)
	{
		super();
		setCollectionType(_collectionType);
		setUser(_user);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _collectionType initial attribute declared by type <code>BackofficeObjectSpecialCollection</code> at extension <code>backoffice</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>BackofficeObjectSpecialCollection</code> at extension <code>backoffice</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BackofficeObjectSpecialCollectionModel(final BackofficeSpecialCollectionType _collectionType, final ItemModel _owner, final UserModel _user)
	{
		super();
		setCollectionType(_collectionType);
		setOwner(_owner);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeObjectSpecialCollection.collectionType</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the collectionType
	 */
	@Accessor(qualifier = "collectionType", type = Accessor.Type.GETTER)
	public BackofficeSpecialCollectionType getCollectionType()
	{
		return getPersistenceContext().getPropertyValue(COLLECTIONTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeObjectSpecialCollection.elements</code> attribute defined at extension <code>backoffice</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the elements
	 */
	@Accessor(qualifier = "elements", type = Accessor.Type.GETTER)
	public List<BackofficeObjectCollectionItemReferenceModel> getElements()
	{
		return getPersistenceContext().getPropertyValue(ELEMENTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeObjectSpecialCollection.user</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.GETTER)
	public UserModel getUser()
	{
		return getPersistenceContext().getPropertyValue(USER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeObjectSpecialCollection.collectionType</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the collectionType
	 */
	@Accessor(qualifier = "collectionType", type = Accessor.Type.SETTER)
	public void setCollectionType(final BackofficeSpecialCollectionType value)
	{
		getPersistenceContext().setPropertyValue(COLLECTIONTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeObjectSpecialCollection.elements</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the elements
	 */
	@Accessor(qualifier = "elements", type = Accessor.Type.SETTER)
	public void setElements(final List<BackofficeObjectCollectionItemReferenceModel> value)
	{
		getPersistenceContext().setPropertyValue(ELEMENTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeObjectSpecialCollection.user</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.SETTER)
	public void setUser(final UserModel value)
	{
		getPersistenceContext().setPropertyValue(USER, value);
	}
	
}
