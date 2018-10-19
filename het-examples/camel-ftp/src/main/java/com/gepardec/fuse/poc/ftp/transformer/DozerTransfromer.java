package com.gepardec.fuse.poc.ftp.transformer;

import java.util.Optional;

public class DozerTransfromer {

	public String mapIntegerToString(Integer input) {
		return String.valueOf(Optional.ofNullable(input).orElse(4240));
	}

	public String transformOrderNumber(final String orderNr) {
		return "AT-".concat(Optional.ofNullable(orderNr).orElse("000000").toString()).concat("-WERK");
	}

}
