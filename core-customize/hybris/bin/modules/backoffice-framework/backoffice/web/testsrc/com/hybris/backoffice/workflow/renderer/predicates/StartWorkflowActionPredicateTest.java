/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.workflow.renderer.predicates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.workflow.WorkflowStatus;
import de.hybris.platform.workflow.model.WorkflowModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.backoffice.workflow.WorkflowFacade;


@RunWith(MockitoJUnitRunner.class)
public class StartWorkflowActionPredicateTest
{
	@Mock
	private WorkflowFacade facade;

	@Mock
	private WorkflowModel workflow;

	@InjectMocks
	private StartWorkflowActionPredicate predicate;

	@Test
	public void testPredicateWhenWorkflowCanBeStarted()
	{
		//given
		Mockito.lenient().when(facade.getWorkflowStatus(workflow)).thenReturn(WorkflowStatus.PLANNED);
		when(facade.canBeStarted(workflow)).thenReturn(true);

		//when
		final boolean result = predicate.test(workflow);

		//then
		assertThat(result).isTrue();
	}

	@Test
	public void testPredicateWhenWorkflowCannotBeStarted()
	{
		//given
		Mockito.lenient().when(facade.getWorkflowStatus(workflow)).thenReturn(WorkflowStatus.TERMINATED);

		//when
		final boolean result = predicate.test(workflow);

		//then
		assertThat(result).isFalse();
	}

}
