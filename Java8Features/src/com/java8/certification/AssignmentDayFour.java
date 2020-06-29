/**
 * 
 */
package com.java8.certification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author User
 *
 */
public class AssignmentDayFour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Question 1
		System.out.println("No of char 'e' in file are: " + countCharacterOccurenceInFile("file/Test.txt"));

		// Question 2
		fileListingAndCopying("H:\\Eclipse\\workspace_sts\\Java8Features\\src\\com\\java8\\");

		// Question 3 & 4
		testMapOperations();

		// Question 5
		List<Person> person = Arrays.asList(new Person("Bernard", "Sawrey"), new Person("Duncan", "Sawrey"),
				new Person("Anastasia", "Sawrey"), new Person("Charlotte", "Sawrey"), new Person("Daphne", "Sawrey"),
				new Person("Gerald", "Hawkshead"), new Person("Eustace", "Hawkshead"),
				new Person("Felicity", "Coniston"));

		// Question 5
		testPersonMapOperations(person);

	}

	/**
	 * a) Start with List<Person> people which is defined above. Make a map with key
	 * = first name, value = last name. b) Make a map with key = first name in lower
	 * case, value = last name in upper case. c) Join all the first names to form a
	 * comma separated string. d) Make a list of first names in alphabetical order.
	 * e) Make a list of the first three names in alphabetical order when sorted by
	 * last name then first name. f) Create a map with key = last name and value = a
	 * list of people with that last name.
	 * 
	 * @param person
	 */
	private static void testPersonMapOperations(List<Person> person) {
		Map<String, String> personMap = new HashMap<>();
		person.forEach(p -> personMap.putIfAbsent(p.getFirstName(), p.getLastName()));
		System.out.println("5.a-> " + personMap);

		person.forEach(p -> personMap.put(p.getFirstName().toLowerCase(), p.getLastName().toUpperCase()));
		System.out.println("5.b-> " + personMap);

		String strFirstName = person.stream().map(Person::getFirstName).collect(Collectors.joining(", "));
		System.out.println("5.c-> " + strFirstName);

		List<String> firstNameList = person.stream().map(Person::getFirstName).sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		System.out.println("5.d-> " + firstNameList);

		List<Person> firstThreeNamesList = person.stream()
				.sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName)).limit(3)
				.collect(Collectors.toList());
		System.out.println("5.e-> " + firstThreeNamesList);

		Map<String, List<Person>> lastNameMap = person.stream().collect(Collectors.groupingBy(Person::getLastName));
		System.out.println("5.f-> " + lastNameMap);
	}

	/**
	 * Check if key with 103 is there or not. If not then add “Noida” value to it.
	 * Check if the key with 102 is already present then contact it will “raj”
	 */
	private static void testMapOperations() {
		Map<Integer, String> cityMap = new HashMap<>();
		cityMap.put(101, "Varanasi");
		cityMap.put(102, "Prayag");
		cityMap.putIfAbsent(103, "Noida");
		System.out.println(cityMap);

		cityMap.computeIfPresent(102, (k, v) -> v.concat("raj"));

		System.out.println(cityMap);
	}

	/**
	 * List all the .java files present in a folder and write to another folder.
	 * 
	 * @param directoryPath
	 */
	private static void fileListingAndCopying(String directoryPath) {
		String destination = "H:\\Eclipse\\Nordea_Repo\\interview\\";
		try {
			Files.walk(Paths.get(directoryPath)).filter(path -> path.toString().endsWith(".java")).forEach(file -> {
				try {
					Files.copy(file, Paths.get(destination.concat(file.getFileName().toString())),
							StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write an example that counts the number of times a particular character, such
	 * as 'e', appears in a file. Create a sample file in your system and do the
	 * above operation.
	 * 
	 * @param fileName
	 * @return long charCount
	 */
	private static long countCharacterOccurenceInFile(String fileName) {
		long charCount = 0;
		try {
			charCount = Files.lines(Paths.get(fileName)).flatMapToInt(CharSequence::chars).filter(c -> c == 'e')
					.count();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return charCount;
	}
}
