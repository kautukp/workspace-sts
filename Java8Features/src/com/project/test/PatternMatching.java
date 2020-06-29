/**
 * 
 */
package com.project.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author USER
 *
 */
public class PatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ad8*!!sadf**7sdf@@!!9*%$#asdf6";
		System.out.println(calculateSumOfDigitsInString(str));
	}

	private static int calculateSumOfDigitsInString(String input) {
		Pattern pattern = Pattern.compile("[\\d]");
		Matcher matcher = pattern.matcher(input);
		int sum = 0;
		while (matcher.find()) {
			sum += Integer.parseInt(matcher.group());
		}
		return sum;
	}

}
