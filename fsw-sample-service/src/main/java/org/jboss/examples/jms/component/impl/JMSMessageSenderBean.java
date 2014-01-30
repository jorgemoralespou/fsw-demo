package org.jboss.examples.jms.component.impl;

import javax.inject.Inject;

import org.jboss.examples.jms.component.JMSMessageSender;
import org.jboss.examples.jms.reference.CaptationJMSService;
import org.jboss.examples.model.CSVMeterRecord;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(JMSMessageSender.class)
public class JMSMessageSenderBean implements JMSMessageSender {

	@Inject
	@Reference("CaptationJMSService")
	CaptationJMSService jmsService;
	
	@Override
	public void sendCSVRecord(CSVMeterRecord record) {
		System.out.println("Sending the CSV record: " + record.getClientName() + record.getCaptureMonth());
		jmsService.send(record);
	}
	
}
