package com.gepardec.fuse.poc.smb.producer;

import org.apache.camel.CamelContext;
import org.apache.camel.PropertyInject;
import org.apache.camel.component.mail.MailComponent;
import org.apache.camel.component.mail.MailConfiguration;
import org.apache.camel.component.mail.MailEndpoint;
import org.apache.camel.component.smbj.SmbComponent;
import org.apache.camel.component.smbj.SmbConfiguration;
import org.apache.camel.component.smbj.SmbEndpoint;

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

    @PropertyInject(value = "smb.mail.host")
    private String mailHost;
    @PropertyInject(value = "smb.mail.port")
    private String mailPort;
    @PropertyInject(value = "smb.mail.scheme")
    private String mailScheme;
    @PropertyInject(value = "smb.mail.user")
    private String mailUser;
    @PropertyInject(value = "smb.mail.pwd")
    private String mailPwd;
    @PropertyInject(value = "smb.mail.to")
    private String mailToAddress;

    @Produces
    @ApplicationScoped
    @Named("smbSourceEndpoint")
    SmbEndpoint createSmbSourceEndpoint(final CamelContext ctx) {
        final URI uri = URI.create("smb://localhost:50445/source/test/me");
        final SmbEndpoint endpoint = new SmbEndpoint(uri.toString(), new SmbComponent(), new SmbConfiguration(uri));
        endpoint.setCamelContext(ctx);
        endpoint.setDownload(true);
        endpoint.setDelete(true);
//        endpoint.setDirectoryMustExist(true);
//        endpoint.setStartingDirectoryMustExist(true);
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
        final URI uri = URI.create(String.format("%s://%s:%d", mailScheme, mailHost, Integer.valueOf(mailPort)));
        final MailEndpoint endpoint = new MailEndpoint(uri.toString(), new MailComponent(ctx), new MailConfiguration());
        endpoint.setCamelContext(ctx);
        endpoint.getConfiguration().configure(uri);
        endpoint.getConfiguration().setUsername(mailUser);
        endpoint.getConfiguration().setPassword(mailPwd);
        endpoint.getConfiguration().setContentType("text/plain");
        endpoint.getConfiguration().setSubject("Error during file processing");
        endpoint.getConfiguration().setFrom("error.reporter@camel.com");
        endpoint.getConfiguration().setTo(mailToAddress);

        return endpoint;
    }
}
