package com.gepardec.fuse.poc.smb.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Thomas Herzog <thomas.herzog@gepardec.com>
 * @since 11/2/18
 */
@ApplicationScoped
public class SmbRoute extends RouteBuilder {

    private static final String ORIGINAL_IS = "ORIGINAL_IS";

    @Override
    public void configure() throws Exception {
        errorHandler(deadLetterChannel("direct:deadLetter"));

        from("smbSourceEndpoint")
                .process(SmbRoute::processTransformInputFileToOutputFormat)
                .to("smbTargetEndpoint")
                .process(exchange -> exchange.getIn().setBody(exchange.getProperty(ORIGINAL_IS)))
                .to("smbBackupEndpoint");
    }

    /**
     * This method processes the input file and transforms it to the target output format.
     *
     * @param exchange the exchange holding the input stream of the file
     * @throws Exception if an error occurs during the processing
     */
    public static void processTransformInputFileToOutputFormat(final Exchange exchange) throws Exception {
        final InputStream is = exchange.getIn().getMandatoryBody(InputStream.class);
        final StringBuilder sw = new StringBuilder();
        String fileData;

        try (final BufferedInputStream bis = new BufferedInputStream(is)) {
            try (final ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[4092];
                int size;
                while ((size = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, size);

                }
                bos.flush();
                fileData = new String(bos.toByteArray(), StandardCharsets.UTF_8);
            }
        }

        Arrays.stream(fileData.split(";"))
              .map(item -> item.split("="))
              .collect(Collectors.toMap(item -> item[0], item -> item[1]))
              .forEach((key, value) -> sw.append(String.format("%s-%s\n", key, value)));

        // Input stream for backup
        exchange.setProperty(ORIGINAL_IS, new BufferedInputStream(new ByteArrayInputStream(fileData.getBytes())));
        // Input stream for target
        exchange.getIn().setBody(new ByteArrayInputStream(sw.toString().getBytes()));
    }
}
