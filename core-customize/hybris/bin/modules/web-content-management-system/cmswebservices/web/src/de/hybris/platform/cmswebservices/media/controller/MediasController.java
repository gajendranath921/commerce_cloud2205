/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.media.controller;

import static de.hybris.platform.cmswebservices.constants.CmswebservicesConstants.API_VERSION;

import de.hybris.platform.cms2.data.PageableData;
import de.hybris.platform.cmsfacades.data.MediaData;
import de.hybris.platform.cmsfacades.media.MediaFacade;
import de.hybris.platform.cmswebservices.data.MediaListData;
import de.hybris.platform.cmswebservices.dto.PageableWsDTO;
import de.hybris.platform.cmswebservices.security.IsAuthorizedCmsManager;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.webservicescommons.mapping.DataMapper;
import de.hybris.platform.webservicescommons.pagination.WebPaginationUtils;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Controller that handles searching and creating media container
 */
@RestController
@IsAuthorizedCmsManager
@RequestMapping(API_VERSION + "/catalogs/{catalogId}/versions/{versionId}/medias")
@Api(tags = "medias")
public class MediasController
{
    @Resource
    private MediaFacade mediaFacade;

    @Resource
    private DataMapper dataMapper;

    @Resource
    private WebPaginationUtils webPaginationUtils;

    @GetMapping(params = { "pageSize" })
    @ResponseBody
    @ApiOperation(value = "Finds medias by partial to full code matching.", notes = "Retrieves a list of available medias using a free text search field.", nickname = "getMediasByText")
    @ApiResponses(
            { //
                    @ApiResponse(code = 200, message = "Item which serves as a wrapper object that contains a list of MediaData; never null", response = MediaListData.class) })
    @ApiImplicitParams(
            { //
                    @ApiImplicitParam(name = "catalogId", value = "The catalog id", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(name = "versionId", value = "The catalog version identifier", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(name = "pageSize", value = "The maximum number of elements in the result list.", required = true, dataType = "string", paramType = "query"),
                    @ApiImplicitParam(name = "currentPage", value = "The requested page number", required = false, dataType = "string", paramType = "query")
            })
    public MediaListData findMedias(
            @ApiParam(value = "The string value on which medias will be filtered")
            @RequestParam(required = false) final String mask,
            @ApiParam(value = "The string value on which medias will be filtered")
            @RequestParam(required = false) final String mimeType,
            @ApiParam(value = "PageableWsDTO", required = true)
            @ModelAttribute final PageableWsDTO pageableInfo)
    {
        final Optional<PageableData> pageableDataOption = Optional.of(pageableInfo).map(pageableWsDTO -> getDataMapper().map(pageableWsDTO, PageableData.class));
        final PageableData pageableData = pageableDataOption.isPresent() ? pageableDataOption.get() : null;

        final SearchResult<MediaData> mediaSearchResult = getMediaFacade().findMedias(mask, mimeType, pageableData);

        final MediaListData medias = new MediaListData();
        medias.setMedia(mediaSearchResult.getResult().stream() //
                .map(mediaData -> getDataMapper().map(mediaData, de.hybris.platform.cmswebservices.data.MediaData.class)) //
                .collect(Collectors.toList()));
        medias.setPagination(getWebPaginationUtils().buildPagination(mediaSearchResult));
        return medias;
    }

    protected MediaFacade getMediaFacade()
    {
        return mediaFacade;
    }

    public void setMediaFacade(final MediaFacade mediaFacade)
    {
        this.mediaFacade = mediaFacade;
    }

    protected DataMapper getDataMapper()
    {
        return dataMapper;
    }

    public void setDataMapper(final DataMapper dataMapper)
    {
        this.dataMapper = dataMapper;
    }

    protected WebPaginationUtils getWebPaginationUtils()
    {
        return webPaginationUtils;
    }

    public void setWebPaginationUtils(final WebPaginationUtils webPaginationUtils)
    {
        this.webPaginationUtils = webPaginationUtils;
    }
}
