/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.predicates;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.common.predicates.IsCollectionAttributePredicate;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.CollectionTypeModel;
import de.hybris.platform.core.model.type.MapTypeModel;
import de.hybris.platform.core.model.type.TypeModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class IsCollectionAttributePredicateTest
{

    @InjectMocks
    private IsCollectionAttributePredicate isCollectionAttributePredicate;

    @Mock
    private TypeModel attributeTypeModel;

    @Mock
    private MapTypeModel localizedAttributeTypeModel;

    @Mock
    private AttributeDescriptorModel attributeDescriptor;

    @Test
    public void givenAttributeDescriptorWhenLocalizedAndNotACollectionWillReturnFalse()
    {
        doReturn(localizedAttributeTypeModel).when(attributeDescriptor).getAttributeType();
        doReturn(true).when(attributeDescriptor).getLocalized();
        doReturn(attributeTypeModel).when(localizedAttributeTypeModel).getReturntype();
        doReturn("someNonsenseItemType").when(attributeTypeModel).getItemtype();

        assertThat(isCollectionAttributePredicate.test(attributeDescriptor), is(false));
        verify(localizedAttributeTypeModel, times(1)).getReturntype();
    }

    @Test
    public void givenAttributeDescriptorWhenLocalizedAndIsACollectionWillReturnTrue()
    {
        doReturn(localizedAttributeTypeModel).when(attributeDescriptor).getAttributeType();
        doReturn(true).when(attributeDescriptor).getLocalized();
        doReturn(attributeTypeModel).when(localizedAttributeTypeModel).getReturntype();
        doReturn(CollectionTypeModel._TYPECODE).when(attributeTypeModel).getItemtype();

        assertThat(isCollectionAttributePredicate.test(attributeDescriptor), is(true));
        verify(localizedAttributeTypeModel, times(1)).getReturntype();
    }

    @Test
    public void givenAttributeDescriptorWhenNotLocalizedAndIsACollectionWillReturnTrue()
    {
        doReturn(attributeTypeModel).when(attributeDescriptor).getAttributeType();
        doReturn(false).when(attributeDescriptor).getLocalized();
        doReturn(CollectionTypeModel._TYPECODE).when(attributeTypeModel).getItemtype();

        assertThat(isCollectionAttributePredicate.test(attributeDescriptor), is(true));
        verify(localizedAttributeTypeModel, times(0)).getReturntype();
    }


    @Test
    public void givenAttributeDescriptorWhenNotLocalizedAndIsNotACollectionWillReturnFalse()
    {
        doReturn(attributeTypeModel).when(attributeDescriptor).getAttributeType();
        doReturn(false).when(attributeDescriptor).getLocalized();
        doReturn("someNonsenseItemType").when(attributeTypeModel).getItemtype();

        assertThat(isCollectionAttributePredicate.test(attributeDescriptor), is(false));
        verify(localizedAttributeTypeModel, times(0)).getReturntype();
    }


}
