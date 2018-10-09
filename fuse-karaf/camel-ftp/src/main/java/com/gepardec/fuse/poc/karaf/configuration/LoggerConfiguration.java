package com.gepardec.fuse.poc.karaf.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class holds the configuration and producer for the logging.
 * 
 * @author thomas.herzog@gepardec.com
 * @data Oct 9, 2018
 *
 */
@ApplicationScoped
public class LoggerConfiguration {

	@Produces
	@Dependent
	public Logger createLoggerInstance(InjectionPoint ip) {
		if (ip.getBean() != null) {
			return LoggerFactory.getLogger(ip.getBean().getBeanClass());
		} else if (ip.getMember() != null) {
			return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
		} else {
			return LoggerFactory.getLogger("default");
		}
	}
}
