/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.services.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.dao.PrincipalGroupMembersDao;
import de.hybris.platform.b2b.dao.impl.BaseDao;
import de.hybris.platform.b2b.dao.impl.DefaultB2BWorkflowActionDao;
import de.hybris.platform.b2b.dao.impl.DefaultB2BWorkflowDao;
import de.hybris.platform.b2b.mail.OrderInfoContextDtoFactory;
import de.hybris.platform.b2b.mock.HybrisMokitoTest;
import de.hybris.platform.b2b.model.B2BBudgetModel;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.b2b.process.approval.actions.B2BPermissionResultHelperImpl;
import de.hybris.platform.b2b.process.approval.model.B2BApprovalProcessModel;
import de.hybris.platform.b2b.services.B2BApproverService;
import de.hybris.platform.b2b.services.B2BBudgetService;
import de.hybris.platform.b2b.services.B2BCartService;
import de.hybris.platform.b2b.services.B2BCurrencyConversionService;
import de.hybris.platform.b2b.services.B2BCustomerService;
import de.hybris.platform.b2b.services.B2BUnitService;
import de.hybris.platform.b2b.services.B2BWorkflowIntegrationService;
import de.hybris.platform.commons.renderer.RendererService;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.orderscheduling.ScheduleOrderService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.type.impl.DefaultTypeService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.workflow.WorkflowActionService;
import de.hybris.platform.workflow.WorkflowAttachmentService;
import de.hybris.platform.workflow.WorkflowProcessingService;
import de.hybris.platform.workflow.WorkflowService;
import de.hybris.platform.workflow.WorkflowTemplateService;
import de.hybris.platform.workflow.enums.WorkflowActionStatus;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowActionTemplateModel;
import de.hybris.platform.workflow.model.WorkflowDecisionModel;
import de.hybris.platform.workflow.model.WorkflowDecisionTemplateModel;
import de.hybris.platform.workflow.model.WorkflowModel;
import de.hybris.platform.workflow.model.WorkflowTemplateModel;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.transaction.PlatformTransactionManager;


@UnitTest
public class DefaultB2BWorkflowIntegrationServiceMockTest extends HybrisMokitoTest
{

	private final DefaultB2BWorkflowIntegrationService b2BWorkflowIntegrationService = new DefaultB2BWorkflowIntegrationService();
	@Mock
	private UserService mockUserService;
	@Mock
	private BaseDao mockBaseDao;
	@Mock
	private ModelService mockModelService;
	@Mock
	private B2BUnitService<B2BUnitModel, B2BCustomerModel> mockB2bUnitService;
	@Mock
	private SessionService mockSessionService;
	@Mock
	private CommonI18NService mockCommonI18NService;
	@Mock
	private DefaultB2BWorkflowDao mockB2BWorkflowDao;
	@Mock
	private DefaultB2BWorkflowActionDao mockB2BWorkflowActionDao;
	@Mock
	private WorkflowActionService mockwWorkflowActionService;
	@Mock
	private WorkflowAttachmentService mockwWorkflowAttachmentService;
	@Mock
	private WorkflowProcessingService mockWorkflowProcessingService;
	@Mock
	private WorkflowService mockWorkflowService;
	@Mock
	private WorkflowTemplateService mockWorkflowTemplateService;
	@Mock
	private PlatformTransactionManager mockTxManager;
	@Mock
	private OrderInfoContextDtoFactory orderInfoContextDtoFactory;
	@Mock
	private RendererService rendererService;
	@Mock
	private B2BCurrencyConversionService mockB2BCurrencyConversionService;
	@Mock
	private B2BBudgetService<B2BBudgetModel, B2BCustomerModel> b2BudgetService;
	@Mock
	private B2BCartService mockB2BCartService;
	@Mock
	private B2BCustomerService<B2BCustomerModel, B2BUnitModel> mockB2BCustomerService;
	@Mock
	private ScheduleOrderService mockScheduleOrderService;
	@Mock
	private B2BApproverService mockB2BApproverService;
	@Mock
	private B2BPermissionResultHelperImpl mockB2BPermissionResultHelperImpl;
	@Mock
	private DefaultTypeService mockTypeService;
	@Mock
	private PrincipalGroupMembersDao mockPrincipalGroupMemberDao;

