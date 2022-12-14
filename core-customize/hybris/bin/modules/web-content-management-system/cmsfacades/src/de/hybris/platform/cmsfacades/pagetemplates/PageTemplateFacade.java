/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.pagetemplates;


import de.hybris.platform.cms2.exceptions.TypePermissionException;
import de.hybris.platform.cmsfacades.data.PageTemplateDTO;
import de.hybris.platform.cmsfacades.data.PageTemplateData;

import java.util.List;


/**
 * Component facade interface which deals with methods related to page operations.
 */
public interface PageTemplateFacade
{

	/**
	 * Retrieves the list of page templates matching the given filters and filtered by type.
	 *
	 * If the user does not have access to the provided page typeCode, then {@link TypePermissionException} is thrown.
	 *
	 * @param pageTemplateDTO
	 *           dto containing search restrictions
	 * @return a list of {@link PageTemplateData}
	 */
	List<PageTemplateData> findPageTemplates(PageTemplateDTO pageTemplateDTO);

	/**
	 * Retrieves the page template matching the given page.
	 *
	 * @param pageUuid
	 *           the uuid of a page
	 * @return {@link PageTemplateData}
	 */
	default PageTemplateData findPageTemplateByPageUuid(String pageUuid)
	{
		return null;
	}
}
