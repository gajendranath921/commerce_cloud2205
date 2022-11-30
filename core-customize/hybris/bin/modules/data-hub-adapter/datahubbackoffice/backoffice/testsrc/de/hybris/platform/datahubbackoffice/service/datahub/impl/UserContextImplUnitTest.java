/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.datahubbackoffice.service.datahub.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.datahubbackoffice.TestApplicationContext;
import de.hybris.platform.servicelayer.user.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class UserContextImplUnitTest
{
	@Rule
	public TestApplicationContext applicationContext = new TestApplicationContext();

	@InjectMocks
	private final UserContextImpl userContext = new UserContextImpl();
	@Mock
	private UserService userService;
	private final UserModel currentUser = new UserModel();
	private final UserGroupModel userGroup = new UserGroupModel();

	@Before
	public void setUp()
	{
		doReturn(currentUser).when(userService).getCurrentUser();
		doReturn(userGroup).when(userService).getUserGroupForUID("datahubadmingroup");
	}

	@Test
	public void testGetCurrentUser()
	{
		assertThat(userContext.getCurrentUser())
				.isNotNull()
				.isEqualTo(currentUser);
	}

	@Test
	public void testUserIsPartOfDataHubAdminGroup()
	{
		givenCurrentUserIsInDataHubAdminGroup(true);

		assertThat(userContext.isUserDataHubAdmin()).isTrue();
	}

	@Test
	public void testUserIsNotInDataHubAdminGroup()
	{
		givenCurrentUserIsInDataHubAdminGroup(false);

		assertThat(userContext.isUserDataHubAdmin()).isFalse();
	}

	@Test
	public void testIsMemberOf()
	{
		givenCurrentUserIsInDataHubAdminGroup(true);

		assertThat(userContext.isMemberOf("datahubadmingroup")).isTrue();
		assertThat(userContext.isMemberOf("someothergroup")).isFalse();
	}

	@Test
	public void testUsesUserServiceFromTheAppContextWhenItWasNotInjected()
	{
		applicationContext.addBean("userService", userService);
		userContext.setUserService(null);

		assertThat(userContext.getCurrentUser()).isEqualTo(currentUser);
	}

	private void givenCurrentUserIsInDataHubAdminGroup(final boolean isDataHubAdmin)
	{
		doReturn(isDataHubAdmin).when(userService).isMemberOfGroup(currentUser, userGroup);
	}
}
