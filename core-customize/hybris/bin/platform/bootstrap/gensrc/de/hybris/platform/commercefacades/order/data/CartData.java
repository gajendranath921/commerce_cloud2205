/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import de.hybris.platform.acceleratorservices.enums.ImportStatus;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BCommentData;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BPaymentTypeData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BCostCenterData;
import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.product.data.PromotionResultData;
import de.hybris.platform.commercefacades.quote.data.QuoteData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class CartData extends AbstractOrderData 

{



	/** <i>Generated property</i> for <code>CartData.potentialOrderPromotions</code> property defined at extension <code>commercefacades</code>. */
	
	private List<PromotionResultData> potentialOrderPromotions;

	/** <i>Generated property</i> for <code>CartData.potentialProductPromotions</code> property defined at extension <code>commercefacades</code>. */
	
	private List<PromotionResultData> potentialProductPromotions;

	/** <i>Generated property</i> for <code>CartData.saveTime</code> property defined at extension <code>commercefacades</code>. */
	
	private Date saveTime;

	/** <i>Generated property</i> for <code>CartData.savedBy</code> property defined at extension <code>commercefacades</code>. */
	
	private PrincipalData savedBy;

	/** <i>Generated property</i> for <code>CartData.quoteData</code> property defined at extension <code>commercefacades</code>. */
	
	private QuoteData quoteData;

	/** <i>Generated property</i> for <code>CartData.cartInvalidMessage</code> property defined at extension <code>configurablebundlefacades</code>. */
	
	private String cartInvalidMessage;

	/** <i>Generated property</i> for <code>CartData.allEntriesCount</code> property defined at extension <code>configurablebundlefacades</code>. */
	
	private Integer allEntriesCount;

	/** <i>Generated property</i> for <code>CartData.importStatus</code> property defined at extension <code>acceleratorfacades</code>. */
	
	private ImportStatus importStatus;

	/** <i>Generated property</i> for <code>CartData.costCenter</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private B2BCostCenterData costCenter;

	/** <i>Generated property</i> for <code>CartData.paymentType</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private B2BPaymentTypeData paymentType;

	/** <i>Generated property</i> for <code>CartData.purchaseOrderNumber</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String purchaseOrderNumber;

	/** <i>Generated property</i> for <code>CartData.b2BComment</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private B2BCommentData b2BComment;

	/** <i>Generated property</i> for <code>CartData.b2bCustomerData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private CustomerData b2bCustomerData;

	/** <i>Generated property</i> for <code>CartData.quoteAllowed</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Boolean quoteAllowed;
	
	public CartData()
	{
		// default constructor
	}
	
	public void setPotentialOrderPromotions(final List<PromotionResultData> potentialOrderPromotions)
	{
		this.potentialOrderPromotions = potentialOrderPromotions;
	}

	public List<PromotionResultData> getPotentialOrderPromotions() 
	{
		return potentialOrderPromotions;
	}
	
	public void setPotentialProductPromotions(final List<PromotionResultData> potentialProductPromotions)
	{
		this.potentialProductPromotions = potentialProductPromotions;
	}

	public List<PromotionResultData> getPotentialProductPromotions() 
	{
		return potentialProductPromotions;
	}
	
	public void setSaveTime(final Date saveTime)
	{
		this.saveTime = saveTime;
	}

	public Date getSaveTime() 
	{
		return saveTime;
	}
	
	public void setSavedBy(final PrincipalData savedBy)
	{
		this.savedBy = savedBy;
	}

	public PrincipalData getSavedBy() 
	{
		return savedBy;
	}
	
	public void setQuoteData(final QuoteData quoteData)
	{
		this.quoteData = quoteData;
	}

	public QuoteData getQuoteData() 
	{
		return quoteData;
	}
	
	public void setCartInvalidMessage(final String cartInvalidMessage)
	{
		this.cartInvalidMessage = cartInvalidMessage;
	}

	public String getCartInvalidMessage() 
	{
		return cartInvalidMessage;
	}
	
	public void setAllEntriesCount(final Integer allEntriesCount)
	{
		this.allEntriesCount = allEntriesCount;
	}

	public Integer getAllEntriesCount() 
	{
		return allEntriesCount;
	}
	
	public void setImportStatus(final ImportStatus importStatus)
	{
		this.importStatus = importStatus;
	}

	public ImportStatus getImportStatus() 
	{
		return importStatus;
	}
	
	public void setCostCenter(final B2BCostCenterData costCenter)
	{
		this.costCenter = costCenter;
	}

	public B2BCostCenterData getCostCenter() 
	{
		return costCenter;
	}
	
	public void setPaymentType(final B2BPaymentTypeData paymentType)
	{
		this.paymentType = paymentType;
	}

	public B2BPaymentTypeData getPaymentType() 
	{
		return paymentType;
	}
	
	public void setPurchaseOrderNumber(final String purchaseOrderNumber)
	{
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public String getPurchaseOrderNumber() 
	{
		return purchaseOrderNumber;
	}
	
	public void setB2BComment(final B2BCommentData b2BComment)
	{
		this.b2BComment = b2BComment;
	}

	public B2BCommentData getB2BComment() 
	{
		return b2BComment;
	}
	
	public void setB2bCustomerData(final CustomerData b2bCustomerData)
	{
		this.b2bCustomerData = b2bCustomerData;
	}

	public CustomerData getB2bCustomerData() 
	{
		return b2bCustomerData;
	}
	
	/**
	 * @deprecated true
	 */
	@Deprecated(since = "6.3", forRemoval = true)
	public void setQuoteAllowed(final Boolean quoteAllowed)
	{
		this.quoteAllowed = quoteAllowed;
	}

	/**
	 * @deprecated true
	 */
	@Deprecated(since = "6.3", forRemoval = true)
	public Boolean getQuoteAllowed() 
	{
		return quoteAllowed;
	}
	

}