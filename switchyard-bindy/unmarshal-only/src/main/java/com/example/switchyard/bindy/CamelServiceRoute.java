package com.example.switchyard.bindy;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.example.switchyard.bindy.model.SimOrder;

public class CamelServiceRoute extends RouteBuilder {

	DataFormat bindy = new BindyCsvDataFormat(SimOrder.class);
	
	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		from("switchyard://BindyComponentService")
		.setHeader("CamelFileName", constant("123.out"))
		.marshal(bindy)
		.to("switchyard://BindyComponentReference");
	}

}
