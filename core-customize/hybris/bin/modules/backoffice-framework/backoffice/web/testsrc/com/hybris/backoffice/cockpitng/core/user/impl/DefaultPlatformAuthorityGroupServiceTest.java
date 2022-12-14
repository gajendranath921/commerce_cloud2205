/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.cockpitng.core.user.impl;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.search.restriction.SearchRestrictionService;
import de.hybris.platform.servicelayer.session.MockSessionService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Sets;
import com.hybris.backoffice.daos.BackofficeRoleDao;
import com.hybris.backoffice.model.user.BackofficeRoleModel;
import com.hybris.cockpitng.core.user.CockpitUserService;
import com.hybris.cockpitng.core.user.impl.AuthorityGroup;
import com.hybris.cockpitng.util.CockpitSessionService;
import com.hybris.backoffice.spring.security.BackofficeUserDetailsService;
import com.hybris.backoffice.user.BackofficeRoleService;
import com.hybris.backoffice.catalogversioneventhandling.AvailableCatalogVersionsTag;


@RunWith(MockitoJUnitRunner.class)
public class DefaultPlatformAuthorityGroupServiceTest
{
	@InjectMocks
	private DefaultPlatformAuthorityGroupService authorityGroupService;
	@Mock
	private CockpitSessionService cockpitSessionService;
	@Mock
	private CockpitUserService cockpitUserService;
	@Mock
	private UserService userService;
	@Mock
	private BackofficeRoleDao backofficeRoleDao;
	@Mock
	private SearchRestrictionService searchRestrictionService;
	@Mock
	private BackofficeUserDetailsService userDetailsService;
	@Mock
	private BackofficeRoleService backofficeRoleService;
	@Mock
	private AvailableCatalogVersionsTag availableCatalogVersionsTag;

	@Mock(answer = Answers.CALLS_REAL_METHODS)
	private MockSessionService sessionService;
	private static final String COCKPIT_ACTIVE_AUTHORITY_GROUP = "cockpitActiveAuthorityGroup";


	@Test
	public void testGetActiveAuthorityGroupForUser()
	{

		final AuthorityGroup simpleGroup = Mockito.mock(AuthorityGroup.class);
		Mockito.when(simpleGroup.getAuthorities()).thenReturn(Collections.singletonList("role_simple"));
		Mockito.when(simpleGroup.getName()).thenReturn("simple");

		final AuthorityGroup advancedGroup = Mockito.mock(AuthorityGroup.class);
		Mockito.lenient().when(advancedGroup.getAuthorities()).thenReturn(Collections.singletonList("role_advanced"));
		Mockito.when(advancedGroup.getName()).thenReturn("advanced");

		Mockito.when(cockpitUserService.getCurrentUser()).thenReturn("simple");
		Mockito.when(cockpitSessionService.getAttribute("cockpitActiveAuthorityGroup")).thenReturn(simpleGroup);
		final AuthorityGroup group1 = authorityGroupService.getActiveAuthorityGroupForUser(simpleGroup.getName());
		Assert.assertTrue("role_simple".equals(group1.getAuthorities().get(0)));

		// Whenever the userNames are not the same null should be return
		Mockito.when(cockpitSessionService.getAttribute("cockpitActiveAuthorityGroup")).thenReturn(advancedGroup);
		final AuthorityGroup group2 = authorityGroupService.getActiveAuthorityGroupForUser(advancedGroup.getName());
		Assert.assertNull(group2);
	}

	@Test
	public void shouldActiveCatalogVersionWhenRoleActived()
	{
		final String userId = "testUser";
		final UserModel mockUser = mock(UserModel.class);
		when(cockpitUserService.getCurrentUser()).thenReturn("user");
		when(cockpitSessionService.getAttribute(COCKPIT_ACTIVE_AUTHORITY_GROUP)).thenReturn(null);

		when(userService.getUserForUID(userId)).thenReturn(mockUser);
		when(userService.getAllUserGroupsForUser(mockUser, BackofficeRoleModel.class)).thenReturn(Collections.singleton(mock(BackofficeRoleModel.class)));
		when(userService.getCurrentUser()).thenReturn(mockUser);

		authorityGroupService.getActiveAuthorityGroupForUser(userId);

		verify(userDetailsService, times(1)).activateCatalogVersions(mockUser);
	}

	@Test
	public void shouldActiveCatalogVersionWhenSetActiveAuthorityGroupForUser()
	{
		final UserModel mockUser = mock(UserModel.class);
		when(userService.getCurrentUser()).thenReturn(mockUser);

		authorityGroupService.setActiveAuthorityGroupForUser(mock(AuthorityGroup.class));

		verify(userDetailsService, times(1)).activateCatalogVersions(mockUser);
	}

