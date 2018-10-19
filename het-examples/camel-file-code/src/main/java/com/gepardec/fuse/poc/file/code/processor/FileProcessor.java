package com.gepardec.fuse.poc.file.code.processor;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.cdi.ContextName;

/**
 * Must be named, otherwise camel will not find it.
 * 
 * @author thomas.herzog@gepardec.com
 * @data Oct 18, 2018
 *
 */
@Named("fileProcessor")
@ApplicationScoped
@ContextName("camel-context-file")
public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
	final String data = exchange.getIn().getBody(String.class);
	final Map<String, Object> inHeaders = exchange.getIn().getHeaders();

	inHeaders.put("CamelFileName", "processed_" + inHeaders.get("CamelFileName"));
	exchange.getIn().setBody(data);
    }
}
