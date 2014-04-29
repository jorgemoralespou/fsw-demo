package com.example.switchyard.cdi_alternative_injected;

import javax.inject.Inject;

import org.switchyard.component.bean.Service;

import com.example.switchyard.cdi_alternative_common.Logger;
import com.example.switchyard.cdi_alternative_common.SysoutPrinter;

@Service(LoggerService.class)
public class LoggerServiceBean implements LoggerService {

	@Inject
	private Logger myLoggerBean;
	
	@Inject
	private SysoutPrinter myPrinterBean;

	@Override
	public void sysoutMessage(String message) {
		myLoggerBean.logMessage(message);
		myPrinterBean.printInSysout(message);
	}

}
