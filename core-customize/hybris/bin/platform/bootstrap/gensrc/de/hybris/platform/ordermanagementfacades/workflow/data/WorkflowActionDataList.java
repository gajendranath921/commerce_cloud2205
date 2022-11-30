/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.workflow.data;

import java.io.Serializable;
import de.hybris.platform.ordermanagementfacades.workflow.data.WorkflowActionData;
import java.util.List;


import java.util.Objects;
public  class WorkflowActionDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowActionDataList.workflowActions</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private List<WorkflowActionData> workflowActions;
	
	public WorkflowActionDataList()
	{
		// default constructor
	}
	
	public void setWorkflowActions(final List<WorkflowActionData> workflowActions)
	{
		this.workflowActions = workflowActions;
	}

	public List<WorkflowActionData> getWorkflowActions() 
	{
		return workflowActions;
	}
	

}