package com.gepardec.fuse.poc.smb.configuration;

import org.apache.camel.impl.DefaultCamelContext;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author Thomas Herzog <thomas.herzog@gepardec.com>
 * @since 11/2/18
 */
@ApplicationScoped
public class SmbCamelContext extends DefaultCamelContext {

    @PostConstruct
    public void postConstruct() {
        setName("camel-context-smb");
    }
}
