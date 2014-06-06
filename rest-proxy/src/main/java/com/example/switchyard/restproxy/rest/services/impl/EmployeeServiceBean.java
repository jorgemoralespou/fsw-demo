package com.example.switchyard.restproxy.rest.services.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;
import org.switchyard.security.context.SecurityContext;
import org.switchyard.security.credential.NameCredential;

import com.example.switchyard.restproxy.exceptions.UnauthorizedException;
import com.example.switchyard.restproxy.rest.model.Employee;
import com.example.switchyard.restproxy.rest.model.UserIdentity;
import com.example.switchyard.restproxy.rest.services.EmployeeService;
import com.example.switchyard.restproxy.services.AccessValidationRulesService;

@Service(name = "EmployeeService", value = EmployeeService.class)
public class EmployeeServiceBean implements EmployeeService {

	@Inject @Reference
	private AccessValidationRulesService rulez;
//	private AccessValidationRulesService rulez = new MockRulez();

	@Inject
	@Reference("ExternalEmployeeService")
	private EmployeeService externalService;

	@Override
	public Employee newEmployee() {
		System.out.println("EmployeeServiceBean.newEmployee");
		getUsernameFromContext();

		UserIdentity user = new UserIdentity(username, "admin");
		if (rulez.validate(user).isValid()) {
			return externalService.newEmployee();
		} else {
			throw new UnauthorizedException("UNAUTHORIZED");
		}
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		System.out.println("EmployeeServiceBean.getEmployee");
		getUsernameFromContext();

		UserIdentity user = new UserIdentity(username, "admin");
		if (rulez.validate(user).isValid()) {
			return externalService.getEmployee(employeeId);
		} else {
			throw new UnauthorizedException("UNAUTHORIZED");
		}
	}

	@Override
	public String removeEmployee(Integer employeeId) {
		System.out.println("EmployeeServiceBean.removeEmployee");
		getUsernameFromContext();

		UserIdentity user = new UserIdentity(username, "admin");
		if (rulez.validate(user).isValid()) {
			return externalService.removeEmployee(employeeId);
		} else {
			throw new UnauthorizedException("UNAUTHORIZED");
		}
	}

	@Override
	public List<Employee> getEmployees() {
		System.out.println("EmployeeServiceBean.getEmployees");
		getUsernameFromContext();

		UserIdentity user = new UserIdentity(username, "admin");
		if (rulez.validate(user).isValid()) {
			return externalService.getEmployees();
		} else {
			throw new UnauthorizedException("UNAUTHORIZED");
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
		System.out.println("EmployeeServiceBean.getUsernameFromContext");
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
		throw new UnauthorizedException(
				"User not authenticated. Credentials not in context");
	}

}
