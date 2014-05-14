package com.example.switchyard.bindy;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.example.switchyard.bindy.student.Student;
import com.example.switchyard.bindy.studentresult.StudentResult;

public class CamelServiceRoute extends RouteBuilder {

	DataFormat csv = new BindyCsvDataFormat(Student.class);
	DataFormat marshal = new BindyCsvDataFormat(StudentResult.class);
	
	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://BindyService")
		.log("****Camel Bindy Unmarshalling, Marshalling example ****")
		.doTry()
			.split(body().tokenize("\n"))
				.streaming()
				.log("Line read: ${body}")
				.unmarshal(csv)
				.log("Details are ${body}")
				.bean(StudentProcessor.class, "processMarks")
				.marshal(marshal)
				.log("After marshalling, the results are:  ${body}")
				.to("switchyard://BindyReference")
			.endDoTry()
		.doCatch(Exception.class)
			.log("Error processing the file")
		.end()
		.log("******** Completed the sucessful Marshalling ******");
	}

}
