/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.order.populators;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.services.B2BWorkflowIntegrationService;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BOrderApprovalData;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BOrderHistoryEntryData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderhistory.model.OrderHistoryEntryModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowDecisionModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class B2BApprovalDataPopulatorTest
{

	@Mock
	private B2BWorkflowIntegrationService b2bWorkflowIntegrationService;

	@Mock
	private Converter<OrderModel, OrderData> orderConverter;

	@Mock
	private Converter<OrderHistoryEntryModel, B2BOrderHistoryEntryData> b2bOrderHistoryEntryConverter;

	@Mock
	private WorkflowActionModel source;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private OrderModel orderModel;

	@InjectMocks
	private final B2BApprovalDataPopulator b2bOrderApprovalDataPopulator = new B2BApprovalDataPopulator();

	@Before
	public void prepare()
	{
		b2bOrderApprovalDataPopulator.setOrderConverter(orderConverter);
		b2bOrderApprovalDataPopulator.setB2bOrderHistoryEntryConverter(b2bOrderHistoryEntryConverter);
	}

	@Test
	public void testPopulateDecisions()
	{
		final WorkflowDecisionModel wfOne = new WorkflowDecisionModel();
		wfOne.setCode("one");
		wfOne.setQualifier("oneQ");
		final WorkflowDecisionModel wfTwo = new WorkflowDecisionModel();
		wfTwo.setCode("two");
		wfTwo.setQualifier("twoQ");
		final List<WorkflowDecisionModel> decisions = Arrays.asList(wfOne, wfTwo);

		BDDMockito.given(b2bWorkflowIntegrationService.getOrderFromAction(source)).willReturn(orderModel);
		BDDMockito.given(orderModel.getHistoryEntries()).willReturn(Collections.EMPTY_LIST);
		BDDMockito.given(source.getDecisions()).willReturn(decisions);
		final B2BOrderApprovalData target = new B2BOrderApprovalData();
		//TODO should call the convert method instead of populator
		b2bOrderApprovalDataPopulator.populate(source, target);

		Assert.assertEquals(target.getAllDecisions(), Arrays.asList("oneQ".toUpperCase(), "twoQ".toUpperCase()));
	}
}
