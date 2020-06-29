/**
 * 
 */
package com.project.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
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
		
		//findEmployeeNamesWithAgeGreaterThan20();

		//countEmployeesWithAgeGreaterThan20();

		//findEmployeeUsingInputString();

		//sortEmployeesUsingAge();

		groupEmployeesByNames();

		//joinEmployeeNames();

		//groupEmployeeByAgeTreeSet();
		
		//groupEmployeeByAgeUsingMap();
		
		//groupByDeptAndEmpIDOfHighestSalary();

	}

	/**
	 * Group Employees based on their Age using TreeSet
	 */
	private static void groupEmployeeByAgeTreeSet() {
		Map<Integer, Collection<String>> ageList = createEmployeeListNew().stream()
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
		Optional<Employee> findEmp = empList.stream().filter(e -> e.getName().equalsIgnoreCase("Virat")).findAny();

		if (findEmp.isPresent()) {
			System.out.print(findEmp.get());
		} else {
			findEmp.orElse(null);
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
	
	/**
	 * Using the list of employees, 
	 * Group by dept and employeeId of the highest salaried employee.
	 */
	private static void groupByDeptAndEmpIDOfHighestSalary() {
		Comparator<Employee> highestSalary = Comparator.comparing(Employee::getSalary);
		Map<String, Optional<Employee>> empDeptList = createEmployeeListNew().stream()
				                              .collect(Collectors.groupingBy(Employee::getDept,
				                            		  Collectors.reducing(BinaryOperator.maxBy(highestSalary))));
		empDeptList.forEach((name,salary)->System.out.println("Dept: "+name+" \nHighest Salaried Employee: "+ salary.get().getName() + " : " +salary.get().getSalary()));
	}

	public static List<Employee> createEmployeeList() {
		List<Employee> employeeCricketList = new ArrayList<>();
		
		employeeCricketList.add(new Employee("Virat Kohli", 19, 333, "Cricket",15000L));
		employeeCricketList.add(new Employee("Sachin Tendulkar", 37, 100, "Cricket",25000L));
		employeeCricketList.add(new Employee("MS Dhoni", 37, 777, "Keeper",15000L));
		employeeCricketList.add(new Employee("Ravi Shastri", 49, 111, "Coach",15000L));
		
		return employeeCricketList;
		
	}
	
	//Employee(String name, int age, int id, String dept, long salary)
	public static List<Employee> createEmployeeListNew() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Rajan Anand", 22, 111, "Engineering", 1600000));
		employeeList.add(new Employee("Swati Patil", 23, 222, "Testing", 800000));
		employeeList.add(new Employee("Vijay Chawda", 23, 334, "Engineering", 1600000));
		employeeList.add(new Employee("Basant Mahapatra", 29, 444, "Engineering", 600000));
		employeeList.add(new Employee("Ajay Patel", 32, 555, "Testing", 350000));
		employeeList.add(new Employee("Swaraj Birla", 32, 111, "Testing", 1350000));

		return employeeList;
	}

}
