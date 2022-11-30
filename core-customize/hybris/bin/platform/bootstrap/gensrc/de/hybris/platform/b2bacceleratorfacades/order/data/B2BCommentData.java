/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import java.util.Date;


import java.util.Objects;
/**
 * @deprecated Use {@link de.hybris.platform.commercefacades.comment.data.CommentData} instead.
 */
@Deprecated(since = "6.3", forRemoval = true)
public  class B2BCommentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BCommentData.comment</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String comment;

	/** <i>Generated property</i> for <code>B2BCommentData.code</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>B2BCommentData.timeStamp</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Date timeStamp;

	/** <i>Generated property</i> for <code>B2BCommentData.ownerData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private PrincipalData ownerData;
	
	public B2BCommentData()
	{
		// default constructor
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setTimeStamp(final Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public Date getTimeStamp() 
	{
		return timeStamp;
	}
	
	public void setOwnerData(final PrincipalData ownerData)
	{
		this.ownerData = ownerData;
	}

	public PrincipalData getOwnerData() 
	{
		return ownerData;
	}
	

}