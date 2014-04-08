package com.example.switchyard.serialization;

import org.switchyard.component.bean.Service;

import com.example.switchyard.serialization.sca.common.CalledReferenceService;
import com.example.switchyard.serialization.sca.common.User;

@Service(CalledReferenceService.class)
public class CalledReferenceServiceBean implements CalledReferenceService {

	@Override
	public String sayHelloToUser(User user) {
		return "Hello " + user.getName() + " " + user.getLastName();
	}

}
