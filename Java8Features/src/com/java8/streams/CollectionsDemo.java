/**
 * 
 */
package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class CollectionsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		/******************************************************/
		// joining/merging 2 lists
		ArrayList<String> firstList = new ArrayList<>(Arrays.asList("Mumbai", "Pune", "Thane"));
		ArrayList<String> secondList = new ArrayList<>(Arrays.asList("Delhi", "Bengaluru", "Kolkata"));
		firstList.addAll(secondList);
		System.out.println("Combining 2 lists-> " + firstList);

		/******************************************************/
		// Convert ArrayList to Arrays
		List<String> myArrayList = Arrays.asList("one", "two", "three");
		Object[] myArray = myArrayList.toArray();
		System.out.println("Convert ArrayList to Array-> " + Arrays.toString(myArray));

		// Convert Array to ArrayList
		String[] myString = { "Hello", "World", "Program" };
		ArrayList<String> myArrList = new ArrayList<>();
		Collections.addAll(myArrList, myString);
		System.out.println("Convert Array to ArrayList-> " + myArrList);

		/******************************************************/
		// Convert HashMap to ArrayList
		HashMap<Integer, String> studentMap = new HashMap<>();
		studentMap.put(1, "Apple");
		studentMap.put(2, "Banana");
		studentMap.put(2, "Mango");

		// Getting Collection of values from HashMap
		Collection<String> values = studentMap.values();

		// Creating an ArrayList of values
		ArrayList<String> myStudentList = new ArrayList<>(values);
		System.out.println("Convert HashMap to ArrayList-> " + myStudentList);

		/******************************************************/
		// remove duplicate characters in given string
		String statement = "Welcome to Java Session Java Session Session Java";
		statement = statement.toLowerCase();
		String[] words = statement.split(" ");
		// Outer loop for Comparison
		for (int i = 0; i < words.length; i++) {
			if (words[i] != null) {
				// Inner loop for Comparison
				for (int j = i + 1; j < words.length; j++) {
					// Checking for both strings are equal
					if (words[i].equals(words[j])) {
						words[j] = null; // Delete the duplicate words
					}
				}
			}
		}
		// Displaying the String without duplicate words
		System.out.println("Displaying the String without duplicate words: ");
		for (int k = 0; k < words.length; k++) {
			if (words[k] != null) {
				System.out.print(" " + words[k]);
			}
		}

		// Bubble sort program
		int arr[] = { 1, 3, 8, 9, 7, 4, 5 };
		int arrLen = arr.length;
		int temp = 0;

		for (int i = 0; i < arrLen; i++) {
			for (int j = 1; j < (arrLen - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.print(arr[i] + " ");
		}

		// Number sorting in Java8
		Stream<Integer> intStream = Stream.of(1, 8, 9, 7, 1, 6, 6);
		intStream.sorted(Comparator.reverseOrder()).forEach(System.out::println); // Descending

		// String sorting
		Stream<String> wordStream = Stream.of("A", "C", "E", "B", "D");
		wordStream.sorted(Comparator.reverseOrder()).forEach(System.out::println); // Descending
	}
}
