/**
 * 
 */
package com.java8.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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
		
		printLongestStringFromFile();
		squareNumbersAndSort();
		removeDuplicateFromList();

		int test = Arrays.stream(new int[] { 1, 2, 3 }).filter(i -> i >= 2).map(i -> i * 3).sum();
		System.out.println("test>" + test);
		
		String et1 = new String();
		String et2 = new String();
		
		System.out.println(et1 == et2);
		System.out.println(et1.equals(et2));
		
		printMe();
		
	}
	
	public static void printMe(int...i) {
		System.out.println("int");
	}
	
	public static void printMe(double...d) {
		System.out.println("double");
	}
	
	public static void printMe(float...f) {
		System.out.println("float");
	}

	private static void removeDuplicateFromList() {
		Integer[] arr = new Integer[] { 100, 24, 13, 44, 114, 44, 40, 112 };
		List<Integer> listWithDuplicates = Arrays.asList(arr);
		Set<Integer> setWithoutDups = listWithDuplicates.stream()
				.collect(Collectors.toSet());
		setWithoutDups.forEach((i) -> System.out.print(" " + i));
	}

	private static void squareNumbersAndSort() {
		/**
		 * Write a method which takes {"-6","-3","-1","2","3","6"} as an input and 
		 * calculates the square of every number and then return the sorted list of integers.
		 */
		List<String> strList = Arrays.asList("-3", "-4", "-2", "5", "8", "9");
		List<Integer> intList = strList.stream()				
				.map(Integer::parseInt)
				.map(n -> n*n)
				.sorted()
				.collect(Collectors.toList());
       System.out.println("Squares: "+intList);
	}

	private static void printLongestStringFromFile() {
		// Read file and print longest string
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

}
