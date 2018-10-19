package com.gepardec.fuse.poc.soap.route;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

@ContextName("camel-context-soap")
@ApplicationScoped
public class SoapRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
	from("direct:input").log("SOAP message recevied").process("soapMessageProcessor").log("SOAP message processed")
		.to("cxfProducer");

    }

}
