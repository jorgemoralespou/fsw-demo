package com.example.switchyard.restproxy.mapper;

import org.switchyard.Exchange;
import org.switchyard.component.common.label.EndpointLabel;
import org.switchyard.component.http.composer.HttpBindingData;
import org.switchyard.component.http.composer.HttpContextMapper;
import org.switchyard.component.http.composer.HttpMessageComposer;

public class CustomHttpMessageComposer extends HttpMessageComposer {

	
	public static final String UNAUTHORIZED = "UNAUTHORIZED";
	public static final String NOT_FOUND = "NOT_FOUND";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public HttpBindingData decompose(Exchange exchange, HttpBindingData target)
			throws Exception {
		// TODO: Catch also Exceptions from policy defined at Component
		
		Object content = exchange.getMessage().getContent();
		if ((content instanceof String) && (content.equals(UNAUTHORIZED))) {
			exchange.getContext()
					.setProperty(HttpContextMapper.HTTP_RESPONSE_STATUS, 401)
					.addLabels(new String[] { EndpointLabel.HTTP.label() });
		}else  if ((content instanceof String) && (content.equals(NOT_FOUND))) {
			exchange.getContext()
					.setProperty(HttpContextMapper.HTTP_RESPONSE_STATUS, 404)
					.addLabels(new String[] { EndpointLabel.HTTP.label() });
		}
		target = super.decompose(exchange, target);
		return target;
	}

}
