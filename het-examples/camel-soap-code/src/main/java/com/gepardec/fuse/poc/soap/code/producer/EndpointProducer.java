package com.gepardec.fuse.poc.soap.code.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.camel.component.cxf.CxfEndpoint;

import com.gepardec.fuse.poc.soap.code.webservice.SinkWebservice;

@ApplicationScoped
public class EndpointProducer {

    @Named("cxfProducer")
    @Produces
    @ApplicationScoped
    CxfEndpoint createCxfEndpoint() {
	final CxfEndpoint endpoint = new CxfEndpoint();
	endpoint.setBeanId("cxfProducer");
	endpoint.setAddress("http://localhost:8080/camel-test-spring/SinkWebservice");
	endpoint.setServiceClass(SinkWebservice.class);
	
	return endpoint;
    }
}
