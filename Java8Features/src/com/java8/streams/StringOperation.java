/**
 * 
 */
package com.java8.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author USER
 *
 */
public class StringOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringJoiner sj = new StringJoiner(" ");
		sj.add("My").add("Name").add("is").add("Kautuk");
		System.out.println(sj.toString());

		// printLongestStringFromFile();
		// squareNumbersAndSort();
		// removeDuplicateFromList();
		findFirstNonRepChar("aaebbccd");

		System.out.println(true & true);
		System.out.println(true && false);

		printMe();

		System.out.println(removeDuplicateCharactersInString("Java + is + good"));

		Optional<Character> opCh = findNonRepeatedCharsInString("SASAS");
		if (opCh.isPresent()) {
			System.out.println("Non repeated character is :" + opCh.toString());
		}else {
			System.out.println("No non repeated character found in String");
		}

	}

	public static void printMe(int... i) {
		System.out.println("int");
	}

	public static void printMe(double... d) {
		System.out.println("double");
	}

	public static void printMe(float... f) {
		System.out.println("float");
	}

	/**
	 * Method to remove duplicate characters from String
	 * 
	 * @param myStr
	 * @return
	 */
	private static String removeDuplicateCharactersInString(String myStr) {
		String newStr = Arrays.asList(myStr.split("")).stream().map(String::toLowerCase).distinct()
				.collect(Collectors.joining());
		return newStr;
	}

	/**
	 * Method to find distinct characters in String
	 * 
	 * @param input
	 * @return
	 */
	private static Optional<Character> findNonRepeatedCharsInString(String input) {
		Map<Character, Integer> countCharacters = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < input.length() - 1; i++) {
			Character c = input.charAt(i);
			if (!countCharacters.containsKey(c)) {
				countCharacters.put(c, 1);
			} else {
				countCharacters.put(c, countCharacters.get(c) + 1);
			}
		}
		// As LinkedHashMap maintains insertion order, first character with
		// count 1 should return first non repeated character
		for (Entry<Character, Integer> e : countCharacters.entrySet()) {
			if (e.getValue() == 1)
				return Optional.of(e.getKey());

		}
		return Optional.ofNullable(null);
	}

	/**
	 * Method to remove duplicate numbers from List
	 */
	private static void removeDuplicateFromList() {
		Integer[] arr = new Integer[] { 100, 24, 13, 44, 114, 44, 40, 112 };
		List<Integer> listWithDuplicates = Arrays.asList(arr);
		Set<Integer> setWithoutDups = listWithDuplicates.stream().collect(Collectors.toSet());
		setWithoutDups.forEach((i) -> System.out.print(" " + i));
	}

	/**
	 * Write a method which takes {"-6","-3","-1","2","3","6"} as an input and
	 * calculates the square of every number and then return the sorted list of
	 * integers.
	 */
	private static void squareNumbersAndSort() {
		List<String> strList = Arrays.asList("-3", "-4", "-2", "5", "8", "9");
		List<Integer> intList = strList.stream().map(Integer::parseInt).map(n -> n * n).sorted()
				.collect(Collectors.toList());
		System.out.println("Squares: " + intList);
	}

	/**
	 * Read file and print longest string
	 */
	private static void printLongestStringFromFile() {
		String filePath = "file/MyText.txt";
		BufferedReader fileReader;
		String longestLine;
		try {
			fileReader = new BufferedReader(new FileReader(new File(filePath)));
			longestLine = fileReader.lines().reduce((x, y) -> {
				if (x.length() > y.length())
					return x;
				return y;
			}).get();

			System.out.println("Longest String is: \n" + longestLine);

		} catch (IOException fileException) {
			fileException.getMessage();
		}
	}

	public static char findFirstNonRepChar(String string) {
		Map<Integer, Long> characters = string.chars().boxed()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		return (char) (int) characters.entrySet().stream().filter(e -> e.getValue() == 1L).findFirst()
				.map(Map.Entry::getKey).orElseThrow(() -> new RuntimeException("No unrepeated character"));
	}

}
