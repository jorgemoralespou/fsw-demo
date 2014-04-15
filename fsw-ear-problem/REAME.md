# ear-problem with FSW reproducer #
Follow these steps to reproduce:

## Prerequisites
- Set this properties in a profile or provide them command line, or change them in base pom.xml.
````
    <hostname>${jboss.fsw.host}</hostname>
	<port>${jboss.fsw.port}</port>
	<username>${jboss.fsw.username}</username>
	<password>${jboss.fsw.password}</password>
````

## Failure scenario

- From top level project deploy every project. (It will deploy in given order) 
````
mvn clean install jboss:as-deploy
````

- Execute service2 request: Endpoint: __http://localhost:8080/examples/SampleLogic__
````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:org.jboss.examples.earproblem.services:1.0">
   <soapenv:Header/>
   <soapenv:Body>
      <urn:doLogic>
         <urn:string>message to log</urn:string>
      </urn:doLogic>
   </soapenv:Body>
</soapenv:Envelope>
````
You should see the following response:
````
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"/>
   <soap:Body>
      <return>DONE SUCCESS</return>
   </soap:Body>
</soap:Envelope>
````

- Execute service1 request: Endpoint: __http://localhost:8080/logger/MessageLogger__
````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:org="org.jboss.examples.earproblem">
   <soapenv:Header/>
   <soapenv:Body>
      <org:logMesssage>
         <!--Optional:-->
         <org:string>message to log</org:string>
      </org:logMesssage>
   </soapenv:Body>
</soapenv:Envelope>
````
You should see the following response:
````
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"/>
   <soap:Body>
      <return>SUCCESS</return>
   </soap:Body>
</soap:Envelope>
````
But you see this:
````
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"/>
   <soap:Body>
      <SOAP-ENV:Fault xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
         <faultcode>SOAP-ENV:Server</faultcode>
         <faultstring>SWITCHYARD035452: Timed out after 15000 ms waiting on synchronous response from target service '{urn:org.jboss.examples.earproblem:service2:1.0}MessageLoggerPortType'.</faultstring>
      </SOAP-ENV:Fault>
   </soap:Body>
</soap:Envelope>
````

## Working scenario

- Only deploy common and service1 
````
cd common
mvn clean install jboss:as-deploy
cd ..
cd service1
mvn clean install jboss:as-deploy
cd ..
````
- Execute service1 request: Endpoint: __http://localhost:8080/logger/MessageLogger__
````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:org="org.jboss.examples.earproblem">
   <soapenv:Header/>
   <soapenv:Body>
      <org:logMesssage>
         <!--Optional:-->
         <org:string>message to log</org:string>
      </org:logMesssage>
   </soapenv:Body>
</soapenv:Envelope>
````
You should see the following response:
````
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"/>
   <soap:Body>
      <return>SUCCESS</return>
   </soap:Body>
</soap:Envelope>
````
### Make it fail
- Deploy service2
````
cd service2
mvn clean install jboss:as-deploy
cd ..
````
- Execute service2 request: Endpoint: __http://localhost:8080/examples/SampleLogic__
````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:org.jboss.examples.earproblem.services:1.0">
   <soapenv:Header/>
   <soapenv:Body>
      <urn:doLogic>
         <urn:string>message to log</urn:string>
      </urn:doLogic>
   </soapenv:Body>
</soapenv:Envelope>
````
You should see the following response:
````
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"/>
   <soap:Body>
      <return>DONE SUCCESS</return>
   </soap:Body>
</soap:Envelope>
````
So far, this service works.
Now lets execute again request for service1.
- Execute service1 request: Endpoint: __http://localhost:8080/logger/MessageLogger__
````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:org="org.jboss.examples.earproblem">
   <soapenv:Header/>
   <soapenv:Body>
      <org:logMesssage>
         <!--Optional:-->
         <org:string>message to log</org:string>
      </org:logMesssage>
   </soapenv:Body>
</soapenv:Envelope>
````
You should see the following response:
````
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"/>
   <soap:Body>
      <return>SUCCESS</return>
   </soap:Body>
</soap:Envelope>
````
But you see this:
````
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"/>
   <soap:Body>
      <SOAP-ENV:Fault xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
         <faultcode>SOAP-ENV:Server</faultcode>
         <faultstring>SWITCHYARD035452: Timed out after 15000 ms waiting on synchronous response from target service '{urn:org.jboss.examples.earproblem:service2:1.0}MessageLoggerPortType'.</faultstring>
      </SOAP-ENV:Fault>
   </soap:Body>
</soap:Envelope>
````

# THIS IS THE BUG
