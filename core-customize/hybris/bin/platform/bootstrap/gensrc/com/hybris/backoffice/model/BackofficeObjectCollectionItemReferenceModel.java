/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.backoffice.model;

import com.hybris.backoffice.model.BackofficeObjectSpecialCollectionModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type BackofficeObjectCollectionItemReference first defined at extension backoffice.
 */
@SuppressWarnings("all")
public class BackofficeObjectCollectionItemReferenceModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "BackofficeObjectCollectionItemReference";
	
	/**<i>Generated relation code constant for relation <code>BackofficeCollection2ElementRelation</code> defining source attribute <code>collectionPk</code> in extension <code>backoffice</code>.</i>*/
	public static final String _BACKOFFICECOLLECTION2ELEMENTRELATION = "BackofficeCollection2ElementRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeObjectCollectionItemReference.product</code> attribute defined at extension <code>backoffice</code>. */
	public static final String PRODUCT = "product";
	
	/** <i>Generated constant</i> - Attribute key of <code>BackofficeObjectCollectionItemReference.collectionPk</code> attribute defined at extension <code>backoffice</code>. */
	public static final String COLLECTIONPK = "collectionPk";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public BackofficeObjectCollectionItemReferenceModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public BackofficeObjectCollectionItemReferenceModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _collectionPk initial attribute declared by type <code>BackofficeObjectCollectionItemReference</code> at extension <code>backoffice</code>
	 * @param _product initial attribute declared by type <code>BackofficeObjectCollectionItemReference</code> at extension <code>backoffice</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BackofficeObjectCollectionItemReferenceModel(final BackofficeObjectSpecialCollectionModel _collectionPk, final ProductModel _product)
	{
		super();
		setCollectionPk(_collectionPk);
		setProduct(_product);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _collectionPk initial attribute declared by type <code>BackofficeObjectCollectionItemReference</code> at extension <code>backoffice</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _product initial attribute declared by type <code>BackofficeObjectCollectionItemReference</code> at extension <code>backoffice</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BackofficeObjectCollectionItemReferenceModel(final BackofficeObjectSpecialCollectionModel _collectionPk, final ItemModel _owner, final ProductModel _product)
	{
		super();
		setCollectionPk(_collectionPk);
		setOwner(_owner);
		setProduct(_product);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeObjectCollectionItemReference.collectionPk</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the collectionPk
	 */
	@Accessor(qualifier = "collectionPk", type = Accessor.Type.GETTER)
	public BackofficeObjectSpecialCollectionModel getCollectionPk()
	{
		return getPersistenceContext().getPropertyValue(COLLECTIONPK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BackofficeObjectCollectionItemReference.product</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.GETTER)
	public ProductModel getProduct()
	{
		return getPersistenceContext().getPropertyValue(PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeObjectCollectionItemReference.collectionPk</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the collectionPk
	 */
	@Accessor(qualifier = "collectionPk", type = Accessor.Type.SETTER)
	public void setCollectionPk(final BackofficeObjectSpecialCollectionModel value)
	{
		getPersistenceContext().setPropertyValue(COLLECTIONPK, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BackofficeObjectCollectionItemReference.product</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.SETTER)
	public void setProduct(final ProductModel value)
	{
		getPersistenceContext().setPropertyValue(PRODUCT, value);
	}
	
}
