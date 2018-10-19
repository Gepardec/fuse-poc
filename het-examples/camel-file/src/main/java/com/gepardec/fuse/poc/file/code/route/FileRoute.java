package com.gepardec.fuse.poc.file.code.route;

import java.util.Iterator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.model.dataformat.ZipFileDataFormat;
import org.slf4j.Logger;

@ApplicationScoped
@ContextName("camel-context-file")
public class FileRoute extends RouteBuilder {

    @Inject
    private Logger log;

    @Override
    public void configure() throws Exception {
	log.debug("Building file route...");

	ZipFileDataFormat zipFile = new ZipFileDataFormat();
	zipFile.setUsingIterator(true);

	from("file:/tmp/file/data/in?initialDelay=2000&delay=2000&include=.*.zip&move=.processed").id("inputFile")
		.unmarshal(zipFile).split(bodyAs(Iterator.class)).streaming().process("fileProcessor").choice()
		.when(header("CamelFileName").endsWith(".xml")).to("file:/tmp/file/data/out/xml")
		.when(header("CamelFileName").endsWith(".txt")).to("file:/tmp/file/data/out/txt").endChoice().end();

	log.debug("Built    file route");
    }

}
