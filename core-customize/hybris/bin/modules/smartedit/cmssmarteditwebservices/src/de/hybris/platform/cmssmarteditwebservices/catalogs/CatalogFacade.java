/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.catalogs;

import de.hybris.platform.cmsfacades.data.CatalogData;

import java.util.List;


/**
 * Facade interface which deals with methods related to catalog operations which the current user has READ and/or WRITE
 * access to.
 */
public interface CatalogFacade
{
	/**
	 * Given a site id, this method will return a list of all content catalogs where the current user has at least a READ
	 * access to one of the catalog version of the catalog.
	 *
	 * @param siteId
	 *           the site identifier
	 *
	 * @return All catalogs that are configured for a site where the user as a least a READ access to a catalog version
	 *         of the catalog; never <tt>null</tt>
	 */
	List<CatalogData> getContentCatalogs(String siteId);

	/**
	 * Given a site id, this method will return a list of all product catalogs where the current user has at least a READ
	 * access to one of the catalog version of the catalog.
	 *
	 * @param siteId
	 *           the site identifier
	 *
	 * @return All catalogs that are configured for a site where the user as a least a READ access to a catalog version
	 *         of the catalog; never <tt>null</tt>
	 */
	List<CatalogData> getProductCatalogs(String siteId);
}
