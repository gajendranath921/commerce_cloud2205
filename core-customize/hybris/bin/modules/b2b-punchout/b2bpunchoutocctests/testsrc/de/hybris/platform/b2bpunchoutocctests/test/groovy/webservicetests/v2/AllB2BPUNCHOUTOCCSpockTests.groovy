package de.hybris.platform.b2bpunchoutocctests.test.groovy.webservicetests.v2;

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.b2bpunchoutocctests.setup.B2BPunchoutOccTestSetupUtils
import de.hybris.platform.b2bpunchoutocctests.test.groovy.webservicetests.v2.controllers.B2BPunchoutOrderCreationTest
import de.hybris.platform.b2bpunchoutocctests.test.groovy.webservicetests.v2.controllers.B2BPunchoutProfileTest
import de.hybris.platform.b2bpunchoutocctests.test.groovy.webservicetests.v2.controllers.B2BPunchoutSetupTest

@RunWith(Suite.class)
@Suite.SuiteClasses([B2BPunchoutProfileTest,B2BPunchoutSetupTest ,B2BPunchoutOrderCreationTest])
@IntegrationTest
class AllB2BPUNCHOUTOCCSpockTests {

	@BeforeClass
	static void setUpClass() {
		B2BPunchoutOccTestSetupUtils.loadExtensionDataInJunit()
		B2BPunchoutOccTestSetupUtils.startServer()
	}

	@AfterClass
	static void tearDown() {
		B2BPunchoutOccTestSetupUtils.stopServer()
		B2BPunchoutOccTestSetupUtils.cleanData()
	}

	@Test
	static void testing() {
		//dummy test class
	}
}