	@Before
	public void setUp() throws Exception
	{
		b2BWorkflowIntegrationService.setBaseDao(mockBaseDao);
		b2BWorkflowIntegrationService.setB2bWorkflowActionDao(mockB2BWorkflowActionDao);
		b2BWorkflowIntegrationService.setB2bWorkflowDao(mockB2BWorkflowDao);
		b2BWorkflowIntegrationService.setModelService(mockModelService);
		b2BWorkflowIntegrationService.setSessionService(mockSessionService);
		b2BWorkflowIntegrationService.setWorkflowActionService(mockwWorkflowActionService);
		b2BWorkflowIntegrationService.setWorkflowProcessingService(mockWorkflowProcessingService);
		b2BWorkflowIntegrationService.setWorkflowService(mockWorkflowService);
		b2BWorkflowIntegrationService.setWorkflowTemplateService(mockWorkflowTemplateService);
	}

	@Test
	public void testGetActionForCode() throws Exception
	{
		final WorkflowActionModel mockAction = mock(WorkflowActionModel.class);
		when(mockAction.getCode()).thenReturn("action1");
		when(mockB2BWorkflowActionDao.findWorkflowActionByCode("action1")).thenReturn(mockAction);
		assertThat(b2BWorkflowIntegrationService.getActionForCode("action1"), equalTo(mockAction));
	}

	@Test
	public void testGetWorkflowActionsForActionStatusAndUser() throws Exception
	{
		final WorkflowActionModel mockWorkflowActionModel = mock(WorkflowActionModel.class);
		final List<WorkflowActionModel> workFlowActions = Collections.<WorkflowActionModel> singletonList(mockWorkflowActionModel);
		final String qualifier = "qualifier1";
		final UserModel mockUserModel = Mockito.mock(UserModel.class);

		when(mockWorkflowActionModel.getCode()).thenReturn("code1");
		when(
				mockB2BWorkflowActionDao.findWorkflowActionsByUserActionCodeAndStatus(WorkflowActionStatus.COMPLETED, qualifier,
				mockUserModel)).thenReturn(workFlowActions);
		Assert.assertThat((List<WorkflowActionModel>) b2BWorkflowIntegrationService.getWorkflowActionsForActionStatusAndUser(
				WorkflowActionStatus.COMPLETED, qualifier, mockUserModel),
				equalTo(Collections.singletonList(mockWorkflowActionModel)));

	}

	@Test
	public void testApproveWorkflowAction() throws Exception
	{
		final WorkflowActionModel mockAction = mock(WorkflowActionModel.class);
		final WorkflowDecisionModel mockDecision = mock(WorkflowDecisionModel.class);
		final WorkflowActionTemplateModel mockWorkflowActionTemplate = mock(WorkflowActionTemplateModel.class);

		when(mockWorkflowActionTemplate.getCode()).thenReturn("action");
		when(mockAction.getTemplate()).thenReturn(mockWorkflowActionTemplate);
		when(mockAction.getCode()).thenReturn("action");
		when(mockAction.getQualifier()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.APPROVE.name());

		when(mockAction.getDecisions()).thenReturn(Collections.singletonList(mockDecision));
		when(mockDecision.getName()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.APPROVE.name());
		when(mockDecision.getCode()).thenReturn("action");
		when(mockDecision.getQualifier()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.APPROVE.name());
		b2BWorkflowIntegrationService.approveWorkflowAction(mockAction);
	}


