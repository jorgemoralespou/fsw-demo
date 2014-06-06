package com.example.switchyard.restproxy.services;

import com.example.switchyard.restproxy.rest.model.UserIdentity;

public interface AccessValidationRulesService {
	public UserIdentity validate(UserIdentity username); 
}
