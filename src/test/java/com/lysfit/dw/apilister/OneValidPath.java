package com.lysfit.dw.apilister;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class OneValidPath {

	@GET
	public int getInt() {
		return 0;
	}
}
