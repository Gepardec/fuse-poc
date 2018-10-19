package com.gepardec.fuse.poc.soap.code.processor;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Named("sinkProcessor")
@ApplicationScoped
public class SoapResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
	final String inMsg = exchange.getIn().getBody(String.class);
	final List<String> params = new LinkedList<String>() {
	    {
		add(inMsg + "_param1");
		add(inMsg + "_param2");
	    }
	};
	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
	exchange.getOut().setBody(params);
    }
}