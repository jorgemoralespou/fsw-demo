package com.example.switchyard.soap;

import javax.xml.namespace.QName;

import org.switchyard.Exchange;
import org.switchyard.component.soap.SOAPMessages;
import org.switchyard.component.soap.composer.SOAPBindingData;
import org.switchyard.component.soap.composer.SOAPMessageComposer;

public class CustomFaultMessageComposer extends SOAPMessageComposer {

	@Override
	public SOAPBindingData decompose(Exchange exchange, SOAPBindingData target)
			throws Exception {
		SOAPBindingData data = target;
		try{
			data = super.decompose(exchange, target);
		}catch(Exception e){
			data.getSOAPMessage().getSOAPBody().addFault(new QName("100"), "ERROR in transformation");
		}
        try {
            getContextMapper().mapTo(exchange.getContext(), data);
        } catch (Exception ex) {
            throw SOAPMessages.MESSAGES.failedToMapContextPropertiesToSOAPMessage(ex);
        }
		
        return data;		
	}
}
