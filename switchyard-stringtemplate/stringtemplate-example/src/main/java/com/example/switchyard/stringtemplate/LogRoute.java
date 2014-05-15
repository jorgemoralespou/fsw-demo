package com.example.switchyard.stringtemplate;

import org.apache.camel.builder.RouteBuilder;

public class LogRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://Log")
		.log("Before template: ${body}")
		.to("string-template:templates/message")
		.log("After template: ${body}")
		.to("switchyard://LogReference");
	}

}
