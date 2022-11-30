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
import de.hybris.platform.cms2.model.contents.components.SimpleCMSComponentModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;

/**
 * Generated model class for type PDFDocumentComponent first defined at extension cms2.
 * <p>
 * It represents PDF component that extends SimpleCMSComponent and contains one more attribute.
 */
@SuppressWarnings("all")
public class PDFDocumentComponentModel extends SimpleCMSComponentModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PDFDocumentComponent";
	
	/** <i>Generated constant</i> - Attribute key of <code>PDFDocumentComponent.pdfFile</code> attribute defined at extension <code>cms2</code>. */
	public static final String PDFFILE = "pdfFile";
	
	/** <i>Generated constant</i> - Attribute key of <code>PDFDocumentComponent.title</code> attribute defined at extension <code>cms2</code>. */
	public static final String TITLE = "title";
	
	/** <i>Generated constant</i> - Attribute key of <code>PDFDocumentComponent.height</code> attribute defined at extension <code>cms2</code>. */
	public static final String HEIGHT = "height";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PDFDocumentComponentModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PDFDocumentComponentModel(final ItemModelContext ctx)
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
	public PDFDocumentComponentModel(final CatalogVersionModel _catalogVersion, final String _uid)
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
	public PDFDocumentComponentModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PDFDocumentComponent.height</code> attribute defined at extension <code>cms2</code>. 
	 * @return the height
	 */
	@Accessor(qualifier = "height", type = Accessor.Type.GETTER)
	public Integer getHeight()
	{
		return getPersistenceContext().getPropertyValue(HEIGHT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PDFDocumentComponent.pdfFile</code> attribute defined at extension <code>cms2</code>. 
	 * @return the pdfFile - It is a Pdf container
	 */
	@Accessor(qualifier = "pdfFile", type = Accessor.Type.GETTER)
	public MediaModel getPdfFile()
	{
		return getPdfFile(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>PDFDocumentComponent.pdfFile</code> attribute defined at extension <code>cms2</code>. 
	 * @param loc the value localization key 
	 * @return the pdfFile - It is a Pdf container
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "pdfFile", type = Accessor.Type.GETTER)
	public MediaModel getPdfFile(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(PDFFILE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PDFDocumentComponent.title</code> attribute defined at extension <code>cms2</code>. 
	 * @return the title
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.GETTER)
	public String getTitle()
	{
		return getTitle(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>PDFDocumentComponent.title</code> attribute defined at extension <code>cms2</code>. 
	 * @param loc the value localization key 
	 * @return the title
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.GETTER)
	public String getTitle(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(TITLE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PDFDocumentComponent.height</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the height
	 */
	@Accessor(qualifier = "height", type = Accessor.Type.SETTER)
	public void setHeight(final Integer value)
	{
		getPersistenceContext().setPropertyValue(HEIGHT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PDFDocumentComponent.pdfFile</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the pdfFile - It is a Pdf container
	 */
	@Accessor(qualifier = "pdfFile", type = Accessor.Type.SETTER)
	public void setPdfFile(final MediaModel value)
	{
		setPdfFile(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>PDFDocumentComponent.pdfFile</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the pdfFile - It is a Pdf container
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "pdfFile", type = Accessor.Type.SETTER)
	public void setPdfFile(final MediaModel value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(PDFFILE, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PDFDocumentComponent.title</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the title
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.SETTER)
	public void setTitle(final String value)
	{
		setTitle(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>PDFDocumentComponent.title</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the title
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.SETTER)
	public void setTitle(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(TITLE, loc, value);
	}
	
}
