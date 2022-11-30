/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import java.io.Serializable;
import java.io.InputStream;


import java.util.Objects;
public  class SubscriptionBillingDetailFileStream  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SubscriptionBillingDetailFileStream.fileName</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String fileName;

	/** <i>Generated property</i> for <code>SubscriptionBillingDetailFileStream.inputStream</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private InputStream inputStream;

	/** <i>Generated property</i> for <code>SubscriptionBillingDetailFileStream.mimeType</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String mimeType;
	
	public SubscriptionBillingDetailFileStream()
	{
		// default constructor
	}
	
	public void setFileName(final String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	
	public void setInputStream(final InputStream inputStream)
	{
		this.inputStream = inputStream;
	}

	public InputStream getInputStream() 
	{
		return inputStream;
	}
	
	public void setMimeType(final String mimeType)
	{
		this.mimeType = mimeType;
	}

	public String getMimeType() 
	{
		return mimeType;
	}
	

}