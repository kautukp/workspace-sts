/**
 * 
 */
package com.project.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author USER
 *
 */
public class Print3DigitNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(21, 1, 100, 100, 5, 8, 101, 102, 201, 8, 73, 203);

		Map<Integer, Integer> greaterThanMap = intList.stream().filter(n -> n >= 100)
				.collect(Collectors.toConcurrentMap(num -> num, num -> 1, Integer::sum));
		greaterThanMap.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
		
		System.out.println("====Without Java 8=====");

		int c = 0;
		List<Integer> myList = new ArrayList<Integer>();
		for (Integer integer : intList) {
			if (integer > 99) {
				c++;
			} else {
				if (c > 0) {
					myList.add(c);
					c = 0;
				}
				myList.add(integer);
			}
		}
		if (c > 0) {
			myList.add(c);
		}
		System.out.println(myList);
	}

}
