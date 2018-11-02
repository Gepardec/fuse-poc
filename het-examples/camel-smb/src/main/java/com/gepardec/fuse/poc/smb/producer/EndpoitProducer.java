package com.gepardec.fuse.poc.smb.producer;

import at.ihet.camel.extras.smbj.SmbComponent;
import at.ihet.camel.extras.smbj.SmbConfiguration;
import at.ihet.camel.extras.smbj.SmbEndpoint;
import org.apache.camel.CamelContext;
import org.apache.camel.component.mail.MailComponent;
import org.apache.camel.component.mail.MailConfiguration;
import org.apache.camel.component.mail.MailEndpoint;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.net.URI;

/**
 * @author Thomas Herzog <thomas.herzog@gepardec.com>
 * @since 11/2/18
 */
@ApplicationScoped
public class EndpoitProducer {

    @Produces
    @ApplicationScoped
    @Named("smbSourceEndpoint")
    SmbEndpoint createSmbSourceEndpoint(final CamelContext ctx) {
        final URI uri = URI.create("smb://localhost:50445/source");
        final SmbEndpoint endpoint = new SmbEndpoint(uri.toString(), new SmbComponent(), new SmbConfiguration(uri));
        endpoint.setCamelContext(ctx);
        endpoint.setDownload(true);
        endpoint.setDelete(true);
        endpoint.setDirectoryMustExist(true);
        endpoint.setStartingDirectoryMustExist(true);
        endpoint.setInitialDelay(5000);
        endpoint.setDelay(2000);
        endpoint.setMoveFailed(".filesFailed");
        endpoint.setMoveExisting(".filesExisting");
        endpoint.setRecursive(true);

        // smb configuration
        endpoint.getConfiguration().setUsername("source");
        endpoint.getConfiguration().setPassword("source");
        endpoint.getConfiguration().setVersions("2_1");

        return endpoint;
    }

    @Produces
    @ApplicationScoped
    @Named("smbTargetEndpoint")
    SmbEndpoint createSmbTargetEndpoint(final CamelContext ctx) {
        final URI uri = URI.create("smb://localhost:50445/target");
        final SmbEndpoint endpoint = new SmbEndpoint(uri.toString(), new SmbComponent(), new SmbConfiguration(uri));
        endpoint.setCamelContext(ctx);
        endpoint.setEagerDeleteTargetFile(false);
        endpoint.setStartingDirectoryMustExist(true);
        endpoint.setMoveExisting(".filesExisting");

        // smb configuration
        endpoint.getConfiguration().setUsername("target");
        endpoint.getConfiguration().setPassword("target");
        endpoint.getConfiguration().setVersions("2_0_2,2_1,2xx");

        return endpoint;
    }

    @Produces
    @ApplicationScoped
    @Named("smbBackupEndpoint")
    SmbEndpoint createSmbBackupEndpoint(final CamelContext ctx) {
        final URI uri = URI.create("smb://localhost:50445/backup");
        final SmbEndpoint endpoint = new SmbEndpoint(uri.toString(), new SmbComponent(), new SmbConfiguration(uri));
        endpoint.setCamelContext(ctx);
        endpoint.setEagerDeleteTargetFile(true);
        endpoint.setStartingDirectoryMustExist(true);
        endpoint.setMoveExisting(".filesExisting");

        // smb configuration
        endpoint.getConfiguration().setUsername("backup");
        endpoint.getConfiguration().setPassword("backup");
        endpoint.getConfiguration().setVersions("2_0_2,2_1,2xx");

        return endpoint;
    }


    @Produces
    @ApplicationScoped
    @Named("mailFailedEndpoint")
    MailEndpoint createMailFailedEndpoint(final CamelContext ctx) {
        final URI uri = URI.create(String.format("%s://%s:%d", System.getProperty("smb.mail.scheme"), System.getProperty("smb.mail.host"), Integer.valueOf(System.getProperty("smb.mail.port"))));
        final MailEndpoint endpoint = new MailEndpoint(uri.toString(), new MailComponent(ctx), new MailConfiguration());
        endpoint.setCamelContext(ctx);
        endpoint.getConfiguration().configure(uri);
        endpoint.getConfiguration().setUsername(System.getProperty("smb.mail.user"));
        endpoint.getConfiguration().setPassword(System.getProperty("smb.mail.pwd"));
        endpoint.getConfiguration().setContentType("text/plain");
        endpoint.getConfiguration().setSubject("Error during file processing");
        endpoint.getConfiguration().setFrom("error.reporter@camel.com");
        endpoint.getConfiguration().setTo("thomas.herzog@gepardec.com");

        return endpoint;
    }
}
