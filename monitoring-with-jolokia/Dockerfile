FROM jboss/switchyard-wildfly:2.0.0.Beta1

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin123! --silent

# Enable port for debugging with --debug
EXPOSE 8787

# Enable binding to all network interfaces and debugging inside the server
RUN echo "JAVA_OPTS=\"\$JAVA_OPTS -Djboss.bind.address=0.0.0.0 -Djboss.bind.address.management=0.0.0.0\"" >> ${JBOSS_HOME}/bin/standalone.conf

ENV JOLOKIA_VERSION 1.2.3

RUN curl http://labs.consol.de/maven/repository/org/jolokia/jolokia-war/$JOLOKIA_VERSION/jolokia-war-$JOLOKIA_VERSION.war -o $JBOSS_HOME/standalone/deployments/jolokia.war

#Add SwitchYard application to test
RUN cd $JBOSS_HOME/standalone/deployments/ \
    && curl http://maven.repository.redhat.com/techpreview/fsw6/6.0.0/maven-repository/org/switchyard/quickstarts/switchyard-quickstart-bean-service/1.1.1-p8-redhat-1/switchyard-quickstart-bean-service-1.1.1-p8-redhat-1.jar -o switchyard-quickstart-bean-service.jar \
    && curl http://maven.repository.redhat.com/techpreview/fsw6/6.0.0/maven-repository/org/switchyard/quickstarts/switchyard-quickstart-camel-ftp-binding/1.1.1-p8-redhat-1/switchyard-quickstart-camel-ftp-binding-1.1.1-p8-redhat-1.jar -o switchyard-quickstart-camel-ftp-binding.jar \
    && curl http://maven.repository.redhat.com/techpreview/fsw6/6.0.0/maven-repository/org/switchyard/quickstarts/switchyard-quickstart-http-binding/1.1.1-p8-redhat-1/switchyard-quickstart-http-binding-1.1.1-p8-redhat-1.jar -o switchyard-quickstart-http-binding.jar

ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh"]
CMD []

