/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.servicelayer.daos.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import de.hybris.platform.cms2.model.restrictions.AbstractRestrictionModel;
import de.hybris.platform.cms2.servicelayer.daos.CMSComponentDao;
import de.hybris.platform.cms2.servicelayer.daos.CMSRestrictionDao;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests the {@link DefaultCMSRestrictionDao}
 */
public class DefaultCMSRestrictionDaoTest extends ServicelayerTransactionalTest
{

	@Resource
	private CMSRestrictionDao cmsRestrictionDao;
	@Resource
	private CatalogVersionService catalogVersionService;
	@Resource
	private CMSComponentDao cmsComponentDao;

	private CatalogVersionModel catVersion;
	private final String categoryRestrictionCode = "restriction01";
	private final String productRestrictionCode = "restriction91";

	@Before
	public void setUp() throws Exception
	{
		importCsv("/test/cmsRestrictionTestData.csv", "windows-1252");
		catVersion = catalogVersionService.getCatalogVersion("cms_Catalog", "Online");
	}

	@Test
	public void shouldFindAllRestrictionsForCatalogVersion()
	{
		final Collection<AbstractRestrictionModel> restrictions = cmsRestrictionDao.findRestrictions(catVersion);
		assertThat(restrictions.size(), is(6));
	}

	@Test
	public void shouldFindNoRestrictionsForEmptyCatalog()
	{
		final CatalogVersionModel empty = catalogVersionService.getCatalogVersion("emptyCatalog", "Online");
		final Collection<AbstractRestrictionModel> restrictions = cmsRestrictionDao.findRestrictions(empty);
		assertThat(restrictions.size(), is(0));
	}

	@Test
	public void shouldFindRestrictionsForComponents()
	{
		final List<AbstractCMSComponentModel> components = cmsComponentDao.findCMSComponentsById("linkComponent01");
		final Collection<AbstractRestrictionModel> restrictions = cmsRestrictionDao.findRestrictionsForComponents(components, catVersion);
		assertThat(restrictions.size(), is(2));
	}

	@Test
	public void shouldFindNoRestrictionsForComponents()
	{
		final List<AbstractCMSComponentModel> components = cmsComponentDao.findCMSComponentsById("linkComponent02");
		final Collection<AbstractRestrictionModel> restrictions = cmsRestrictionDao.findRestrictionsForComponents(components, catVersion);
		assertThat(restrictions.size(), is(0));
	}

	protected Set<String> prepareCategoryCodes()
	{
		final Set<String> result = new HashSet<String>(2);
		result.add("category01");
		result.add("category02");
		return result;
	}

	protected Set<String> prepareProductCodes()
	{
		final Set<String> result = new HashSet<String>(2);
		result.add("product01");
		result.add("product02");
		return result;
	}

}
