/**
 * 
 */
package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author USER
 *
 */
public class OptionalDemo {

	public  void streamOperation(String valueToTest) {
		List<String> list = Arrays.asList("my", "name", "is", "nancy");
		Optional<String> resultData = list
				.stream()
				.filter(str -> str.startsWith(valueToTest))
				.findFirst();

		boolean val = resultData.isPresent();
		if (val) {
			System.out.println("First Occurence-> "+resultData.get());
		} else {
			System.out.println("Fail");
		}
	}
}
