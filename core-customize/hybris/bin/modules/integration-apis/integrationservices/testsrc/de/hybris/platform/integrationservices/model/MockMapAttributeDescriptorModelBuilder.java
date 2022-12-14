/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.integrationservices.model;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;


import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.MapTypeModel;
import de.hybris.platform.core.model.type.TypeModel;

public class MockMapAttributeDescriptorModelBuilder extends BaseMockAttributeDescriptorModelBuilder<MockMapAttributeDescriptorModelBuilder, AttributeDescriptorModel>
{
	private TypeModel returnType;

	MockMapAttributeDescriptorModelBuilder()
	{
		// Prevent instantiation from externally
	}

	public static MockMapAttributeDescriptorModelBuilder mapAttributeDescriptor()
	{
		return new MockMapAttributeDescriptorModelBuilder();
	}

	public <T extends TypeModel> MockMapAttributeDescriptorModelBuilder withReturnType(final Class<T> returnType)
	{
		this.returnType = mock(returnType);
		return this;
	}

	public MockMapAttributeDescriptorModelBuilder withReturnType(final String returnType)
	{
		this.returnType = typeModel(returnType);
		return this;
	}

	public AttributeDescriptorModel build()
	{
		final AttributeDescriptorModel model = createMock(AttributeDescriptorModel.class);
		final MapTypeModel mapModel = mock(MapTypeModel.class);
		lenient().when(mapModel.getReturntype()).thenReturn(returnType);
		lenient().when(model.getAttributeType()).thenReturn(mapModel);
		lenient().when(model.getPrimitive()).thenReturn(primitive);
		return model;
	}

	@Override
	protected MockMapAttributeDescriptorModelBuilder myself()
	{
		return this;
	}
}