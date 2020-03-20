package com.patternsearch;

/**
 * Takes arguments and calls KMP.java
 */
public class FindPatternInFile {

	private static String helpString = "FindPatternInFile\n"
			+ "This sample demonstrates to find pattern string from a given file .\n" + "\n" + "Options\n"
			+ "\t--pattern <pattern-name>\n" + "\t--file <file-name>\n";

	public static void main(String[] args) {
		if (args.length % 2 != 0) {
			help();
			return;
		}

		String pattern = null;
		String file = null;

		for (int i = 0; i < args.length; i += 2) {
			String arg = args[i];
			String value = args[i + 1];
			switch (arg) {
			case "--pattern":
				pattern = value;
				break;
			case "--file":
				file = value;
				break;
			}
		}
		if (file == null || pattern == null) {
			help();
			return;
		} else {
			// Find string match if pattern and file is passed.
			KMP.findString(pattern, file);
		}
	}

	public static void help() {
		System.out.println(helpString);
	}
}
