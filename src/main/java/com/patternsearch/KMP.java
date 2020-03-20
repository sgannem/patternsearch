package com.patternsearch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * knuth, Morris, Pratt algorithm to find matching string
 */
public class KMP {

	static int[] lps = null;

	public static boolean findString(String pattern, String filePath) {
		buildLps(pattern);
		boolean foundFlag = false;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
			Scanner scanner = new Scanner(fis);
			int i = 0;
			while (scanner.hasNext()) {
				int result = pmatch(scanner.next(), pattern);
				i++;
				if (result > -1) {
					foundFlag = true;
					System.out.println("# Got the pattern on line no:" + i + ", at location:" + result);
				}
			}
			if (!foundFlag)
				System.out.println("# Sorry No match found, please try again with different pattern");
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return foundFlag;
	}

	static int pmatch(String value, String pattern) {
		/* knuth, Morris, Pratt string matching algorithm **/
		int i = 0, j = 0;
		int lens = value.length();
		int lenp = pattern.length();
		while (i < lens && j < lenp) {
			if (value.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else if (j == 0)
				i++;
			else
				j = lps[j - 1] + 1;
		}
		return ((j == lenp) ? (i - lenp) : -1);
	}

	public static void buildLps(String pattern) {
		/* compute the pattern's buildLps function */

		int n = pattern.length();
		lps = new int[n];
		lps[0] = -1;
		for (int j = 1; j < n; j++) {
			int i = lps[j - 1];
			while ((pattern.charAt(j) != pattern.charAt(i + 1)) && (i >= 0)) {
				i = lps[i];
				if (pattern.charAt(j) == pattern.charAt(i + 1))
					lps[j] = i + 1;
				else
					lps[j] = -1;
			}
		}
		System.out.println("Built Lps=" + Arrays.toString(lps));
	}
}
