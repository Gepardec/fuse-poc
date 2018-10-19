package com.gepardec.fuse.poc.soap.code.webservice;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;

@ApplicationScoped
@WebService
public class SinkWebservice {

    @Inject
    private Logger log;
    
    @WebMethod
    public String hello(@WebParam(name="param1") final String param1, @WebParam(name="param2") final String param2) {
	final String msg = String.format("SinkService received message: Param1: %s, Param2: %s", param1, param2);
	log.info(msg);
	return msg;
    }
}
