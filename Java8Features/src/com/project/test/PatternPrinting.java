/**
 * 
 */
package com.project.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author USER
 *
 */
public class PatternPrinting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printPattern(1, 50);
		long l = calculateMod(5);
	}

	public static void printPattern(int rangeStart, int rangeEnd) {
		String strI = "I";
		String strLove = "Love";
		String strCapgemini = "Capgemini";
		List<Object> myList = IntStream.rangeClosed(rangeStart, rangeEnd)
			.mapToObj(num -> 
				(num % (2 * 3 * 5) == 0) ? strI.concat(strLove).concat(strCapgemini) :
				(num % (2 * 3) == 0) ? strI.concat(strLove) : 
				(num % 15 == 0) ? strLove.concat(strCapgemini) : 
				(num % 2 == 0) ? strI : 
				(num % 3 == 0) ? strLove : 
				(num % 5 == 0) ? strCapgemini : num)
			.collect(Collectors.toList());
		System.out.println(myList.toString());
	}
	
	public static long calculateMod(long num) {		
		return LongStream.rangeClosed( 1, num )
                .reduce(1, ( long a, long b ) -> a * b);		
	}
}
