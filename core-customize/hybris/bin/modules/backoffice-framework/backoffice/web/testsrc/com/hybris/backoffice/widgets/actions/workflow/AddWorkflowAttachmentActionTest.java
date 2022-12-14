/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.widgets.actions.workflow;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.workflow.WorkflowStatus;
import de.hybris.platform.workflow.model.WorkflowItemAttachmentModel;
import de.hybris.platform.workflow.model.WorkflowModel;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.zkoss.zk.ui.event.EventListener;

import com.google.common.collect.Lists;
import com.hybris.backoffice.BackofficeTestUtil;
import com.hybris.backoffice.widgets.notificationarea.NotificationService;
import com.hybris.backoffice.workflow.WorkflowFacade;
import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.core.events.CockpitEvent;
import com.hybris.cockpitng.core.events.CockpitEventQueue;
import com.hybris.cockpitng.data.TypeAwareSelectionContext;
import com.hybris.cockpitng.dataaccess.facades.object.ObjectCRUDHandler;
import com.hybris.cockpitng.events.SocketEvent;
import com.hybris.cockpitng.testing.AbstractActionUnitTest;


public class AddWorkflowAttachmentActionTest extends AbstractActionUnitTest<AddWorkflowAttachmentAction>
{
	@InjectMocks
	private AddWorkflowAttachmentAction action;

	@Mock
	private WorkflowFacade workflowFacade;
	@Mock
	private CockpitEventQueue cockpitEventQueue;
	@Mock
	private NotificationService notificationService;

	@Override
	public AddWorkflowAttachmentAction getActionInstance()
	{
		return action;
	}

	@Test
	public void testPerformSendsCorrectContext()
	{
		final WorkflowModel workflow = mock(WorkflowModel.class);

		final ActionContext<WorkflowModel> ctx = new ActionContext<>(workflow, null, null, null);
		ctx.setParameter(AddWorkflowAttachmentAction.PARAM_ATTACHMENT_TYPE, ProductModel._TYPECODE);

		action.perform(ctx);

		verify(componentWidgetAdapter).sendOutput(eq(AddWorkflowAttachmentAction.SOCKET_OUT_REFERENCE_SEARCH_CTX),
				argThat(new ArgumentMatcher<TypeAwareSelectionContext>()
				{
					@Override
					public boolean matches(TypeAwareSelectionContext typeAwareSelectionContext) {
						return typeAwareSelectionContext.isMultiSelect() && typeAwareSelectionContext.getTypeCode().equals(ProductModel._TYPECODE)
								&& typeAwareSelectionContext.getAvailableItems().isEmpty();
					}
				}), same(action));

	}

	@Test
	public void testPerformNotExecutedWithoutTypeParam()
	{
		final WorkflowModel workflow = mock(WorkflowModel.class);

		final ActionContext<WorkflowModel> ctx = new ActionContext<>(workflow, null, null, null);

		action.perform(ctx);

		verify(componentWidgetAdapter, never()).sendOutput(any(), any(), any());

	}

	@Test
	public void testNoDuplicatesAddedToWorkflowOnReturnSocket() throws Exception
	{
		//given
		final WorkflowModel workflow = mock(WorkflowModel.class);
		final WorkflowItemAttachmentModel a1 = mockAttachment(1);
		final WorkflowItemAttachmentModel a2 = mockAttachment(2);
		when(workflow.getAttachments()).thenReturn(Lists.newArrayList(a1, a2));
		final ProductModel newChosenItem = new ProductModel();
		BackofficeTestUtil.setPk(newChosenItem, 3);

		final ActionContext<WorkflowModel> ctx = new ActionContext<>(workflow, null, null, null);
		ctx.setParameter(AddWorkflowAttachmentAction.PARAM_ATTACHMENT_TYPE, ProductModel._TYPECODE);

		//when
		action.perform(ctx);

		final ArgumentCaptor<EventListener> listener = ArgumentCaptor.forClass(EventListener.class);
		verify(componentWidgetAdapter).addSocketInputEventListener(eq(AddWorkflowAttachmentAction.SOCKET_IN_CHOSEN_ATTACHMENTS),
				listener.capture());

		final List<ItemModel> chosenItems = Lists.newArrayList(a1.getItem(), a2.getItem(), newChosenItem);
		final SocketEvent event = mock(SocketEvent.class);
		when(event.getData()).thenReturn(chosenItems);
		listener.getValue().onEvent(event);

		//then
		verify(workflowFacade).addItems(workflow, Lists.newArrayList(newChosenItem));
		verify(cockpitEventQueue).publishEvent(argThat(new ArgumentMatcher<CockpitEvent>()
		{
			@Override
			public boolean matches(CockpitEvent cockpitEvent) {
				return ObjectCRUDHandler.OBJECTS_UPDATED_EVENT.equals(cockpitEvent.getName()) && cockpitEvent.getData() == workflow;
			}
		}));
	}

	@Test
	public void testCanPerformWhenWorkflowIsInPreparedStatus()
	{
		//given
		final WorkflowModel workflow = mock(WorkflowModel.class);
		when(workflowFacade.getWorkflowStatus(workflow)).thenReturn(WorkflowStatus.PLANNED);
		final ActionContext<WorkflowModel> ctx = new ActionContext<>(workflow, null, null, null);
		ctx.setParameter(AddWorkflowAttachmentAction.PARAM_ATTACHMENT_TYPE, ProductModel._TYPECODE);

		//when
		final boolean result = action.canPerform(ctx);

		//then
		assertThat(result).isTrue();
	}

	@Test
	public void testCanNotPerformWhenWorkflowIsNotInPreparedStatus()
	{
		final EnumSet<WorkflowStatus> workflowStatuses = WorkflowStatus.getAll();
		final List<WorkflowStatus> list = workflowStatuses.stream().filter(status -> !status.equals(WorkflowStatus.PLANNED))
				.collect(Collectors.toList());

		for (final WorkflowStatus workflowStatus : list)
		{
			//given
			final WorkflowModel workflow = mock(WorkflowModel.class);
			final ActionContext<WorkflowModel> ctx = new ActionContext<>(workflow, null, null, null);
			ctx.setParameter(AddWorkflowAttachmentAction.PARAM_ATTACHMENT_TYPE, ProductModel._TYPECODE);
			when(workflowFacade.getWorkflowStatus(workflow)).thenReturn(workflowStatus);
			//when
			final boolean result = action.canPerform(ctx);
			//then
			assertThat(result).isFalse();
		}
	}

	protected WorkflowItemAttachmentModel mockAttachment(final long itemPK)
	{
		final ProductModel product = new ProductModel();
		BackofficeTestUtil.setPk(product, itemPK);
		final WorkflowItemAttachmentModel attachment = mock(WorkflowItemAttachmentModel.class);
		when(attachment.getItem()).thenReturn(product);
		return attachment;
	}
}
