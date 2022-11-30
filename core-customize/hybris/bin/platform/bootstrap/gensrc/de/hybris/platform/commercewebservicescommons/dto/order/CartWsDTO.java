/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import de.hybris.platform.b2bacceleratorfacades.order.data.B2BPaymentTypeData;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.AbstractOrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PromotionResultWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Cart
 */
@ApiModel(value="Cart", description="Representation of a Cart")
public  class CartWsDTO extends AbstractOrderWsDTO 

{



	/** Total unit count<br/><br/><i>Generated property</i> for <code>CartWsDTO.totalUnitCount</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="totalUnitCount", value="Total unit count") 	
	private Integer totalUnitCount;

	/** List of potential order promotions for cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.potentialOrderPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="potentialOrderPromotions", value="List of potential order promotions for cart") 	
	private List<PromotionResultWsDTO> potentialOrderPromotions;

	/** List of potential product promotions for cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.potentialProductPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="potentialProductPromotions", value="List of potential product promotions for cart") 	
	private List<PromotionResultWsDTO> potentialProductPromotions;

	/** Name of the cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="name", value="Name of the cart") 	
	private String name;

	/** Description of the cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="description", value="Description of the cart") 	
	private String description;

	/** Date of cart expiration time<br/><br/><i>Generated property</i> for <code>CartWsDTO.expirationTime</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="expirationTime", value="Date of cart expiration time") 	
	private Date expirationTime;

	/** Date of saving cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.saveTime</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="saveTime", value="Date of saving cart") 	
	private Date saveTime;

	/** Information about person who saved cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.savedBy</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="savedBy", value="Information about person who saved cart") 	
	private PrincipalWsDTO savedBy;

	/** <i>Generated property</i> for <code>CartWsDTO.costCenter</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="costCenter") 	
	private B2BCostCenterWsDTO costCenter;

	/** <i>Generated property</i> for <code>CartWsDTO.paymentType</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="paymentType") 	
	private B2BPaymentTypeData paymentType;

	/** <i>Generated property</i> for <code>CartWsDTO.purchaseOrderNumber</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="purchaseOrderNumber") 	
	private String purchaseOrderNumber;
	
	public CartWsDTO()
	{
		// default constructor
	}
	
	public void setTotalUnitCount(final Integer totalUnitCount)
	{
		this.totalUnitCount = totalUnitCount;
	}

	public Integer getTotalUnitCount() 
	{
		return totalUnitCount;
	}
	
	public void setPotentialOrderPromotions(final List<PromotionResultWsDTO> potentialOrderPromotions)
	{
		this.potentialOrderPromotions = potentialOrderPromotions;
	}

	public List<PromotionResultWsDTO> getPotentialOrderPromotions() 
	{
		return potentialOrderPromotions;
	}
	
	public void setPotentialProductPromotions(final List<PromotionResultWsDTO> potentialProductPromotions)
	{
		this.potentialProductPromotions = potentialProductPromotions;
	}

	public List<PromotionResultWsDTO> getPotentialProductPromotions() 
	{
		return potentialProductPromotions;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}

	public Date getExpirationTime() 
	{
		return expirationTime;
	}
	
	public void setSaveTime(final Date saveTime)
	{
		this.saveTime = saveTime;
	}

	public Date getSaveTime() 
	{
		return saveTime;
	}
	
	public void setSavedBy(final PrincipalWsDTO savedBy)
	{
		this.savedBy = savedBy;
	}

	public PrincipalWsDTO getSavedBy() 
	{
		return savedBy;
	}
	
	public void setCostCenter(final B2BCostCenterWsDTO costCenter)
	{
		this.costCenter = costCenter;
	}

	public B2BCostCenterWsDTO getCostCenter() 
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
	

}