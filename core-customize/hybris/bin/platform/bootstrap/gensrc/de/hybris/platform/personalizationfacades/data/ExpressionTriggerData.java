/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import de.hybris.platform.personalizationfacades.data.ExpressionData;
import de.hybris.platform.personalizationfacades.data.TriggerData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Expression trigger
 */
@ApiModel(value="expressionTrigger", description="Expression trigger")
public  class ExpressionTriggerData extends TriggerData 

{



	/** Details of the expression<br/><br/><i>Generated property</i> for <code>ExpressionTriggerData.expression</code> property defined at extension <code>personalizationfacades</code>. */
@ApiModelProperty(name="expression", value="Details of the expression") 	
	private ExpressionData expression;
	
	public ExpressionTriggerData()
	{
		// default constructor
	}
	
	public void setExpression(final ExpressionData expression)
	{
		this.expression = expression;
	}

	public ExpressionData getExpression() 
	{
		return expression;
	}
	

}