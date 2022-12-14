/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.promotion.converters.populator;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.PromotionData;
import de.hybris.platform.promotions.model.AbstractPromotionModel;
import de.hybris.platform.promotions.model.PromotionGroupModel;

import java.util.Collections;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test suite for {@link de.hybris.platform.commercefacades.promotion.converters.populator.PromotionExtendedPopulator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class PromotionExtendedPopulatorTest
{
	private static final String PROMOTION_TITLE = "promotionTitle";
	private static final Boolean PROMOTION_ENABLED = Boolean.TRUE;
	private static final Date PROMOTION_START = new Date();
	private static final Integer PROMOTION_PRIORITY = Integer.valueOf(2);
	private static final String PROMOTION_GROUP_IDENTIFIER = "groupIdentifier";
	@Mock
	private AbstractPromotionModel promotionModel;
	@Mock
	private PromotionGroupModel promotionGroupModel;
	private PromotionExtendedPopulator promotionExtendedPopulator;

	@Before
	public void setUp()
	{
		promotionExtendedPopulator = spy(new PromotionExtendedPopulator());
		doReturn(Collections.EMPTY_LIST).when(promotionExtendedPopulator).convertRestrictions(anyCollection());

		given(promotionModel.getTitle()).willReturn(PROMOTION_TITLE);
		given(promotionModel.getEnabled()).willReturn(PROMOTION_ENABLED);
		given(promotionModel.getStartDate()).willReturn(PROMOTION_START);
		given(promotionModel.getPriority()).willReturn(PROMOTION_PRIORITY);

		given(promotionGroupModel.getIdentifier()).willReturn(PROMOTION_GROUP_IDENTIFIER);
		given(promotionModel.getPromotionGroup()).willReturn(promotionGroupModel);
		given(promotionModel.getRestrictions()).willReturn(Collections.EMPTY_LIST);
	}

	@Test
	public void testPopulate()
	{
		final PromotionData promotionData = new PromotionData();
		promotionExtendedPopulator.populate(promotionModel, promotionData);

		Assert.assertEquals(PROMOTION_TITLE, promotionData.getTitle());
		Assert.assertEquals(PROMOTION_ENABLED, promotionData.getEnabled());
		Assert.assertEquals(PROMOTION_START, promotionData.getStartDate());
		Assert.assertEquals(PROMOTION_PRIORITY, promotionData.getPriority());
		Assert.assertEquals(PROMOTION_GROUP_IDENTIFIER, promotionData.getPromotionGroup());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPopulateWithNullSource()
	{
		final PromotionData promotionData = new PromotionData();
		promotionExtendedPopulator.populate(null, promotionData);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPopulateWithNullTarget()
	{
		promotionExtendedPopulator.populate(promotionModel, null);
	}

}
