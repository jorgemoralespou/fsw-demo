package com.redhat.poc.mediacom.asyncjmsexample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IncomingRequest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
