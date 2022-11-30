/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of an attribute value in the context of the configuration overview
 */
@ApiModel(value="CCPAttributeValueOverview", description="Representation of an attribute value in the context of the configuration overview")
public  class OverviewCsticValueWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Language dependent attribute name<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.characteristic</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="characteristic", value="Language dependent attribute name", example="Accessories") 	
	private String characteristic;

	/** Attribute ID<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.characteristicId</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="characteristicId", value="Attribute ID", example="ACCESSORIES") 	
	private String characteristicId;

	/** Language dependent value name<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.value</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="value", value="Language dependent value name", example="Extra Audio Package") 	
	private String value;

	/** Value ID<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.valueId</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="valueId", value="Value ID", example="EXTRA_AUDIO_PACKAGE") 	
	private String valueId;
	
	public OverviewCsticValueWsDTO()
	{
		// default constructor
	}
	
	public void setCharacteristic(final String characteristic)
	{
		this.characteristic = characteristic;
	}

	public String getCharacteristic() 
	{
		return characteristic;
	}
	
	public void setCharacteristicId(final String characteristicId)
	{
		this.characteristicId = characteristicId;
	}

	public String getCharacteristicId() 
	{
		return characteristicId;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	
	public void setValueId(final String valueId)
	{
		this.valueId = valueId;
	}

	public String getValueId() 
	{
		return valueId;
	}
	

}