package com.example.switchyard.restproxy.services.impl;

import java.util.Iterator;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;
import org.switchyard.security.context.SecurityContext;
import org.switchyard.security.credential.NameCredential;

import com.example.switchyard.restproxy.mapper.CustomHttpMessageComposer;
import com.example.switchyard.restproxy.services.AccessValidationRulesService;
import com.example.switchyard.restproxy.services.ProxyService;

@Service(ProxyService.class)
public class ProxyServiceBean implements ProxyService {

	// @Inject @Reference
	// private AccessValidationRules rulez;
	private AccessValidationRulesService rulez = new MockRulez();

	@Inject
	@Reference("DataVirtService")
	private ProxyService proxy;

	@Override
	public String employeePeople(String content) {
		getUsernameFromContext();
		if (rulez.isValid(username)) {

			System.out.println("Content: " + content);
			String ret = "ERROR";
			try {
				ret = proxy.employeePeople(content);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		} else {
			return CustomHttpMessageComposer.UNAUTHORIZED;
		}
	}

	@Override
	public String peopleUnion(String content) {
		getUsernameFromContext();
		if (rulez.isValid(username)) {

			System.out.println("Content: " + content);
			String ret = "ERROR";
			try {
				ret = proxy.peopleUnion(content);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		} else {
			// TODO: Currently not possible to set property on return path for CDI Beans
			// context.setProperty(HttpContextMapper.HTTP_RESPONSE_STATUS, 401).addLabels(new String[]{EndpointLabel.HTTP.label()});
			// return "";
			return CustomHttpMessageComposer.UNAUTHORIZED;
		}
	}

	@Override
	public String inc(String content) {
		getUsernameFromContext();
		if (rulez.isValid(username)) {

			System.out.println("Content: " + content);
			String ret = "ERROR";
			try {
				ret = proxy.inc(content);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		} else {
			return CustomHttpMessageComposer.UNAUTHORIZED;
		}
	}

	@Inject
	private Context context;

	private String username;

	/**
	 * This method must be run in the beginning of each request management
	 * operation that will be executed by a job. The method fetches the username
	 * from the SY context and stores it in a class variable. This class
	 * variable must then be used when creating a new job.
	 */
	private void getUsernameFromContext() {
		SecurityContext securityCtx = context
				.getPropertyValue(SecurityContext.class.getName());
		Iterator<NameCredential> i = securityCtx.getCredentials(
				NameCredential.class).iterator();
		while (i.hasNext()) {
			NameCredential c = i.next();
			if (!c.getName().isEmpty()) {
				username = c.getName();
				System.out.println("Fetched username from Auth header: "
						+ username);
				return;
			}
		}
		throw new RuntimeException(
				"User not authenticated. Credentials not in context");
	}

}
