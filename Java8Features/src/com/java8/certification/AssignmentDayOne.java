/**
 * 
 */
package com.java8.certification;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author User
 *
 */
public class AssignmentDayOne {

	@FunctionalInterface
	interface NoArgumentInterface {
		void printMsg();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Given a number n returns a boolean indicating if it is odd.
		Predicate<Integer> isOddPredicate = input -> input % 2 == 1;
		System.out.println(isOddPredicate.test(3));

		// Given a character c returns a boolean indicating if it is equal to ‘y’.
		Predicate<Character> isEqualPredicate = ch -> ch == 'y';
		System.out.println(isEqualPredicate.test('y'));

		// Given two numbers x and y returns another number with their summation.
		BiFunction<Integer, Integer, Integer> summation = (a, b) -> a + b;
		System.out.println(summation.apply(4, 5));

		// Given two integers a and b returns another integer with the sum of their squares.
		BiFunction<Integer, Integer, Integer> squareSum = (a, b) -> ((a * a) + (b * b));
		System.out.println(squareSum.apply(2, 3));

		// Given no parameters returns the integer 42.
		Supplier<Integer> supplierInt = () -> 42;
		System.out.println(supplierInt.get());

		// Given no parameters returns the double 3.14.
		Supplier<Double> supplierDbl = () -> 3.14;
		System.out.println(supplierDbl.get());

		// Given a string s prints the string to the main output and returns void.
		Consumer<String> strS = str -> System.out.println(str);
		strS.accept("Java 8");

		// Give no parameters prints Hello World! to the main output and returns void.
		NoArgumentInterface noArgumentInterface = () -> {
			System.out.println("Hello World!");
		};
		noArgumentInterface.printMsg();
		
	}
}
