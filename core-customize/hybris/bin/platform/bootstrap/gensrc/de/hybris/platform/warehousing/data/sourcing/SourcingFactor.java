/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.sourcing;

import java.io.Serializable;
import de.hybris.platform.warehousing.data.sourcing.SourcingFactorIdentifiersEnum;


import java.util.Objects;
public  class SourcingFactor  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SourcingFactor.factorId</code> property defined at extension <code>warehousing</code>. */
	
	private SourcingFactorIdentifiersEnum factorId;

	/** <i>Generated property</i> for <code>SourcingFactor.weight</code> property defined at extension <code>warehousing</code>. */
	
	private int weight;
	
	public SourcingFactor()
	{
		// default constructor
	}
	
	public void setFactorId(final SourcingFactorIdentifiersEnum factorId)
	{
		this.factorId = factorId;
	}

	public SourcingFactorIdentifiersEnum getFactorId() 
	{
		return factorId;
	}
	
	public void setWeight(final int weight)
	{
		this.weight = weight;
	}

	public int getWeight() 
	{
		return weight;
	}
	

}