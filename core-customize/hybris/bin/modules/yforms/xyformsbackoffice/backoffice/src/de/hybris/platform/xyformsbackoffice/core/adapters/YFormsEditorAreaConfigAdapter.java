/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.xyformsbackoffice.core.adapters;

import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.xyformsbackoffice.core.YFormsBackofficeHelper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.StringUtils;

import com.hybris.cockpitng.core.config.CockpitConfigurationException;
import com.hybris.cockpitng.core.config.ConfigContext;
import com.hybris.cockpitng.core.config.impl.DefaultConfigContext;
import com.hybris.cockpitng.core.config.impl.adapters.EditorAreaConfigAdapter;
import com.hybris.cockpitng.core.config.impl.jaxb.editorarea.AbstractTab;
import com.hybris.cockpitng.core.config.impl.jaxb.editorarea.EditorArea;


/**
 * EditorArea configuration adapter which is responsible for arranging tabs, sections, panels, attributes in proper
 * order. Its main purpose is to hide administration tab for certain group of users.
 */
public class YFormsEditorAreaConfigAdapter extends EditorAreaConfigAdapter
{
	private static final Logger LOG = Logger.getLogger(YFormsEditorAreaConfigAdapter.class);

	private static final String ADMINISTRATION_TAB = "hmc.administration";

	private Set<String> types;
	private Set<String> rolesNotAllowed;

	private UserService userService;

	@Override
	public Class<EditorArea> getSupportedType()
	{
		return EditorArea.class;
	}

	@Override
	public EditorArea adaptAfterLoad(final ConfigContext context, final EditorArea ea) throws CockpitConfigurationException
	{
		final EditorArea editorArea = super.adaptAfterLoad(context, ea);
		if (shouldRemoveAdministrationTab(context, editorArea))
		{
			AbstractTab toRemove = null;
			for (final AbstractTab tab : editorArea.getCustomTabOrTab())
			{
				if (ADMINISTRATION_TAB.equals(tab.getName()))
				{
					toRemove = tab;
					break;
				}
			}
			if (toRemove != null)
			{
				LOG.debug("Removing Administration Tab");
				editorArea.getCustomTabOrTab().remove(toRemove);
			}
		}
		return editorArea;
	}

	/**
	 * Decides if the user may see the administration Tab or not.
	 *
	 * @param context
	 * @param ea
	 */
	private boolean shouldRemoveAdministrationTab(final ConfigContext context, final EditorArea ea)
	{
		final UserModel userModel = userService.getCurrentUser();
		if (userService.isAdmin(userModel))
		{
			LOG.debug("User has admin rights, administration tab will be shown");
			return false;
		}

		// We do this only for the following Types
		final String typeCode = context.getAttribute(DefaultConfigContext.CONTEXT_TYPE);
		if (!types.contains(typeCode))
		{
			LOG.debug(typeCode + " is not part of the defined types to be filtered");
			return false;
		}

		return YFormsBackofficeHelper.isUserInNotAllowedRoles(rolesNotAllowed, userModel);
	}

	@Required
	public void setTypes(final String types)
	{
		this.types = StringUtils.commaDelimitedListToSet(types);
	}

	@Required
	public void setRolesNotAllowed(final String rolesNotAllowed)
	{
		this.rolesNotAllowed = StringUtils.commaDelimitedListToSet(rolesNotAllowed);
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}
}
