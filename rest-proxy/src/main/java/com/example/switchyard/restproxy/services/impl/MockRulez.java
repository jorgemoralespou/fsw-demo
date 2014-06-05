package com.example.switchyard.restproxy.services.impl;

import com.example.switchyard.restproxy.services.AccessValidationRulesService;

public class MockRulez implements AccessValidationRulesService {

	@Override
	public boolean isValid(String username) {
		if ("userA".equals(username) || "viewerA".equals(username)) {
			return true;
		} else {
			return false;
		}
	}
}
