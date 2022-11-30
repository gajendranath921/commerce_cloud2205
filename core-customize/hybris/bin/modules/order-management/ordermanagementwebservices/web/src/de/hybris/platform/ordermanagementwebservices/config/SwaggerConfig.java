/*
 * [y] hybris Platform
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.ordermanagementwebservices.config;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.webservicescommons.swagger.services.ApiVendorExtensionService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ClientCredentialsGrant;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Component
public class SwaggerConfig
{
	private static final String LICENSE_URL = "";
	private static final String TERMS_OF_SERVICE_URL = "";
	private static final String LICENSE = "Use of this file is subject to the terms of your agreement with SAP SE or its affiliates respecting the use of the SAP product for which this file relates.";
	private static final String DESC = "These services manage order cancellations, returns, fraud, and payment transactions.";
	private static final String TITLE = "Order Management Webservices";
	private static final String VERSION = "2.1.0";

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;
	@Resource(name = "apiVendorExtensionService")
	private ApiVendorExtensionService apiVendorExtensionService;
	
	@Bean
	public Docket apiDocumentation()
	{
		return (new Docket(DocumentationType.SWAGGER_2))
				.apiInfo(this.apiInfo()).select().paths(PathSelectors.any()).build()
				.produces(Set.of("application/json", "application/xml"))
				.securitySchemes(Arrays.asList(this.clientCredentialFlow(), this.passwordFlow()))
				.securityContexts(Arrays.asList(this.oauthSecurityContext()))
				.extensions(apiVendorExtensionService.getAllVendorExtensions("commercewebservices"));
	}

	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title(TITLE).description(DESC).termsOfServiceUrl(TERMS_OF_SERVICE_URL).license(LICENSE)
				.licenseUrl(LICENSE_URL).version(VERSION).build();
	}

	protected OAuth clientCredentialFlow() {
		AuthorizationScope authorizationScope = new AuthorizationScope(this.getPropertyValue("ordermanagementwebservices.oauth.scope"), "");
		ClientCredentialsGrant clientCredentialsGrant = new ClientCredentialsGrant("/authorizationserver/oauth/token");
		return new OAuth("oauth2_client_credentials", Arrays.asList(authorizationScope), Arrays.asList(clientCredentialsGrant));
	}

	protected String getPropertyValue(String propertyName) {
		return this.configurationService.getConfiguration().getString(propertyName);
	}

	protected OAuth passwordFlow() {
		AuthorizationScope authorizationScope = new AuthorizationScope(this.getPropertyValue("ordermanagementwebservices.oauth.scope"), "");
		ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant("/authorizationserver/oauth/token");
		return new OAuth("oauth2_password", Arrays.asList(authorizationScope), Arrays.asList(resourceOwnerPasswordCredentialsGrant));
	}

	protected SecurityContext oauthSecurityContext() {
		return SecurityContext.builder().securityReferences(this.oauthSecurityReferences()).forPaths(PathSelectors.any()).build();
	}

	protected List<SecurityReference> oauthSecurityReferences() {
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[0];
		return Arrays.asList(new SecurityReference("oauth2_password", authorizationScopes), new SecurityReference("oauth2_client_credentials", authorizationScopes));
	}

}
