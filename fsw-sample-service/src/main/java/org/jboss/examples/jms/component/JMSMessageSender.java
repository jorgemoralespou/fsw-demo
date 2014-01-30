package org.jboss.examples.jms.component;

import org.jboss.examples.model.CSVMeterRecord;

public interface JMSMessageSender {
	void sendCSVRecord(CSVMeterRecord record);
}
