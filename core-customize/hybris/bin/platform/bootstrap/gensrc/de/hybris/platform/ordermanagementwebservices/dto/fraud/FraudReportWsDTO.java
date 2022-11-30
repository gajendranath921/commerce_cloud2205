/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.fraud;

import java.io.Serializable;
import de.hybris.platform.ordermanagementwebservices.dto.fraud.FraudSymptomScoringsWsDTO;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class FraudReportWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FraudReportWsDTO.explanation</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String explanation;

	/** <i>Generated property</i> for <code>FraudReportWsDTO.fraudSymptomScorings</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<FraudSymptomScoringsWsDTO> fraudSymptomScorings;

	/** <i>Generated property</i> for <code>FraudReportWsDTO.provider</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String provider;

	/** <i>Generated property</i> for <code>FraudReportWsDTO.status</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String status;

	/** <i>Generated property</i> for <code>FraudReportWsDTO.timestamp</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private Date timestamp;
	
	public FraudReportWsDTO()
	{
		// default constructor
	}
	
	public void setExplanation(final String explanation)
	{
		this.explanation = explanation;
	}

	public String getExplanation() 
	{
		return explanation;
	}
	
	public void setFraudSymptomScorings(final List<FraudSymptomScoringsWsDTO> fraudSymptomScorings)
	{
		this.fraudSymptomScorings = fraudSymptomScorings;
	}

	public List<FraudSymptomScoringsWsDTO> getFraudSymptomScorings() 
	{
		return fraudSymptomScorings;
	}
	
	public void setProvider(final String provider)
	{
		this.provider = provider;
	}

	public String getProvider() 
	{
		return provider;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setTimestamp(final Date timestamp)
	{
		this.timestamp = timestamp;
	}

	public Date getTimestamp() 
	{
		return timestamp;
	}
	

}