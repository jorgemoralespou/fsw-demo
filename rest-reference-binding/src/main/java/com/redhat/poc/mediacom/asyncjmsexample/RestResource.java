package com.redhat.poc.mediacom.asyncjmsexample;
 
 
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
 
/**
 * @author <a href="http://www.christianposta.com/blog">Christian Posta</a>
 */
@Path("/")
public interface RestResource {
 
    @POST
    @Consumes({"text/xml"})
    public String getBackendService(IncomingRequest request);
}