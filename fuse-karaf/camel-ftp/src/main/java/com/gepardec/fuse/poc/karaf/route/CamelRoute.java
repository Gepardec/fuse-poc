package com.gepardec.fuse.poc.karaf.route;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;

@ApplicationScoped
public class CamelRoute extends RouteBuilder {

	@Inject
	private Logger log;

	@Override
	public void configure() throws Exception {
		from("direct:log").log("hello");
	}
}
