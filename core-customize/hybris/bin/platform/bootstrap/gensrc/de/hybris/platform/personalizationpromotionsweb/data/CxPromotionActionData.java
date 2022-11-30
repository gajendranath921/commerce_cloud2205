/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationpromotionsweb.data;

import de.hybris.platform.personalizationfacades.data.ActionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * CxPromotionAction details
 */
@ApiModel(value="cxPromotionAction", description="CxPromotionAction details")
public  class CxPromotionActionData extends ActionData 

{



	/** ID of the promotion<br/><br/><i>Generated property</i> for <code>CxPromotionActionData.promotionId</code> property defined at extension <code>personalizationpromotionsweb</code>. */
@ApiModelProperty(name="promotionId", value="ID of the promotion") 	
	private String promotionId;
	
	public CxPromotionActionData()
	{
		// default constructor
	}
	
	public void setPromotionId(final String promotionId)
	{
		this.promotionId = promotionId;
	}

	public String getPromotionId() 
	{
		return promotionId;
	}
	

}