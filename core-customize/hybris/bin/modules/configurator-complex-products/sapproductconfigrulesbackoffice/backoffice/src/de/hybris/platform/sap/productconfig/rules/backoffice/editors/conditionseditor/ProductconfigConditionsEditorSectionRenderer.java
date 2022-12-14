/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.rules.backoffice.editors.conditionseditor;

import de.hybris.platform.rulebuilderbackoffice.editors.conditionseditor.ConditionsEditorSectionRenderer;


public class ProductconfigConditionsEditorSectionRenderer extends ConditionsEditorSectionRenderer
{
	protected static final String PRODUCTCONFIG_CONDITIONS_EDITOR_ID = "conditionsEditor";

	@Override
	public String getEditorId()
	{
		return PRODUCTCONFIG_CONDITIONS_EDITOR_ID;
	}
}
