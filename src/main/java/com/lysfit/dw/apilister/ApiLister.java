package com.lysfit.dw.apilister;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Path;

public class ApiLister {

	public List<ApiEntry> getApiEntries(Class<?> clazz) {
		Path basePath = clazz.getAnnotation(Path.class);

		if (annotatedWithPath(basePath)) {

			List<ApiEntry> apiEntries = new ArrayList<ApiEntry>();

			for (ApiMethod method : getAnnotatedMethods(clazz)) {
				String path = basePath.value() + method.getPath();
				apiEntries.add(new ApiEntry(path, method.getHttpMethod()));
			}

			return apiEntries;
		}

		return Collections.emptyList();
	}

	private boolean annotatedWithPath(Path path) {
		return path != null;
	}

	private List<ApiMethod> getAnnotatedMethods(Class<?> clazz) {
		List<ApiMethod> methods = getDeclaredMethods(clazz);
		List<ApiMethod> annotated = new ArrayList<ApiMethod>();

		for (ApiMethod method : methods) {
			if (method.markedWithHttpMethod()) {
				annotated.add(method);
			}
		}
		return annotated;
	}

	private List<ApiMethod> getDeclaredMethods(Class<?> clazz) {
		List<ApiMethod> methods = new ArrayList<ApiMethod>();
		for (Method method : clazz.getDeclaredMethods()) {
			methods.add(new ApiMethod(method));
		}
		return methods;
	}

}
