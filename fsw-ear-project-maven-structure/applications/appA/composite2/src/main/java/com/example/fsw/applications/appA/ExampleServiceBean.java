package com.example.fsw.applications.appA;

import org.switchyard.component.bean.Service;

import com.example.fsw.applications.appA.beans.ExtendedResponse;
import com.example.fsw.beans.Request;
import com.example.fsw.beans.Response;
import com.example.fsw.interfaces.ExampleService;
import com.example.fsw.utils.UtilLogger;

@Service(ExampleService.class)
public class ExampleServiceBean implements ExampleService {

	
	public Response execute(Request req) {
		System.out.println("==== Request received");
		UtilLogger.log(req);
		Response res = new ExtendedResponse("OK", 100);
		
		UtilLogger.log(res);
		System.out.println("==== Response sent");
		return res;
	}

}
