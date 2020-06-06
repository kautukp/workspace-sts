/**
 * 
 */
package com.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class PrintFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fibonacci(15);
	}
	
	private static void fibonacci(int series) {
		List<Integer> fiboList= Stream.iterate(new int[] { 0, 1 }, t -> new int[] {t[1], t[0] + t[1] })
				.limit(series)
				.map(num -> num[0])
				.collect(Collectors.toList());
		System.out.println(fiboList);
	}

}
