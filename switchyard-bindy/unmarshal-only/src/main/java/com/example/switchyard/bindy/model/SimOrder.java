package com.example.switchyard.bindy.model;
import java.util.Date;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator=",", crlf="UNIX", generateHeaderColumns = true)
public class SimOrder {
	
	@DataField(pos = 1, columnName = "Order ID")
	private String orderId;
	
	@DataField(pos = 2, columnName = "Batch ID")
	private String batchId;
	
	@DataField(pos = 3, columnName = "Customer Number")
	private String customerNo;
	
	@DataField(pos = 4, columnName = "Customer")
	private String customerName;
	
	@DataField(pos = 5, columnName = "IMSI")
	private String imsi;
	
	@DataField(pos = 6, columnName = "MSISDN")
	private String msisdn;
	
	@DataField(pos = 7, columnName = "SIM Spec Ref")
	private String simSpecificationId;
	
	@DataField(pos = 8, columnName = "Quantity")
	private int quantity;
	
	@DataField(pos = 9, columnName = "Required Date", pattern = "yyyy/MM/dd HH:mm:ss") //SimpleDateFormat
	private Date requiredDate;
	
	@DataField(pos = 10, columnName = "Delivery Address")
	private String deliveryAddress;
	
	@DataField(pos = 11, columnName = "Shipment Type", defaultValue="NULL")
	private String shipmentType; //TODO: String for now, but later change to ENUM
	
	@DataField(pos = 12, columnName = "Package Marking")
	private String packageMarking;
	
	@DataField(pos = 13, columnName = "Reference Contact")
	private String contactName;
	
	@DataField(pos = 14, columnName = "Contact Telephone Number")
	private String contactPhoneNumber;
	
	@DataField(pos = 15, columnName = "Email")
	private String contactEmail;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getSimSpecificationId() {
		return simSpecificationId;
	}

	public void setSimSpecificationId(String simSpecificationId) {
		this.simSpecificationId = simSpecificationId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public String getPackageMarking() {
		return packageMarking;
	}

	public void setPackageMarking(String packageMarking) {
		this.packageMarking = packageMarking;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Override
	public String toString() {
		return "SimOrderFile [orderId=" + orderId + ", batchId=" + batchId + ", customerNo="
					+ customerNo + ", customerName=" + customerName + ", imsi=" + imsi + ", msisdn="
					+ msisdn + ", simSpecificationId=" + simSpecificationId + ", quantity="
					+ quantity + ", requiredDate=" + requiredDate + ", deliveryAddress="
					+ deliveryAddress + ", shipmentType=" + shipmentType + ", packageMarking="
					+ packageMarking + ", contactName="	+ contactName + ", contactPhoneNumber="
					+ contactPhoneNumber + ", contactEmail="+ contactEmail + "]";
	}

}
