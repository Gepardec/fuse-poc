package com.gepardec.fuse.poc.soap.code;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.ImportResource;
import org.apache.camel.impl.DefaultCamelContext;

@ApplicationScoped
@ContextName("camel-context-soap")
@ImportResource("META-INF/jboss-camel-context.xml")
public class SoapCamelContext extends DefaultCamelContext {

}
