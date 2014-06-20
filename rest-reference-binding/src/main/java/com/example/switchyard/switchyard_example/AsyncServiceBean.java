package com.example.switchyard.switchyard_example;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.redhat.poc.mediacom.asyncjmsexample.AsyncService;
import com.redhat.poc.mediacom.asyncjmsexample.IncomingRequest;
import com.redhat.poc.mediacom.asyncjmsexample.RestService;

@Service(AsyncService.class)
public class AsyncServiceBean implements AsyncService {

	@Inject @Reference
	private RestService svc;
	
	public void execute(String arg){
		IncomingRequest req = new IncomingRequest();
		req.setName(arg);
		svc.getBackendService(req);
	}
}
