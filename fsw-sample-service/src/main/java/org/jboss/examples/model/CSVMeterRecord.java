package org.jboss.examples.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class CSVMeterRecord {
	
	@DataField(pos = 1)
	public String clientName;
	
	@DataField(pos = 2)
	public String meterNumber;
	
	@DataField(pos = 3)
	public String eanNumber;
	
	@DataField(pos = 4)
	public int captureMonth;
	
	@DataField(pos = 5)
	public int captation;
	

	public int getCaptation() {
		return captation;
	}

	public void setCaptation(int captation) {
		this.captation = captation;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public String getEanNumber() {
		return eanNumber;
	}

	public void setEanNumber(String eanNumber) {
		this.eanNumber = eanNumber;
	}

	public int getCaptureMonth() {
		return captureMonth;
	}

	public void setCaptureMonth(int captureMonth) {
		this.captureMonth = captureMonth;
	}
	
	@Override
	public String toString() {
		return "CSVMeterRecord [clientName=" + clientName + ", meterNumber="
				+ meterNumber + ", eanNumber=" + eanNumber + ", captureMonth="
				+ captureMonth + ", captation=" + captation + "]";
	}

	
}
