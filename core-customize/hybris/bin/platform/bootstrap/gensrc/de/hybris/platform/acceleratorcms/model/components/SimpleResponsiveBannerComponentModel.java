/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorcms.model.components;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.acceleratorcms.model.components.AbstractResponsiveBannerComponentModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type SimpleResponsiveBannerComponent first defined at extension acceleratorcms.
 * <p>
 * Concrete implementation of abstract responsive banner component.
 */
@SuppressWarnings("all")
public class SimpleResponsiveBannerComponentModel extends AbstractResponsiveBannerComponentModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SimpleResponsiveBannerComponent";
	
	/**<i>Generated relation code constant for relation <code>SimpleResponsiveBannerComponentsForContentPage</code> defining source attribute <code>contentPage</code> in extension <code>acceleratorcms</code>.</i>*/
	public static final String _SIMPLERESPONSIVEBANNERCOMPONENTSFORCONTENTPAGE = "SimpleResponsiveBannerComponentsForContentPage";
	
	/**<i>Generated relation code constant for relation <code>SimpleResponsiveBannerComponentsForProduct</code> defining source attribute <code>product</code> in extension <code>acceleratorcms</code>.</i>*/
	public static final String _SIMPLERESPONSIVEBANNERCOMPONENTSFORPRODUCT = "SimpleResponsiveBannerComponentsForProduct";
	
	/**<i>Generated relation code constant for relation <code>SimpleResponsiveBannerComponentsForCategory</code> defining source attribute <code>category</code> in extension <code>acceleratorcms</code>.</i>*/
	public static final String _SIMPLERESPONSIVEBANNERCOMPONENTSFORCATEGORY = "SimpleResponsiveBannerComponentsForCategory";
	
	/** <i>Generated constant</i> - Attribute key of <code>SimpleResponsiveBannerComponent.contentPagePOS</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String CONTENTPAGEPOS = "contentPagePOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SimpleResponsiveBannerComponent.contentPage</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String CONTENTPAGE = "contentPage";
	
	/** <i>Generated constant</i> - Attribute key of <code>SimpleResponsiveBannerComponent.productPOS</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String PRODUCTPOS = "productPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SimpleResponsiveBannerComponent.product</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String PRODUCT = "product";
	
	/** <i>Generated constant</i> - Attribute key of <code>SimpleResponsiveBannerComponent.categoryPOS</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String CATEGORYPOS = "categoryPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SimpleResponsiveBannerComponent.category</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String CATEGORY = "category";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SimpleResponsiveBannerComponentModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SimpleResponsiveBannerComponentModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SimpleResponsiveBannerComponentModel(final CatalogVersionModel _catalogVersion, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SimpleResponsiveBannerComponentModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleResponsiveBannerComponent.category</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the category
	 */
	@Accessor(qualifier = "category", type = Accessor.Type.GETTER)
	public CategoryModel getCategory()
	{
		return getPersistenceContext().getPropertyValue(CATEGORY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleResponsiveBannerComponent.contentPage</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the contentPage
	 */
	@Accessor(qualifier = "contentPage", type = Accessor.Type.GETTER)
	public ContentPageModel getContentPage()
	{
		return getPersistenceContext().getPropertyValue(CONTENTPAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleResponsiveBannerComponent.product</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.GETTER)
	public ProductModel getProduct()
	{
		return getPersistenceContext().getPropertyValue(PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SimpleResponsiveBannerComponent.category</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the category
	 */
	@Accessor(qualifier = "category", type = Accessor.Type.SETTER)
	public void setCategory(final CategoryModel value)
	{
		getPersistenceContext().setPropertyValue(CATEGORY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SimpleResponsiveBannerComponent.contentPage</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the contentPage
	 */
	@Accessor(qualifier = "contentPage", type = Accessor.Type.SETTER)
	public void setContentPage(final ContentPageModel value)
	{
		getPersistenceContext().setPropertyValue(CONTENTPAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SimpleResponsiveBannerComponent.product</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.SETTER)
	public void setProduct(final ProductModel value)
	{
		getPersistenceContext().setPropertyValue(PRODUCT, value);
	}
	
}
