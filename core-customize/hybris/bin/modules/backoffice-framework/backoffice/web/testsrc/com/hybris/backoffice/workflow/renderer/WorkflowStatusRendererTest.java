/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.workflow.renderer;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.workflow.WorkflowStatus;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowModel;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.zkoss.zul.Label;
import org.zkoss.zul.Span;

import com.hybris.backoffice.renderer.WorkflowStatusRenderer;
import com.hybris.backoffice.workflow.WorkflowFacade;
import com.hybris.cockpitng.testing.annotation.ExtensibleWidget;


@RunWith(MockitoJUnitRunner.class)
@ExtensibleWidget(level = ExtensibleWidget.ALL)
public class WorkflowStatusRendererTest extends AbstractWidgetComponentRendererTest<WorkflowStatusRenderer>
{

	@Mock
	private WorkflowFacade workflowFacade;


	@Override
	@Before
	public void setUp()
	{
		super.setUp();
		when(workflowFacade.getWorkflowStatus(any())).thenReturn(WorkflowStatus.FINISHED);
	}

	@Override
	protected WorkflowStatusRenderer createRendererInstance()
	{
		final WorkflowStatusRenderer workflowStatusRenderer = new WorkflowStatusRenderer();
		workflowStatusRenderer.setWorkflowFacade(workflowFacade);

		return workflowStatusRenderer;
	}

	@Override
	protected Object createDefaultRenderedData()
	{
		final WorkflowModel workflowModel = mock(WorkflowModel.class);
		final WorkflowActionModel workflowActionModel = mock(WorkflowActionModel.class);
		Mockito.lenient().when(workflowModel.getActions()).thenReturn(Collections.singletonList(workflowActionModel));
		return workflowModel;
	}

	@Test
	@Override
	public void testMinimumNotification() {
		super.testMinimumNotification();

		assertFireComponentRendererCalled(Label.class, parent, times(1));
		assertFireComponentRendererCalled(Span.class, parent, times(1));
	}

}
