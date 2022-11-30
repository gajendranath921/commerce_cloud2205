/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.integrationkey.impl;

import static de.hybris.platform.integrationservices.constants.IntegrationservicesConstants.INTEGRATION_KEY_PROP_DIV;
import static de.hybris.platform.integrationservices.constants.IntegrationservicesConstants.INTEGRATION_KEY_TYPE_DIV;

import de.hybris.platform.integrationservices.integrationkey.IntegrationKeyMetadataGenerator;
import de.hybris.platform.integrationservices.model.DescriptorFactory;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.integrationservices.model.KeyAttribute;
import de.hybris.platform.integrationservices.util.ApplicationBeans;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

public class DefaultAlphabeticalIntegrationKeyMetadataGenerator implements IntegrationKeyMetadataGenerator
{
	private DescriptorFactory descriptorFactory;

	@Override
	public String generateKeyMetadata(final IntegrationObjectItemModel item)
	{
		Preconditions.checkArgument(item != null, "Cannot generate integration key metadata for null");

		return buildKeyAlias(item);
	}

	protected String buildKeyAlias(final IntegrationObjectItemModel item)
	{
		final StringBuilder stringBuilder = getDescriptorFactory().createItemTypeDescriptor(item)
				.getKeyDescriptor()
				.getKeyAttributes()
				.stream()
				.map(this::formatAliasPart)
				.distinct()
				.sorted()
				.map(StringBuilder::new)
				.reduce(new StringBuilder(), (a, b) -> a.append(b).append(INTEGRATION_KEY_PROP_DIV));
		return StringUtils.chop(stringBuilder.toString());
	}

	protected String formatAliasPart(final KeyAttribute keyAttribute)
	{
		return String.format("%s%s%s",
				keyAttribute.getItemCode(),
				INTEGRATION_KEY_TYPE_DIV,
				keyAttribute.getName());
	}

	public void setDescriptorFactory(final DescriptorFactory factory)
	{
		descriptorFactory = factory;
	}

	private DescriptorFactory getDescriptorFactory()
	{
		return descriptorFactory == null ? ApplicationBeans.getBean("integrationServicesDescriptorFactory", DescriptorFactory.class) : descriptorFactory;
	}
}
