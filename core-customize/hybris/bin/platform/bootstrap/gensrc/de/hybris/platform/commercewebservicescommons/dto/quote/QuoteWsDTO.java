/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.comments.CommentWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of the quote object.
 */
@ApiModel(value="Quote", description="Representation of the quote object.")
public  class QuoteWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Expiration time of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.expirationTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="expirationTime", value="Expiration time of the quote.", required=true, example="yyyy-MM-ddTHH:mm:ss+0000") 	
	private Date expirationTime;

	/** Code of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="code", value="Code of the quote.", required=true, example="0003005") 	
	private String code;

	/** Name of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="name", value="Name of the quote.", required=true, example="Quote 0003005") 	
	private String name;

	/** Current state of the quote. Possible state values - DRAFT, SUBMITTED, OFFER, CANCELLED, EXPIRED, etc.. The list of the states can be extended.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.state</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="state", value="Current state of the quote. Possible state values - DRAFT, SUBMITTED, OFFER, CANCELLED, EXPIRED, etc.. The list of the states can be extended.", required=true, example="CANCELLED") 	
	private String state;

	/** Description of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.description</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="description", value="Description of the quote.", required=false, example="Quote description") 	
	private String description;

	/** Current version of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.version</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="version", value="Current version of the quote.", required=true, example="1") 	
	private Integer version;

	/** Minimum subtotal value for the quote in the currency of the store.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.threshold</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="threshold", value="Minimum subtotal value for the quote in the currency of the store.", required=true, example="25000") 	
	private Double threshold;

	/** Id of the cart, which is linked to the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.cartId</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="cartId", value="Id of the cart, which is linked to the quote.", required=false, example="000350") 	
	private String cartId;

	/** Date of quote creation.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.creationTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="creationTime", value="Date of quote creation.", required=true, example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date creationTime;

	/** Date of the last quote update.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.updatedTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="updatedTime", value="Date of the last quote update.", required=true, example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date updatedTime;

	/** Actions, which are allowed to perform with the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.allowedActions</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="allowedActions", value="Actions, which are allowed to perform with the quote.") 	
	private List<String> allowedActions;

	/** Previously estimated total price of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.previousEstimatedTotal</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="previousEstimatedTotal", value="Previously estimated total price of the quote.") 	
	private PriceWsDTO previousEstimatedTotal;

	/** List of quote comments.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.comments</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="comments", value="List of quote comments.") 	
	private List<CommentWsDTO> comments;

	/** Total price of the cart with taxes.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.totalPriceWithTax</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="totalPriceWithTax", value="Total price of the cart with taxes.") 	
	private PriceWsDTO totalPriceWithTax;

	/** Total price of the cart.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.totalPrice</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="totalPrice", value="Total price of the cart.") 	
	private PriceWsDTO totalPrice;

	/** Entries of the cart.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.entries</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="entries", value="Entries of the cart.") 	
	private List<OrderEntryWsDTO> entries;

	/** Total number of the items in the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.totalItems</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="totalItems", value="Total number of the items in the quote.", required=true, example="2") 	
	private Integer totalItems;

	/** Discounts available for the current quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.quoteDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="quoteDiscounts", value="Discounts available for the current quote.") 	
	private PriceWsDTO quoteDiscounts;

	/** Discounts available for the current order.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.orderDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orderDiscounts", value="Discounts available for the current order.") 	
	private PriceWsDTO orderDiscounts;

	/** Subtotal of the quote with applied discount.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.subTotalWithDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="subTotalWithDiscounts", value="Subtotal of the quote with applied discount.") 	
	private PriceWsDTO subTotalWithDiscounts;

	/** Discount applied to the product.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.productDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="productDiscounts", value="Discount applied to the product.") 	
	private PriceWsDTO productDiscounts;
	
	public QuoteWsDTO()
	{
		// default constructor
	}
	
	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}

	public Date getExpirationTime() 
	{
		return expirationTime;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setState(final String state)
	{
		this.state = state;
	}

	public String getState() 
	{
		return state;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setVersion(final Integer version)
	{
		this.version = version;
	}

	public Integer getVersion() 
	{
		return version;
	}
	
	public void setThreshold(final Double threshold)
	{
		this.threshold = threshold;
	}

	public Double getThreshold() 
	{
		return threshold;
	}
	
	public void setCartId(final String cartId)
	{
		this.cartId = cartId;
	}

	public String getCartId() 
	{
		return cartId;
	}
	
	public void setCreationTime(final Date creationTime)
	{
		this.creationTime = creationTime;
	}

	public Date getCreationTime() 
	{
		return creationTime;
	}
	
	public void setUpdatedTime(final Date updatedTime)
	{
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() 
	{
		return updatedTime;
	}
	
	public void setAllowedActions(final List<String> allowedActions)
	{
		this.allowedActions = allowedActions;
	}

	public List<String> getAllowedActions() 
	{
		return allowedActions;
	}
	
	public void setPreviousEstimatedTotal(final PriceWsDTO previousEstimatedTotal)
	{
		this.previousEstimatedTotal = previousEstimatedTotal;
	}

	public PriceWsDTO getPreviousEstimatedTotal() 
	{
		return previousEstimatedTotal;
	}
	
	public void setComments(final List<CommentWsDTO> comments)
	{
		this.comments = comments;
	}

	public List<CommentWsDTO> getComments() 
	{
		return comments;
	}
	
	public void setTotalPriceWithTax(final PriceWsDTO totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}

	public PriceWsDTO getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
	
	public void setTotalPrice(final PriceWsDTO totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public PriceWsDTO getTotalPrice() 
	{
		return totalPrice;
	}
	
	public void setEntries(final List<OrderEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<OrderEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
	public void setTotalItems(final Integer totalItems)
	{
		this.totalItems = totalItems;
	}

	public Integer getTotalItems() 
	{
		return totalItems;
	}
	
	public void setQuoteDiscounts(final PriceWsDTO quoteDiscounts)
	{
		this.quoteDiscounts = quoteDiscounts;
	}

	public PriceWsDTO getQuoteDiscounts() 
	{
		return quoteDiscounts;
	}
	
	public void setOrderDiscounts(final PriceWsDTO orderDiscounts)
	{
		this.orderDiscounts = orderDiscounts;
	}

	public PriceWsDTO getOrderDiscounts() 
	{
		return orderDiscounts;
	}
	
	public void setSubTotalWithDiscounts(final PriceWsDTO subTotalWithDiscounts)
	{
		this.subTotalWithDiscounts = subTotalWithDiscounts;
	}

	public PriceWsDTO getSubTotalWithDiscounts() 
	{
		return subTotalWithDiscounts;
	}
	
	public void setProductDiscounts(final PriceWsDTO productDiscounts)
	{
		this.productDiscounts = productDiscounts;
	}

	public PriceWsDTO getProductDiscounts() 
	{
		return productDiscounts;
	}
	

}