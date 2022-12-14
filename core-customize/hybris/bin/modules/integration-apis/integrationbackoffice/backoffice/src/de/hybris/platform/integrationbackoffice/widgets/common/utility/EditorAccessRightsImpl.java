/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationbackoffice.widgets.common.utility;

import de.hybris.platform.servicelayer.user.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class EditorAccessRightsImpl implements EditorAccessRights
{
	private UserService userService;
	private List<String> adminRoles = new ArrayList<>();

	@Override
	public boolean isUserAdmin()
	{
		// Check what user roles are to determine if in an admin capacity, if not, remove editing permissions

		// Cannot properly confirm credential, default to regular User
		if (getAdminRoles() == null)
		{
			return false;
		}

		final ArrayList<String> currentRoles = new ArrayList<>();
		getUserService().getCurrentUser().getGroups().forEach(role -> {
			currentRoles.add(role.getUid());
		});
		return !Collections.disjoint(currentRoles, getAdminRoles());
	}

	public List<String> getAdminRoles()
	{
		return List.copyOf(adminRoles);
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	public void setAdminRoles(final List<String> adminRolesList)
	{
		if(CollectionUtils.isNotEmpty(adminRolesList))
		{
			adminRoles = new ArrayList<>(adminRolesList);
		}
		else
		{
			adminRoles.clear();
		}
	}
}
