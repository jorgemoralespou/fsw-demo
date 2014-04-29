package com.example.switchyard.cdi_alternative_injected;

import javax.inject.Inject;

import org.switchyard.component.bean.Service;

import com.example.switchyard.cdi_alternative_common.Logger;

@Service(LoggerService.class)
public class LoggerServiceBean implements LoggerService {

	@Inject
	private Logger myLoggerBean;
	
	@Override
	public void sysoutMessage(String message) {
		myLoggerBean.logMessage(message);
	}

}
