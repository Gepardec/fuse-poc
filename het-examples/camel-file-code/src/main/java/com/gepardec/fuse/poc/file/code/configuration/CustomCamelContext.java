package com.gepardec.fuse.poc.file.code.configuration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.cdi.ContextName;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;

@ApplicationScoped
@ContextName("camel-file-code")
public class CustomCamelContext extends DefaultCamelContext {

	@Inject
	private Logger log;
	
	@PostConstruct
	public void postConstruct() {
		log.info("Initializing custom camel context with name camel-file-code");
		setName("camel-file-code");
		setTypeConverterStatisticsEnabled(true);
		disableJMX();
	}

}
