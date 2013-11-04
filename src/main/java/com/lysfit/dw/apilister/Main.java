package com.lysfit.dw.apilister;

import java.util.List;

import com.lysfit.li.core.resources.EstateTaskResource;
import com.lysfit.li.core.resources.NewsResource;
import com.lysfit.li.core.resources.UserResource;

public class Main {

	public static final void main(String[] args) {
		ApiLister lister = new ApiLister();
		List<ApiEntry> newsResourceEntries = lister.getApiEntries(NewsResource.class);
		List<ApiEntry> userResource = lister.getApiEntries(UserResource.class);
		List<ApiEntry> estateTasks = lister.getApiEntries(EstateTaskResource.class);

		print("NEWS", newsResourceEntries);
		print("USERS", userResource);
		print("TASKS", estateTasks);
	}

	private static void print(String title, List<ApiEntry> entries) {
		System.out.println(title + ":");
		for (ApiEntry entry : entries) {
			System.out.println(entry.getPath() + " " + entry.getMethod());
		}
	}

}
