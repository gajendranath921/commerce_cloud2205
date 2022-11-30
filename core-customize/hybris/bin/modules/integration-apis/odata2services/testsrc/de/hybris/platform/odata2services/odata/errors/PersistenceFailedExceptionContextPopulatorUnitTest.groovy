/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.odata2services.odata.errors

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.inboundservices.persistence.PersistenceContext
import de.hybris.platform.inboundservices.persistence.impl.PersistenceFailedException
import de.hybris.platform.integrationservices.item.IntegrationItem
import de.hybris.platform.integrationservices.model.TypeDescriptor
import de.hybris.platform.jalo.JaloInvalidParameterException
import de.hybris.platform.servicelayer.exceptions.ModelSavingException
import de.hybris.platform.servicelayer.exceptions.SystemException
import de.hybris.platform.servicelayer.interceptor.InterceptorException
import de.hybris.platform.testframework.JUnitPlatformSpecification
import org.apache.olingo.odata2.api.commons.HttpStatusCodes
import org.apache.olingo.odata2.api.processor.ODataErrorContext
import org.junit.Test
import spock.lang.Unroll

@UnitTest
class PersistenceFailedExceptionContextPopulatorUnitTest extends JUnitPlatformSpecification {
    private static final def CAUSE_MESSAGE = 'nested exception message'
    private static final def ENTITY_TYPE_NAME = 'EntityTypeName'
    private static final def INTEGRATION_KEY = 'key|value'

    def populator = new PersistenceFailedExceptionContextPopulator()

    @Test
    @Unroll
    def "response has BAD_REQUEST status with cause exception message when cause is #rootCause.class.simpleName"() {
        given:
        def cause = new ModelSavingException('testMessage', rootCause)
        def errorContext = new ODataErrorContext(exception: new PersistenceFailedException(context(), cause))

        when:
        populator.populate errorContext

        then:
        with(errorContext) {
            httpStatus == HttpStatusCodes.BAD_REQUEST
            errorCode == 'invalid_attribute_value'
            message == "An error occurred while attempting to save entries for entityType: $ENTITY_TYPE_NAME, with error message $CAUSE_MESSAGE"
            locale == Locale.ENGLISH
            innerError == INTEGRATION_KEY
        }

        where:
        rootCause << [new InterceptorException(CAUSE_MESSAGE), new JaloInvalidParameterException(CAUSE_MESSAGE, 0)]
    }

    @Test
    def "response has INTERNAL_ERROR status with cause exception message when the cause is of type SystemException"() {
        given:
        def cause = new SystemException(CAUSE_MESSAGE)
        def errorContext = new ODataErrorContext(exception: new PersistenceFailedException(context(), cause))

        when:
        populator.populate errorContext

        then:
        with(errorContext) {
            httpStatus == HttpStatusCodes.INTERNAL_SERVER_ERROR
            errorCode == 'internal_error'
            message == "An error occurred while attempting to save entries for entityType: $ENTITY_TYPE_NAME, with error message $CAUSE_MESSAGE"
            locale == Locale.ENGLISH
            innerError == INTEGRATION_KEY
        }
    }

    @Test
    def 'response message does not contain cause message when the cause is not one of: SystemException, InterceptorException, JaloInvalidParameterException'() {
        given:
        def rootCause = new IllegalArgumentException('root cause message')
        def cause = new RuntimeException('cause message', rootCause)
        def errorContext = new ODataErrorContext(exception: new PersistenceFailedException(context(), cause))

        when:
        populator.populate errorContext

        then:
        with(errorContext) {
            httpStatus == HttpStatusCodes.INTERNAL_SERVER_ERROR
            errorCode == 'internal_error'
            message == "An error occurred while attempting to save entries for entityType: $ENTITY_TYPE_NAME"
            locale == Locale.ENGLISH
            innerError == INTEGRATION_KEY
        }
    }

    @Test
    def 'handles absence of cause in PersistenceFailedException'() {
        given:
        def errorContext = new ODataErrorContext(exception: new PersistenceFailedException(context(), null))

        when:
        populator.populate errorContext

        then:
        with(errorContext) {
            httpStatus == HttpStatusCodes.INTERNAL_SERVER_ERROR
            errorCode == 'internal_error'
            message == "An error occurred while attempting to save entries for entityType: $ENTITY_TYPE_NAME"
            locale == Locale.ENGLISH
            innerError == INTEGRATION_KEY
        }
    }

    @Test
    def 'handles absence of persistence context in PersistenceFailedException'() {
        given:
        def cause = new Exception(CAUSE_MESSAGE)
        def errorContext = new ODataErrorContext(exception: new PersistenceFailedException(null, cause))

        when:
        populator.populate errorContext

        then:
        with(errorContext) {
            httpStatus == HttpStatusCodes.INTERNAL_SERVER_ERROR
            errorCode == 'internal_error'
            message == 'An error occurred while attempting to save entries for entityType: null'
            locale == Locale.ENGLISH
            !innerError
        }
    }

    @Test
    def 'does not populate the error context for exceptions other than PersistenceFailedException'() {
        given:
        def errorContext = new ODataErrorContext(exception: new RuntimeException())

        when:
        populator.populate errorContext

        then:
        with(errorContext) {
            !httpStatus
            !errorCode
            !message
            !locale
            !innerError
        }
    }

    @Test
    def 'handles PersistenceFailedException'() {
        expect:
        populator.exceptionClass == PersistenceFailedException
    }

    PersistenceContext context() {
        Stub(PersistenceContext) {
            getIntegrationItem() >> Stub(IntegrationItem) {
                getItemType() >> Stub(TypeDescriptor) {
                    getItemCode() >> ENTITY_TYPE_NAME
                }
                getIntegrationKey() >> INTEGRATION_KEY
            }
        }
    }
}
