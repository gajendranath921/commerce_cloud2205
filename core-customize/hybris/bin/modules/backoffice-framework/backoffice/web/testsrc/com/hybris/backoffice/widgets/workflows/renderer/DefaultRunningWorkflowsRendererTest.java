/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.widgets.workflows.renderer;

import static com.hybris.backoffice.widgets.workflows.renderer.AbstractWorkflowsListRenderer.SCLASS_WORKFLOWS_LIST_TITLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.servicelayer.time.TimeService;
import de.hybris.platform.workflow.enums.WorkflowActionStatus;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowModel;
import de.hybris.platform.workflow.model.WorkflowTemplateModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Menupopup;

import com.hybris.backoffice.renderer.utils.UIDateRendererProvider;
import com.hybris.backoffice.widgets.workflows.WorkflowsController;
import com.hybris.cockpitng.common.renderer.AbstractCustomMenuActionRenderer;
import com.hybris.cockpitng.dataaccess.facades.permissions.PermissionFacade;
import com.hybris.cockpitng.dataaccess.facades.type.DataType;
import com.hybris.cockpitng.engine.WidgetInstanceManager;
import com.hybris.cockpitng.labels.HyperlinkFallbackLabelProvider;
import com.hybris.cockpitng.labels.LabelService;
import com.hybris.cockpitng.testing.util.CockpitTestUtil;


@RunWith(MockitoJUnitRunner.class)
public class DefaultRunningWorkflowsRendererTest
{
	public static final String TITLE = "title";
	@Mock
	private Object config;
	@Mock
	private WorkflowModel data;
	@Mock
	private WidgetInstanceManager wim;
	@Mock
	private DataType dataType;
	@Mock
	private TimeService timeService;
	@Mock
	private AbstractCustomMenuActionRenderer abstractCustomMenuActionRenderer;
	@Mock
	private LabelService labelService;
	@Mock
	private UIDateRendererProvider uiDateRendererProvider;
	@Mock
	private HyperlinkFallbackLabelProvider hyperlinkFallbackLabelProvider;
	@Mock
	private PermissionFacade permissionFacade;
	@InjectMocks
	private DefaultRunningWorkflowsRenderer runningWorkflowsRenderer;

	@BeforeClass
	public static void initialize()
	{
		CockpitTestUtil.mockZkEnvironment();
	}

	@Before
	public void setUp()
	{
		CockpitTestUtil.mockZkEnvironment();
		final WorkflowTemplateModel job = mock(WorkflowTemplateModel.class);
		Mockito.lenient().when(job.getName()).thenReturn("template name");
		Mockito.lenient().when(data.getJob()).thenReturn(job);
		Mockito.lenient().when(data.getName()).thenReturn("instance name");
		final Date referenceDate = new Date(123456789);
		when(data.getModifiedtime()).thenReturn(referenceDate);
		when(timeService.getCurrentTime()).thenReturn(new Date(referenceDate.getTime() + 1000000));
		given(hyperlinkFallbackLabelProvider.getFallback(any())).willAnswer(e -> e.getArguments()[0]);
	}

	@Test
	public void shouldClickingOnTheLabelInvokeSocket()
	{
		// given
		final Listitem listitem = new Listitem();
		runningWorkflowsRenderer.render(listitem, config, data, dataType, wim);
		final Button button = (Button) Selectors.find(listitem, "." + SCLASS_WORKFLOWS_LIST_TITLE).get(0);

		// when
		CockpitTestUtil.simulateEvent(button, Events.ON_CLICK, null);

		// then
		verify(wim).sendOutput(WorkflowsController.SOCKET_OUT_WORKFLOW_SELECTED, data);
	}

	@Test
	public void shouldMenupopupBeCreatedWhenNumberOfActionsInProgressAreGreaterThanOne()
	{
		// given
		final int size = 6;
		final List<WorkflowActionModel> actions = prepareData(size);
		given(data.getActions()).willReturn(actions);
		given(permissionFacade.canReadInstance(any())).willReturn(Boolean.TRUE);

		// when
		final Div content = runningWorkflowsRenderer.createMiddleContent(wim, data);

		// then
		final SoftAssertions softly = new SoftAssertions();
		softly.assertThat(content.getFirstChild().getClass()).isEqualTo(Menupopup.class);
		softly.assertThat(content.getFirstChild().getChildren().size()).isEqualTo(size);
		softly.assertAll();
	}

	@Test
	public void shouldMenupopupNotBeCreatedWhenNumberOfActionsInProgressAreEqualToOne()
	{
		// given
		final List<WorkflowActionModel> actions = prepareData(1);
		given(data.getActions()).willReturn(actions);

		// when
		final Div content = runningWorkflowsRenderer.createMiddleContent(wim, data);

		// then
		assertFalse(content.getChildren().stream().anyMatch(e -> e.getClass().equals(Menupopup.class)));
	}

	@Test
	public void shouldClickingOnActionInProgressInvokeSocket()
	{
		// given
		final List<WorkflowActionModel> actions = prepareData(1);
		given(data.getActions()).willReturn(actions);
		given(permissionFacade.canReadInstance(any())).willReturn(Boolean.TRUE);
		final Div content = runningWorkflowsRenderer.createMiddleContent(wim, data);
		final Button actionButton = ((Button) content.getFirstChild());

		// when
		CockpitTestUtil.simulateEvent(actionButton, Events.ON_CLICK, null);

		// then
		verify(wim).sendOutput(WorkflowsController.SOCKET_OUT_WORKFLOW_ACTION_SELECTED, actions.get(0));
	}

	@Test
	public void shouldNotCreateButtonIfUserHasNoPermissions()
	{
		//given
		final List<WorkflowActionModel> actions = prepareData(1);
		given(data.getActions()).willReturn(actions);
		given(permissionFacade.canReadInstance(any())).willReturn(Boolean.FALSE);

		//when
		final Div content = runningWorkflowsRenderer.createMiddleContent(wim, data);

		//then
		assertThat(content.getChildren().get(0)).isInstanceOf(Label.class);
		content.getChildren();

	}

	private List<WorkflowActionModel> prepareData(final int size)
	{
		final List<WorkflowActionModel> actions = new ArrayList<>();
		for (int i = 0; i < size; i++)
		{
			final WorkflowActionModel action = mock(WorkflowActionModel.class);
			when(action.getStatus()).thenReturn(WorkflowActionStatus.IN_PROGRESS);
			actions.add(action);
		}

		final WorkflowActionModel finishedAction = mock(WorkflowActionModel.class);
		Mockito.lenient().when(finishedAction.getStatus()).thenReturn(WorkflowActionStatus.COMPLETED);

		return actions;
	}

}
