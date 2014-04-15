package org.jboss.examples.earproblem.services.impl;

import javax.inject.Inject;

import org.jboss.examples.earproblem.service2.service.MessageLogger;
import org.jboss.examples.earproblem.services.SampleLogic;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(SampleLogic.class)
public class SampleLogicBean implements SampleLogic {

	@Inject @Reference
	MessageLogger logger;
	
	@Override
	public String doLogic(String request) {
		return "DONE " + logger.logMesssage(request);
	}

}
