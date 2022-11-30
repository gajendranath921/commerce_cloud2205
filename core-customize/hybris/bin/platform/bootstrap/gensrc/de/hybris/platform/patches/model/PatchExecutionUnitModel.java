/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.patches.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.patches.enums.ExecutionStatus;
import de.hybris.platform.patches.enums.ExecutionUnitType;
import de.hybris.platform.patches.model.PatchExecutionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type PatchExecutionUnit first defined at extension patches.
 */
@SuppressWarnings("all")
public class PatchExecutionUnitModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PatchExecutionUnit";
	
	/**<i>Generated relation code constant for relation <code>PatchExecution2PatchExecutionUnitRel</code> defining source attribute <code>patch</code> in extension <code>patches</code>.</i>*/
	public static final String _PATCHEXECUTION2PATCHEXECUTIONUNITREL = "PatchExecution2PatchExecutionUnitRel";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.idHash</code> attribute defined at extension <code>patches</code>. */
	public static final String IDHASH = "idHash";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.name</code> attribute defined at extension <code>patches</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.orderNumber</code> attribute defined at extension <code>patches</code>. */
	public static final String ORDERNUMBER = "orderNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.organisation</code> attribute defined at extension <code>patches</code>. */
	public static final String ORGANISATION = "organisation";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.executionStatus</code> attribute defined at extension <code>patches</code>. */
	public static final String EXECUTIONSTATUS = "executionStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.executionType</code> attribute defined at extension <code>patches</code>. */
	public static final String EXECUTIONTYPE = "executionType";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.executionTime</code> attribute defined at extension <code>patches</code>. */
	public static final String EXECUTIONTIME = "executionTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.contentHash</code> attribute defined at extension <code>patches</code>. */
	public static final String CONTENTHASH = "contentHash";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.errorLog</code> attribute defined at extension <code>patches</code>. */
	public static final String ERRORLOG = "errorLog";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.cronjob</code> attribute defined at extension <code>patches</code>. */
	public static final String CRONJOB = "cronjob";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecutionUnit.patch</code> attribute defined at extension <code>patches</code>. */
	public static final String PATCH = "patch";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PatchExecutionUnitModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PatchExecutionUnitModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _executionType initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 * @param _idHash initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 * @param _name initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 * @param _orderNumber initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PatchExecutionUnitModel(final ExecutionUnitType _executionType, final String _idHash, final String _name, final Integer _orderNumber)
	{
		super();
		setExecutionType(_executionType);
		setIdHash(_idHash);
		setName(_name);
		setOrderNumber(_orderNumber);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _executionType initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 * @param _idHash initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 * @param _name initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 * @param _orderNumber initial attribute declared by type <code>PatchExecutionUnit</code> at extension <code>patches</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PatchExecutionUnitModel(final ExecutionUnitType _executionType, final String _idHash, final String _name, final Integer _orderNumber, final ItemModel _owner)
	{
		super();
		setExecutionType(_executionType);
		setIdHash(_idHash);
		setName(_name);
		setOrderNumber(_orderNumber);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.contentHash</code> attribute defined at extension <code>patches</code>. 
	 * @return the contentHash - The impex content hash.
	 */
	@Accessor(qualifier = "contentHash", type = Accessor.Type.GETTER)
	public String getContentHash()
	{
		return getPersistenceContext().getPropertyValue(CONTENTHASH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.cronjob</code> attribute defined at extension <code>patches</code>. 
	 * @return the cronjob
	 */
	@Accessor(qualifier = "cronjob", type = Accessor.Type.GETTER)
	public CronJobModel getCronjob()
	{
		return getPersistenceContext().getPropertyValue(CRONJOB);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.errorLog</code> attribute defined at extension <code>patches</code>. 
	 * @return the errorLog - Details about errors during the execution of specific patch execution unit element.
	 */
	@Accessor(qualifier = "errorLog", type = Accessor.Type.GETTER)
	public String getErrorLog()
	{
		return getPersistenceContext().getPropertyValue(ERRORLOG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.executionStatus</code> attribute defined at extension <code>patches</code>. 
	 * @return the executionStatus
	 */
	@Accessor(qualifier = "executionStatus", type = Accessor.Type.GETTER)
	public ExecutionStatus getExecutionStatus()
	{
		return getPersistenceContext().getPropertyValue(EXECUTIONSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.executionTime</code> attribute defined at extension <code>patches</code>. 
	 * @return the executionTime - The time when the patch item was applied.
	 */
	@Accessor(qualifier = "executionTime", type = Accessor.Type.GETTER)
	public Date getExecutionTime()
	{
		return getPersistenceContext().getPropertyValue(EXECUTIONTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.executionType</code> attribute defined at extension <code>patches</code>. 
	 * @return the executionType
	 */
	@Accessor(qualifier = "executionType", type = Accessor.Type.GETTER)
	public ExecutionUnitType getExecutionType()
	{
		return getPersistenceContext().getPropertyValue(EXECUTIONTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.idHash</code> attribute defined at extension <code>patches</code>. 
	 * @return the idHash - The execution unit id hash
	 */
	@Accessor(qualifier = "idHash", type = Accessor.Type.GETTER)
	public String getIdHash()
	{
		return getPersistenceContext().getPropertyValue(IDHASH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.name</code> attribute defined at extension <code>patches</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.orderNumber</code> attribute defined at extension <code>patches</code>. 
	 * @return the orderNumber
	 */
	@Accessor(qualifier = "orderNumber", type = Accessor.Type.GETTER)
	public Integer getOrderNumber()
	{
		return getPersistenceContext().getPropertyValue(ORDERNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.organisation</code> attribute defined at extension <code>patches</code>. 
	 * @return the organisation
	 */
	@Accessor(qualifier = "organisation", type = Accessor.Type.GETTER)
	public String getOrganisation()
	{
		return getPersistenceContext().getPropertyValue(ORGANISATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecutionUnit.patch</code> attribute defined at extension <code>patches</code>. 
	 * @return the patch
	 */
	@Accessor(qualifier = "patch", type = Accessor.Type.GETTER)
	public PatchExecutionModel getPatch()
	{
		return getPersistenceContext().getPropertyValue(PATCH);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.contentHash</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the contentHash - The impex content hash.
	 */
	@Accessor(qualifier = "contentHash", type = Accessor.Type.SETTER)
	public void setContentHash(final String value)
	{
		getPersistenceContext().setPropertyValue(CONTENTHASH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.cronjob</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the cronjob
	 */
	@Accessor(qualifier = "cronjob", type = Accessor.Type.SETTER)
	public void setCronjob(final CronJobModel value)
	{
		getPersistenceContext().setPropertyValue(CRONJOB, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.errorLog</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the errorLog - Details about errors during the execution of specific patch execution unit element.
	 */
	@Accessor(qualifier = "errorLog", type = Accessor.Type.SETTER)
	public void setErrorLog(final String value)
	{
		getPersistenceContext().setPropertyValue(ERRORLOG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.executionStatus</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the executionStatus
	 */
	@Accessor(qualifier = "executionStatus", type = Accessor.Type.SETTER)
	public void setExecutionStatus(final ExecutionStatus value)
	{
		getPersistenceContext().setPropertyValue(EXECUTIONSTATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.executionTime</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the executionTime - The time when the patch item was applied.
	 */
	@Accessor(qualifier = "executionTime", type = Accessor.Type.SETTER)
	public void setExecutionTime(final Date value)
	{
		getPersistenceContext().setPropertyValue(EXECUTIONTIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.executionType</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the executionType
	 */
	@Accessor(qualifier = "executionType", type = Accessor.Type.SETTER)
	public void setExecutionType(final ExecutionUnitType value)
	{
		getPersistenceContext().setPropertyValue(EXECUTIONTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.idHash</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the idHash - The execution unit id hash
	 */
	@Accessor(qualifier = "idHash", type = Accessor.Type.SETTER)
	public void setIdHash(final String value)
	{
		getPersistenceContext().setPropertyValue(IDHASH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.name</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.orderNumber</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the orderNumber
	 */
	@Accessor(qualifier = "orderNumber", type = Accessor.Type.SETTER)
	public void setOrderNumber(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ORDERNUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.organisation</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the organisation
	 */
	@Accessor(qualifier = "organisation", type = Accessor.Type.SETTER)
	public void setOrganisation(final String value)
	{
		getPersistenceContext().setPropertyValue(ORGANISATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecutionUnit.patch</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the patch
	 */
	@Accessor(qualifier = "patch", type = Accessor.Type.SETTER)
	public void setPatch(final PatchExecutionModel value)
	{
		getPersistenceContext().setPropertyValue(PATCH, value);
	}
	
}
