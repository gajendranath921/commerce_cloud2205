/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bpunchoutocctests.test.groovy.webservicetests.v2.controllers;

import static groovyx.net.http.ContentType.XML
import static org.apache.http.HttpStatus.SC_BAD_REQUEST
import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR
import static org.apache.http.HttpStatus.SC_OK
import static org.apache.http.HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE

import java.util.regex.Pattern

import org.apache.http.util.EntityUtils
import org.springframework.util.ResourceUtils

import de.hybris.bootstrap.annotations.ManualTest;
import de.hybris.platform.commercewebservicestests.test.groovy.webservicetests.v2.spock.AbstractSpockFlowTest;
import spock.lang.Unroll;
import de.hybris.platform.b2b.services.B2BOrderService;
import de.hybris.platform.core.Registry
import de.hybris.platform.core.model.order.OrderModel
import de.hybris.platform.core.model.product.ProductModel
import de.hybris.platform.core.model.user.UserModel
import de.hybris.platform.order.CartService
import de.hybris.platform.product.ProductService
import de.hybris.platform.servicelayer.user.UserService;

@ManualTest
@Unroll
public class B2BPunchoutOrderCreationTest extends AbstractSpockFlowTest {

	static final TOTAL_PRICE = 27.5
	static final PUNCHOUT_CUSTOMER = "punchout.customer@punchoutorg.com"

	def "When Ariba sends a request asking for Punchout Order Creation transaction "() {
		given: "a CXML Order Request"
		File file = ResourceUtils.getFile("classpath:b2bpunchoutocctests/test/b2bpunchoutoccOrderCreation.xml")
		def cXMLRequest = file.text

		when: "a valid Http POST request is made"
		def fullpath = getBasePathWithSite() + "/punchout/cxml/order"
		def pr = restClient.getParser();
		Pattern myRegex = ~/Response/
		pr.putAt(XML) { response ->
			String responseXml = EntityUtils.toString(response.entity)
			EntityUtils.consume(response.entity)
			return responseXml
		}
		ProductService productService = Registry.getApplicationContext().getBean("productService")
		CartService cartService = Registry.getApplicationContext().getBean("cartService")
		B2BOrderService orderService = Registry.getApplicationContext().getBean("b2bOrderService");
		UserService userService = Registry.getApplicationContext().getBean("userService");
		ProductModel product = productService.getProductForCode("TW1210-9342")
		println "Product Description " + product.getName()

		def response = restClient.post(
				path: fullpath,
				contentType: XML,
				body: cXMLRequest,
				headers: ["accept": XML],
				requestContentType: XML)


		then: "a valid response is obtained"
		with(response) {
			response.status == SC_OK
			println "RESPONSE data " + response.data
			myRegex.matcher(response.data)
			final UserModel user = userService.getUserForUID(PUNCHOUT_CUSTOMER);
			final Collection<OrderModel> orders = user.getOrders()
			orders.size() == 1
			OrderModel order = orders.getAt(0)
			order.getTotalPrice() == TOTAL_PRICE
			orders.getAt(0).getEntries().size() == 1
		}
	}

	def "When Ariba sends a request asking for Punchout Order Creation transaction with Content-Type #contentType"() {
		given: "a CXML Order Request"
		File file = ResourceUtils.getFile("classpath:b2bpunchoutocctests/test/b2bpunchoutoccOrderCreation.xml")
		def cXMLRequest = file.text

		when: "a Http POST request is made with Content-Type: #contentType"
		def fullpath = getBasePathWithSite() + "/punchout/cxml/order"
		def pr = restClient.getParser();
		pr.putAt(XML) { response ->
			String responseXml = EntityUtils.toString(response.entity)
			EntityUtils.consume(response.entity)
			return responseXml
		}

		def response = restClient.post(
				path: fullpath,
				contentType: contentType,
				body: cXMLRequest,
				headers: ["accept": contentType],
				requestContentType: contentType)


		then: "a response is obtained"
		with(response) {
			response.status == statusCode
		}

		where: "possible values header Content-Type are:"
		contentType        | statusCode
		"application/xml"  | SC_OK
		"text/xml"         | SC_OK
		"text/plain"       | SC_UNSUPPORTED_MEDIA_TYPE
	}

	def "When Ariba sends a request asking for Punchout Order Creation transaction with bad or missing data: #fileName "() {
		given: "a CXML Order Request"
		File file = ResourceUtils.getFile("classpath:b2bpunchoutocctests/test/" + fileName)
		def cXMLRequest = file.text

		when: "a Http POST request is made with bad data"
		def fullpath = getBasePathWithSite() + "/punchout/cxml/order"
		def pr = restClient.getParser();
		pr.putAt(XML) { response ->
			String responseXml = EntityUtils.toString(response.entity)
			EntityUtils.consume(response.entity)
			return responseXml
		}
		def response = restClient.post(
				path: fullpath,
				contentType: XML,
				body: cXMLRequest,
				headers: ["accept": XML],
				requestContentType: XML)


		then: "a server error response is obtained"
		with(response) {
			response.status == statusCode
			println "RESPONSE data " + response.data
			response.data.contains(errorMessage)
		}

		where: "possible values for bad data are:"
		fileName                                              | statusCode     | errorMessage
		"b2bpunchoutoccOrderCreationWithNonExisitingItem.xml" | SC_BAD_REQUEST | "Product with code TW1210-9342-NE is not found."
		"b2bpunchoutoccOrderCreationWithoutBillTo.xml"        | SC_BAD_REQUEST | "Miss ShipTo or BillTo in cxml request."
		"b2bpunchoutoccOrderCreationWithoutItemOut.xml"       | SC_BAD_REQUEST | "Miss ItemOut in cxml request."
		"b2bpunchoutoccOrderCreationWithoutShipTo.xml"        | SC_BAD_REQUEST | "Miss ShipTo or BillTo in cxml request."
		"b2bpunchoutoccOrderCreationWithoutCity.xml"          | SC_BAD_REQUEST | "Miss required information in address"
	}

	def "When Ariba sends a request asking for Punchout Order Creation transaction with a malformed XML"() {
		given: "a malformed CXML Request"
		File file = ResourceUtils.getFile("classpath:b2bpunchoutocctests/test/b2bpunchoutoccMalformedRequest.xml")
		def cXMLRequest = file.text

		when: "a Http POST request is made with malformed cxml"
		def fullpath = getBasePathWithSite() + "/punchout/cxml/order"
		def pr = restClient.getParser();
		pr.putAt(XML) { response ->
			String responseXml = EntityUtils.toString(response.entity)
			EntityUtils.consume(response.entity)
			return responseXml
		}

		def response = restClient.post(
				path: fullpath,
				contentType: XML,
				body: cXMLRequest,
				headers: ["accept": XML],
				requestContentType: XML)


		then: "an internal server error response is obtained"
		with(response) {
			response.status == SC_INTERNAL_SERVER_ERROR
			response.data.contains("UnmarshalException")
			response.data.contains("Content is not allowed in prolog.")
		}
	}
}
