package com.example.environment;

import org.switchyard.component.bean.Service;

@Service(PropertiesSampler.class)
public class PropertiesSamplerBean implements PropertiesSampler {

	@Override
	public TestResponse test(TestRequest message) {
		TestResponse resp = new TestResponse();
		resp.setMessage(message.getMessage());
		return resp;
	}

}
