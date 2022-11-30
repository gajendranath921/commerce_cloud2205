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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseStoreRAO extends AbstractActionedRAO 
{

	/** <i>Generated property</i> for <code>BaseStoreRAO.uid</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String uid;
	
	public BaseStoreRAO()
	{
		// default constructor
	}
	

	public void setUid(final String uid)
	{
		this.uid = uid;
	}
	
	public String getUid() 
	{
		return uid;
	}
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("uid", uid)
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
      BaseStoreRAO other = (BaseStoreRAO)obj;
      return new EqualsBuilder()
			.append(uid, other.uid)
         .isEquals();
   }
    	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
			.append(uid)
			.toHashCode();
	}
}