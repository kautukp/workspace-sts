/**
 * 
 */
package com.project.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author USER
 *
 */
public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		findEmployeeNamesWithAgeGreaterThan20();

		countEmployeesWithAgeGreaterThan20();

		findEmployeeUsingInputString();

		sortEmployeesUsingAge();

		groupEmployeesByNames();

		joinEmployeeNames();

		groupEmployeeByAgeTreeSet();
		
		groupEmployeeByAgeUsingMap();

	}

	/**
	 * Group Employees based on their Age using TreeSet
	 */
	private static void groupEmployeeByAgeTreeSet() {
		Map<Integer, Collection<String>> ageList = createEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getAge, 
							Collectors.mapping(Employee::getName, 
									Collectors.toCollection(TreeSet::new))));
		ageList.forEach((age, name) -> System.out.println("Age: " + age + " =>" + name));
	}

	/**
	 * Group Employees based on their Age without TreeSet
	 */
	private static void groupEmployeeByAgeUsingMap() {
		Map<Integer, List<Employee>> map = createEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getAge));
		map.forEach((age, name) -> System.out.println("Age: " + age + " =>" + name));
	}

	/**
	 * Join the all employee names with “,”
	 */
	private static void joinEmployeeNames() {
		List<String> employeeNames = createEmployeeList().stream().map(Employee::getName).collect(Collectors.toList());
		String employeeNamesStr = String.join(",", employeeNames);
		System.out.println("Employees are: " + employeeNamesStr);

	}

	/**
	 * Given the list of employee, group them by employee name?
	 */
	private static void groupEmployeesByNames() {
		Map<String, List<Employee>> map = createEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getName));
		map.forEach((name, employeeListTemp) -> System.out.println("Name: " + name + " ==>" + employeeListTemp));
	}

	/**
	 * Given a list of employees, sort all the employee on the basis of age?
	 */
	private static void sortEmployeesUsingAge() {
		createEmployeeList().stream().map(e -> e.getAge()).sorted().forEach(System.out::println);
	}

	/**
	 * Given the list of employees, find the employee with name “Mary”.
	 */
	private static void findEmployeeUsingInputString() {
		List<Employee> empList = createEmployeeList();
		Optional<Employee> findEmp = empList.stream().filter(e -> e.getName().equalsIgnoreCase("Mary")).findAny();

		if (findEmp.isPresent()) {
			System.out.print(findEmp.get());
		}
	}

	/**
	 * Given the list of employees, count number of employees with age > 25?
	 */
	private static void countEmployeesWithAgeGreaterThan20() {
		List<Employee> empList = createEmployeeList();
		long countEmp = empList.stream().filter(e -> e.getAge() > 25).count();
		System.out.println("Number of employees with age > 25: " + countEmp);
	}

	/**
	 * Using the list of employees, you need to filter all the employee whose age is
	 * greater than 20 and print the employee names.
	 */
	private static void findEmployeeNamesWithAgeGreaterThan20() {
		List<String> employeeFilteredList = createEmployeeList().stream().filter(e -> e.getAge() > 20)
				.map(Employee::getName).collect(Collectors.toList());
		System.out.println("Employees whose age is greater than 20 are: " + employeeFilteredList);
		// employeeFilteredList.forEach((name)-> System.out.println(name));
	}

	public static List<Employee> createEmployeeList() {
		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee("Virat Kohli", 29));
		employeeList.add(new Employee("Sachin Tendulkar", 37));
		employeeList.add(new Employee("MS Dhoni", 37));
		employeeList.add(new Employee("Ravi Shastri", 19));
		employeeList.add(new Employee("Anushka", 29));
		employeeList.add(new Employee("Vijay Mallya", 49));

		return employeeList;
	}

}
