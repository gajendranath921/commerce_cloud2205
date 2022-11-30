/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webhookservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Map;

/**
 * Generated model class for type WebhookPayload first defined at extension webhookservices.
 * <p>
 * A webhook payload wrapper.
 */
@SuppressWarnings("all")
public class WebhookPayloadModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "WebhookPayload";
	
	/** <i>Generated constant</i> - Attribute key of <code>WebhookPayload.data</code> attribute defined at extension <code>webhookservices</code>. */
	public static final String DATA = "data";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public WebhookPayloadModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public WebhookPayloadModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public WebhookPayloadModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>WebhookPayload.data</code> attribute defined at extension <code>webhookservices</code>. 
	 * @return the data - Payload to be sent to a webhook
	 */
	@Accessor(qualifier = "data", type = Accessor.Type.GETTER)
	public Map<String,Object> getData()
	{
		return getPersistenceContext().getPropertyValue(DATA);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>WebhookPayload.data</code> attribute defined at extension <code>webhookservices</code>. 
	 *  
	 * @param value the data - Payload to be sent to a webhook
	 */
	@Accessor(qualifier = "data", type = Accessor.Type.SETTER)
	public void setData(final Map<String,Object> value)
	{
		getPersistenceContext().setPropertyValue(DATA, value);
	}
	
}
