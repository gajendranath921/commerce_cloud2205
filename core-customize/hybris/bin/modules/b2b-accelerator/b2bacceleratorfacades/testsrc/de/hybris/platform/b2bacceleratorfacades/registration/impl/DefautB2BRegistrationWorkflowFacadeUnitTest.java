/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.registration.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.platform.b2b.model.B2BRegistrationModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.workflow.WorkflowProcessingService;
import de.hybris.platform.workflow.WorkflowService;
import de.hybris.platform.workflow.model.WorkflowModel;
import de.hybris.platform.workflow.model.WorkflowTemplateModel;

import org.junit.Before;
import org.junit.Test;


public class DefautB2BRegistrationWorkflowFacadeUnitTest
{
	private DefautB2BRegistrationWorkflowFacade B2BRegistrationWorkflowFacade;

	private WorkflowService workflowService;

	private WorkflowProcessingService workflowProcessingService;

	private UserService userService;

	private ModelService modelService;

	private WorkflowTemplateModel workflowTemplateModel;

	@Before
	public void setup()
	{
		B2BRegistrationWorkflowFacade = new DefautB2BRegistrationWorkflowFacade();

		workflowService = mock(WorkflowService.class);
		B2BRegistrationWorkflowFacade.setWorkflowService(workflowService);

		workflowProcessingService = mock(WorkflowProcessingService.class);
		B2BRegistrationWorkflowFacade.setWorkflowProcessingService(workflowProcessingService);

		userService = mock(UserService.class);
		B2BRegistrationWorkflowFacade.setUserService(userService);

		modelService = mock(ModelService.class);
		B2BRegistrationWorkflowFacade.setModelService(modelService);

		workflowTemplateModel = mock(WorkflowTemplateModel.class);

	}

	@Test
	public void testLaunchWorkflow()
	{
		final EmployeeModel employee = mock(EmployeeModel.class);
		when(userService.getAdminUser()).thenReturn(employee);

		final B2BRegistrationModel registration = mock(B2BRegistrationModel.class);

		final WorkflowModel workflow = mock(WorkflowModel.class);
		when(workflowService.createWorkflow(workflowTemplateModel, registration, employee)).thenReturn(workflow);

		//For unit test, we don't need to test the functions from other servives, so the commented out part is not needed.
		//final ArrayList attachments = Lists.newArrayList(customer, registration);
		//workflowAttachmentService.addItems(workflow, attachments);

		//assertNotNull(workflowAttachmentService.containsItem(workflow, attachments));
		//assertEquals(attachments, workflow.getAttachments());

		//modelService.save(workflow);
		//assertTrue(modelService.getModelType(workflow).equals(workflow));

		B2BRegistrationWorkflowFacade.launchWorkflow(workflowTemplateModel, registration);
		verify(workflowProcessingService).startWorkflow(workflow);

	}

}