	@Test
	public void shouldNotActiveCatalogVersionWhenSetNullActiveAuthorityGroupForUser()
	{
		final UserModel mockUser = mock(UserModel.class);
		Mockito.lenient().when(userService.getCurrentUser()).thenReturn(mockUser);

		authorityGroupService.setActiveAuthorityGroupForUser(null);

		verify(userDetailsService, never()).activateCatalogVersions(mockUser);
	}


	@Test
	public void testGetAllAuthorityGroups()
	{
		final AuthorityGroup fullGroup = Mockito.mock(AuthorityGroup.class);
		Mockito.when(fullGroup.getAuthorities()).thenReturn(Arrays.asList("role_simple", "role_advanced"));
		Mockito.lenient().when(fullGroup.getName()).thenReturn("full");

		final Set<BackofficeRoleModel> backOfficeRoles = new LinkedHashSet<BackofficeRoleModel>();
		final BackofficeRoleModel roleSimple = Mockito.mock(BackofficeRoleModel.class);
		Mockito.when(roleSimple.getUid()).thenReturn("role_simple");
		final BackofficeRoleModel roleAdvanced = Mockito.mock(BackofficeRoleModel.class);
		Mockito.when(roleAdvanced.getUid()).thenReturn("role_advanced");

		backOfficeRoles.add(roleSimple);
		backOfficeRoles.add(roleAdvanced);

		Mockito.when(backofficeRoleDao.findAllBackofficeRoles()).thenReturn(backOfficeRoles);

		final List<AuthorityGroup> allGroups = authorityGroupService.getAllAuthorityGroups();
		Assert.assertEquals(backOfficeRoles.size(), allGroups.size());

		for (int i = 0; i < allGroups.size(); i++)
		{
			final String authorityCode = allGroups.get(i).getCode();
			final String expectedAuthorityCode = fullGroup.getAuthorities().get(i);
			Assert.assertTrue(expectedAuthorityCode.equals(authorityCode));
		}
	}

	@Test
	public void testGetAllAuthorityGroupsForUser()
	{
		final AuthorityGroup fullGroup = Mockito.mock(AuthorityGroup.class);
		Mockito.lenient().when(fullGroup.getAuthorities()).thenReturn(Arrays.asList("role_simple", "role_advanced"));
		Mockito.when(fullGroup.getCode()).thenReturn("full");

		final BackofficeRoleModel roleSimple = Mockito.mock(BackofficeRoleModel.class);
		Mockito.when(roleSimple.getUid()).thenReturn("role_simple");
		final BackofficeRoleModel roleAdvanced = Mockito.mock(BackofficeRoleModel.class);
		Mockito.when(roleAdvanced.getUid()).thenReturn("role_advanced");
		final BackofficeRoleModel roleComplex = Mockito.mock(BackofficeRoleModel.class);
		Mockito.when(roleComplex.getUid()).thenReturn("role_complex");

		final Set<BackofficeRoleModel> backOfficeRoles = new LinkedHashSet<BackofficeRoleModel>();
		backOfficeRoles.add(roleAdvanced);
		backOfficeRoles.add(roleSimple);
		backOfficeRoles.add(roleComplex);
		final UserModel userModel = new UserModel();
		userModel.setUid("full");

		Mockito.when(userService.getUserForUID("full")).thenReturn(userModel);
		Mockito.when(userService.getAllUserGroupsForUser(userModel, BackofficeRoleModel.class)).thenReturn(backOfficeRoles);

		final List<AuthorityGroup> allGroups = authorityGroupService.getAllAuthorityGroupsForUser(fullGroup.getCode());
		Assert.assertEquals(backOfficeRoles.size(), allGroups.size());

		Assert.assertEquals("role_advanced", allGroups.get(0).getCode());
		Assert.assertEquals("role_complex", allGroups.get(1).getCode());
		Assert.assertEquals("role_simple", allGroups.get(2).getCode());
	}

	@Test
	public void testGetAuthorityGroup()
	{

		final BackofficeRoleModel roleModel1 = Mockito.mock(BackofficeRoleModel.class);
		Mockito.when(roleModel1.getUid()).thenReturn("role_advanced");
		Mockito.when(roleModel1.getDescription()).thenReturn("This is an advanced user");
		Mockito.when(roleModel1.getDisplayName()).thenReturn("this is loc name");

		final BackofficeRoleModel roleModel2 = Mockito.mock(BackofficeRoleModel.class);
		Mockito.when(roleModel2.getUid()).thenReturn("role_second");
		Mockito.when(roleModel2.getDescription()).thenReturn("This is a second user");
		Mockito.when(roleModel2.getDisplayName()).thenReturn("this is loc name");
		Mockito.when(backofficeRoleDao.findAllBackofficeRoles()).thenReturn(Sets.newHashSet(roleModel1, roleModel2));

		final AuthorityGroup group1 = authorityGroupService.getAuthorityGroup("role_advanced");

		Assert.assertNotNull(group1);
		Assert.assertTrue("role_advanced".equals(group1.getCode()));
	}

}
