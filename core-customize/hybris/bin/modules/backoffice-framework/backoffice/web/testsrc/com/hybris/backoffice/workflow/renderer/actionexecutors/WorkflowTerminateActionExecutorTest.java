/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.workflow.renderer.actionexecutors;

import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

import de.hybris.platform.workflow.model.WorkflowModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.backoffice.widgets.notificationarea.NotificationService;
import com.hybris.backoffice.widgets.notificationarea.event.NotificationEvent;
import com.hybris.backoffice.workflow.WorkflowEventPublisher;
import com.hybris.backoffice.workflow.WorkflowFacade;


@RunWith(MockitoJUnitRunner.class)
public class WorkflowTerminateActionExecutorTest
{

	@Mock
	WorkflowFacade workflowFacade;
	@Mock
	WorkflowEventPublisher workflowEventPublisher;
	@Mock
	NotificationService notificationService;
	@InjectMocks
	private final WorkflowTerminateActionExecutor executor = new WorkflowTerminateActionExecutor();

	@Test
	public void shouldNotificationBeDisplayedAndEventsBePublishedWhenWorkflowIsSuccessfullyTerminated()
	{
		// given
		final WorkflowModel workflowModel = mock(WorkflowModel.class);
		doReturn(true).when(workflowFacade).terminateWorkflow(any());

		// when
		executor.apply(workflowModel);

		// then
		then(notificationService).should().notifyUser(anyString(), any(), eq(NotificationEvent.Level.SUCCESS), any());
		then(workflowEventPublisher).should().publishWorkflowUpdatedEvent(any());
		then(workflowEventPublisher).should().publishWorkflowActionsUpdatedEvent(any());
	}

	@Test
	public void shouldErrorNotificationBeDisplayedWhenTerminationFail()
	{
		// given
		final WorkflowModel workflowModel = mock(WorkflowModel.class);
		doReturn(false).when(workflowFacade).terminateWorkflow(any());

		// when
		executor.apply(workflowModel);

		// then
		then(notificationService).should().notifyUser(anyString(), any(), eq(NotificationEvent.Level.FAILURE), any());
		then(workflowEventPublisher).should(never()).publishWorkflowUpdatedEvent(any());
		then(workflowEventPublisher).should(never()).publishWorkflowActionsUpdatedEvent(any());
	}

}
