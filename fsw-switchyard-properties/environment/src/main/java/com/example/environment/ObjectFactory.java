
package com.example.environment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.environment package. 
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

    private final static QName _TestRequest_QNAME = new QName("urn:org.jboss.examples.sy.properties:environment:1.0", "testRequest");
    private final static QName _TestResponse_QNAME = new QName("urn:org.jboss.examples.sy.properties:environment:1.0", "testResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.environment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TestResponse }
     * 
     */
    public TestResponse createTestResponse() {
        return new TestResponse();
    }

    /**
     * Create an instance of {@link TestRequest }
     * 
     */
    public TestRequest createTestRequest() {
        return new TestRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:org.jboss.examples.sy.properties:environment:1.0", name = "testRequest")
    public JAXBElement<TestRequest> createTestRequest(TestRequest value) {
        return new JAXBElement<TestRequest>(_TestRequest_QNAME, TestRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:org.jboss.examples.sy.properties:environment:1.0", name = "testResponse")
    public JAXBElement<TestResponse> createTestResponse(TestResponse value) {
        return new JAXBElement<TestResponse>(_TestResponse_QNAME, TestResponse.class, null, value);
    }

}
