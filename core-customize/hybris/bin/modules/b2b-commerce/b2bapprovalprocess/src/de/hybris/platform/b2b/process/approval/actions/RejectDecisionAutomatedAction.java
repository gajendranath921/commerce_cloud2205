/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.process.approval.actions;

import de.hybris.platform.b2b.enums.PermissionStatus;
import de.hybris.platform.b2b.event.OrderRejectedEvent;
import de.hybris.platform.b2b.process.approval.model.B2BApprovalProcessModel;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.workflow.model.WorkflowActionModel;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;


/**
 * Action which handles business logic after an approve decision has been chosen by an approver of a b2b approval
 * workflow
 */
public class RejectDecisionAutomatedAction extends B2BAbstractWorkflowAutomatedAction
{
	private static final Logger LOG = Logger.getLogger(RejectDecisionAutomatedAction.class);
	private EventService eventService;

	@Override
	public void performAction(final WorkflowActionModel action)
	{
		OrderModel order = null;
		try
		{
			final PrincipalModel principalAssigned = action.getPrincipalAssigned();
			final B2BApprovalProcessModel process = (B2BApprovalProcessModel) CollectionUtils.find(action.getAttachmentItems(),
					PredicateUtils.instanceofPredicate(B2BApprovalProcessModel.class));
			Assert.notNull(process, String.format("Process attachment missing for action %s", action.getCode()));
			order = process.getOrder();
			if (LOG.isDebugEnabled())
			{
				LOG.debug(String.format("Executing action %s for process %s on order %s assigned to %s", action.getCode(),
						process.getCode(), order.getCode(), principalAssigned.getUid()));
			}
			updatePermissionResultsStatus(order, principalAssigned, PermissionStatus.REJECTED);

			getEventService().publishEvent(new OrderRejectedEvent(order, principalAssigned));
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage(), e);
			if (order != null)
			{
				order.setStatus(OrderStatus.B2B_PROCESSING_ERROR);
				getModelService().save(order);
			}
		}
	}

	protected EventService getEventService()
	{
		return eventService;
	}

	@Required
	public void setEventService(final EventService eventService)
	{
		this.eventService = eventService;
	}
}
