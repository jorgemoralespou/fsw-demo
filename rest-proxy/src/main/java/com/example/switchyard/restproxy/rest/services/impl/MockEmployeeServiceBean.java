package com.example.switchyard.restproxy.rest.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.switchyard.component.bean.Service;

import com.example.switchyard.restproxy.rest.model.Employee;
import com.example.switchyard.restproxy.rest.services.EmployeeService;

@Service(name="MockEmployeeService", value=EmployeeService.class)
public class MockEmployeeServiceBean implements EmployeeService {

	private static final Map<Integer, Employee> _employees = new HashMap<Integer, Employee>();

	private static final AtomicInteger count = new AtomicInteger(0);

	@Override
	public Employee newEmployee() {
		Employee e = new Employee();
		Integer id = count.addAndGet(1);
		e.setEmployeeId(id);
		e.setName("Employee_" + id);
		_employees.put(id, e);
		return e;
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		return _employees.get(employeeId);
	}

	@Override
	public String removeEmployee(Integer employeeId) {
		_employees.remove(employeeId);
		return "SUCCESS";
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> lE = new ArrayList<Employee>(_employees.values());
		return lE;
	}

}
