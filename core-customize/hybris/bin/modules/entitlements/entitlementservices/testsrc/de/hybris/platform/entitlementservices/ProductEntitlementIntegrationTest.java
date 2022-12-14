/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.entitlementservices;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.entitlementservices.model.ProductEntitlementModel;
import de.hybris.platform.impex.constants.ImpExConstants;
import de.hybris.platform.jalo.CoreBasicDataCreator;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.Config;

import javax.annotation.Resource;

import java.util.Collection;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@IntegrationTest
public class ProductEntitlementIntegrationTest extends ServicelayerTest
{
	private static final Logger LOG = Logger.getLogger(ProductEntitlementIntegrationTest.class);

	@Resource
	private UserService userService;

	@Resource
	private ModelService modelService;

	@Resource
	private ProductService productService;

	@Resource
	private CatalogVersionService catalogVersionService;

	private static final String PRODUCT_CODE = "GALAXY_NEXUS";

	private ProductModel product;

	@Before
	public void setUp() throws Exception
	{
		LOG.info("Creating data for ProductEntitlementTest ...");
		userService.setCurrentUser(userService.getAdminUser());
		final long startTime = System.currentTimeMillis();
		new CoreBasicDataCreator().createEssentialData(Collections.EMPTY_MAP, null);
		// importing test csv
		final String legacyModeBackup = Config.getParameter(ImpExConstants.Params.LEGACY_MODE_KEY);
		LOG.info("Existing value for " + ImpExConstants.Params.LEGACY_MODE_KEY + " :" + legacyModeBackup);
		Config.setParameter(ImpExConstants.Params.LEGACY_MODE_KEY, "true");
		importCsv("/commerceservices/test/testCommerceCart.csv", "utf-8");
		Config.setParameter(ImpExConstants.Params.LEGACY_MODE_KEY, "false");
		importCsv("/entitlementservices/test/testEntitlements.impex", "utf-8");
		Config.setParameter(ImpExConstants.Params.LEGACY_MODE_KEY, legacyModeBackup);

		LOG.info("Finished data for ProductEntitlementTest " + (System.currentTimeMillis() - startTime) + "ms");
		modelService.detachAll();
	}

	/**
	 * Import multiple subscription entitlements of the same type for a subscription product, for example, a trial period
	 * entitlement and a normal entitlement
	 */
	@Test
	public void testEntitlementsWithTrialPeriods()
	{
		setupProducts();

		assertNotNull(product);

		final Collection<ProductEntitlementModel> entitlements = product.getProductEntitlements();
		assertNotNull(entitlements);

		assertEquals(2, entitlements.size());

		final ProductEntitlementModel[] entitlementArray = entitlements.toArray(new ProductEntitlementModel[entitlements
				.size()]);

		assertEquals(entitlementArray[0].getEntitlement().getId(), entitlementArray[1].getEntitlement().getId());
	}

	private void setupProducts()
	{
		final CatalogVersionModel catalogVersionModel = catalogVersionService.getCatalogVersion("testCatalog", "Online");
		product = productService.getProductForCode(catalogVersionModel,
				PRODUCT_CODE);
	}

}
