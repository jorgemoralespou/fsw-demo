package com.example.fsw.applications.appA;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.example.fsw.beans.Request;
import com.example.fsw.beans.Response;
import com.example.fsw.interfaces.ExampleService;
import com.example.fsw.utils.UtilLogger;

@Service(TriggeredService.class)
public class TriggeredServiceBean implements TriggeredService {

	@Inject @Reference
	ExampleService ref;
	
	public void execute(String nothing) {
		Request req = new Request();
		req.setName("timestamp");
		req.setValue("" + System.currentTimeMillis());
		
		UtilLogger.log(req);
		
		Response res = ref.execute(req);
		
		UtilLogger.log(res);
	}

}
