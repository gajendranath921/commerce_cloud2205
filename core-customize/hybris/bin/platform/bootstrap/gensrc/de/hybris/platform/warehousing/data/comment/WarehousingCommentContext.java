/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.comment;

import java.io.Serializable;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.warehousing.data.comment.WarehousingCommentEventType;


import java.util.Objects;
public  class WarehousingCommentContext  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WarehousingCommentContext.commentType</code> property defined at extension <code>warehousing</code>. */
	
	private WarehousingCommentEventType commentType;

	/** <i>Generated property</i> for <code>WarehousingCommentContext.item</code> property defined at extension <code>warehousing</code>. */
	
	private ItemModel item;

	/** <i>Generated property</i> for <code>WarehousingCommentContext.subject</code> property defined at extension <code>warehousing</code>. */
	
	private String subject;

	/** <i>Generated property</i> for <code>WarehousingCommentContext.text</code> property defined at extension <code>warehousing</code>. */
	
	private String text;
	
	public WarehousingCommentContext()
	{
		// default constructor
	}
	
	public void setCommentType(final WarehousingCommentEventType commentType)
	{
		this.commentType = commentType;
	}

	public WarehousingCommentEventType getCommentType() 
	{
		return commentType;
	}
	
	public void setItem(final ItemModel item)
	{
		this.item = item;
	}

	public ItemModel getItem() 
	{
		return item;
	}
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setText(final String text)
	{
		this.text = text;
	}

	public String getText() 
	{
		return text;
	}
	

}