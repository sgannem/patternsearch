package com.test.patternsearch;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.patternsearch.KMP;

// Test class for KMP.java file
public class KMPTest {

	@Before()
	public void runBeforeTestMethod() {
		new KMP();
	}

	@Rule
	public ExpectedException thrown;

	// happyflow
	@Test
	public void test() {
		assertEquals(true, KMP.findString("key", "src/test/resources/com/test/patternsearch/Test.txt"));
	}

	// String not matched
	@Test
	public void testLPS() {
		assertEquals(false, KMP.findString("KeyKey", "src/test/resources/com/test/patternsearch/Test.txt"));
	}

	// String not matched
	@Test
	public void testStringnotFound() {
		assertEquals(false, KMP.findString("aaaa", "src/test/resources/com/test/patternsearch/Test.txt"));
	}

	// Exception flow
	@Test
	public void testFileNotFound() {
		try {
			KMP.findString("aaaa", "Test.txt");
		} catch (Exception e) {
			assertEquals(false, e instanceof FileNotFoundException);
		}
	}

}
