/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.CollectionTypeModel;
import de.hybris.platform.core.model.type.TypeModel;
import de.hybris.platform.servicelayer.model.AbstractItemModel;

import java.lang.reflect.Field;

public class BackofficeTestUtil
{
	/**
	 * Only for unit tests! Sets the pk of an ItemModel. It relies on internal platform implementation and should not be used
	 * outside unit tests.
	 */
	public static void setPk(final AbstractItemModel itemModel, final long pk)
	{
		try
		{
			final Field field = itemModel.getItemModelContext().getClass().getDeclaredField("pk");
			field.setAccessible(true);
			field.set(itemModel.getItemModelContext(), PK.fromLong(pk));
		}
		catch (NoSuchFieldException | IllegalAccessException e)
		{
			throw new RuntimeException("Cannot set pk on itemModel: " + itemModel, e);
		}
	}

	public static AttributeDescriptorModel mockAttributeDescriptor(final String typecode)
	{
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final TypeModel typeModel = mock(TypeModel.class);
		Mockito.lenient().when(typeModel.getCode()).thenReturn(typecode);
		Mockito.lenient().when(attributeDescriptor.getAttributeType()).thenReturn(typeModel);
		return attributeDescriptor;
	}

	public static AttributeDescriptorModel mockCollectionTypeAttributeDescriptor(final String typecode)
	{
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);

		final CollectionTypeModel collectionType = mock(CollectionTypeModel.class);
		Mockito.lenient().when(collectionType.getCode()).thenReturn("CollectionType");
		when(attributeDescriptor.getAttributeType()).thenReturn(collectionType);

		final TypeModel typeModel = mock(TypeModel.class);
		when(typeModel.getCode()).thenReturn(typecode);
		when(collectionType.getElementType()).thenReturn(typeModel);
		return attributeDescriptor;
	}
}
