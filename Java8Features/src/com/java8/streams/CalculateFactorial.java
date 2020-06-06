/**
 * 
 */
package com.java8.streams;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class CalculateFactorial {

	// Calculate Factorial for numbers > 20
	public static BigInteger factorial(BigInteger id) {
		BigInteger num = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE))
				.limit(id.longValue())
				.reduce(BigInteger.ONE, BigInteger::multiply);
		return num;
	}

	// Calculate Factorial for numbers < 20
	public static long factorialStreams(long n) {
		if (n > 20) {
			throw new IllegalArgumentException(n + " is out of range");
		} else {
			return LongStream.rangeClosed(1, n)
					.reduce(1, (long a, long b) -> a * b);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Factorial > 20 program: > " + factorial(new BigInteger("21")));
		System.out.println("Factorial < 20 program: > " + factorialStreams(21));
	}

}
