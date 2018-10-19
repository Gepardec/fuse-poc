package com.gepardec.fuse.poc.soap.webservice;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.camel.CamelContext;

@ApplicationScoped
@WebService
public class HelloService {

    @Resource(name = "java:jboss/camel/context/camel-context-soap")
    private CamelContext ctx;

    @WebMethod
    public String hello() {
	ctx.createProducerTemplate().sendBody("direct:input", "hello");
	return "hello";
    }
}
