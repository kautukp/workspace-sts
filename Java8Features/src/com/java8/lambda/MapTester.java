/**
 * 
 */
package com.java8.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author USER
 *
 */
public class MapTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, String> myMap = new HashMap<>();
		fillData(myMap);

		myMap.forEach((k, v) -> System.out.printf("%s %s%n", k, v));

		myMap.put(500, "Customer");
		myMap.put(600, "NewPerson");
		myMap.remove(300);

		myMap.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
	}

	private static void fillData(Map<Integer, String> map) {
		map.put(100, "John");
		map.put(200, "Brett");
		map.put(300, "Client");
		map.put(400, "Hello");
	}

}
