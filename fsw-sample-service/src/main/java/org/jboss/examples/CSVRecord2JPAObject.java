package org.jboss.examples;

import org.jboss.examples.data.csv.CSVMeterRecord;

public interface CSVRecord2JPAObject {
	void copyAndPersist(CSVMeterRecord csvRecord);
}
