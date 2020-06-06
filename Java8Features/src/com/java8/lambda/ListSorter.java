/**
 * 
 */
package com.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author USER
 *
 */
public class ListSorter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> list1 = createList();
		list1.sort(null);
		list1.forEach(System.out::println);

		List<String> list2 = createList();
		list2.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		list2.forEach(System.out::println);

		List<String> list3 = createList();
		list3.sort(String::compareToIgnoreCase);
		list3.forEach(System.out::println);

		// Using Collections to sort
		List<String> list4 = createList();
		Collections.sort(list4);
		list4.forEach(System.out::println);
		
		List<String> list5 = createList();
		list5.stream()
        .sorted()        
        .forEach(System.out::println);
		
	}

	private static List<String> createList() {
		return Arrays.asList("Mark", "Brett", "John");
	}

}
