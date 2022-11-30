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
import de.hybris.platform.integrationservices.model.AbstractIntegrationObjectItemAttributeModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectVirtualAttributeDescriptorModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type IntegrationObjectItemVirtualAttribute first defined at extension integrationservices.
 * <p>
 * An Integration Object Item Attribute that exists virtually by executing the specified logic referenced in the descriptors.
 */
@SuppressWarnings("all")
public class IntegrationObjectItemVirtualAttributeModel extends AbstractIntegrationObjectItemAttributeModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObjectItemVirtualAttribute";
	
	/**<i>Generated relation code constant for relation <code>IntegObjItem2VirtualIntegObjItemAttr</code> defining source attribute <code>integrationObjectItem</code> in extension <code>integrationservices</code>.</i>*/
	public static final String _INTEGOBJITEM2VIRTUALINTEGOBJITEMATTR = "IntegObjItem2VirtualIntegObjItemAttr";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemVirtualAttribute.retrievalDescriptor</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String RETRIEVALDESCRIPTOR = "retrievalDescriptor";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemVirtualAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONOBJECTITEM = "integrationObjectItem";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectItemVirtualAttributeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectItemVirtualAttributeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectItem initial attribute declared by type <code>IntegrationObjectItemVirtualAttribute</code> at extension <code>integrationservices</code>
	 * @param _retrievalDescriptor initial attribute declared by type <code>IntegrationObjectItemVirtualAttribute</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemVirtualAttributeModel(final String _attributeName, final IntegrationObjectItemModel _integrationObjectItem, final IntegrationObjectVirtualAttributeDescriptorModel _retrievalDescriptor)
	{
		super();
		setAttributeName(_attributeName);
		setIntegrationObjectItem(_integrationObjectItem);
		setRetrievalDescriptor(_retrievalDescriptor);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectItem initial attribute declared by type <code>IntegrationObjectItemVirtualAttribute</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _retrievalDescriptor initial attribute declared by type <code>IntegrationObjectItemVirtualAttribute</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemVirtualAttributeModel(final String _attributeName, final IntegrationObjectItemModel _integrationObjectItem, final ItemModel _owner, final IntegrationObjectVirtualAttributeDescriptorModel _retrievalDescriptor)
	{
		super();
		setAttributeName(_attributeName);
		setIntegrationObjectItem(_integrationObjectItem);
		setOwner(_owner);
		setRetrievalDescriptor(_retrievalDescriptor);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemVirtualAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationObjectItem
	 */
	@Accessor(qualifier = "integrationObjectItem", type = Accessor.Type.GETTER)
	public IntegrationObjectItemModel getIntegrationObjectItem()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECTITEM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemVirtualAttribute.retrievalDescriptor</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the retrievalDescriptor
	 */
	@Accessor(qualifier = "retrievalDescriptor", type = Accessor.Type.GETTER)
	public IntegrationObjectVirtualAttributeDescriptorModel getRetrievalDescriptor()
	{
		return getPersistenceContext().getPropertyValue(RETRIEVALDESCRIPTOR);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItemVirtualAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationObjectItem
	 */
	@Accessor(qualifier = "integrationObjectItem", type = Accessor.Type.SETTER)
	public void setIntegrationObjectItem(final IntegrationObjectItemModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECTITEM, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItemVirtualAttribute.retrievalDescriptor</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the retrievalDescriptor
	 */
	@Accessor(qualifier = "retrievalDescriptor", type = Accessor.Type.SETTER)
	public void setRetrievalDescriptor(final IntegrationObjectVirtualAttributeDescriptorModel value)
	{
		getPersistenceContext().setPropertyValue(RETRIEVALDESCRIPTOR, value);
	}
	
}
