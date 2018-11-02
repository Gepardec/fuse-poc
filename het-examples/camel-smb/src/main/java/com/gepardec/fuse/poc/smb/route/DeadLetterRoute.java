package com.gepardec.fuse.poc.smb.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Thomas Herzog <thomas.herzog@gepardec.com>
 * @since 11/2/18
 */
@ApplicationScoped
public class DeadLetterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:deadLetter")
                .log(LoggingLevel.ERROR, String.format("Error found for file ${header.%s}", Exchange.FILE_NAME))
                .process(DeadLetterRoute::processFailedMail)
                .to("mailFailedEndpoint");
    }

    private static void processFailedMail(final Exchange exchange) {
        final String msg = String.format("File with name '%s' failed to process. Take a look in failed directory", exchange.getIn().getHeader(Exchange.FILE_NAME));
        exchange.getIn().setBody(msg);
    }
}
