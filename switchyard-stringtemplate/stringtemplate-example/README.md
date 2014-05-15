# SwitchYard Stringtemplate integration
This project tests creating a file based on contents from a template

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


## How to test

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

