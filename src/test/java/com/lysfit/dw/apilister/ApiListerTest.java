package com.lysfit.dw.apilister;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ApiListerTest {

	private ApiLister testObj;

	@Before
	public void setUp() {
		testObj = new ApiLister();
	}

	@Test
	public void it_returns_an_empty_list_if_the_class_does_not_contains_a_path() {
		List<ApiEntry> apiEntries = testObj.getApiEntries(NoPath.class);
		assertThat(apiEntries).isEmpty();
	}

	@Test
	public void it_returns_an_ApiEntry_if_the_class_does_contains_one_path() {
		List<ApiEntry> apiEntries = testObj.getApiEntries(OneValidPath.class);
		assertThat(apiEntries.get(0).getPath()).isEqualTo("/test");
	}

	@Test
	public void it_returns_correct_ApiEntries_if_the_class_contains_more_paths() {
		List<ApiEntry> apiEntries = testObj.getApiEntries(MoreValidPaths.class);

		ApiEntry get = new ApiEntry("/test/get", "GET");
		ApiEntry delete = new ApiEntry("/test/delete", "DELETE");
		ApiEntry add = new ApiEntry("/test/add", "POST");
		ApiEntry put = new ApiEntry("/test", "PUT");

		assertThat(apiEntries).containsOnly(get, add, delete, put);
	}

}
