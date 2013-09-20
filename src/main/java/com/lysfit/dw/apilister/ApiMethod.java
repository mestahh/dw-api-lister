package com.lysfit.dw.apilister;

import java.lang.reflect.Method;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

public class ApiMethod {

	private final Method method;

	public ApiMethod(Method method) {
		this.method = method;
	}

	public boolean put() {
		return method.getAnnotation(PUT.class) != null;
	}

	public boolean delete() {
		return method.getAnnotation(DELETE.class) != null;
	}

	public boolean post() {
		return method.getAnnotation(POST.class) != null;
	}

	public boolean get() {
		return method.getAnnotation(GET.class) != null;
	}

	public String getHttpMethod() {
		if (get()) {
			return "GET";
		} else if (delete()) {
			return "DELETE";
		} else if (put()) {
			return "PUT";
		}
		return "POST";
	}

	public boolean markedWithHttpMethod() {
		return put() || delete() || get() || post();
	}

	public String getPath() {
		Path methodPath = method.getAnnotation(Path.class);

		if (methodPath != null) {
			return methodPath.value();
		}
		return "";
	}
}
