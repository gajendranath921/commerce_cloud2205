/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.backoffice.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;

/**
 * Generated model class for type Theme first defined at extension backoffice.
 */
@SuppressWarnings("all")
public class ThemeModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Theme";
	
	/** <i>Generated constant</i> - Attribute key of <code>Theme.code</code> attribute defined at extension <code>backoffice</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>Theme.name</code> attribute defined at extension <code>backoffice</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>Theme.thumbnail</code> attribute defined at extension <code>backoffice</code>. */
	public static final String THUMBNAIL = "thumbnail";
	
	/** <i>Generated constant</i> - Attribute key of <code>Theme.style</code> attribute defined at extension <code>backoffice</code>. */
	public static final String STYLE = "style";
	
	/** <i>Generated constant</i> - Attribute key of <code>Theme.sequence</code> attribute defined at extension <code>backoffice</code>. */
	public static final String SEQUENCE = "sequence";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ThemeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ThemeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Theme</code> at extension <code>backoffice</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ThemeModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Theme</code> at extension <code>backoffice</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ThemeModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Theme.code</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Theme.name</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Theme.name</code> attribute defined at extension <code>backoffice</code>. 
	 * @param loc the value localization key 
	 * @return the name
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Theme.sequence</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the sequence - Sequence for the theme list, this will affect the position of the list when getting list of theme lists, lower values are displayed first
	 */
	@Accessor(qualifier = "sequence", type = Accessor.Type.GETTER)
	public Integer getSequence()
	{
		return getPersistenceContext().getPropertyValue(SEQUENCE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Theme.style</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the style
	 */
	@Accessor(qualifier = "style", type = Accessor.Type.GETTER)
	public MediaModel getStyle()
	{
		return getPersistenceContext().getPropertyValue(STYLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Theme.thumbnail</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the thumbnail
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.GETTER)
	public MediaModel getThumbnail()
	{
		return getPersistenceContext().getPropertyValue(THUMBNAIL);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Theme.code</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Theme.name</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Theme.name</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the name
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Theme.sequence</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the sequence - Sequence for the theme list, this will affect the position of the list when getting list of theme lists, lower values are displayed first
	 */
	@Accessor(qualifier = "sequence", type = Accessor.Type.SETTER)
	public void setSequence(final Integer value)
	{
		getPersistenceContext().setPropertyValue(SEQUENCE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Theme.style</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the style
	 */
	@Accessor(qualifier = "style", type = Accessor.Type.SETTER)
	public void setStyle(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(STYLE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Theme.thumbnail</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the thumbnail
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.SETTER)
	public void setThumbnail(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(THUMBNAIL, value);
	}
	
}
