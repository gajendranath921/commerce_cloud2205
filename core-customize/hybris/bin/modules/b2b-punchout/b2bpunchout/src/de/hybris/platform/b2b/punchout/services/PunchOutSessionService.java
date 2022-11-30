/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.services;

import de.hybris.platform.b2b.punchout.PunchOutException;
import de.hybris.platform.b2b.punchout.PunchOutSession;
import de.hybris.platform.b2b.punchout.PunchOutSessionNotFoundException;
import de.hybris.platform.b2b.punchout.model.StoredPunchOutSessionModel;

import org.cxml.CXML;


/**
 * This service handles the basic operations on {@link PunchOutService} instances.
 */
public interface PunchOutSessionService
{
	/**
	 * Saves current {@link StoredPunchOutSessionModel} in the db.
	 */
	public void saveCurrentPunchoutSession();

	/**
	 * Loads a given {@link StoredPunchOutSessionModel} by sid.
	 *
	 * @param punchOutSessionId The sid to search.
	 * @return The {@link StoredPunchOutSessionModel}, or null if stored session does not exists.
	 */
	StoredPunchOutSessionModel loadStoredPunchOutSessionModel(final String punchOutSessionId);

	/**
	 * Activates a {@link PunchOutSession} for the current user session.
	 *
	 * @param punchOutSession the new punchOut session
	 */
	void activate(PunchOutSession punchOutSession);

	/**
	 * Loads and activates a {@link PunchOutSession} by its ID.
	 *
	 * @param punchOutSessionId the punchOut session ID
	 * @return the newly loaded session
	 * @throws PunchOutSessionNotFoundException when the session is not found
	 */
	PunchOutSession loadPunchOutSession(String punchOutSessionId);

	/**
	 * Set the cart for the current session using the cart saved in a given punch out session. This is necessary as the
	 * punchOut provider may use different sessions for sequential calls (e.g.: edit setup request and edit seamless
	 * login).<br>
	 * <i>Notice that this should only be called after punch out user is authenticated.</i>
	 *
	 * @param punchOutSessionId The punch out session ID.
	 */
	void setCurrentCartFromPunchOutSetup(final String punchOutSessionId);

	/**
	 * Retrieves the currently loaded {@link PunchOutSession}.
	 *
	 * @return the punchOut session or <code>null</code> if none has been loaded yet
	 */
	PunchOutSession getCurrentPunchOutSession();

	/**
	 * Gets the currently active punchOut session.
	 *
	 * @return the active punchOut session ID
	 */
	String getCurrentPunchOutSessionId();

	/**
	 * initiates and activates a punchout session
	 *
	 * @param request the cXML request
	 */
	void initAndActivatePunchOutSession(CXML request);

	/**
	 * Retrieves the userId from given Punchout Session.
	 *
	 * @param punchoutSession The session of the current punchout user.
	 * @return The userId, if the information contained in the encryptedText passes the security verification (null
	 * @throws PunchOutException If some of the required arguments are missing or empty.
	 */
	String retrieveUserId(final PunchOutSession punchoutSession) throws PunchOutException;
}
