/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.integrationservices.model.AbstractIntegrationObjectItemAttributeModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type IntegrationObjectItemAttribute first defined at extension integrationservices.
 * <p>
 * An Integration Object Item Attribute that uses standard type system attributes.
 */
@SuppressWarnings("all")
public class IntegrationObjectItemAttributeModel extends AbstractIntegrationObjectItemAttributeModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObjectItemAttribute";
	
	/**<i>Generated relation code constant for relation <code>IntegObjItem2IntegObjItemAttr</code> defining source attribute <code>integrationObjectItem</code> in extension <code>integrationservices</code>.</i>*/
	public static final String _INTEGOBJITEM2INTEGOBJITEMATTR = "IntegObjItem2IntegObjItemAttr";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ATTRIBUTEDESCRIPTOR = "attributeDescriptor";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemAttribute.unique</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String UNIQUE = "unique";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemAttribute.partOf</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String PARTOF = "partOf";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONOBJECTITEM = "integrationObjectItem";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectItemAttributeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectItemAttributeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeDescriptor initial attribute declared by type <code>IntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectItem initial attribute declared by type <code>IntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemAttributeModel(final AttributeDescriptorModel _attributeDescriptor, final String _attributeName, final IntegrationObjectItemModel _integrationObjectItem)
	{
		super();
		setAttributeDescriptor(_attributeDescriptor);
		setAttributeName(_attributeName);
		setIntegrationObjectItem(_integrationObjectItem);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeDescriptor initial attribute declared by type <code>IntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectItem initial attribute declared by type <code>IntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemAttributeModel(final AttributeDescriptorModel _attributeDescriptor, final String _attributeName, final IntegrationObjectItemModel _integrationObjectItem, final ItemModel _owner)
	{
		super();
		setAttributeDescriptor(_attributeDescriptor);
		setAttributeName(_attributeName);
		setIntegrationObjectItem(_integrationObjectItem);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the attributeDescriptor
	 */
	@Accessor(qualifier = "attributeDescriptor", type = Accessor.Type.GETTER)
	public AttributeDescriptorModel getAttributeDescriptor()
	{
		return getPersistenceContext().getPropertyValue(ATTRIBUTEDESCRIPTOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationObjectItem
	 */
	@Accessor(qualifier = "integrationObjectItem", type = Accessor.Type.GETTER)
	public IntegrationObjectItemModel getIntegrationObjectItem()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECTITEM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.partOf</code> dynamic attribute defined at extension <code>integrationservices</code>. 
	 * @return the partOf
	 */
	@Accessor(qualifier = "partOf", type = Accessor.Type.GETTER)
	public Boolean getPartOf()
	{
		return getPersistenceContext().getDynamicValue(this,PARTOF);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.unique</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the unique
	 */
	@Accessor(qualifier = "unique", type = Accessor.Type.GETTER)
	public Boolean getUnique()
	{
		return getPersistenceContext().getPropertyValue(UNIQUE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the attributeDescriptor
	 */
	@Accessor(qualifier = "attributeDescriptor", type = Accessor.Type.SETTER)
	public void setAttributeDescriptor(final AttributeDescriptorModel value)
	{
		getPersistenceContext().setPropertyValue(ATTRIBUTEDESCRIPTOR, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationObjectItem
	 */
	@Accessor(qualifier = "integrationObjectItem", type = Accessor.Type.SETTER)
	public void setIntegrationObjectItem(final IntegrationObjectItemModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECTITEM, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItemAttribute.unique</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the unique
	 */
	@Accessor(qualifier = "unique", type = Accessor.Type.SETTER)
	public void setUnique(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(UNIQUE, value);
	}
	
}
