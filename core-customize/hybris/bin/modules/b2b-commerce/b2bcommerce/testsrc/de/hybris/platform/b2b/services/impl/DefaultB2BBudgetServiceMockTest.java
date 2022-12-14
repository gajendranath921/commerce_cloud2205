/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.services.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.dao.B2BBudgetDao;
import de.hybris.platform.b2b.mock.HybrisMokitoTest;
import de.hybris.platform.b2b.model.B2BBudgetModel;
import de.hybris.platform.b2b.model.B2BCostCenterModel;
import de.hybris.platform.commerceservices.search.dao.PagedGenericDao;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.util.StandardDateRange;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultB2BBudgetServiceMockTest extends HybrisMokitoTest
{
	private final DefaultB2BBudgetService defaultB2BBudgetService = new DefaultB2BBudgetService();
	private final Set<B2BBudgetModel> budgetModelSet = mock(Set.class);
	private final List<B2BBudgetModel> budgetModelList = mock(List.class);
	private final B2BBudgetModel budgetModel = mock(B2BBudgetModel.class);
	private final CurrencyModel currency = mock(CurrencyModel.class);
	private final Iterator iterator = mock(Iterator.class);
	private final B2BBudgetDao b2bBudgetDao = mock(B2BBudgetDao.class);
	private final PagedGenericDao<B2BBudgetModel> pagedB2BBudgetDao = mock(PagedGenericDao.class);

	public static final Logger LOG = Logger.getLogger(DefaultB2BBudgetServiceMockTest.class);

	@Before
	public void setup() throws Exception
	{
		when(budgetModel.getCurrency()).thenReturn(currency);

		budgetModelList.add(budgetModel);
		when(budgetModelList.iterator()).thenReturn(iterator);

		budgetModelSet.add(budgetModel);
		when(budgetModelSet.iterator()).thenReturn(iterator);
		when(iterator.hasNext()).thenReturn(Boolean.TRUE, Boolean.FALSE);
		when(iterator.next()).thenReturn(budgetModel);

		defaultB2BBudgetService.setB2bBudgetDao(b2bBudgetDao);
		defaultB2BBudgetService.setPagedB2BBudgetDao(pagedB2BBudgetDao);
	}

	@Test
	public void testGetCurrentBudgets() throws Exception
	{
		final B2BCostCenterModel costCenter = mock(B2BCostCenterModel.class);
		costCenter.setBudgets(budgetModelSet);
		when(costCenter.getBudgets()).thenReturn(budgetModelSet);
		when(costCenter.getCurrency()).thenReturn(currency);

		when(budgetModel.getActive()).thenReturn(Boolean.TRUE);

		final StandardDateRange dateRange = mock(StandardDateRange.class);
		when(budgetModel.getDateRange()).thenReturn(dateRange);

		when(dateRange.encloses(any(Date.class))).thenReturn(true);

		final Collection<B2BBudgetModel> budgetModelCollection = defaultB2BBudgetService.getCurrentBudgets(costCenter);
		Assert.assertTrue(budgetModelCollection.size() == 1 && budgetModelCollection.contains(budgetModel));
	}

	@Test
	public void testGetB2BBudgets() throws Exception
	{
		when(b2bBudgetDao.find()).thenReturn(budgetModelList);

		final Set<B2BBudgetModel> budgetSet = defaultB2BBudgetService.getB2BBudgets();
		Assert.assertTrue(budgetSet.size() == 1);
		Assert.assertTrue(budgetSet.contains(budgetModel));
	}

	@Test
	public void testFindPagedBudgets()
	{
		final SearchPageData<B2BBudgetModel> mockedSearchPageData = new SearchPageData<B2BBudgetModel>();
		mockedSearchPageData.setResults(budgetModelList);
		when(pagedB2BBudgetDao.find(any(PageableData.class))).thenReturn(mockedSearchPageData);

		final SearchPageData<B2BBudgetModel> searchPageData = defaultB2BBudgetService.findPagedBudgets(new PageableData());
		Assert.assertNotNull(searchPageData);
		Assert.assertNotNull(searchPageData.getResults());
	}
}
