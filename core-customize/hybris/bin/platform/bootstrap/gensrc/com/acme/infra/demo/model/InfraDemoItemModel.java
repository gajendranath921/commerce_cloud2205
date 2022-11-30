/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.acme.infra.demo.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type InfraDemoItem first defined at extension kiwi.
 */
@SuppressWarnings("all")
public class InfraDemoItemModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "InfraDemoItem";
	
	/** <i>Generated constant</i> - Attribute key of <code>InfraDemoItem.exampleStringField</code> attribute defined at extension <code>kiwi</code>. */
	public static final String EXAMPLESTRINGFIELD = "exampleStringField";
	
	/** <i>Generated constant</i> - Attribute key of <code>InfraDemoItem.exampleNumberField</code> attribute defined at extension <code>kiwi</code>. */
	public static final String EXAMPLENUMBERFIELD = "exampleNumberField";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public InfraDemoItemModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public InfraDemoItemModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public InfraDemoItemModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InfraDemoItem.exampleNumberField</code> attribute defined at extension <code>kiwi</code>. 
	 * @return the exampleNumberField - Example Number Field
	 */
	@Accessor(qualifier = "exampleNumberField", type = Accessor.Type.GETTER)
	public Long getExampleNumberField()
	{
		return getPersistenceContext().getPropertyValue(EXAMPLENUMBERFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InfraDemoItem.exampleStringField</code> attribute defined at extension <code>kiwi</code>. 
	 * @return the exampleStringField - Example String Value
	 */
	@Accessor(qualifier = "exampleStringField", type = Accessor.Type.GETTER)
	public String getExampleStringField()
	{
		return getPersistenceContext().getPropertyValue(EXAMPLESTRINGFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>InfraDemoItem.exampleNumberField</code> attribute defined at extension <code>kiwi</code>. 
	 *  
	 * @param value the exampleNumberField - Example Number Field
	 */
	@Accessor(qualifier = "exampleNumberField", type = Accessor.Type.SETTER)
	public void setExampleNumberField(final Long value)
	{
		getPersistenceContext().setPropertyValue(EXAMPLENUMBERFIELD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>InfraDemoItem.exampleStringField</code> attribute defined at extension <code>kiwi</code>. 
	 *  
	 * @param value the exampleStringField - Example String Value
	 */
	@Accessor(qualifier = "exampleStringField", type = Accessor.Type.SETTER)
	public void setExampleStringField(final String value)
	{
		getPersistenceContext().setPropertyValue(EXAMPLESTRINGFIELD, value);
	}
	
}
