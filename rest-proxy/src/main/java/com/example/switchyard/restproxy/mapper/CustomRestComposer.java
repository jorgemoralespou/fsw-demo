package com.example.switchyard.restproxy.mapper;

import javax.ws.rs.WebApplicationException;

import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.component.common.label.EndpointLabel;
import org.switchyard.component.http.composer.HttpContextMapper;
import org.switchyard.component.resteasy.composer.RESTEasyBindingData;
import org.switchyard.component.resteasy.composer.RESTEasyContextMapper;
import org.switchyard.component.resteasy.composer.RESTEasyMessageComposer;

import com.example.switchyard.restproxy.exceptions.UnauthorizedException;

public class CustomRestComposer extends RESTEasyMessageComposer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Message compose(RESTEasyBindingData source, Exchange exchange)
			throws Exception {
		final Message message = super.compose(source, exchange);
		// if (source.getOperationName().equals("addItem") &&
		// (source.getParameters().length == 2)) {
		// // Wrap the parameters
		// Item item = new Item((Integer)source.getParameters()[0],
		// (String)source.getParameters()[1]);
		// message.setContent(item);
		// }
		return message;
	}
	public static final String UNAUTHORIZED = "UNAUTHORIZED";
	public static final String NOT_FOUND = "NOT_FOUND";
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RESTEasyBindingData decompose(Exchange exchange,
			RESTEasyBindingData target) throws Exception {
		Object content = exchange.getMessage().getContent();
		// String opName =
		// exchange.getContract().getProviderOperation().getName();
		// if (opName.equals("getItem") && (content == null)) {
		// exchange.getContext()
		// .setProperty(RESTEasyContextMapper.HTTP_RESPONSE_STATUS,
		// 404)
		// .addLabels(new String[] { EndpointLabel.HTTP.label() });
		// }
		System.out.println("Content: " + content);
		if ((content instanceof WebApplicationException) && (((WebApplicationException)content).getCause() instanceof UnauthorizedException)) {
			exchange.getContext()
					.setProperty(HttpContextMapper.HTTP_RESPONSE_STATUS, 401)
					.addLabels(new String[] { EndpointLabel.HTTP.label() });
		}
//		else  if ((content instanceof String) && (content.equals(NOT_FOUND))) {
//			exchange.getContext()
//					.setProperty(HttpContextMapper.HTTP_RESPONSE_STATUS, 404)
//					.addLabels(new String[] { EndpointLabel.HTTP.label() });
//		}
		target = super.decompose(exchange, target);
		// if (target.getOperationName().equals("addItem")
		// && (content != null) && (content instanceof Item)) {
		// // Unwrap the parameters
		// target.setParameters(new Object[]{((Item)content).getItemId(),
		// ((Item)content).getName()});
		// }

		return target;
	}

}
