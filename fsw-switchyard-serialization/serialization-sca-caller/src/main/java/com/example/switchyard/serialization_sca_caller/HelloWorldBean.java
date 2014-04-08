package com.example.switchyard.serialization_sca_caller;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.example.switchyard.serialization.sca.common.CalledReferenceService;
import com.example.switchyard.serialization.sca.common.HelloWorld;
import com.example.switchyard.serialization.sca.common.User;

@Service(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {

	@Inject @Reference
	CalledReferenceService called;
	
	@Override
	public void sayHello(String to) {
		User user = User.createUserBuilder("12345").setName(to).setLastName("Morales").build();
		String resp = called.sayHelloToUser(user);
		System.out.println("---- " + resp);
	}

}
