/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.cockpitng.user;


import static com.hybris.backoffice.cockpitng.user.BackofficeCockpitUserService.CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import com.hybris.backoffice.cockpitng.user.cache.BackofficeCockpitUserServiceCache;
import com.hybris.backoffice.user.BackofficeRoleService;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.cockpitng.core.util.CockpitProperties;
import com.hybris.cockpitng.util.CockpitSessionService;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class BackofficeCockpitUserServiceTest
{

	public static final String USER_NAME = "ADAM_321";
	public static final String UID = "3141592";

	@InjectMocks
	private final BackofficeCockpitUserService backofficeCockpitUserService = new BackofficeCockpitUserService();

	@Mock
	private UserService userService;
	@Mock
	private CockpitSessionService cockpitSessionService;
	@Mock
	private CockpitProperties cockpitProperties;
	@Mock
	private BackofficeRoleService backofficeRoleService;

	@Mock
	private UserGroupModel adminGroup;
	@Mock
	private UserModel user;

	@Mock
	private BackofficeCockpitUserServiceCache backofficeCockpitUserServiceCache;


	@Test
	public void testGetCurrentUserWithSetValue()
	{
		//given
		when(userService.getCurrentUser()).thenReturn(user);
		when(user.getUid()).thenReturn(USER_NAME);

		// when
		final String currentUserUid = backofficeCockpitUserService.getCurrentUser();

		// then
		assertThat(currentUserUid).isEqualTo(USER_NAME);
	}

	@Test
	public void testGetCurrentUserWithoutSetValue()
	{
		// given
		when(userService.getCurrentUser()).thenReturn(null);

		// when
		final String currentUserUid = backofficeCockpitUserService.getCurrentUser();

		// then
		assertThat(currentUserUid).isNull();
	}

	@Test
	public void testIsAdmin()
	{
		// given
		when(backofficeCockpitUserServiceCache.isAdmin(eq(UID), any())).thenReturn(Boolean.TRUE);
		// when
		final Boolean isAdmin = Boolean.valueOf(backofficeCockpitUserService.isAdmin(UID));

		// then
		assertThat(isAdmin).isTrue();
	}

	@Test
	public void testSetCurrentUser()
	{
		// given
		final UserModel currentUser = user;
		when(userService.getUserForUID(UID)).thenReturn(currentUser);

		// when
		backofficeCockpitUserService.setCurrentUser(UID);

		// then
		verify(userService).getUserForUID(UID);
	}

	@Test
	public void testCurrentUserWithoutCheckingForAnonymous()
	{
		// given
		when(userService.getCurrentUser()).thenReturn(user);
		when(user.getUid()).thenReturn(USER_NAME);
		when(cockpitProperties.getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false)).thenReturn(false);

		// when
		final String currentUserUid = backofficeCockpitUserService.getCurrentUser();

		// then
		assertThat(currentUserUid).isEqualTo(USER_NAME);
		verify(userService).getCurrentUser();
		verify(user).getUid();
		verify(cockpitProperties).getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false);
	}

	@Test
	public void testCurrentUserWithCheckingForNonActiveAnonymous()
	{
		// given
		when(userService.getCurrentUser()).thenReturn(user);
		when(user.getUid()).thenReturn(USER_NAME);
		when(cockpitProperties.getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false)).thenReturn(true);
		when(userService.isAnonymousUser(user)).thenReturn(false);

		// when
		final String currentUserUid = backofficeCockpitUserService.getCurrentUser();

		// then
		assertThat(currentUserUid).isEqualTo(USER_NAME);
		verify(userService).getCurrentUser();
		verify(user).getUid();
		verify(cockpitProperties).getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false);
		verify(userService).isAnonymousUser(user);
	}

	@Test
	public void testCurrentUserWithCheckingForActiveAnonymous()
	{
		// given
		when(userService.getCurrentUser()).thenReturn(user);
		when(cockpitProperties.getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false)).thenReturn(true);
		when(userService.isAnonymousUser(user)).thenReturn(true);

		// when
		final String currentUserUid = backofficeCockpitUserService.getCurrentUser();

		// then
		assertThat(currentUserUid).isNull();
		verify(userService).getCurrentUser();
		verify(cockpitProperties).getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false);
		verify(userService).isAnonymousUser(user);
	}

	@Test
	public void testVerifiedAnonymousUserWithEnabledPropertyAndNonActiveAnonymous()
	{
		// given
		when(cockpitProperties.getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false)).thenReturn(true);
		when(userService.isAnonymousUser(user)).thenReturn(false);

		// when
		final boolean verifiedAnonymousUser = backofficeCockpitUserService.isVerifiedAnonymousUser(user);

		// then
		assertThat(verifiedAnonymousUser).isEqualTo(false);
		verify(cockpitProperties).getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false);
		verify(userService).isAnonymousUser(user);
	}

	@Test
	public void testVerifiedAnonymousUserWithEnabledPropertyAndActiveAnonymous()
	{
		// given
		when(cockpitProperties.getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false)).thenReturn(true);
		when(userService.isAnonymousUser(user)).thenReturn(true);

		// when
		final boolean verifiedAnonymousUser = backofficeCockpitUserService.isVerifiedAnonymousUser(user);

		// then
		assertThat(verifiedAnonymousUser).isEqualTo(true);
		verify(cockpitProperties).getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false);
		verify(userService).isAnonymousUser(user);
	}

	@Test
	public void testVerifiedAnonymousUserWithDisabledProperty()
	{
		// given
		when(cockpitProperties.getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false)).thenReturn(false);
		Mockito.lenient().when(userService.isAnonymousUser(user)).thenReturn(true);

		// when
		final boolean verifiedAnonymousUser = backofficeCockpitUserService.isVerifiedAnonymousUser(user);

		// then
		assertThat(verifiedAnonymousUser).isEqualTo(false);
		verify(cockpitProperties).getBoolean(CURRENT_USER_VERIFIES_ANONYMOUS_USER_PROPERTY, false);
		verify(userService, times(0)).isAnonymousUser(user);
	}

}
