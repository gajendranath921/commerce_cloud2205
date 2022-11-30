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
import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.model.AbstractIntegrationObjectItemAttributeModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type IntegrationObjectItemClassificationAttribute first defined at extension integrationservices.
 * <p>
 * An Integration Object Item Attribute that uses classification attributes.
 */
@SuppressWarnings("all")
public class IntegrationObjectItemClassificationAttributeModel extends AbstractIntegrationObjectItemAttributeModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObjectItemClassificationAttribute";
	
	/**<i>Generated relation code constant for relation <code>IntegObjItem2ClassificationIntegObjItemAttr</code> defining source attribute <code>integrationObjectItem</code> in extension <code>integrationservices</code>.</i>*/
	public static final String _INTEGOBJITEM2CLASSIFICATIONINTEGOBJITEMATTR = "IntegObjItem2ClassificationIntegObjItemAttr";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemClassificationAttribute.classAttributeAssignment</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CLASSATTRIBUTEASSIGNMENT = "classAttributeAssignment";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItemClassificationAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONOBJECTITEM = "integrationObjectItem";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectItemClassificationAttributeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectItemClassificationAttributeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _classAttributeAssignment initial attribute declared by type <code>IntegrationObjectItemClassificationAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectItem initial attribute declared by type <code>IntegrationObjectItemClassificationAttribute</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemClassificationAttributeModel(final String _attributeName, final ClassAttributeAssignmentModel _classAttributeAssignment, final IntegrationObjectItemModel _integrationObjectItem)
	{
		super();
		setAttributeName(_attributeName);
		setClassAttributeAssignment(_classAttributeAssignment);
		setIntegrationObjectItem(_integrationObjectItem);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>AbstractIntegrationObjectItemAttribute</code> at extension <code>integrationservices</code>
	 * @param _classAttributeAssignment initial attribute declared by type <code>IntegrationObjectItemClassificationAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectItem initial attribute declared by type <code>IntegrationObjectItemClassificationAttribute</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemClassificationAttributeModel(final String _attributeName, final ClassAttributeAssignmentModel _classAttributeAssignment, final IntegrationObjectItemModel _integrationObjectItem, final ItemModel _owner)
	{
		super();
		setAttributeName(_attributeName);
		setClassAttributeAssignment(_classAttributeAssignment);
		setIntegrationObjectItem(_integrationObjectItem);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemClassificationAttribute.classAttributeAssignment</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the classAttributeAssignment
	 */
	@Accessor(qualifier = "classAttributeAssignment", type = Accessor.Type.GETTER)
	public ClassAttributeAssignmentModel getClassAttributeAssignment()
	{
		return getPersistenceContext().getPropertyValue(CLASSATTRIBUTEASSIGNMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemClassificationAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationObjectItem
	 */
	@Accessor(qualifier = "integrationObjectItem", type = Accessor.Type.GETTER)
	public IntegrationObjectItemModel getIntegrationObjectItem()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECTITEM);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItemClassificationAttribute.classAttributeAssignment</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the classAttributeAssignment
	 */
	@Accessor(qualifier = "classAttributeAssignment", type = Accessor.Type.SETTER)
	public void setClassAttributeAssignment(final ClassAttributeAssignmentModel value)
	{
		getPersistenceContext().setPropertyValue(CLASSATTRIBUTEASSIGNMENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItemClassificationAttribute.integrationObjectItem</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationObjectItem
	 */
	@Accessor(qualifier = "integrationObjectItem", type = Accessor.Type.SETTER)
	public void setIntegrationObjectItem(final IntegrationObjectItemModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECTITEM, value);
	}
	
}
