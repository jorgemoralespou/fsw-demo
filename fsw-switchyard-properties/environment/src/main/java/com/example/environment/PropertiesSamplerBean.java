package com.example.environment;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(PropertiesSampler.class)
public class PropertiesSamplerBean implements PropertiesSampler {

	
	@Inject @Reference
	MessageLogger logger;
	
	@Override
	public TestResponse test(TestRequest message) {
		TestResponse resp = new TestResponse();
		resp.setMessage(message.getMessage());
		logger.log(resp.getMessage());
		return resp;
	}

}
