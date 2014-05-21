# SwitchYard Stringtemplate integration
This project demonstrates a BUG in SwitchYard where an invocation from a SOAP composite to an SCA composite with a camel extension does not work, while if calling directly the composite with the camel extension via a File binding, it does work.

## Prerequitites

Install stringtemplate module and register as extension.

````
<module xmlns="urn:jboss:module:1.0" name="org.apache.camel.stringtemplate">

    <resources>
        <resource-root path="camel-stringtemplate-2.10.0.redhat-60024.jar"/>
        <resource-root path="stringtemplate-3.2.1.jar"/>
    </resources>

    <dependencies>
        <module name="org.slf4j"/>
        <module name="javax.api"/>
        <module name="org.apache.camel.core"/>
        <module name="org.antlr"/>
    </dependencies>
</module>
````

## Deployment order
You have to deploy:
- stringtemplate-common
- stringtemplate-example
- stringtemplate-soap-caller

## How to test KO
Send a request to the SOAP endpoint with a string:

E.g.:
````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:com.example.switchyard:stringtemplate:example:1.0">
   <soapenv:Header/>
   <soapenv:Body>
      <urn:logRequest>
         <urn:string>Jorgeurn:string>
      </urn:logRequest>
   </soapenv:Body>
</soapenv:Envelope>
````

Cheking the log files, you can see the error. No output file is written.

````
12:20:39,078 INFO  [route1] (http-/0.0.0.0:8080-1) Before template: ?
12:20:39,081 ERROR [org.apache.camel.processor.DefaultErrorHandler] (http-/0.0.0.0:8080-1) Failed delivery for (MessageId: ID-jbscsma01-45781-1400699294352-0-1 on ExchangeId: ID-jbscsma01-45781-1400699294352-0-2). Exhausted after delivery attempt: 1 caught: java.io.FileNotFoundException: Cannot find resource in classpath for URI: templates/message: java.io.FileNotFoundException: Cannot find resource in classpath for URI: templates/message
	at org.apache.camel.util.ResourceHelper.resolveMandatoryResourceAsInputStream(ResourceHelper.java:106) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.component.ResourceEndpoint.loadResource(ResourceEndpoint.java:94) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.component.ResourceEndpoint.getResourceAsInputStreamWithoutCache(ResourceEndpoint.java:83) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.component.ResourceEndpoint.getResourceAsInputStream(ResourceEndpoint.java:79) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.component.stringtemplate.StringTemplateEndpoint.onExchange(StringTemplateEndpoint.java:59) [camel-stringtemplate-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.impl.ProcessorEndpoint$1.process(ProcessorEndpoint.java:71) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.util.AsyncProcessorConverterHelper$ProcessorToAsyncProcessorBridge.process(AsyncProcessorConverterHelper.java:61) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.util.AsyncProcessorHelper.process(AsyncProcessorHelper.java:73) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.processor.SendProcessor$2.doInAsyncProducer(SendProcessor.java:122) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
	at org.apache.camel.impl.ProducerCache.doInAsyncProducer(ProducerCache.java:298) [camel-core-2.10.0.redhat-60024.jar:2.10.0.redhat-60024]
        ...
        ...
````

## How to test OK

Just deploy and activate the service. 

Drop a file in __/tmp/input__ with following content:

E.g.:
````
Jorge
````

Output: You will get a file __/tmp/output__ with following content:
````
Hola Jorge.
````

In logs:
````
12:21:30,310 INFO  [route1] (Camel (camel-1) thread #1 - file:///tmp) Before template: Jorge
12:21:30,352 INFO  [route1] (Camel (camel-1) thread #1 - file:///tmp) After template: Hola Jorge
````
