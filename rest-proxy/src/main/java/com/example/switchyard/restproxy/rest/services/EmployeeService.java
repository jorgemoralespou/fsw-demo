package com.example.switchyard.restproxy.rest.services;

import java.util.List;

import com.example.switchyard.restproxy.rest.model.Employee;

public interface EmployeeService {
    public Employee newEmployee();
    public Employee getEmployee(Integer employeeId);
    public String removeEmployee(Integer employeeId);
    public List<Employee> getEmployees();   
}
