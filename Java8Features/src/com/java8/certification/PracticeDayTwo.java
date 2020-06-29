/**
 * 
 */
package com.java8.certification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author User
 *
 */
public class PracticeDayTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//streamIteration();
		//streamOperations();
		//streamAndPredicate();
		//streamFlatMap();
		//streamReduceTest();
		streamFileOperations();
	}

	private static void streamIteration() {
		Stream.iterate(2, n -> n * n)
			.limit(5)
			.skip(2)
			.forEach(System.out::println);
	}

	private static void streamOperations() {
		List<String> inputList = Arrays.asList("one", "two", "three");
		List<String> outputList = new ArrayList<>();

		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = outputList::add;

		outputList.forEach(c2.andThen(c1));
	}

	private static void streamAndPredicate() {
		List<String> inputList = Arrays.asList("one", "two", "three");
		Predicate<String> p1 = p -> p.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");

		inputList.stream()
			.filter(p1.and(p2).or(p3))
			.forEach(System.out::print);
	}
	
	private static void streamFlatMap() {
		List<String> listOne = Arrays.asList("one", "two", "three");
		List<String> listTwo = Arrays.asList("four", "five", "six");
		List<String> listThree = Arrays.asList("twelve", "hundred");

		Predicate<String> p1 = p -> p.length() > 3;
		Predicate<String> p2 = p -> p.startsWith("t");

		List<List<String>> finalList = Arrays.asList(listOne, listTwo, listThree);
		System.out.println("Before-> "+finalList);
		
		List<String> flatList = finalList.stream()
			.flatMap(list -> list.stream())
			.filter(p1.and(p2))
			.collect(
					Collectors.toList()
					);
		
		System.out.println("After-> "+flatList);
	}
	
	private static void streamReduceTest() {
		Stream<Integer> inputStream = Stream.empty();
		
		Optional<Integer> output = inputStream.reduce((n1, n2) -> n1+n2);
		if(output.isPresent()) {
			System.out.println(output.get());
		}else {
			System.out.println("Empty");
		}
	}
	
	private static void streamFileOperations() {
			String filePath = "file/Candidate.txt";
			List<Candidate> candidate = new ArrayList<>();
			BufferedReader fileReader;
			
			try {
				fileReader = new BufferedReader(new FileReader(new File(filePath)));
				Stream<String> streamCandidate = fileReader.lines();
				
				streamCandidate.map(line -> {
						String[] str = line.split(" ");
						Candidate myCandidate = new Candidate(str[0].trim(), Integer.parseInt(str[1]));
						candidate.add(myCandidate);
						return candidate;						
						}).collect(
								Collectors.toList()
								);
			} catch (IOException fileException) {
				fileException.getMessage();
			}
			
			List<String> getCandidateAge = candidate.stream()
					.filter(c -> c.getAge() > 35)
					.map(Candidate::getName)
					.collect(Collectors.toList());
			
			System.out.println("Candidate Age > 35 -> "+getCandidateAge);
			
			
			Map<Integer, String> candidateMap = candidate.stream()
					.collect(
							Collectors.groupingBy(
									Candidate::getAge, Collectors.mapping(
											Candidate::getName, Collectors.joining(", ")
											))
							);
			candidateMap.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
		}

}
