/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationservices.process;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.personalizationservices.action.dao.CxActionResultDao;
import de.hybris.platform.personalizationservices.constants.PersonalizationservicesConstants;
import de.hybris.platform.personalizationservices.model.CxResultsModel;
import de.hybris.platform.personalizationservices.model.process.CxPersonalizationProcessModel;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction.Transition;
import de.hybris.platform.processengine.helpers.ProcessParameterHelper;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.impex.impl.ClasspathImpExResource;
import de.hybris.platform.servicelayer.session.impl.DefaultSessionTokenService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.task.RetryLaterException;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class CalculatePersonalizationForUserActionIntegrationTest extends ServicelayerTest
{
	@Resource
	private CalculatePersonalizationForUserAction calculatePersonalizationForUserAction;
	@Resource
	private CatalogVersionService catalogVersionService;
	@Resource
	private UserService userService;
	@Resource
	private CxActionResultDao cxActionResultDao;
	@Resource
	private DefaultSessionTokenService defaultSessionTokenService;
	@Resource
	private ProcessParameterHelper processParameterHelper;

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		createDefaultCatalog();
		importData(new ClasspathImpExResource("/personalizationservices/test/testdata_cxsite.impex", "UTF-8"));
		importData(new ClasspathImpExResource("/personalizationservices/test/testdata_personalizationservices.impex", "UTF-8"));
	}

	@Test
	public void shouldStoreEmptyActionResultsOnUser() throws RetryLaterException, Exception
	{
		//given
		final UserModel user = userService.getUserForUID("defaultcxcustomer");
		assertNoResultsInDatabase();

		final CxPersonalizationProcessModel process = new CxPersonalizationProcessModel();
		process.setCode("testCxCalculationProcess");
		process.setProcessDefinitionName("testProcessDefinition");
		process.setCatalogVersions(Collections.singletonList(catalogVersionService.getCatalogVersion("testCatalog", "Online")));
		process.setUser(user);
		process.setKey("testProcess");
		processParameterHelper.setProcessParameter(process, PersonalizationservicesConstants.SESSION_TOKEN,
				defaultSessionTokenService.getOrCreateSessionToken());


		final Transition result = calculatePersonalizationForUserAction.executeAction(process);

		Assert.assertThat(result, CoreMatchers.equalTo(Transition.OK));
		assertResultStoredInDatabase();
	}

	protected void assertResultStoredInDatabase()
	{
		final List<CxResultsModel> resultsList = cxActionResultDao
				.findResultsBySessionKey(defaultSessionTokenService.getOrCreateSessionToken());
		Assert.assertTrue(!resultsList.isEmpty());
	}

	protected void assertNoResultsInDatabase()
	{
		final List<CxResultsModel> resultsList = cxActionResultDao
				.findResultsBySessionKey(defaultSessionTokenService.getOrCreateSessionToken());
		Assert.assertEquals(0, resultsList.size());
	}

}
