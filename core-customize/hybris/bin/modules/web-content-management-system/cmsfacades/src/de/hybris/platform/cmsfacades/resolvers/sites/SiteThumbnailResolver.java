/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.resolvers.sites;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.site.CMSSiteModel;

import java.util.Optional;


/**
 * Resolver that uses a {@link CMSSiteModel} to resolve a homepage thumbnail URL
 */
public interface SiteThumbnailResolver {

	/**
	 * Can be called to resolve the homepage thumbnail url. In the event you need to act
	 * on the URL you can override this method and resolve the URL in an alternative way.
	 *
	 * @param cmsSiteModel the cmsSiteModel
	 * @return Optional thumbnail url
	 */
	Optional<String> resolveHomepageThumbnailUrl(CMSSiteModel cmsSiteModel);

	/**
	 * Can be called to resolve the homepage thumbnail url for a given catalog version.
	 * 
	 * @param catalogVersion
	 *           the catalog version containing the homepage
	 * @return Optional thumbnail url
	 */
	Optional<String> resolveHomepageThumbnailUrl(CatalogVersionModel catalogVersion);
}


