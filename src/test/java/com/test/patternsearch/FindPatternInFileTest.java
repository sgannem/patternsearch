package com.test.patternsearch;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.patternsearch.FindPatternInFile;

public class FindPatternInFileTest {

	// happy flow
	@Test
	public void test() {
		FindPatternInFile.main(new String[] { "--pattern", "key", "--file",
				"src/test/resources/com/test/patternsearch/Test.txt" });
	}

	// Error flow
	@Test
	public void testError() {
		FindPatternInFile.main(new String[] { "--pattern", "key", "--file" });
	}

	// Error flow
	@Test
	public void testException() {
		try {
			FindPatternInFile.main(new String[] { "--pattern", "key", "--file" });
		} catch (Exception e) {
			assertEquals(false, e instanceof FileNotFoundException);
		}
	}

}
