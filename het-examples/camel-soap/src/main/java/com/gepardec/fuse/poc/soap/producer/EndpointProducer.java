package com.gepardec.fuse.poc.soap.producer;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.transport.http.asyncclient.AsyncHTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;

import com.gepardec.fuse.poc.soap.webservice.SinkWebservice;
import org.example.ICalculator;

@ApplicationScoped
public class EndpointProducer {

//	{
//		@Override
//		protected void setupHandlers(ClientFactoryBean factoryBean, Client client) throws Exception {
//		final AsyncHTTPConduit conduit = (AsyncHTTPConduit) client.getConduit();
//
//		// ((DefaultHttpAsyncClient)conduit.getHttpAsyncClient()).getCredentialsProvider().setCredentials(AuthScope.ANY,
//		// arg1);
//
//		final AuthorizationPolicy authPolicy = conduit.getAuthorization();
//		final HTTPClientPolicy policy = new HTTPClientPolicy();
//		policy.setAllowChunking(false);
//		policy.setConnectionTimeout(36000);
//		policy.setReceiveTimeout(36000);
//		policy.setAutoRedirect(true);
//		conduit.setClient(policy);
//
//		authPolicy.setAuthorization("NTLM");
//		authPolicy.setAuthorizationType("NTLM");
//		authPolicy.setUserName("mm\\vieschul01");
//		authPolicy.setPassword("mmkarton01");
//	}
//	};

    @Named("cxfProducer")
    @Produces
    @ApplicationScoped
    CxfEndpoint createCxfEndpoint() {
	final CxfEndpoint endpoint = new CxfEndpoint();
	endpoint.setBeanId("cxfProducer");
	endpoint.setAddress("http://localhost:8080/camel-soap/SinkWebservice");
	endpoint.getInInterceptors().add(new LoggingInInterceptor());
	endpoint.getOutInterceptors().add(new LoggingOutInterceptor());
	endpoint.setServiceClass(ICalculator.class);
	endpoint.setProperties(new HashMap<>());
	endpoint.getProperties().put(AsyncHTTPConduit.USE_ASYNC, Boolean.TRUE);
	endpoint.getProperties().put(Credentials.class.getName(),
		new NTCredentials("vieschul01", "mmkarton01", null, "mm"));

	return endpoint;
    }
}
