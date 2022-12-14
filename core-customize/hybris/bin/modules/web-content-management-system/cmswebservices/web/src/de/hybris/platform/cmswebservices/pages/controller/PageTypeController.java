/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.pages.controller;

import de.hybris.platform.cmsfacades.pages.PageFacade;
import de.hybris.platform.cmswebservices.data.PageTypeData;
import de.hybris.platform.cmswebservices.data.PageTypeListData;
import de.hybris.platform.cmswebservices.security.IsAuthorizedCmsManager;
import de.hybris.platform.webservicescommons.mapping.DataMapper;

import java.util.List;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static de.hybris.platform.cmswebservices.constants.CmswebservicesConstants.API_VERSION;


/**
 * Controller to get page types.
 */
@Controller
@IsAuthorizedCmsManager
@RequestMapping(API_VERSION + "/pagetypes")
@Api(tags = "page types")
public class PageTypeController
{
	@Resource
	private PageFacade cmsPageFacade;
	@Resource
	private DataMapper dataMapper;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Finds all page types.", notes = "Retrieves a list of available page types.",
					nickname = "getAllPageTypes")
	@ApiResponses({
			@ApiResponse(code = 200, message = "The list of page types", response = PageTypeListData.class)
	})
	public PageTypeListData findAllPageTypes()
	{
		final List<PageTypeData> pageTypes = getDataMapper() //
				.mapAsList(getCmsPageFacade().findAllPageTypes(), PageTypeData.class, null);

		final PageTypeListData pageTypeListData = new PageTypeListData();
		pageTypeListData.setPageTypes(pageTypes);
		return pageTypeListData;
	}

	protected PageFacade getCmsPageFacade()
	{
		return cmsPageFacade;
	}

	public void setCmsPageFacade(final PageFacade pageFacade)
	{
		this.cmsPageFacade = pageFacade;
	}

	protected DataMapper getDataMapper()
	{
		return dataMapper;
	}

	public void setDataMapper(final DataMapper dataMapper)
	{
		this.dataMapper = dataMapper;
	}
}