	@Test
	public void testDecideAction() throws Exception
	{
		final WorkflowActionModel mockAction = mock(WorkflowActionModel.class);
		final WorkflowDecisionModel mockDecision = mock(WorkflowDecisionModel.class);
		final WorkflowActionTemplateModel mockWorkflowActionTemplate = mock(WorkflowActionTemplateModel.class);

		when(mockWorkflowActionTemplate.getCode()).thenReturn("action");
		when(mockAction.getTemplate()).thenReturn(mockWorkflowActionTemplate);
		when(mockAction.getCode()).thenReturn("action");
		when(mockAction.getQualifier()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.APPROVE.name());

		when(mockAction.getDecisions()).thenReturn(Collections.singletonList(mockDecision));
		when(mockDecision.getName()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.APPROVE.name());
		when(mockDecision.getCode()).thenReturn("action");
		when(mockDecision.getQualifier()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.APPROVE.name());
		b2BWorkflowIntegrationService.decideAction(mockAction, B2BWorkflowIntegrationService.DECISIONCODES.APPROVE.name());
	}

	@Test
	public void testRejectWorkflowAction() throws Exception
	{

		final WorkflowActionModel mockAction = mock(WorkflowActionModel.class);
		final WorkflowDecisionModel mockDecision = mock(WorkflowDecisionModel.class);
		final WorkflowActionTemplateModel mockWorkflowActionTemplate = mock(WorkflowActionTemplateModel.class);

		when(mockWorkflowActionTemplate.getCode()).thenReturn("action");
		when(mockAction.getTemplate()).thenReturn(mockWorkflowActionTemplate);
		when(mockAction.getCode()).thenReturn("action");
		when(mockAction.getCode()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.REJECT.name());
		when(mockAction.getDecisions()).thenReturn(Collections.singletonList(mockDecision));
		when(mockDecision.getName()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.REJECT.name());
		when(mockDecision.getCode()).thenReturn("action");
		when(mockDecision.getQualifier()).thenReturn(B2BWorkflowIntegrationService.DECISIONCODES.REJECT.name());
		b2BWorkflowIntegrationService.rejectWorkflowAction(mockAction);
	}

	@Test
	public void testGetOrderFromAction() throws Exception
	{
		final OrderModel mockOrder = mock(OrderModel.class);
		final B2BApprovalProcessModel mockProcess = mock(B2BApprovalProcessModel.class);
		when(mockProcess.getOrder()).thenReturn(mockOrder);
		final WorkflowActionModel mockAction = mock(WorkflowActionModel.class);
		when(mockAction.getCode()).thenReturn("action1");
		when(mockAction.getAttachmentItems()).thenReturn(Collections.<ItemModel> singletonList(mockProcess));
		assertThat(b2BWorkflowIntegrationService.getOrderFromAction(mockAction), equalTo(mockOrder));

	}

