package org.jboss.examples.earproblem.service2.service.impl;

import org.jboss.examples.earproblem.service2.service.MessageLogger;
import org.switchyard.component.bean.Service;

@Service(MessageLogger.class)
public class MessageLoggerBean implements MessageLogger {

	@Override
	public String logMesssage(String message) {
		System.out.println("Logging message: " + message);
		return "SUCCESS";
	}

}
