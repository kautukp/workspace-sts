/**
 * 
 */
package com.java8.streams;

import java.util.stream.IntStream;

/**
 * @author USER
 *
 */
public class CheckPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(checkPalindromeUsingJava8("madam"));
		System.out.println(checkPalindromeUsingJava8("apple"));
		System.out.println(checkPalindromeUsingStringBuilder("radar"));
		System.out.println(checkPalindromeUsingStringBuilder("hello"));
		System.out.println(checkPalindromeUsingForLoop("radar"));
		System.out.println(checkPalindromeUsingForLoop("hello"));
	}

	private static boolean checkPalindromeUsingForLoop(String givenString) {
		String palindromeString = "";
		int i;
		for (i = givenString.length() - 1; i >= 0; i--) {
			palindromeString = palindromeString + givenString.charAt(i);
		}
		return givenString.equalsIgnoreCase(palindromeString);
	}

	private static boolean checkPalindromeUsingStringBuilder(String givenString) {
		String palindromeString = new StringBuilder(givenString).reverse().toString();
		return givenString.equalsIgnoreCase(palindromeString);
	}

	private static boolean checkPalindromeUsingJava8(String givenString) {
		String palindromeString = givenString.replaceAll("\\s+", "");
		return IntStream.range(0, palindromeString.length() / 2)
				.noneMatch(n -> palindromeString.charAt(n) != palindromeString.charAt(givenString.length() - n - 1));
	}

}
