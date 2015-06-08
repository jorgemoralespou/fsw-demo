package com.example.fsw.applications.appA.beans;

import com.example.fsw.beans.Response;

public class ExtendedResponse extends Response {
	
	
	
	public ExtendedResponse() {
		super();
	}

	public ExtendedResponse(String result, Integer code) {
		super(result, code);
	}

	@Override
	public String getResult() {
		return "Extended-" + super.getResult();
	}
	
	
	
}
