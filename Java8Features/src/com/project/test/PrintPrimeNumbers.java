/**
 * 
 */
package com.project.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author USER
 *
 */
public class PrintPrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generatePrimeNumberListByStream(1, 25);
	}

	private static void generatePrimeNumberListByStream(int rangeStart, int rangeEnd) {
		List<Integer> primeNumbers = IntStream.range(rangeStart, rangeEnd)
				.filter(num -> IntStream.range(2, num).noneMatch(divider -> num % divider == 0))
				.boxed()
				.collect(Collectors.toList());
		primeNumbers.forEach(n -> System.out.print(" " + n));
	}
}
