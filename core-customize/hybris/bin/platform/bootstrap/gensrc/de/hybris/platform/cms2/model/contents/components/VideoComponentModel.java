/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.model.contents.components;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2.enums.ThumbnailSelectorOptions;
import de.hybris.platform.cms2.model.contents.components.SimpleCMSComponentModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;

/**
 * Generated model class for type VideoComponent first defined at extension cms2.
 * <p>
 * It represents video map component that extends SimpleCMSComponent and contains one more attribute.
 */
@SuppressWarnings("all")
public class VideoComponentModel extends SimpleCMSComponentModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "VideoComponent";
	
	/**<i>Generated relation code constant for relation <code>VideoComponentsForContentPage</code> defining source attribute <code>contentPage</code> in extension <code>cms2</code>.</i>*/
	public static final String _VIDEOCOMPONENTSFORCONTENTPAGE = "VideoComponentsForContentPage";
	
	/**<i>Generated relation code constant for relation <code>VideoComponentsForProduct</code> defining source attribute <code>product</code> in extension <code>cms2</code>.</i>*/
	public static final String _VIDEOCOMPONENTSFORPRODUCT = "VideoComponentsForProduct";
	
	/**<i>Generated relation code constant for relation <code>VideoComponentsForCategory</code> defining source attribute <code>category</code> in extension <code>cms2</code>.</i>*/
	public static final String _VIDEOCOMPONENTSFORCATEGORY = "VideoComponentsForCategory";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.video</code> attribute defined at extension <code>cms2</code>. */
	public static final String VIDEO = "video";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.autoPlay</code> attribute defined at extension <code>cms2</code>. */
	public static final String AUTOPLAY = "autoPlay";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.loop</code> attribute defined at extension <code>cms2</code>. */
	public static final String LOOP = "loop";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.mute</code> attribute defined at extension <code>cms2</code>. */
	public static final String MUTE = "mute";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.thumbnailSelector</code> attribute defined at extension <code>cms2</code>. */
	public static final String THUMBNAILSELECTOR = "thumbnailSelector";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.thumbnail</code> attribute defined at extension <code>cms2</code>. */
	public static final String THUMBNAIL = "thumbnail";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.url</code> attribute defined at extension <code>cms2</code>. */
	public static final String URL = "url";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.contentPagePOS</code> attribute defined at extension <code>cms2</code>. */
	public static final String CONTENTPAGEPOS = "contentPagePOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.contentPage</code> attribute defined at extension <code>cms2</code>. */
	public static final String CONTENTPAGE = "contentPage";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.productPOS</code> attribute defined at extension <code>cms2</code>. */
	public static final String PRODUCTPOS = "productPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.product</code> attribute defined at extension <code>cms2</code>. */
	public static final String PRODUCT = "product";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.categoryPOS</code> attribute defined at extension <code>cms2</code>. */
	public static final String CATEGORYPOS = "categoryPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>VideoComponent.category</code> attribute defined at extension <code>cms2</code>. */
	public static final String CATEGORY = "category";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public VideoComponentModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public VideoComponentModel(final ItemModelContext ctx)
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
	public VideoComponentModel(final CatalogVersionModel _catalogVersion, final String _uid)
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
	public VideoComponentModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.autoPlay</code> attribute defined at extension <code>cms2</code>. 
	 * @return the autoPlay - the autoplay control for video
	 */
	@Accessor(qualifier = "autoPlay", type = Accessor.Type.GETTER)
	public Boolean getAutoPlay()
	{
		return getPersistenceContext().getPropertyValue(AUTOPLAY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.category</code> attribute defined at extension <code>cms2</code>. 
	 * @return the category
	 */
	@Accessor(qualifier = "category", type = Accessor.Type.GETTER)
	public CategoryModel getCategory()
	{
		return getPersistenceContext().getPropertyValue(CATEGORY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.contentPage</code> attribute defined at extension <code>cms2</code>. 
	 * @return the contentPage
	 */
	@Accessor(qualifier = "contentPage", type = Accessor.Type.GETTER)
	public ContentPageModel getContentPage()
	{
		return getPersistenceContext().getPropertyValue(CONTENTPAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.loop</code> attribute defined at extension <code>cms2</code>. 
	 * @return the loop - loop the video
	 */
	@Accessor(qualifier = "loop", type = Accessor.Type.GETTER)
	public Boolean getLoop()
	{
		return getPersistenceContext().getPropertyValue(LOOP);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.mute</code> attribute defined at extension <code>cms2</code>. 
	 * @return the mute - the mute control for video
	 */
	@Accessor(qualifier = "mute", type = Accessor.Type.GETTER)
	public Boolean getMute()
	{
		return getPersistenceContext().getPropertyValue(MUTE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.product</code> attribute defined at extension <code>cms2</code>. 
	 * @return the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.GETTER)
	public ProductModel getProduct()
	{
		return getPersistenceContext().getPropertyValue(PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.thumbnail</code> attribute defined at extension <code>cms2</code>. 
	 * @return the thumbnail - It is a media container containing images for specific resolutions
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.GETTER)
	public MediaContainerModel getThumbnail()
	{
		return getThumbnail(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.thumbnail</code> attribute defined at extension <code>cms2</code>. 
	 * @param loc the value localization key 
	 * @return the thumbnail - It is a media container containing images for specific resolutions
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.GETTER)
	public MediaContainerModel getThumbnail(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(THUMBNAIL, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.thumbnailSelector</code> attribute defined at extension <code>cms2</code>. 
	 * @return the thumbnailSelector - the thumbnail Selector for video, it has two options define at ThumbnailSelectorOptions
	 */
	@Accessor(qualifier = "thumbnailSelector", type = Accessor.Type.GETTER)
	public ThumbnailSelectorOptions getThumbnailSelector()
	{
		return getPersistenceContext().getPropertyValue(THUMBNAILSELECTOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.url</code> attribute defined at extension <code>cms2</code>. 
	 * @return the url - the url that the video component will linkTo
	 */
	@Accessor(qualifier = "url", type = Accessor.Type.GETTER)
	public String getUrl()
	{
		return getPersistenceContext().getPropertyValue(URL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.video</code> attribute defined at extension <code>cms2</code>. 
	 * @return the video - It is containing video
	 */
	@Accessor(qualifier = "video", type = Accessor.Type.GETTER)
	public MediaModel getVideo()
	{
		return getVideo(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>VideoComponent.video</code> attribute defined at extension <code>cms2</code>. 
	 * @param loc the value localization key 
	 * @return the video - It is containing video
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "video", type = Accessor.Type.GETTER)
	public MediaModel getVideo(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(VIDEO, loc);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.autoPlay</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the autoPlay - the autoplay control for video
	 */
	@Accessor(qualifier = "autoPlay", type = Accessor.Type.SETTER)
	public void setAutoPlay(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(AUTOPLAY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.category</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the category
	 */
	@Accessor(qualifier = "category", type = Accessor.Type.SETTER)
	public void setCategory(final CategoryModel value)
	{
		getPersistenceContext().setPropertyValue(CATEGORY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.contentPage</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the contentPage
	 */
	@Accessor(qualifier = "contentPage", type = Accessor.Type.SETTER)
	public void setContentPage(final ContentPageModel value)
	{
		getPersistenceContext().setPropertyValue(CONTENTPAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.loop</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the loop - loop the video
	 */
	@Accessor(qualifier = "loop", type = Accessor.Type.SETTER)
	public void setLoop(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(LOOP, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.mute</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the mute - the mute control for video
	 */
	@Accessor(qualifier = "mute", type = Accessor.Type.SETTER)
	public void setMute(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(MUTE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.product</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.SETTER)
	public void setProduct(final ProductModel value)
	{
		getPersistenceContext().setPropertyValue(PRODUCT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.thumbnail</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the thumbnail - It is a media container containing images for specific resolutions
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.SETTER)
	public void setThumbnail(final MediaContainerModel value)
	{
		setThumbnail(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.thumbnail</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the thumbnail - It is a media container containing images for specific resolutions
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.SETTER)
	public void setThumbnail(final MediaContainerModel value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(THUMBNAIL, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.thumbnailSelector</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the thumbnailSelector - the thumbnail Selector for video, it has two options define at ThumbnailSelectorOptions
	 */
	@Accessor(qualifier = "thumbnailSelector", type = Accessor.Type.SETTER)
	public void setThumbnailSelector(final ThumbnailSelectorOptions value)
	{
		getPersistenceContext().setPropertyValue(THUMBNAILSELECTOR, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.url</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the url - the url that the video component will linkTo
	 */
	@Accessor(qualifier = "url", type = Accessor.Type.SETTER)
	public void setUrl(final String value)
	{
		getPersistenceContext().setPropertyValue(URL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.video</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the video - It is containing video
	 */
	@Accessor(qualifier = "video", type = Accessor.Type.SETTER)
	public void setVideo(final MediaModel value)
	{
		setVideo(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>VideoComponent.video</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the video - It is containing video
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "video", type = Accessor.Type.SETTER)
	public void setVideo(final MediaModel value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(VIDEO, loc, value);
	}
	
}
