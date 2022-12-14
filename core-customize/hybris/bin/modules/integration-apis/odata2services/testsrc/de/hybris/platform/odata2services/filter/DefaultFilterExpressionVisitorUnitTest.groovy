/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.odata2services.filter

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.integrationservices.search.NoResultWhereClauseCondition
import de.hybris.platform.integrationservices.search.SimplePropertyWhereClauseCondition
import de.hybris.platform.integrationservices.search.WhereClauseConditions
import de.hybris.platform.odata2services.filter.impl.DefaultFilterExpressionVisitor
import de.hybris.platform.testframework.JUnitPlatformSpecification
import org.apache.olingo.odata2.api.uri.expression.FilterExpression
import org.junit.Test

@UnitTest
class DefaultFilterExpressionVisitorUnitTest extends JUnitPlatformSpecification {
    def filterExpressionVisitor = new DefaultFilterExpressionVisitor()
    def expression = Mock(FilterExpression)
    def expressionString = "expressionString"

    @Test
    def "filter expression visitor returns result as WhereClauseCondition"() {
        given:
        def expectedWhereClauseCondition = new SimplePropertyWhereClauseCondition('code', '-', '123')
                .toWhereClauseConditions()

        when:
        def actualWhereClauseCondition = filterExpressionVisitor.visit(expression, expressionString, expectedWhereClauseCondition)

        then:
        expectedWhereClauseCondition == actualWhereClauseCondition
    }


    @Test
    def "filter expression visitor with empty condition"() {
        given:
        def result = "stringResult"

        when:
        def actualResult = filterExpressionVisitor.visit(expression, expressionString, result)

        then:
        new WhereClauseConditions(Collections.emptyList()) == actualResult
    }


    @Test
    def "filter expression visitor with no result condition"() {
        given:
        def result = new NoResultWhereClauseCondition().toWhereClauseConditions()

        when:
        filterExpressionVisitor.visit(expression, expressionString, result)

        then:
        thrown NoFilterResultException
    }
}
