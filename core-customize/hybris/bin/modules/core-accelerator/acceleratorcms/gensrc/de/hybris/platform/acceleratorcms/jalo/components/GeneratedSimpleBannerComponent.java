/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorcms.jalo.components;

import de.hybris.platform.acceleratorcms.constants.AcceleratorCmsConstants;
import de.hybris.platform.category.jalo.Category;
import de.hybris.platform.cms2.jalo.pages.ContentPage;
import de.hybris.platform.cms2lib.components.AbstractBannerComponent;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.acceleratorcms.jalo.components.SimpleBannerComponent SimpleBannerComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedSimpleBannerComponent extends AbstractBannerComponent
{
	/** Qualifier of the <code>SimpleBannerComponent.contentPagePOS</code> attribute **/
	public static final String CONTENTPAGEPOS = "contentPagePOS";
	/** Qualifier of the <code>SimpleBannerComponent.contentPage</code> attribute **/
	public static final String CONTENTPAGE = "contentPage";
	/** Qualifier of the <code>SimpleBannerComponent.productPOS</code> attribute **/
	public static final String PRODUCTPOS = "productPOS";
	/** Qualifier of the <code>SimpleBannerComponent.product</code> attribute **/
	public static final String PRODUCT = "product";
	/** Qualifier of the <code>SimpleBannerComponent.categoryPOS</code> attribute **/
	public static final String CATEGORYPOS = "categoryPOS";
	/** Qualifier of the <code>SimpleBannerComponent.category</code> attribute **/
	public static final String CATEGORY = "category";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n CONTENTPAGE's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedSimpleBannerComponent> CONTENTPAGEHANDLER = new BidirectionalOneToManyHandler<GeneratedSimpleBannerComponent>(
	AcceleratorCmsConstants.TC.SIMPLEBANNERCOMPONENT,
	false,
	"contentPage",
	"contentPagePOS",
	true,
	true,
	CollectionType.LIST
	);
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n PRODUCT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedSimpleBannerComponent> PRODUCTHANDLER = new BidirectionalOneToManyHandler<GeneratedSimpleBannerComponent>(
	AcceleratorCmsConstants.TC.SIMPLEBANNERCOMPONENT,
	false,
	"product",
	"productPOS",
	true,
	true,
	CollectionType.LIST
	);
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n CATEGORY's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedSimpleBannerComponent> CATEGORYHANDLER = new BidirectionalOneToManyHandler<GeneratedSimpleBannerComponent>(
	AcceleratorCmsConstants.TC.SIMPLEBANNERCOMPONENT,
	false,
	"category",
	"categoryPOS",
	true,
	true,
	CollectionType.LIST
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(AbstractBannerComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CONTENTPAGEPOS, AttributeMode.INITIAL);
		tmp.put(CONTENTPAGE, AttributeMode.INITIAL);
		tmp.put(PRODUCTPOS, AttributeMode.INITIAL);
		tmp.put(PRODUCT, AttributeMode.INITIAL);
		tmp.put(CATEGORYPOS, AttributeMode.INITIAL);
		tmp.put(CATEGORY, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.category</code> attribute.
	 * @return the category
	 */
	public Category getCategory(final SessionContext ctx)
	{
		return (Category)getProperty( ctx, CATEGORY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.category</code> attribute.
	 * @return the category
	 */
	public Category getCategory()
	{
		return getCategory( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.category</code> attribute. 
	 * @param value the category
	 */
	public void setCategory(final SessionContext ctx, final Category value)
	{
		CATEGORYHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.category</code> attribute. 
	 * @param value the category
	 */
	public void setCategory(final Category value)
	{
		setCategory( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.categoryPOS</code> attribute.
	 * @return the categoryPOS
	 */
	 Integer getCategoryPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, CATEGORYPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.categoryPOS</code> attribute.
	 * @return the categoryPOS
	 */
	 Integer getCategoryPOS()
	{
		return getCategoryPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.categoryPOS</code> attribute. 
	 * @return the categoryPOS
	 */
	 int getCategoryPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getCategoryPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.categoryPOS</code> attribute. 
	 * @return the categoryPOS
	 */
	 int getCategoryPOSAsPrimitive()
	{
		return getCategoryPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.categoryPOS</code> attribute. 
	 * @param value the categoryPOS
	 */
	 void setCategoryPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, CATEGORYPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.categoryPOS</code> attribute. 
	 * @param value the categoryPOS
	 */
	 void setCategoryPOS(final Integer value)
	{
		setCategoryPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.categoryPOS</code> attribute. 
	 * @param value the categoryPOS
	 */
	 void setCategoryPOS(final SessionContext ctx, final int value)
	{
		setCategoryPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.categoryPOS</code> attribute. 
	 * @param value the categoryPOS
	 */
	 void setCategoryPOS(final int value)
	{
		setCategoryPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.contentPage</code> attribute.
	 * @return the contentPage
	 */
	public ContentPage getContentPage(final SessionContext ctx)
	{
		return (ContentPage)getProperty( ctx, CONTENTPAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.contentPage</code> attribute.
	 * @return the contentPage
	 */
	public ContentPage getContentPage()
	{
		return getContentPage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.contentPage</code> attribute. 
	 * @param value the contentPage
	 */
	public void setContentPage(final SessionContext ctx, final ContentPage value)
	{
		CONTENTPAGEHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.contentPage</code> attribute. 
	 * @param value the contentPage
	 */
	public void setContentPage(final ContentPage value)
	{
		setContentPage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute.
	 * @return the contentPagePOS
	 */
	 Integer getContentPagePOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, CONTENTPAGEPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute.
	 * @return the contentPagePOS
	 */
	 Integer getContentPagePOS()
	{
		return getContentPagePOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute. 
	 * @return the contentPagePOS
	 */
	 int getContentPagePOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getContentPagePOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute. 
	 * @return the contentPagePOS
	 */
	 int getContentPagePOSAsPrimitive()
	{
		return getContentPagePOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute. 
	 * @param value the contentPagePOS
	 */
	 void setContentPagePOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, CONTENTPAGEPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute. 
	 * @param value the contentPagePOS
	 */
	 void setContentPagePOS(final Integer value)
	{
		setContentPagePOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute. 
	 * @param value the contentPagePOS
	 */
	 void setContentPagePOS(final SessionContext ctx, final int value)
	{
		setContentPagePOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.contentPagePOS</code> attribute. 
	 * @param value the contentPagePOS
	 */
	 void setContentPagePOS(final int value)
	{
		setContentPagePOS( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		CONTENTPAGEHANDLER.newInstance(ctx, allAttributes);
		PRODUCTHANDLER.newInstance(ctx, allAttributes);
		CATEGORYHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct(final SessionContext ctx)
	{
		return (Product)getProperty( ctx, PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct()
	{
		return getProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final SessionContext ctx, final Product value)
	{
		PRODUCTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final Product value)
	{
		setProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.productPOS</code> attribute.
	 * @return the productPOS
	 */
	 Integer getProductPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, PRODUCTPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.productPOS</code> attribute.
	 * @return the productPOS
	 */
	 Integer getProductPOS()
	{
		return getProductPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.productPOS</code> attribute. 
	 * @return the productPOS
	 */
	 int getProductPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getProductPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleBannerComponent.productPOS</code> attribute. 
	 * @return the productPOS
	 */
	 int getProductPOSAsPrimitive()
	{
		return getProductPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.productPOS</code> attribute. 
	 * @param value the productPOS
	 */
	 void setProductPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, PRODUCTPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.productPOS</code> attribute. 
	 * @param value the productPOS
	 */
	 void setProductPOS(final Integer value)
	{
		setProductPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.productPOS</code> attribute. 
	 * @param value the productPOS
	 */
	 void setProductPOS(final SessionContext ctx, final int value)
	{
		setProductPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleBannerComponent.productPOS</code> attribute. 
	 * @param value the productPOS
	 */
	 void setProductPOS(final int value)
	{
		setProductPOS( getSession().getSessionContext(), value );
	}
	
}
