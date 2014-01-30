package org.jboss.examples;

import javax.inject.Inject;

import org.jboss.examples.data.csv.CSVMeterRecord;
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
