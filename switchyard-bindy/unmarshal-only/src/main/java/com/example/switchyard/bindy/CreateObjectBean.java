package com.example.switchyard.bindy;

import java.util.Date;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.example.switchyard.bindy.model.SimOrder;

@Service(CreateObject.class)
public class CreateObjectBean implements CreateObject {

	@Inject @Reference("BindyComponentService")
	private Bindy service;
	
	@Override
	public void create() {
		System.out.println("Sending an object out");
		SimOrder s = new SimOrder();
		s.setOrderId("1");
		s.setBatchId("2");
		s.setCustomerNo("3");
		s.setCustomerName("Name");
		s.setImsi("1111");
		s.setMsisdn("2222");
		s.setSimSpecificationId("SimId");
		s.setQuantity(25);
		s.setRequiredDate(new Date());
		s.setDeliveryAddress("Address");
		s.setShipmentType("ShipmentType");
		s.setPackageMarking("packageMarking");
		s.setContactName("contactName");
		s.setContactEmail("contactEmail");
		s.setContactPhoneNumber("contactPhoneNumber");
		service.bind(s);
	}

}
