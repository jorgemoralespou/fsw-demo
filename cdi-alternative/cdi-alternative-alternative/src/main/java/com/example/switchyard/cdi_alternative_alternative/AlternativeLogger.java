package com.example.switchyard.cdi_alternative_alternative;

import javax.enterprise.inject.Alternative;

import com.example.switchyard.cdi_alternative_common.Logger;

@Alternative
public class AlternativeLogger implements Logger {

	@Override
	public void logMessage(String message) {
		System.out.println("Alternative: " + message);

	}

}
