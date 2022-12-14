/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.workflow.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowItemAttachmentModel;
import de.hybris.platform.workflow.model.WorkflowModel;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.cockpitng.dataaccess.context.Context;
import com.hybris.cockpitng.dataaccess.context.impl.DefaultContext;
import com.hybris.cockpitng.dataaccess.facades.object.ObjectFacade;
import com.hybris.cockpitng.dataaccess.util.CockpitGlobalEventPublisher;


@RunWith(MockitoJUnitRunner.class)
public class DefaultWorkflowEventPublisherTest
{

	@Mock
	private CockpitGlobalEventPublisher cockpitGlobalEventPublisher;
	@Mock
	private Context context;
	@Mock
	private WorkflowModel workflow;
	@Mock
	private WorkflowItemAttachmentModel workflowAttachment;
	@Mock
	private List<WorkflowActionModel> workflowActions;

	@InjectMocks
	private DefaultWorkflowEventPublisher workflowEventPublisher;

	@Test
	public void shouldPublishWorkflowsAndWorkflowsActions()
	{
		//given
		when(workflow.getActions()).thenReturn(workflowActions);

		//when
		workflowEventPublisher.publishWorkflowUpdatedEvent(workflow, context);

		//then
		verify(cockpitGlobalEventPublisher).publish(eq(ObjectFacade.OBJECTS_UPDATED_EVENT), eq(workflow), eq(context));
		verify(cockpitGlobalEventPublisher).publish(eq(ObjectFacade.OBJECTS_UPDATED_EVENT), eq(workflowActions), eq(context));
	}

	@Test
	public void shouldPublishWorkflowsAndWorkflowsActionsWithDefaultContext()
	{
		//given
		when(workflow.getActions()).thenReturn(workflowActions);

		//when
		workflowEventPublisher.publishWorkflowUpdatedEvent(workflow);

		//then
		verify(cockpitGlobalEventPublisher).publish(eq(ObjectFacade.OBJECTS_UPDATED_EVENT), eq(workflow),
				any(DefaultContext.class));
		verify(cockpitGlobalEventPublisher).publish(eq(ObjectFacade.OBJECTS_UPDATED_EVENT), eq(workflowActions),
				any(DefaultContext.class));
	}



	@Test
	public void shouldPublishWorkflowAttachmentDelete()
	{
		//given
		Mockito.lenient().when(workflow.getActions()).thenReturn(workflowActions);
		Mockito.lenient().when(workflowAttachment.getWorkflow()).thenReturn(workflow);

		//when
		workflowEventPublisher.publishWorkflowAttachmentDeletedEvent(workflowAttachment);

		//then
		verify(cockpitGlobalEventPublisher).publish(eq(ObjectFacade.OBJECTS_DELETED_EVENT), eq(workflowAttachment),
				any(DefaultContext.class));
	}
}
