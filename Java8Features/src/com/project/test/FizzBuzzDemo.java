/**
 * 
 */
package com.project.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class FizzBuzzDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntStream.rangeClosed(1, 100)
			.mapToObj(num -> num % 3 == 0 ? (num % 5 == 0 ? "FizzBuzz" : "Fizz") : (num % 5 == 0 ? "Buzz" : num + " "))
			.forEach(System.out::println);

		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
		List<Integer> collect = infiniteStream.skip(3).limit(5).collect(Collectors.toList());
		System.out.println(collect);

		Stream<Integer> iterate = Stream.iterate(1, i -> i + 1);
		List<Integer> numbers = iterate.limit(10).collect(Collectors.toList());
		System.out.println(numbers);

		List<Integer> lst = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			lst.add(i);
		}
		System.out.print(lst);
		
		System.out.println();
		
		IntStream ins = IntStream.range(1, 6);
        ins.mapToObj(x -> text(x))
        .forEach(System.out::println);
	}

	private static Object text(int x) {
		return "Hello";
	}
	
	

}
