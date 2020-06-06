/**
 * 
 */
package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = "Java 8 Reverse";

		/*********** Without Java 8 **************/
		System.out.println("Original String-> " + input);
		String s1[] = input.split(" ");
		String s2 = input.replace(" ", "");

		StringBuilder input2 = new StringBuilder();
		input2.append(s2);
		input2 = input2.reverse();

		int startIndx = 0;
		int splLen = 0;
		StringBuilder rB = new StringBuilder();
		for (String spl : s1) {
			splLen = spl.length();
			String r = input2.substring(startIndx, startIndx + splLen);
			rB.append(r).append(" ");
			startIndx += splLen;
		}
		System.out.println("Reverse String-> " + rB);
		/*********** Without Java 8 **************/

		/*********** With Java 8 **************/

		System.out.println("\nInput String> " + input);

		String output = Stream.of(input).map(word -> new StringBuilder(word.replaceAll(" ", "")).reverse())
				.collect(Collectors.joining(" "));
		reverseString(output, input.split(" "));
		/*********** Without Java 8 **************/
	}

	public static void reverseString(String input, String[] size) {
		String output = "";
		for (int i = 0; i < size.length; i++) {
			output = output + " " + input.substring(0, size[i].length());
			input = input.substring(size[i].length());
		}
		System.out.println("Output String> " + output.substring(1));
	}

	private static void getWordsLength(String input) {
		String[] words = input.split(" ");
		List<String> myList = new ArrayList<>();

		for (String word : words) {
			myList.add(word);
			System.out.println("Characters in " + word + "> " + word.length());
		}
		System.out.println("\nmyList> " + myList);
	}
}
