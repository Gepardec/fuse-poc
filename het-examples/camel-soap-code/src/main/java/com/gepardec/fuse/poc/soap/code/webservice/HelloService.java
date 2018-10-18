package com.gepardec.fuse.poc.soap.code.webservice;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.camel.CamelContext;

@ApplicationScoped
@WebService
public class HelloService {

    @Resource(name = "java:jboss/camel/context/spring-context")
    private CamelContext ctx;

    @WebMethod
    public String hello() {
	ctx.createProducerTemplate().sendBody("direct:name", "hello");
	return "hello";
    }
}
