package com.example.switchyard.file_streaming;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		from("switchyard://ReadFileService")
		.to("switchyard://FileWriteService");
	}

}
