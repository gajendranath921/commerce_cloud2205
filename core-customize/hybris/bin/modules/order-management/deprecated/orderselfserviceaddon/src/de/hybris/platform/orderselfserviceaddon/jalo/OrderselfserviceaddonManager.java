/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */
package de.hybris.platform.orderselfserviceaddon.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.orderselfserviceaddon.constants.OrderselfserviceaddonConstants;

public class OrderselfserviceaddonManager extends GeneratedOrderselfserviceaddonManager
{
	public static final OrderselfserviceaddonManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (OrderselfserviceaddonManager) em.getExtension(OrderselfserviceaddonConstants.EXTENSIONNAME);
	}
	
}
