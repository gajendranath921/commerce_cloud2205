/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.predicates;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.cms2.servicelayer.services.admin.CMSAdminPageService;
import de.hybris.platform.cmsfacades.cmsitems.OriginalClonedItemProvider;
import de.hybris.platform.cmsfacades.cmsitems.predicates.HasPageLabelChangedPredicate;
import de.hybris.platform.cmsfacades.constants.CmsfacadesConstants;
import de.hybris.platform.servicelayer.session.SessionService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class HasPageLabelChangedPredicateTest
{
	private static final String LABEL = "test-label";
	private static final String NEW_LABEL = "test-new-label";
	private static final String UID = "test-page-uid";

	@InjectMocks
	private HasPageLabelChangedPredicate predicate;

	@Mock
	private OriginalClonedItemProvider originalClonedItemProvider;
	@Mock
	private ContentPageModel contentPageModel;

	@Test
	public void testLabelHasChanged()
	{
		when(originalClonedItemProvider.getCurrentItem()).thenReturn(contentPageModel);
		when(contentPageModel.getLabel()).thenReturn(NEW_LABEL);

		final boolean result = predicate.test(LABEL);

		assertTrue(result);
	}

	@Test
	public void testLabelNotChanged()
	{
		when(originalClonedItemProvider.getCurrentItem()).thenReturn(contentPageModel);
		when(contentPageModel.getUid()).thenReturn(UID);
		when(contentPageModel.getLabel()).thenReturn(LABEL);

		final boolean result = predicate.test(LABEL);

		assertFalse(result);
	}

	@Test
	public void testLabelNotChanged_NoPagesFoundForLabel()
	{
		when(originalClonedItemProvider.getCurrentItem()).thenReturn(null);

		final boolean result = predicate.test(LABEL);

		assertFalse(result);
	}

}
