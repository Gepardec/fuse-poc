package com.gepardec.fuse.poc.soap.code.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
	
@WebService
public class SinkWebservice {

    @WebMethod
    public String hello(Object o) {
	return "hello from the sink";
    }
}
