package com.example.switchyard.switchyard_example;

import org.apache.camel.builder.RouteBuilder;

public class AsyncServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://AsyncService").log(
				"Received message for 'AsyncService' : ${body}")
				.to("switchyard://RestService");
	}

}
