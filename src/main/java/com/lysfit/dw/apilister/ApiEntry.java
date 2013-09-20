package com.lysfit.dw.apilister;

public class ApiEntry {

	private final String path;
	private final String method;

	public ApiEntry(String path, String method) {
		this.path = path;
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public String getMethod() {
		return method;
	}

	@Override
	public String toString() {
		return method + ": " + path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ApiEntry) {
			ApiEntry o = (ApiEntry) obj;
			return path.equals(o.path) && method.equals(o.method);
		}
		return false;
	}

}
