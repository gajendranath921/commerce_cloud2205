/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StringUtils, TypedMap } from '@smart/utils';
import { from, Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { IExperience, ISharedDataService } from 'smarteditcommons/services/interfaces';
import {
    CMSWEBSERVICES_PATH,
    CONTEXT_CATALOG,
    CONTEXT_CATALOG_VERSION,
    CONTEXT_SITE_ID,
    HttpUtils,
    PAGE_CONTEXT_CATALOG,
    PAGE_CONTEXT_CATALOG_VERSION,
    PAGE_CONTEXT_SITE_ID,
    EXPERIENCE_STORAGE_KEY
} from 'smarteditcommons/utils';

/**
 * A HTTP request interceptor which intercepts all 'cmswebservices/catalogs' requests and adds the current catalog and version
 * from any URI which define the variables 'CURRENT_CONTEXT_CATALOG' and 'CURRENT_CONTEXT_CATALOG_VERSION' in the URL.
 */
@Injectable()
export class ExperienceInterceptor implements HttpInterceptor {
    constructor(
        private readonly sharedDataService: ISharedDataService,
        private readonly stringUtils: StringUtils,
        private readonly httpUtils: HttpUtils
    ) {}

    /**
     * Interceptor method which gets called with a http config object, intercepts any 'cmswebservices/catalogs' requests and adds
     * the current catalog and version
     * from any URI which define the variables 'CURRENT_CONTEXT_CATALOG' and 'CURRENT_CONTEXT_CATALOG_VERSION' in the URL.
     * If the request URI contains any of 'PAGE_CONTEXT_SITE_ID', 'PAGE_CONTEXT_CATALOG' or 'PAGE_CONTEXT_CATALOG_VERSION',
     * then it is replaced by the siteId/catalogId/catalogVersion of the current page in context.
     *
     * The catalog name and catalog versions of the current experience and the page loaded are stored in the shared data service object called 'experience' during preview initialization
     * and here we retrieve those details and set it to headers.
     */
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (!CMSWEBSERVICES_PATH.test(request.url)) {
            return next.handle(request);
        }

        return from(this.sharedDataService.get(EXPERIENCE_STORAGE_KEY)).pipe(
            switchMap((data: IExperience) => {
                if (!data) {
                    return next.handle(request);
                }

                const keys: TypedMap<string> = {};
                keys.CONTEXT_SITE_ID_WITH_COLON = data.siteDescriptor.uid;
                keys.CONTEXT_CATALOG_VERSION_WITH_COLON = data.catalogDescriptor.catalogVersion;
                keys.CONTEXT_CATALOG_WITH_COLON = data.catalogDescriptor.catalogId;
                keys[CONTEXT_SITE_ID] = data.siteDescriptor.uid;
                keys[CONTEXT_CATALOG_VERSION] = data.catalogDescriptor.catalogVersion;
                keys[CONTEXT_CATALOG] = data.catalogDescriptor.catalogId;

                keys[PAGE_CONTEXT_SITE_ID] = data.pageContext
                    ? data.pageContext.siteId
                    : data.siteDescriptor.uid;
                keys[PAGE_CONTEXT_CATALOG_VERSION] = data.pageContext
                    ? data.pageContext.catalogVersion
                    : data.catalogDescriptor.catalogVersion;
                keys[PAGE_CONTEXT_CATALOG] = data.pageContext
                    ? data.pageContext.catalogId
                    : data.catalogDescriptor.catalogId;

                const newRequest = request.clone({
                    url: this.stringUtils.replaceAll(request.url, keys),
                    params:
                        request.params && typeof request.params === 'object'
                            ? this.httpUtils.transformHttpParams(request.params, keys)
                            : request.params
                });

                return next.handle(newRequest);
            })
        );
    }
}
