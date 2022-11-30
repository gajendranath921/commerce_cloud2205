/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 */
package de.hybris.platform.sap.productconfig.rules.rao;

import de.hybris.platform.ruleengineservices.rao.AbstractActionedRAO;
import de.hybris.platform.sap.productconfig.rules.rao.CsticRAO;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ProductConfigRAO extends AbstractActionedRAO 
{

	/** <i>Generated property</i> for <code>ProductConfigRAO.productCode</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String productCode;
	/** <i>Generated property</i> for <code>ProductConfigRAO.configId</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String configId;
	/** <i>Generated property</i> for <code>ProductConfigRAO.inCart</code> property defined at extension <code>sapproductconfigrules</code>. */
	private Boolean inCart;
	/** <i>Generated property</i> for <code>ProductConfigRAO.cstics</code> property defined at extension <code>sapproductconfigrules</code>. */
	private List<CsticRAO> cstics;
	
	public ProductConfigRAO()
	{
		// default constructor
	}
	

	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}
	
	public String getProductCode() 
	{
		return productCode;
	}

	public void setConfigId(final String configId)
	{
		this.configId = configId;
	}
	
	public String getConfigId() 
	{
		return configId;
	}

	public void setInCart(final Boolean inCart)
	{
		this.inCart = inCart;
	}
	
	public Boolean getInCart() 
	{
		return inCart;
	}

	public void setCstics(final List<CsticRAO> cstics)
	{
		this.cstics = cstics;
	}
	
	public List<CsticRAO> getCstics() 
	{
		return cstics;
	}
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("productCode", productCode)
			.append("configId", configId)
			.append("inCart", inCart)
			.append("cstics", cstics)
			.toString();
	}

 	@Override
   public boolean equals(Object obj)
	{
		if (obj == null || !this.getClass().equals(obj.getClass())) {
      	return false;
      } else if (obj == this) {
      	return true;
      }
      ProductConfigRAO other = (ProductConfigRAO)obj;
      return new EqualsBuilder()
			.append(productCode, other.productCode)
			.append(configId, other.configId)
			.append(inCart, other.inCart)
         .isEquals();
   }
    	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
			.append(productCode)
			.append(configId)
			.append(inCart)
			.toHashCode();
	}
}