package com.example.switchyard.restproxy.rest.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.example.switchyard.restproxy.rest.model.Employee;

@Path("/EmployeePeople")
public interface EmployeeResource {

	@POST
    @Path("/")
    @Produces({"text/xml"})
    public Employee newEmployee();

    @GET
    @Path("{employeeId}")
    @Produces({"text/xml"})
    public Response getEmployee(@PathParam("employeeId") Integer employeeId);
    
    @DELETE
    @Path("{employeeId}")
    public String removeEmployee(@PathParam("employeeId") Integer employeeId);
    
    @GET
    @Path("/")
    @Produces({"text/xml"})
    public List<Employee> getEmployees();   
}
