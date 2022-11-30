/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.backoffice.model;

import com.hybris.backoffice.model.ThemeModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type CustomTheme first defined at extension backoffice.
 */
@SuppressWarnings("all")
public class CustomThemeModel extends ThemeModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CustomTheme";
	
	/** <i>Generated constant</i> - Attribute key of <code>CustomTheme.base</code> attribute defined at extension <code>backoffice</code>. */
	public static final String BASE = "base";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CustomThemeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CustomThemeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _base initial attribute declared by type <code>CustomTheme</code> at extension <code>backoffice</code>
	 * @param _code initial attribute declared by type <code>Theme</code> at extension <code>backoffice</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CustomThemeModel(final ThemeModel _base, final String _code)
	{
		super();
		setBase(_base);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _base initial attribute declared by type <code>CustomTheme</code> at extension <code>backoffice</code>
	 * @param _code initial attribute declared by type <code>Theme</code> at extension <code>backoffice</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CustomThemeModel(final ThemeModel _base, final String _code, final ItemModel _owner)
	{
		super();
		setBase(_base);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomTheme.base</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the base
	 */
	@Accessor(qualifier = "base", type = Accessor.Type.GETTER)
	public ThemeModel getBase()
	{
		return getPersistenceContext().getPropertyValue(BASE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CustomTheme.base</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the base
	 */
	@Accessor(qualifier = "base", type = Accessor.Type.SETTER)
	public void setBase(final ThemeModel value)
	{
		getPersistenceContext().setPropertyValue(BASE, value);
	}
	
}
