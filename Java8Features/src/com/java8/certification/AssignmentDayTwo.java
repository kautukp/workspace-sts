/**
 * 
 */
package com.java8.certification;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author User
 *
 */
public class AssignmentDayTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*******************************************************/
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		// Count the empty strings
		Long checkEmpty = strList.stream().filter(x -> x.isEmpty()).count();
		System.out.println("There are " + checkEmpty + " empty Strings in given String");

		// Count String with length more than 3
		Long strLen = strList.stream().filter(x -> x.length() > 3).count();
		System.out.println("String with length more than 3 are " + strLen);

		// Count number of String which startswith "a"
		Long strStartsWith = strList.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).count();
		System.out.println("String starting with 'a' are " + strStartsWith);

		// Remove all empty Strings from List
		List<String> emptyStrings = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.println("Non empty strings are: " + emptyStrings);

		// Create a List with String more than 2 characters
		List<String> moreThan2Chars = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.println("List with length more than 2 characters " + moreThan2Chars);

		// Convert String to Uppercase and join them using coma
		String sentence = strList.stream().filter(x -> !x.isEmpty()).map(String::toUpperCase)
				.collect(Collectors.joining(", "));
		System.out.println("Uppercase joined by comma: " + sentence);

		/*******************************************************/
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		// Create List of square of all distinct numbers
		List<Integer> squareList = numbers.stream().distinct().map(n -> n * n).collect(Collectors.toList());
		System.out.println("List of square of all distinct numbers> " + squareList);

		/*******************************************************/
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

		// Get count, min, max, sum, and average for numbers
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(stats.toString());

		/*******************************************************/
		List<Integer> intList1 = Arrays.asList(2, 5, 3, 2, 4, 3);

		// Remove the duplicates from an array and sort the unique items and print the
		// elements.
		Set<Integer> setWithoutDups = intList1.stream().sorted().collect(Collectors.toSet());
		setWithoutDups.forEach((i) -> System.out.println(i));

		/*******************************************************/
		List<Integer> intList2 = Arrays.asList(2, 4, 5, 6, 8);

		// Check if there is any multiple of 3?
		System.out.println("Any multiple of 3? : " + intList2.stream().anyMatch(num -> num % 3 == 0));

		// Check if all the elements are even?
		System.out.println("All the elements are even? : " + intList2.stream().allMatch(even -> even % 2 == 0));

		// Check if none of the elements are odd?
		System.out.println("None of the elements are odd? : " + intList2.stream().noneMatch(odd -> odd % 2 == 1));

		/*******************************************************/
		List<Integer> intList3 = Arrays.asList(1, 4, 6, 5, 4, 2, 1);

		// find the duplicate occurrence integers and minimum of that.
		Set<Integer> originalSet = new HashSet<>();
		int minVal = intList3.stream().filter(i -> !originalSet.add(i)).mapToInt(Integer::intValue).min().getAsInt();
		System.out.println("Minimum from list is-> " + minVal);

		/*******************************************************/
		List<String> strListNew = Arrays.asList("a", "f", "c", "d", "a", "b", "c");

		// find the duplicates in the string arraylist
		Set<String> duplicateSet = new HashSet<>();
		System.out.println(strListNew.stream().filter(i -> !duplicateSet.add(i)).map(String::toString)
				.collect(Collectors.toList()));

		/*******************************************************/
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		// count the occurrences of each element and print by using groupBy.
		// 3 apple, 2 banana, others 1
		Map<String, Long> itemsCountMap = items.stream()
				.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
		System.out.println(itemsCountMap);

		/*******************************************************/
	}

}
