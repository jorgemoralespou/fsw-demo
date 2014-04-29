package com.example.switchyard.cdi_alternative_injected;

import javax.enterprise.inject.Default;

import com.example.switchyard.cdi_alternative_common.Logger;

@Default
public class DefaultLogger implements Logger {

	@Override
	public void logMessage(String message) {
		System.out.println("Default: " + message);
	}

}
