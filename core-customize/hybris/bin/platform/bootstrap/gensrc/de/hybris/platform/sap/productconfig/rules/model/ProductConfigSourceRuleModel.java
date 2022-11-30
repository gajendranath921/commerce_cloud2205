/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.rules.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.ruleengineservices.model.SourceRuleModel;
import de.hybris.platform.sap.productconfig.rules.enums.ProductConfigRuleMessageSeverity;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.store.BaseStoreModel;
import java.util.Set;

/**
 * Generated model class for type ProductConfigSourceRule first defined at extension sapproductconfigrules.
 */
@SuppressWarnings("all")
public class ProductConfigSourceRuleModel extends SourceRuleModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProductConfigSourceRule";
	
	/**<i>Generated relation code constant for relation <code>BaseStoreForCPQRule</code> defining source attribute <code>baseStores</code> in extension <code>sapproductconfigrules</code>.</i>*/
	public static final String _BASESTOREFORCPQRULE = "BaseStoreForCPQRule";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductConfigSourceRule.messageSeverity</code> attribute defined at extension <code>sapproductconfigrules</code>. */
	public static final String MESSAGESEVERITY = "messageSeverity";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductConfigSourceRule.messageForCstic</code> attribute defined at extension <code>sapproductconfigrules</code>. */
	public static final String MESSAGEFORCSTIC = "messageForCstic";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductConfigSourceRule.baseStores</code> attribute defined at extension <code>sapproductconfigrules</code>. */
	public static final String BASESTORES = "baseStores";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProductConfigSourceRuleModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProductConfigSourceRuleModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractRule</code> at extension <code>ruleengineservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProductConfigSourceRuleModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractRule</code> at extension <code>ruleengineservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uuid initial attribute declared by type <code>AbstractRule</code> at extension <code>ruleengineservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProductConfigSourceRuleModel(final String _code, final ItemModel _owner, final String _uuid)
	{
		super();
		setCode(_code);
		setOwner(_owner);
		setUuid(_uuid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductConfigSourceRule.baseStores</code> attribute defined at extension <code>sapproductconfigrules</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the baseStores
	 */
	@Accessor(qualifier = "baseStores", type = Accessor.Type.GETTER)
	public Set<BaseStoreModel> getBaseStores()
	{
		return getPersistenceContext().getPropertyValue(BASESTORES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductConfigSourceRule.messageForCstic</code> attribute defined at extension <code>sapproductconfigrules</code>. 
	 * @return the messageForCstic - Message for characteristic
	 */
	@Accessor(qualifier = "messageForCstic", type = Accessor.Type.GETTER)
	public String getMessageForCstic()
	{
		return getPersistenceContext().getPropertyValue(MESSAGEFORCSTIC);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductConfigSourceRule.messageSeverity</code> attribute defined at extension <code>sapproductconfigrules</code>. 
	 * @return the messageSeverity - Severity of the rule related message.
	 */
	@Accessor(qualifier = "messageSeverity", type = Accessor.Type.GETTER)
	public ProductConfigRuleMessageSeverity getMessageSeverity()
	{
		return getPersistenceContext().getPropertyValue(MESSAGESEVERITY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductConfigSourceRule.baseStores</code> attribute defined at extension <code>sapproductconfigrules</code>. 
	 *  
	 * @param value the baseStores
	 */
	@Accessor(qualifier = "baseStores", type = Accessor.Type.SETTER)
	public void setBaseStores(final Set<BaseStoreModel> value)
	{
		getPersistenceContext().setPropertyValue(BASESTORES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductConfigSourceRule.messageForCstic</code> attribute defined at extension <code>sapproductconfigrules</code>. 
	 *  
	 * @param value the messageForCstic - Message for characteristic
	 */
	@Accessor(qualifier = "messageForCstic", type = Accessor.Type.SETTER)
	public void setMessageForCstic(final String value)
	{
		getPersistenceContext().setPropertyValue(MESSAGEFORCSTIC, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductConfigSourceRule.messageSeverity</code> attribute defined at extension <code>sapproductconfigrules</code>. 
	 *  
	 * @param value the messageSeverity - Severity of the rule related message.
	 */
	@Accessor(qualifier = "messageSeverity", type = Accessor.Type.SETTER)
	public void setMessageSeverity(final ProductConfigRuleMessageSeverity value)
	{
		getPersistenceContext().setPropertyValue(MESSAGESEVERITY, value);
	}
	
}
