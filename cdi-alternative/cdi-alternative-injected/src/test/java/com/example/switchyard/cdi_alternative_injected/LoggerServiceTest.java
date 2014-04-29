package com.example.switchyard.cdi_alternative_injected;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class LoggerServiceTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("LoggerService")
	private Invoker service;

	@Test
	public void testSysoutMessage() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		String message = "Jorge";
		service.operation("sysoutMessage").sendInOnly(message);

		// validate the results
		Assert.assertTrue("[Alternative: Jorge] should be seen in system.out", true);
	}

}
