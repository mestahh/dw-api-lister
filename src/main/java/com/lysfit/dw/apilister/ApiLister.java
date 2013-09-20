package com.lysfit.dw.apilister;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

public class ApiLister {

	public List<ApiEntry> getApiEntries(Class<?> class1) {
		Path basePath = class1.getAnnotation(Path.class);

		if (annotatedWithPath(basePath)) {

			List<ApiEntry> apiEntries = new ArrayList<ApiEntry>();

			for (Method method : getAnnotatedMethods(class1)) {
				String path = basePath.value();
				Path methodPath = method.getAnnotation(Path.class);

				if (annotatedWithPath(methodPath)) {
					path += methodPath.value();
				}

				String httpMethod = getHttpMethod(method);
				apiEntries.add(new ApiEntry(path, httpMethod));
			}

			return apiEntries;
		}

		return Collections.emptyList();
	}

	private boolean annotatedWithPath(Path basePath) {
		return basePath != null;
	}

	private String getHttpMethod(Method method) {
		if (method.getAnnotation(GET.class) != null) {
			return "GET";
		} else if (method.getAnnotation(DELETE.class) != null) {
			return "DELETE";
		} else if (method.getAnnotation(PUT.class) != null) {
			return "PUT";
		}
		return "POST";
	}

	private List<Method> getAnnotatedMethods(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		List<Method> annotated = new ArrayList<Method>();

		for (Method method : methods) {
			if (markedWithHttpMethod(method)) {
				annotated.add(method);
			}
		}
		return annotated;
	}

	private boolean markedWithHttpMethod(Method method) {
		return method.getAnnotation(PUT.class) != null || method.getAnnotation(DELETE.class) != null
				|| method.getAnnotation(GET.class) != null || method.getAnnotation(POST.class) != null;
	}
}
