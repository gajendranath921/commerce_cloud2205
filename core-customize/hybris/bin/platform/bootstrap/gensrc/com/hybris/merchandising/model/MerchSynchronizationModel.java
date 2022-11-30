/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.merchandising.model;

import com.hybris.merchandising.model.MerchProductDirectoryConfigModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type MerchSynchronization first defined at extension merchandisingservices.
 */
@SuppressWarnings("all")
public class MerchSynchronizationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "MerchSynchronization";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.operationId</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String OPERATIONID = "operationId";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.config</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String CONFIG = "config";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.type</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.status</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String STATUS = "status";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.startTime</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String STARTTIME = "startTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.endTime</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String ENDTIME = "endTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.numberOfProducts</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String NUMBEROFPRODUCTS = "numberOfProducts";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSynchronization.details</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String DETAILS = "details";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public MerchSynchronizationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public MerchSynchronizationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _operationId initial attribute declared by type <code>MerchSynchronization</code> at extension <code>merchandisingservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MerchSynchronizationModel(final String _operationId)
	{
		super();
		setOperationId(_operationId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _operationId initial attribute declared by type <code>MerchSynchronization</code> at extension <code>merchandisingservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MerchSynchronizationModel(final String _operationId, final ItemModel _owner)
	{
		super();
		setOperationId(_operationId);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.config</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the config
	 */
	@Accessor(qualifier = "config", type = Accessor.Type.GETTER)
	public MerchProductDirectoryConfigModel getConfig()
	{
		return getPersistenceContext().getPropertyValue(CONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.details</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the details
	 */
	@Accessor(qualifier = "details", type = Accessor.Type.GETTER)
	public String getDetails()
	{
		return getPersistenceContext().getPropertyValue(DETAILS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.endTime</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the endTime
	 */
	@Accessor(qualifier = "endTime", type = Accessor.Type.GETTER)
	public Date getEndTime()
	{
		return getPersistenceContext().getPropertyValue(ENDTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.numberOfProducts</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the numberOfProducts
	 */
	@Accessor(qualifier = "numberOfProducts", type = Accessor.Type.GETTER)
	public Long getNumberOfProducts()
	{
		return getPersistenceContext().getPropertyValue(NUMBEROFPRODUCTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.operationId</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the operationId - Operation id
	 */
	@Accessor(qualifier = "operationId", type = Accessor.Type.GETTER)
	public String getOperationId()
	{
		return getPersistenceContext().getPropertyValue(OPERATIONID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.startTime</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the startTime
	 */
	@Accessor(qualifier = "startTime", type = Accessor.Type.GETTER)
	public Date getStartTime()
	{
		return getPersistenceContext().getPropertyValue(STARTTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.status</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.GETTER)
	public String getStatus()
	{
		return getPersistenceContext().getPropertyValue(STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSynchronization.type</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public String getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSynchronization.config</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the config
	 */
	@Accessor(qualifier = "config", type = Accessor.Type.SETTER)
	public void setConfig(final MerchProductDirectoryConfigModel value)
	{
		getPersistenceContext().setPropertyValue(CONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSynchronization.details</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the details
	 */
	@Accessor(qualifier = "details", type = Accessor.Type.SETTER)
	public void setDetails(final String value)
	{
		getPersistenceContext().setPropertyValue(DETAILS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSynchronization.endTime</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the endTime
	 */
	@Accessor(qualifier = "endTime", type = Accessor.Type.SETTER)
	public void setEndTime(final Date value)
	{
		getPersistenceContext().setPropertyValue(ENDTIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSynchronization.numberOfProducts</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the numberOfProducts
	 */
	@Accessor(qualifier = "numberOfProducts", type = Accessor.Type.SETTER)
	public void setNumberOfProducts(final Long value)
	{
		getPersistenceContext().setPropertyValue(NUMBEROFPRODUCTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>MerchSynchronization.operationId</code> attribute defined at extension <code>merchandisingservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the operationId - Operation id
	 */
	@Accessor(qualifier = "operationId", type = Accessor.Type.SETTER)
	public void setOperationId(final String value)
	{
		getPersistenceContext().setPropertyValue(OPERATIONID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSynchronization.startTime</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the startTime
	 */
	@Accessor(qualifier = "startTime", type = Accessor.Type.SETTER)
	public void setStartTime(final Date value)
	{
		getPersistenceContext().setPropertyValue(STARTTIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSynchronization.status</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.SETTER)
	public void setStatus(final String value)
	{
		getPersistenceContext().setPropertyValue(STATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSynchronization.type</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final String value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
}
