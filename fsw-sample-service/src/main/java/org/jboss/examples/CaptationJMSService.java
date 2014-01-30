package org.jboss.examples;

import org.jboss.examples.data.csv.CSVMeterRecord;

public interface CaptationJMSService {
	void send(CSVMeterRecord message);
}
