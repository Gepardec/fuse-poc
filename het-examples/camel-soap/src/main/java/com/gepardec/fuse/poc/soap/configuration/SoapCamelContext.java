package com.gepardec.fuse.poc.soap.configuration;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.cdi.ContextName;
import org.apache.camel.impl.DefaultCamelContext;

@ApplicationScoped
@ContextName("camel-context-soap")
public class SoapCamelContext extends DefaultCamelContext {
}
