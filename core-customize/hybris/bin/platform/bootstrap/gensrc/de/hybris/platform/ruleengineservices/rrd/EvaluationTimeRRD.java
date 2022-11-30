/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ruleengineservices.rrd;

import java.io.Serializable;


import java.util.Objects;
/**
 * Represents rule evaluation time (gets inserted as one fact per rule). Encapsulates milliseconds,
            between the evaluation time and midnight, January 1, 1970 UTC
        
 */
public  class EvaluationTimeRRD  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EvaluationTimeRRD.evaluationTime</code> property defined at extension <code>ruleengineservices</code>. */
	
	private Long evaluationTime;
	
	public EvaluationTimeRRD()
	{
		// default constructor
	}
	
	public void setEvaluationTime(final Long evaluationTime)
	{
		this.evaluationTime = evaluationTime;
	}

	public Long getEvaluationTime() 
	{
		return evaluationTime;
	}
	

}