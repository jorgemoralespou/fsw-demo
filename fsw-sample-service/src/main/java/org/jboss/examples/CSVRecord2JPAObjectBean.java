package org.jboss.examples;

import javax.inject.Inject;

import org.jboss.examples.data.csv.CSVMeterRecord;
import org.jboss.examples.jpa.StoreCaptation;
import org.jboss.examples.jpa.model.Captation;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(CSVRecord2JPAObject.class)
public class CSVRecord2JPAObjectBean implements CSVRecord2JPAObject {

	@Inject
	@Reference("StoreCaptation")
	StoreCaptation storeService;
	
	public void copyAndPersist(CSVMeterRecord csvRecord){
		Captation cap = new Captation();
		cap.setClientName(csvRecord.getClientName());
		cap.setMeterNumber(csvRecord.getMeterNumber());
		cap.setEanNumber(csvRecord.getEanNumber());
		cap.setCaptureMonth(csvRecord.getCaptureMonth());
		
		storeService.save(cap);
	}
}
