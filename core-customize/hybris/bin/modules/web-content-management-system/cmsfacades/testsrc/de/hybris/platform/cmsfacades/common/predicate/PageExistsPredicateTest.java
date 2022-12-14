/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.servicelayer.services.admin.CMSAdminPageService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class PageExistsPredicateTest
{
	private static final String PAGE_ID = "test-page-id";
	private static final String INVALID = "invalid";

	@Mock
	private CMSAdminPageService pageService;
	@Mock
	private AbstractPageModel page;

	@InjectMocks
	private PageExistsPredicate predicate;

	@Test
	public void shouldFail_PageNotFound() throws CMSItemNotFoundException
	{
		when(pageService.getPageForIdFromActiveCatalogVersion(INVALID)).thenThrow(new UnknownIdentifierException("exception"));

		final boolean result = predicate.test(INVALID);
		assertFalse(result);
	}

	@Test
	public void shouldPass_PageExists() throws CMSItemNotFoundException
	{
		when(pageService.getPageForIdFromActiveCatalogVersion(PAGE_ID)).thenReturn(page);
		final boolean result = predicate.test(PAGE_ID);
		assertTrue(result);
	}

}
