package com.example.switchyard.stringtemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.LinkedBlockingQueue;

import org.hamcrest.core.IsNot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.Exchange;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.MockHandler;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = {CDIMixIn.class})
public class StringTemplateTest {

	private SwitchYardTestKit testKit;

	private CDIMixIn cdimixin;
	

	private static final String MESSAGE_EN = "Hello Jorge.";
	private static final String MESSAGE_ES = "Hola Jorge.";
	
	@ServiceOperation("Log")
	private Invoker service;

	@Test
	public void testSend() throws Exception {
		testKit.removeService("LogReference");
		MockHandler mock = testKit.registerInOnlyService("LogReference");
		
		
		String message = "Jorge";
		service.operation("log").sendInOnly(message);
		
        final LinkedBlockingQueue<Exchange> recievedMessages = mock.getMessages();
        assertThat(recievedMessages, is(notNullValue()));
        assertThat(recievedMessages.size(), not(0));
        System.out.println("Received messages: " + recievedMessages.size());

        final Exchange recievedExchange = recievedMessages.iterator().next();
        String s = recievedExchange.getMessage().getContent(String.class);
        System.out.println("Received message: " + s);
        assertThat(s, is(equalTo(MESSAGE_ES)));

		// mock.getMessages();

		// validate the results
		//Assert.assertTrue("Implement me", false);
	}

}
