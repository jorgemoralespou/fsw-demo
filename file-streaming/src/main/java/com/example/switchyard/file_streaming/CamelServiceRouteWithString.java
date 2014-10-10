package com.example.switchyard.file_streaming;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRouteWithString extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://FileReadServiceAsString")
		.to("switchyard://FileWriteServiceAsString");
	}

}
