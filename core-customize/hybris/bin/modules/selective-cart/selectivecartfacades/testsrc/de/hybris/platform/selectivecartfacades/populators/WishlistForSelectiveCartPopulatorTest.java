/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.selectivecartfacades.populators;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.selectivecartfacades.data.Wishlist2Data;
import de.hybris.platform.selectivecartfacades.data.Wishlist2EntryData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.wishlist2.model.Wishlist2EntryModel;
import de.hybris.platform.wishlist2.model.Wishlist2Model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Junit test suite for {@link WishlistForSelectiveCartPopulator}
 */
@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class WishlistForSelectiveCartPopulatorTest
{

	WishlistForSelectiveCartPopulator wishlistForSelectiveCartPopulator = null;
	private static final Integer NUMS1 = 100;
	private static final Integer NUMS2 = 88;
	
	@Mock
	private Converter<Wishlist2EntryModel, Wishlist2EntryData> wishlistEntryConverter;
	
	@Mock
	private Converter<PrincipalModel, PrincipalData> principalConverter;
	
	@Before
	public void setUp()
	{
		wishlistForSelectiveCartPopulator = new WishlistForSelectiveCartPopulator();
	}
	
	@Test
	public void testPopulateWithSuccessfulResult()
	{
		
		wishlistForSelectiveCartPopulator.setPrincipalConverter(principalConverter);
		wishlistForSelectiveCartPopulator.setWishlistEntryConverter(wishlistEntryConverter);

		PrincipalData principalData = new PrincipalData();
		principalData.setName("jove");
		principalData.setUid("000001");

		given(principalConverter.convert(any())).willReturn(principalData);
		
		Wishlist2Data wishlist2Data = new Wishlist2Data();
		//wishlist2Data.setUser(principalData);
		wishlist2Data.setName("wishlist2");
		
		List<Wishlist2EntryData> entries = new ArrayList<>();
		Wishlist2EntryData wishlist2EntryData1 = new Wishlist2EntryData();
		Wishlist2EntryData wishlist2EntryData2 = new Wishlist2EntryData();
		wishlist2EntryData1.setQuantity(NUMS1);;
		wishlist2EntryData2.setQuantity(NUMS2);
		entries.add(wishlist2EntryData1);
		entries.add(wishlist2EntryData2);
		
		given(wishlistEntryConverter.convertAll(any())).willReturn(entries);
		
		//wishlist2Data.setEntries(entries);
		
		Wishlist2Model wishlist2Model = new Wishlist2Model();	
		
		wishlist2Model.setName("wishlist2");
		
		wishlistForSelectiveCartPopulator.populate(wishlist2Model, wishlist2Data);
		
		Assert.assertSame(wishlist2Model.getName(), wishlist2Data.getName());
		Assert.assertSame(principalData.getName(), wishlist2Data.getUser().getName());
		Assert.assertSame(principalData.getUid(), wishlist2Data.getUser().getUid());
		Assert.assertSame(entries.size(), wishlist2Data.getEntries().size());
		Assert.assertSame(entries.get(0).getQuantity(), wishlist2Data.getEntries().get(0).getQuantity());
		Assert.assertSame(entries.get(1).getQuantity(), wishlist2Data.getEntries().get(1).getQuantity());
	}
	
}
