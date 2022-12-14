/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.smartedit.controllers;

import java.util.Map;

import org.springframework.messaging.handler.annotation.Header;


/**
 * Gateway to relay the PUT operation to the secured webservice responsible of executing the operation. By default,
 * {@code smarteditwebservices} is the targeted extension.
 */
public interface HttpPUTGateway
{
	public String update(Map<String, String> payload, @Header("configId") String configId, @Header("Authorization") String token);
}
