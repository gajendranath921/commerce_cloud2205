/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.occ.controllers;

import de.hybris.platform.sap.productconfig.facades.ConfigurationVariantData;
import de.hybris.platform.sap.productconfig.facades.ConfigurationVariantFacade;
import de.hybris.platform.sap.productconfig.occ.ConfigurationVariantWsDTO;
import de.hybris.platform.webservicescommons.mapping.DataMapper;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * Web Services Controller to expose the functionality of the
 * {@link de.hybris.platform.sap.productconfig.facades.ConfigurationVariantFacade}.
 */
@Controller
@Api(tags = "Product Configurator CCP Variant Search")
public class ProductConfiguratorCCPVariantSearchController
{


	@Resource(name = "sapProductConfigVariantFacade")
	private ConfigurationVariantFacade configurationVariantFacade;

	@Resource(name = "dataMapper")
	private DataMapper dataMapper;

	/**
	 * @return the dataMapper
	 */
	protected DataMapper getDataMapper()
	{
		return dataMapper;
	}

	/**
	 * @return the configurationVariantFacade
	 */
	protected ConfigurationVariantFacade getConfigurationVariantFacade()
	{
		return configurationVariantFacade;
	}


	@RequestMapping(value = SapproductconfigoccControllerConstants.GET_VARIANTS_URL, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(nickname = "getProductConfigurationVariantSearch", value = "Gets variants for a product configuration", notes = "Gets variants that match the current configuration attributes")
	@ApiBaseSiteIdParam
	public List<ConfigurationVariantWsDTO> getVariants(//
			@ApiParam(value = "Configuration identifier", required = true) //
			@PathVariable("configId")
			final String configId)
	{

		final List<ConfigurationVariantData> variants = getConfigurationVariantFacade().searchForSimilarVariants(configId);
		return getDataMapper().mapAsList(variants, ConfigurationVariantWsDTO.class, null);

	}

}
