/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.namedquery.validator;

import de.hybris.platform.cms2.exceptions.InvalidNamedQueryException;
import de.hybris.platform.cms2.namedquery.service.NamedQueryFactory;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Required;


/**
 * Predicate to test if a given query name maps to an existing named query.
 * <p>
 * Returns <tt>TRUE</tt> if the named query exists; <tt>FALSE</tt> otherwise.
 * </p>
 */
public class NamedQueryExistsPredicate implements Predicate<String>
{
	private NamedQueryFactory namedQueryFactory;

	@Override
	public boolean test(final String target)
	{
		boolean result = true;
		try
		{
			getNamedQueryFactory().getNamedQuery(target);
		}
		catch (final InvalidNamedQueryException e)
		{
			result = false;
		}
		return result;
	}

	protected NamedQueryFactory getNamedQueryFactory()
	{
		return namedQueryFactory;
	}

	@Required
	public void setNamedQueryFactory(final NamedQueryFactory namedQueryFactory)
	{
		this.namedQueryFactory = namedQueryFactory;
	}

}
