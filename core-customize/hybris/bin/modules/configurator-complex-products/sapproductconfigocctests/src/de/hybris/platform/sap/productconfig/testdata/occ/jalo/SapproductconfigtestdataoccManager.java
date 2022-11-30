/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.testdata.occ.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.sap.productconfig.testdata.occ.constants.SapproductconfigtestdataoccConstants;




/**
 * This is the extension manager of the Sapproductconfigtestdataocc extension.
 */
public class SapproductconfigtestdataoccManager extends GeneratedSapproductconfigtestdataoccManager
{
	/**
	 * factory-method for this class
	 *
	 * @return manager instance
	 */
	public static final SapproductconfigtestdataoccManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (SapproductconfigtestdataoccManager) em.getExtension(SapproductconfigtestdataoccConstants.EXTENSIONNAME);
	}

}
