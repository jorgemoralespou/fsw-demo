package com.example.switchyard.serialization.sca.common;

public interface RemoteInvocationWithGenerics {
	public Container<String, Integer> create(
			Container<String, Integer> param);
}
