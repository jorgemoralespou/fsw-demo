package com.example.switchyard.stringtemplate;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(StringtemplateExample.class)
public class StringtemplateExampleBean implements StringtemplateExample {

	@Inject @Reference
	private Log referenceService;
	
	@Override
	public LogResponse log(LogRequest s) {
		referenceService.log(s.getString());
		LogResponse resp = new LogResponse();
		resp.setString("OK");
		return resp;
	}

}
