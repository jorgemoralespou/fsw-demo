package org.jboss.examples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "captation")
public class Captation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    
    @Column(name = "name")
    String clientName;
	
	@Column(name = "meter_number")
	String meterNumber;
	
	@Column(name = "ean")
	String eanNumber;
	
	@Column(name = "month")
	int captureMonth;
	
	@Column(name = "captation")
	int captation;

	   /**
     * @return the _id
     */
    public Long getId() {
        return _id;
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

	public int getCaptation() {
		return captation;
	}

	public void setCaptation(int captation) {
		this.captation = captation;
	}

	@Override
	public String toString() {
		return "Captation [_id=" + _id + ", clientName=" + clientName
				+ ", meterNumber=" + meterNumber + ", eanNumber=" + eanNumber
				+ ", captureMonth=" + captureMonth + ", captation=" + captation
				+ "]";
	}
    
	
}
