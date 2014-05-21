
package com.example.switchyard.stringtemplate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.switchyard.stringtemplate package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Log_QNAME = new QName("urn:com.example.switchyard:stringtemplate:example:1.0", "logRequest");
    private final static QName _LogResponse_QNAME = new QName("urn:com.example.switchyard:stringtemplate:example:1.0", "logResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.switchyard.stringtemplate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LogResponse }
     * 
     */
    public LogResponse createLogResponse() {
        return new LogResponse();
    }

    /**
     * Create an instance of {@link LogRequest }
     * 
     */
    public LogRequest createLog() {
        return new LogRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com.example.switchyard:stringtemplate:example:1.0", name = "logRequest")
    public JAXBElement<LogRequest> createLog(LogRequest value) {
        return new JAXBElement<LogRequest>(_Log_QNAME, LogRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com.example.switchyard:stringtemplate:example:1.0", name = "logResponse")
    public JAXBElement<LogResponse> createLogResponse(LogResponse value) {
        return new JAXBElement<LogResponse>(_LogResponse_QNAME, LogResponse.class, null, value);
    }

}
