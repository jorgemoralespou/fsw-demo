package com.example.switchyard.restproxy.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employee")
public class Employee {
    @XmlElement(name = "employeeId", required = true)
    private Integer _employeeId;
    
    @XmlElement(name = "name", required = true)
    private String _name;

	public Integer getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(Integer _employeeId) {
		this._employeeId = _employeeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}    
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{EmployeeId: ");
        builder.append(_employeeId);
        builder.append(", Name:");
        builder.append(_name);
        builder.append("}");
        return builder.toString();
    }   
}
