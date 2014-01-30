package org.jboss.examples.jms.reference;

import org.jboss.examples.model.CSVMeterRecord;

public interface CaptationJMSService {
	void send(CSVMeterRecord message);
}
