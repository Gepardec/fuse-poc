package com.gepardec.fuse.poc.file.code.route;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.ZipFileDataFormat;
import org.slf4j.Logger;

@ApplicationScoped
public class FileRoute extends RouteBuilder {

	@Inject
	private Logger log;

	@Override
	public void configure() throws Exception {
		log.debug("Building file route...");

		ZipFileDataFormat zipFile = new ZipFileDataFormat();
		zipFile.setUsingIterator(true);

		from("file:/tmp/file/data/in?initialDelay=2000;delay=2000;regexPattern=*.xml;moveNamePrefix=.processed")
				.id("inputFile");

		log.debug("Built    file route");
	}

}
