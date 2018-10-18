package com.gepardec.fuse.poc.file.code.configuration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.impl.DefaultCamelContext;

@ApplicationScoped
public class CustomCamelContext extends DefaultCamelContext {

	@PostConstruct
	public void postConstruct() {
		setName("camel-file-code");
		setTypeConverterStatisticsEnabled(true);
		disableJMX();
	}

}
