package com.example.switchyard.serialization;

import org.switchyard.component.bean.Service;

import com.example.switchyard.serialization.sca.common.Container;
import com.example.switchyard.serialization.sca.common.RemoteInvocationWithGenerics;

@Service(RemoteInvocationWithGenerics.class)
public class RemoteInvocationWithGenericsBean implements
		RemoteInvocationWithGenerics {

	@Override
	public Container<String, Integer> create(Container<String, Integer> param) {
		System.out.println("--- SCA Reference called with: " + param);
		return param;
	}

}
