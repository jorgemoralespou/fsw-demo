package com.example.switchyard.serialization_sca_caller;

import java.io.IOException;

import javax.inject.Inject;
import javax.xml.namespace.QName;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;
import org.switchyard.remote.RemoteInvoker;
import org.switchyard.remote.RemoteMessage;
import org.switchyard.remote.http.HttpInvoker;

import com.example.switchyard.serialization.sca.common.CalledReferenceService;
import com.example.switchyard.serialization.sca.common.Container;
import com.example.switchyard.serialization.sca.common.HelloWorld;
import com.example.switchyard.serialization.sca.common.User;

@Service(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {

	@Inject @Reference
	CalledReferenceService called;
	
    private RemoteInvoker invoker = new HttpInvoker("http://localhost:8080/switchyard-remote");
	
	@Override
	public void sayHello(String to) {
		User user = User.createUserBuilder("12345").setName(to).setLastName("Morales").build();
		String resp = called.sayHelloToUser(user);
		System.out.println("---- " + resp);
	}
	
	@Override
	public void testSCAArgumentError(String to){
		Container<String,Integer> c = new Container.ContainerBuilder<String, Integer>("100").setOperation("myOp").setTarget(100).build();
		
		System.out.println("---- CALLING with: " + c);
        try {
            RemoteMessage response =
                    invoker.invoke(new RemoteMessage()
                            .setService(
                                    new QName("urn:com.example.switchyard:switchyard-example:1.0",
                                            "RemoteInvocationWithGenerics")).setOperation("create")
                            .setContent(c));
            if (response != null) {
                System.out.println(response.getContent());
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
	}

}
