package org.jboss.examples.transform.component.impl;

import javax.inject.Inject;

import org.jboss.examples.jms.reference.CaptationJMSService;
import org.jboss.examples.jpa.StoreCaptation;
import org.jboss.examples.model.CSVMeterRecord;
import org.jboss.examples.model.Captation;
import org.jboss.examples.transform.component.CSVRecord2JPAObject;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(CSVRecord2JPAObject.class)
public class CSVRecord2JPAObjectBean implements CSVRecord2JPAObject {

	@Inject
	@Reference("StoreCaptation")
	StoreCaptation storeService;
	
	@Inject
	@Reference("CaptationJMSService")
	CaptationJMSService jmsService;
	
	public void copyAndPersist(CSVMeterRecord csvRecord){
		Captation cap = new Captation();
		cap.setClientName(csvRecord.getClientName());
		cap.setMeterNumber(csvRecord.getMeterNumber());
		cap.setEanNumber(csvRecord.getEanNumber());
		cap.setCaptureMonth(csvRecord.getCaptureMonth());
		
		storeService.save(cap);
	}
}
