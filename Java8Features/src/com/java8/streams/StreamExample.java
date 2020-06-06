/**
 * 
 */
package com.java8.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class StreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println("ForkJoinPool parallelism level of this pool: " + commonPool.getParallelism());

		testIntSummaryStatistics();
		useOfStringOperations();
		fileOperations();
		streamIteration();

	}
	
	private static void streamIteration() {
		Stream<Integer> iterate = Stream.iterate(1, i -> i + 1);
		List<Integer> numbers = iterate.limit(5)
				.collect(Collectors.toList());
		numbers.remove(2); // removes the element indexed at 2, and shift subsequent element to left
		numbers.add(4); // appends the specified element at the end of list
		System.out.println("Numbers--> " + numbers);

	}

	// Read file and print longest string
	private static void fileOperations() {
		String filePath = "file/MyText.txt";
		BufferedReader fileReader;
		try {
			fileReader = new BufferedReader(new FileReader(new File(filePath)));
			String longestLine = fileReader.lines()
				.reduce((x, y) -> {
					if (x.length() > y.length())
						return x;
					return y;
				}).get();

			System.out.println("Longest String is: \n" + longestLine);

		} catch (IOException fileException) {
			fileException.getMessage();
		}
	}

	private static void useOfStringOperations() {
		Arrays.asList("Courier!", "I", "like", "java", "because", "is", "complex").stream()
				.filter(s -> s.toLowerCase().startsWith("c"))
				.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);

		List<String> checkEmpty = Arrays.asList("Harry", "", "Gary", "Tony", "", "is", "cool");
		Long count = checkEmpty.stream()
				.filter(x -> x.isEmpty())
				.count();
		System.out.println("There are " + count + " empty Strings in given String");

		List<String> testList = Arrays.asList("programming", "in", "java", "interview");
		String sentence = testList.stream()
				.map(String::toLowerCase)
				.collect(Collectors.joining(" "));
		System.out.println("Combined sentence: " + sentence);

		List<String> filteredList = createList().stream()
				.filter(str -> str.toLowerCase().startsWith("ja"))
				.collect(Collectors.toList());
		System.out.println("Names starting with 'Ja' are " + filteredList);

		String combinedNames = filteredList.stream()
				.collect(Collectors.joining(" "));
		System.out.println("Combined names are-> " + combinedNames);
	}

	private static void testIntSummaryStatistics() {
		List<Integer> numb = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = numb.stream()
				.mapToInt((x) -> x)
				.summaryStatistics();
		System.out.println("Minimum is: " + stats.getMin() + " & Maximum is: " + stats.getMax());

		int sumNumb1 = numb.stream()
				.mapToInt(n -> n)
				.sum();
		int sumNumb2 = numb.stream()
				.mapToInt(Integer::intValue)
				.sum();
		int sumNumb3 = numb.stream()
				.reduce(0, Integer::sum);
		System.out.println("sumNumb1-> " + sumNumb1 + " sumNumb2-> " + sumNumb2 + " sumNumb3-> " + sumNumb3);
	}

	private static List<String> createList() {
		return Arrays.asList("Oliver", "Jack", "Harry", "Jacob", "Charlie");
	}

}
