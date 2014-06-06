package com.example.switchyard.restproxy.services.impl;

import com.example.switchyard.restproxy.rest.model.UserIdentity;
import com.example.switchyard.restproxy.services.AccessValidationRulesService;

public class MockRulez implements AccessValidationRulesService {

	@Override
	public UserIdentity validate(UserIdentity username) {
		if ("userA".equals(username.getUsername()) || "viewerA".equals(username.getUsername())) {
			username.setValid(true);
		} else {
			username.setValid(false);
		}
		return username;
	}
}
