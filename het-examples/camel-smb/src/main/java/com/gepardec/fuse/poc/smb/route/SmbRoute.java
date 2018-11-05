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
                .process(SmbRoute::processTransformInputFileToStringAndKeepOriginal)
                .doTry()
                .process(SmbRoute::processTransformInputFileToOutputFormat)
                .to("smbTargetEndpoint")
                .doFinally()
                .process(exchange -> exchange.getIn().setBody(exchange.getProperty(ORIGINAL_IS)))
                .to("smbBackupEndpoint")
                .end();
    }

    /**
     * This method processes the input file by reading the string content and setting it as the new body and keeping the original data as an input stream on the exchange header.
     *
     * @param exchange the exchange holding the input stream of the file
     * @throws Exception if an error occurs during the processing
     */
    public static void processTransformInputFileToStringAndKeepOriginal(final Exchange exchange) throws Exception {
        final InputStream is = exchange.getIn().getMandatoryBody(InputStream.class);
        String fileData;

        // read text file
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

        // Input stream for backup
        exchange.setProperty(ORIGINAL_IS, new BufferedInputStream(new ByteArrayInputStream(fileData.getBytes())));

        // Input stream for target
        exchange.getIn().setBody(fileData);
    }

    /**
     * This method processes the input file represented by an string and transforms it to the target output format.
     *
     * @param exchange the exchange holding the input data as string
     * @throws Exception if an error occurs during the processing
     */
    public static void processTransformInputFileToOutputFormat(final Exchange exchange) throws Exception {
        final String fileData = exchange.getIn().getMandatoryBody(String.class);
        final StringBuilder sw = new StringBuilder();

        // Parse file
        Arrays.stream(fileData.split(";"))
              .map(item -> item.split("="))
              .collect(Collectors.toMap(item -> item[0], item -> item[1]))
              .forEach((key, value) -> sw.append(String.format("%s-%s\n", key, value)));

        // Input stream for target
        exchange.getIn().setBody(new ByteArrayInputStream(sw.toString().getBytes()));
    }
}
