package com.example.switchyard.restproxy.transformers;

import javax.inject.Named;

import org.jboss.resteasy.client.core.BaseClientResponse;
import org.switchyard.annotations.Transformer;

import com.example.switchyard.restproxy.rest.model.Employee;


@Named("Transformers")
public class Transformers {


    @Transformer(from = "java:org.jboss.resteasy.client.core.BaseClientResponse")
    public Employee transform(BaseClientResponse<Employee> from) {
        from.setReturnType(Employee.class);
        return (Employee)from.getEntity();
    }

}