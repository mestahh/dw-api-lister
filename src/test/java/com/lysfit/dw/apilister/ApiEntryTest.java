package com.lysfit.dw.apilister;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ApiEntryTest {

	private ApiEntry testObj;

	@Before
	public void setUp() {
		testObj = new ApiEntry("path", "method");
	}

	@Test
	public void stores_the_path_and_the_method() {
		assertThat(testObj.getPath()).isEqualTo("path");
		assertThat(testObj.getMethod()).isEqualTo("method");
	}

	@Test
	public void toString_is_implemented() {
		assertThat(testObj.toString()).isEqualTo("method: path");
	}

	@Test
	public void two_entries_are_equal_if_the_method_and_the_path_are_equal() {
		assertThat(testObj).isEqualTo(new ApiEntry("path", "method"));
	}
}
