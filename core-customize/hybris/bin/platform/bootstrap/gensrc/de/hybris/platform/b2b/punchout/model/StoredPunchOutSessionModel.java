/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type StoredPunchOutSession first defined at extension b2bpunchout.
 */
@SuppressWarnings("all")
public class StoredPunchOutSessionModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "StoredPunchOutSession";
	
	/** <i>Generated constant</i> - Attribute key of <code>StoredPunchOutSession.sid</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String SID = "sid";
	
	/** <i>Generated constant</i> - Attribute key of <code>StoredPunchOutSession.punchOutSession</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String PUNCHOUTSESSION = "punchOutSession";
	
	/** <i>Generated constant</i> - Attribute key of <code>StoredPunchOutSession.cart</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String CART = "cart";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public StoredPunchOutSessionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public StoredPunchOutSessionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _cart initial attribute declared by type <code>StoredPunchOutSession</code> at extension <code>b2bpunchout</code>
	 * @param _punchOutSession initial attribute declared by type <code>StoredPunchOutSession</code> at extension <code>b2bpunchout</code>
	 * @param _sid initial attribute declared by type <code>StoredPunchOutSession</code> at extension <code>b2bpunchout</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public StoredPunchOutSessionModel(final CartModel _cart, final Object _punchOutSession, final String _sid)
	{
		super();
		setCart(_cart);
		setPunchOutSession(_punchOutSession);
		setSid(_sid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _cart initial attribute declared by type <code>StoredPunchOutSession</code> at extension <code>b2bpunchout</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _punchOutSession initial attribute declared by type <code>StoredPunchOutSession</code> at extension <code>b2bpunchout</code>
	 * @param _sid initial attribute declared by type <code>StoredPunchOutSession</code> at extension <code>b2bpunchout</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public StoredPunchOutSessionModel(final CartModel _cart, final ItemModel _owner, final Object _punchOutSession, final String _sid)
	{
		super();
		setCart(_cart);
		setOwner(_owner);
		setPunchOutSession(_punchOutSession);
		setSid(_sid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoredPunchOutSession.cart</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the cart
	 */
	@Accessor(qualifier = "cart", type = Accessor.Type.GETTER)
	public CartModel getCart()
	{
		return getPersistenceContext().getPropertyValue(CART);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoredPunchOutSession.punchOutSession</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the punchOutSession - Should be instance of type PunchOutSession
	 */
	@Accessor(qualifier = "punchOutSession", type = Accessor.Type.GETTER)
	public Object getPunchOutSession()
	{
		return getPersistenceContext().getPropertyValue(PUNCHOUTSESSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoredPunchOutSession.sid</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the sid
	 */
	@Accessor(qualifier = "sid", type = Accessor.Type.GETTER)
	public String getSid()
	{
		return getPersistenceContext().getPropertyValue(SID);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>StoredPunchOutSession.cart</code> attribute defined at extension <code>b2bpunchout</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the cart
	 */
	@Accessor(qualifier = "cart", type = Accessor.Type.SETTER)
	public void setCart(final CartModel value)
	{
		getPersistenceContext().setPropertyValue(CART, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>StoredPunchOutSession.punchOutSession</code> attribute defined at extension <code>b2bpunchout</code>. 
	 *  
	 * @param value the punchOutSession - Should be instance of type PunchOutSession
	 */
	@Accessor(qualifier = "punchOutSession", type = Accessor.Type.SETTER)
	public void setPunchOutSession(final Object value)
	{
		getPersistenceContext().setPropertyValue(PUNCHOUTSESSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>StoredPunchOutSession.sid</code> attribute defined at extension <code>b2bpunchout</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the sid
	 */
	@Accessor(qualifier = "sid", type = Accessor.Type.SETTER)
	public void setSid(final String value)
	{
		getPersistenceContext().setPropertyValue(SID, value);
	}
	
}
