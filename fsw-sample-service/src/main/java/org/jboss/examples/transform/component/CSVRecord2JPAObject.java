package org.jboss.examples.transform.component;

import org.jboss.examples.model.CSVMeterRecord;

public interface CSVRecord2JPAObject {
	void copyAndPersist(CSVMeterRecord csvRecord);
}
