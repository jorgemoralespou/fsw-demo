CDI Injection with alternative
===

There are 3 projects:
- cdi-alternative-common: The interface, Logger.
- cdi-alternative-alternative: The alternative implementation. AlternativeLogger, annotated with @Alternative
- cdi-alternative-injected: The SwitchYard project wchih injects a Logger. A default implementation @Default DefaultLogger, and an alternative set in beans.xml for AlternativeLogger

At runtime, you should see the message printed by the AlternativeLogger instead that the one set by the DefaultLogger on the server.log

To test, create a file in /tmp name log.txt with a String in it.

- If DefaultLogger is used, you will see: "Default: " + message
- If AlternativeLogger is used, you will see: "Alternative: " + message.


Deployment order:

1. cdi-alternative-common
1. cdi-alternative-alternative
1. cdi-alternative-injected
