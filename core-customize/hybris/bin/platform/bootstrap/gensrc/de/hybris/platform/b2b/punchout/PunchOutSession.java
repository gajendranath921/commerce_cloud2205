/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class PunchOutSession  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PunchOutSession.operation</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String operation;

	/** <i>Generated property</i> for <code>PunchOutSession.buyerCookie</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String buyerCookie;

	/** <i>Generated property</i> for <code>PunchOutSession.browserFormPostUrl</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String browserFormPostUrl;

	/** <i>Generated property</i> for <code>PunchOutSession.time</code> property defined at extension <code>b2bpunchout</code>. */
	
	private Date time;

	/** <i>Generated property</i> for <code>PunchOutSession.initiatedBy</code> property defined at extension <code>b2bpunchout</code>. */
	
	private List initiatedBy;

	/** <i>Generated property</i> for <code>PunchOutSession.targetedTo</code> property defined at extension <code>b2bpunchout</code>. */
	
	private List targetedTo;

	/** <i>Generated property</i> for <code>PunchOutSession.sentBy</code> property defined at extension <code>b2bpunchout</code>. */
	
	private List sentBy;

	/** <i>Generated property</i> for <code>PunchOutSession.sentByUserAgent</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String sentByUserAgent;

	/** <i>Generated property</i> for <code>PunchOutSession.key</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String key;

	/** <i>Generated property</i> for <code>PunchOutSession.salt</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String salt;
	
	public PunchOutSession()
	{
		// default constructor
	}
	
	public void setOperation(final String operation)
	{
		this.operation = operation;
	}

	public String getOperation() 
	{
		return operation;
	}
	
	public void setBuyerCookie(final String buyerCookie)
	{
		this.buyerCookie = buyerCookie;
	}

	public String getBuyerCookie() 
	{
		return buyerCookie;
	}
	
	public void setBrowserFormPostUrl(final String browserFormPostUrl)
	{
		this.browserFormPostUrl = browserFormPostUrl;
	}

	public String getBrowserFormPostUrl() 
	{
		return browserFormPostUrl;
	}
	
	public void setTime(final Date time)
	{
		this.time = time;
	}

	public Date getTime() 
	{
		return time;
	}
	
	public void setInitiatedBy(final List initiatedBy)
	{
		this.initiatedBy = initiatedBy;
	}

	public List getInitiatedBy() 
	{
		return initiatedBy;
	}
	
	public void setTargetedTo(final List targetedTo)
	{
		this.targetedTo = targetedTo;
	}

	public List getTargetedTo() 
	{
		return targetedTo;
	}
	
	public void setSentBy(final List sentBy)
	{
		this.sentBy = sentBy;
	}

	public List getSentBy() 
	{
		return sentBy;
	}
	
	public void setSentByUserAgent(final String sentByUserAgent)
	{
		this.sentByUserAgent = sentByUserAgent;
	}

	public String getSentByUserAgent() 
	{
		return sentByUserAgent;
	}
	
	public void setKey(final String key)
	{
		this.key = key;
	}

	public String getKey() 
	{
		return key;
	}
	
	public void setSalt(final String salt)
	{
		this.salt = salt;
	}

	public String getSalt() 
	{
		return salt;
	}
	

}