package com.gepardec.fuse.poc.karaf.configuration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;

@ApplicationScoped
public class CamelFtpContext extends DefaultCamelContext {

	public static final String CTX_NAME = "camel-ftp-ctx";
	
	@Inject
	private Logger log;
	
	@PostConstruct
	public void postConstruct() {
		log.info("Initializing the camel context");
		setName(CTX_NAME);
	}
}
