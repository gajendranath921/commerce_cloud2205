/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.jalo;

import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.ComposedType;

import org.apache.log4j.Logger;


public class B2BRegistrationRejectedProcess extends GeneratedB2BRegistrationRejectedProcess
{
	private static final Logger LOG = Logger.getLogger(B2BRegistrationRejectedProcess.class.getName());

	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final Item.ItemAttributeMap allAttributes)
			throws JaloBusinessException
	{
		// business code placed here will be executed before the item is created
		// then create the item
		final Item item = super.createItem(ctx, type, allAttributes);
		// business code placed here will be executed after the item was created
		// and return the item
		return item;
	}

}
