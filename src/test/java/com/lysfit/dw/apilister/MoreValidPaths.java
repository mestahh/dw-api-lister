package com.lysfit.dw.apilister;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/test")
public class MoreValidPaths {

	@GET
	@Path("/get")
	public int get() {
		return 0;
	}

	@POST
	@Path("/add")
	public void add() {

	}

	@Path("/wrong")
	public void wrong() {

	}

	@PUT
	public void put() {
	}

	@DELETE
	@Path("/delete")
	public void delete() {

	}

	public void notPathMethod() {

	}

	private void privateMethod() {

	}
}
