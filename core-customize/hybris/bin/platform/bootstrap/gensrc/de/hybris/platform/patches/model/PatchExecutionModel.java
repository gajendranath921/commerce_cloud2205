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
import de.hybris.platform.patches.enums.ExecutionStatus;
import de.hybris.platform.patches.model.PatchExecutionUnitModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Date;

/**
 * Generated model class for type PatchExecution first defined at extension patches.
 */
@SuppressWarnings("all")
public class PatchExecutionModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PatchExecution";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.patchId</code> attribute defined at extension <code>patches</code>. */
	public static final String PATCHID = "patchId";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.patchName</code> attribute defined at extension <code>patches</code>. */
	public static final String PATCHNAME = "patchName";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.patchDescription</code> attribute defined at extension <code>patches</code>. */
	public static final String PATCHDESCRIPTION = "patchDescription";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.executionTime</code> attribute defined at extension <code>patches</code>. */
	public static final String EXECUTIONTIME = "executionTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.previousExecution</code> attribute defined at extension <code>patches</code>. */
	public static final String PREVIOUSEXECUTION = "previousExecution";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.nextExecution</code> attribute defined at extension <code>patches</code>. */
	public static final String NEXTEXECUTION = "nextExecution";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.jenkinsBuild</code> attribute defined at extension <code>patches</code>. */
	public static final String JENKINSBUILD = "jenkinsBuild";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.gitHashCode</code> attribute defined at extension <code>patches</code>. */
	public static final String GITHASHCODE = "gitHashCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.numberOfUnits</code> attribute defined at extension <code>patches</code>. */
	public static final String NUMBEROFUNITS = "numberOfUnits";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.numberOfErrorUnits</code> attribute defined at extension <code>patches</code>. */
	public static final String NUMBEROFERRORUNITS = "numberOfErrorUnits";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.executionStatus</code> attribute defined at extension <code>patches</code>. */
	public static final String EXECUTIONSTATUS = "executionStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.errorLog</code> attribute defined at extension <code>patches</code>. */
	public static final String ERRORLOG = "errorLog";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.rerunnable</code> attribute defined at extension <code>patches</code>. */
	public static final String RERUNNABLE = "rerunnable";
	
	/** <i>Generated constant</i> - Attribute key of <code>PatchExecution.patchUnits</code> attribute defined at extension <code>patches</code>. */
	public static final String PATCHUNITS = "patchUnits";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PatchExecutionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PatchExecutionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _executionTime initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 * @param _patchDescription initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 * @param _patchId initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 * @param _patchName initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PatchExecutionModel(final Date _executionTime, final String _patchDescription, final String _patchId, final String _patchName)
	{
		super();
		setExecutionTime(_executionTime);
		setPatchDescription(_patchDescription);
		setPatchId(_patchId);
		setPatchName(_patchName);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _executionTime initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _patchDescription initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 * @param _patchId initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 * @param _patchName initial attribute declared by type <code>PatchExecution</code> at extension <code>patches</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PatchExecutionModel(final Date _executionTime, final ItemModel _owner, final String _patchDescription, final String _patchId, final String _patchName)
	{
		super();
		setExecutionTime(_executionTime);
		setOwner(_owner);
		setPatchDescription(_patchDescription);
		setPatchId(_patchId);
		setPatchName(_patchName);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.errorLog</code> attribute defined at extension <code>patches</code>. 
	 * @return the errorLog - Details about major errors during the patch execution.
	 */
	@Accessor(qualifier = "errorLog", type = Accessor.Type.GETTER)
	public String getErrorLog()
	{
		return getPersistenceContext().getPropertyValue(ERRORLOG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.executionStatus</code> attribute defined at extension <code>patches</code>. 
	 * @return the executionStatus
	 */
	@Accessor(qualifier = "executionStatus", type = Accessor.Type.GETTER)
	public ExecutionStatus getExecutionStatus()
	{
		return getPersistenceContext().getPropertyValue(EXECUTIONSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.executionTime</code> attribute defined at extension <code>patches</code>. 
	 * @return the executionTime
	 */
	@Accessor(qualifier = "executionTime", type = Accessor.Type.GETTER)
	public Date getExecutionTime()
	{
		return getPersistenceContext().getPropertyValue(EXECUTIONTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.gitHashCode</code> attribute defined at extension <code>patches</code>. 
	 * @return the gitHashCode
	 */
	@Accessor(qualifier = "gitHashCode", type = Accessor.Type.GETTER)
	public String getGitHashCode()
	{
		return getPersistenceContext().getPropertyValue(GITHASHCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.jenkinsBuild</code> attribute defined at extension <code>patches</code>. 
	 * @return the jenkinsBuild
	 */
	@Accessor(qualifier = "jenkinsBuild", type = Accessor.Type.GETTER)
	public String getJenkinsBuild()
	{
		return getPersistenceContext().getPropertyValue(JENKINSBUILD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.nextExecution</code> attribute defined at extension <code>patches</code>. 
	 * @return the nextExecution
	 */
	@Accessor(qualifier = "nextExecution", type = Accessor.Type.GETTER)
	public PatchExecutionModel getNextExecution()
	{
		return getPersistenceContext().getPropertyValue(NEXTEXECUTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.numberOfErrorUnits</code> dynamic attribute defined at extension <code>patches</code>. 
	 * @return the numberOfErrorUnits
	 */
	@Accessor(qualifier = "numberOfErrorUnits", type = Accessor.Type.GETTER)
	public Integer getNumberOfErrorUnits()
	{
		return getPersistenceContext().getDynamicValue(this,NUMBEROFERRORUNITS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.numberOfUnits</code> dynamic attribute defined at extension <code>patches</code>. 
	 * @return the numberOfUnits
	 */
	@Accessor(qualifier = "numberOfUnits", type = Accessor.Type.GETTER)
	public Integer getNumberOfUnits()
	{
		return getPersistenceContext().getDynamicValue(this,NUMBEROFUNITS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.patchDescription</code> attribute defined at extension <code>patches</code>. 
	 * @return the patchDescription
	 */
	@Accessor(qualifier = "patchDescription", type = Accessor.Type.GETTER)
	public String getPatchDescription()
	{
		return getPersistenceContext().getPropertyValue(PATCHDESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.patchId</code> attribute defined at extension <code>patches</code>. 
	 * @return the patchId
	 */
	@Accessor(qualifier = "patchId", type = Accessor.Type.GETTER)
	public String getPatchId()
	{
		return getPersistenceContext().getPropertyValue(PATCHID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.patchName</code> attribute defined at extension <code>patches</code>. 
	 * @return the patchName
	 */
	@Accessor(qualifier = "patchName", type = Accessor.Type.GETTER)
	public String getPatchName()
	{
		return getPersistenceContext().getPropertyValue(PATCHNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.patchUnits</code> attribute defined at extension <code>patches</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the patchUnits
	 */
	@Accessor(qualifier = "patchUnits", type = Accessor.Type.GETTER)
	public Collection<PatchExecutionUnitModel> getPatchUnits()
	{
		return getPersistenceContext().getPropertyValue(PATCHUNITS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.previousExecution</code> attribute defined at extension <code>patches</code>. 
	 * @return the previousExecution
	 */
	@Accessor(qualifier = "previousExecution", type = Accessor.Type.GETTER)
	public PatchExecutionModel getPreviousExecution()
	{
		return getPersistenceContext().getPropertyValue(PREVIOUSEXECUTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PatchExecution.rerunnable</code> attribute defined at extension <code>patches</code>. 
	 * @return the rerunnable - Flag indicating whether patch is re runnable by default.
	 */
	@Accessor(qualifier = "rerunnable", type = Accessor.Type.GETTER)
	public boolean isRerunnable()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(RERUNNABLE));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.errorLog</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the errorLog - Details about major errors during the patch execution.
	 */
	@Accessor(qualifier = "errorLog", type = Accessor.Type.SETTER)
	public void setErrorLog(final String value)
	{
		getPersistenceContext().setPropertyValue(ERRORLOG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.executionStatus</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the executionStatus
	 */
	@Accessor(qualifier = "executionStatus", type = Accessor.Type.SETTER)
	public void setExecutionStatus(final ExecutionStatus value)
	{
		getPersistenceContext().setPropertyValue(EXECUTIONSTATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.executionTime</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the executionTime
	 */
	@Accessor(qualifier = "executionTime", type = Accessor.Type.SETTER)
	public void setExecutionTime(final Date value)
	{
		getPersistenceContext().setPropertyValue(EXECUTIONTIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.gitHashCode</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the gitHashCode
	 */
	@Accessor(qualifier = "gitHashCode", type = Accessor.Type.SETTER)
	public void setGitHashCode(final String value)
	{
		getPersistenceContext().setPropertyValue(GITHASHCODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.jenkinsBuild</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the jenkinsBuild
	 */
	@Accessor(qualifier = "jenkinsBuild", type = Accessor.Type.SETTER)
	public void setJenkinsBuild(final String value)
	{
		getPersistenceContext().setPropertyValue(JENKINSBUILD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.nextExecution</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the nextExecution
	 */
	@Accessor(qualifier = "nextExecution", type = Accessor.Type.SETTER)
	public void setNextExecution(final PatchExecutionModel value)
	{
		getPersistenceContext().setPropertyValue(NEXTEXECUTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.patchDescription</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the patchDescription
	 */
	@Accessor(qualifier = "patchDescription", type = Accessor.Type.SETTER)
	public void setPatchDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(PATCHDESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.patchId</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the patchId
	 */
	@Accessor(qualifier = "patchId", type = Accessor.Type.SETTER)
	public void setPatchId(final String value)
	{
		getPersistenceContext().setPropertyValue(PATCHID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.patchName</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the patchName
	 */
	@Accessor(qualifier = "patchName", type = Accessor.Type.SETTER)
	public void setPatchName(final String value)
	{
		getPersistenceContext().setPropertyValue(PATCHNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.patchUnits</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the patchUnits
	 */
	@Accessor(qualifier = "patchUnits", type = Accessor.Type.SETTER)
	public void setPatchUnits(final Collection<PatchExecutionUnitModel> value)
	{
		getPersistenceContext().setPropertyValue(PATCHUNITS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.previousExecution</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the previousExecution
	 */
	@Accessor(qualifier = "previousExecution", type = Accessor.Type.SETTER)
	public void setPreviousExecution(final PatchExecutionModel value)
	{
		getPersistenceContext().setPropertyValue(PREVIOUSEXECUTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PatchExecution.rerunnable</code> attribute defined at extension <code>patches</code>. 
	 *  
	 * @param value the rerunnable - Flag indicating whether patch is re runnable by default.
	 */
	@Accessor(qualifier = "rerunnable", type = Accessor.Type.SETTER)
	public void setRerunnable(final boolean value)
	{
		getPersistenceContext().setPropertyValue(RERUNNABLE, toObject(value));
	}
	
}