	@Test
	public void testCreateWorkflow() throws Exception
	{
		final UserModel mockUser = mock(UserModel.class);
		final OrderModel mockOrder = mock(OrderModel.class);
		final B2BApprovalProcessModel mockProcess = mock(B2BApprovalProcessModel.class);
		when(mockProcess.getOrder()).thenReturn(mockOrder);
		final WorkflowTemplateModel mockWorkflowTemplateModel = mock(WorkflowTemplateModel.class);
		final List<ItemModel> attachments = Collections.<ItemModel> singletonList(mockProcess);
		final WorkflowActionTemplateModel mockWorkflowActionTemplateModel = mock(WorkflowActionTemplateModel.class);
		final WorkflowModel mockWorkflowModel = mock(WorkflowModel.class);
		final WorkflowDecisionTemplateModel decisionTemplate = mock(WorkflowDecisionTemplateModel.class);
		final WorkflowActionModel mockWorkflowActionModel = mock(WorkflowActionModel.class);
		final WorkflowDecisionModel decision = mock(WorkflowDecisionModel.class);

		when(decisionTemplate.getName(Locale.ENGLISH)).thenReturn("workflowdecision");
		when(decisionTemplate.getCode()).thenReturn("workflowdecisioncode");
		when(decisionTemplate.getQualifier()).thenReturn("workflowdecisioncode");

		when(decisionTemplate.getActionTemplate()).thenReturn(mockWorkflowActionTemplateModel);
		when(mockWorkflowActionTemplateModel.getDecisionTemplates()).thenReturn(Collections.singletonList(decisionTemplate));
		when(decision.getName(Locale.ENGLISH)).thenReturn("workflowdecision");
		when(decision.getAction()).thenReturn(mockWorkflowActionModel);
		when(decision.getCode()).thenReturn("workflowdecisioncode");
		when(decision.getQualifier()).thenReturn("workflowdecisioncode");

		when(mockWorkflowActionModel.getDecisions()).thenReturn(Collections.singletonList(decision));
		when(mockWorkflowActionModel.getTemplate()).thenReturn(mockWorkflowActionTemplateModel);
		when(mockWorkflowActionModel.getName(Locale.ENGLISH)).thenReturn("worflowaction");
		when(mockWorkflowModel.getActions()).thenReturn(Collections.singletonList(mockWorkflowActionModel));
		when(mockWorkflowTemplateModel.getName(Locale.ENGLISH)).thenReturn("workflowtemplate");
		when(mockWorkflowTemplateModel.getActions()).thenReturn(
				Collections.<WorkflowActionTemplateModel> singletonList(mockWorkflowActionTemplateModel));
		when(mockWorkflowTemplateModel.getOwner()).thenReturn(mockUser);
		when(
				mockWorkflowService.createWorkflow(nullable(String.class), nullable(WorkflowTemplateModel.class), nullable(List.class),
						nullable(UserModel.class))).thenReturn(mockWorkflowModel);
		assertThat(b2BWorkflowIntegrationService.createWorkflow(mockWorkflowTemplateModel, attachments), equalTo(mockWorkflowModel));

	}

	@Test
	public void testGetWorkflowTemplateByCode() throws Exception
	{
		final WorkflowTemplateModel mockWorkflowTemplateModel = Mockito.mock(WorkflowTemplateModel.class);
		when(mockWorkflowTemplateService.getWorkflowTemplateForCode("code1")).thenReturn(mockWorkflowTemplateModel);
		assertThat(b2BWorkflowIntegrationService.getWorkflowTemplateForCode("code1"), equalTo(mockWorkflowTemplateModel));
	}

	@Test
	public void testStartWorkflow() throws Exception
	{
		final WorkflowModel mockWorkflowModel = Mockito.mock(WorkflowModel.class);
		b2BWorkflowIntegrationService.startWorkflow(mockWorkflowModel);
	}

	@Test
	public void testGetStartWorkflowActions() throws Exception
	{
		final WorkflowModel mockWorkflowModel = Mockito.mock(WorkflowModel.class);
		final WorkflowActionModel mockWorkflowActionModel = mock(WorkflowActionModel.class);
		when(mockwWorkflowActionService.getStartWorkflowActions(mockWorkflowModel)).thenReturn(
				Collections.singletonList(mockWorkflowActionModel));
		assertThat(b2BWorkflowIntegrationService.getStartWorkflowActions(mockWorkflowModel), notNullValue());
	}

	@Test
	public void testGetWorkflowForOrder() throws Exception
	{
		final WorkflowModel mockWorkflowModel = Mockito.mock(WorkflowModel.class);
		final OrderModel mockOrderModel = Mockito.mock(OrderModel.class);
		when(mockB2BWorkflowDao.findWorkflowByOrder(mockOrderModel)).thenReturn(mockWorkflowModel);
		assertThat(b2BWorkflowIntegrationService.getWorkflowForOrder(mockOrderModel), equalTo(mockWorkflowModel));
	}
}
