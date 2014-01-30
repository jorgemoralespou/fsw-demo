package org.jboss.examples;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.jboss.examples.data.csv.CSVMeterRecord;

public class FileProcessorBean extends RouteBuilder {

	DataFormat csv = new BindyCsvDataFormat(CSVMeterRecord.class);
	
	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		errorHandler(noErrorHandler());
		
		from("switchyard://FileProcessor")
			.doTry()
				.split(body().tokenize("\n"))
				.streaming()
				.unmarshal(csv)
				.log("Metering for ${body.clientName}[EAN=${body.eanNumber}, METER=${body.meterNumber}] for ${body.captureMonth}: ${body.captation}")
				.to("switchyard://CSVRecord2JPAObject")
				.endDoTry()
			.doCatch(Exception.class)
				.log("There was a problem while processing the file")
			.end();

	}

}
