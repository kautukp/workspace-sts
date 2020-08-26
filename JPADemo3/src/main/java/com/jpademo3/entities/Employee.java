/**
 * 
 */
package com.jpademo3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author User
 *
 */
@Entity
@Table(name = "EMPLOYEE")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {

	@Id
	@Column(name = "EMP_ID")
	private Long empID;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_CITY")
	private String city;

	@Column(name = "EMP_SALARY")
	private Double salary;

	@OneToOne
	private Department department;

	/**
	 * 
	 */
	public Employee() {
		super();
	}

	/**
	 * @param empID
	 * @param empName
	 * @param city
	 * @param salary
	 * @param department
	 */
	public Employee(Long empID, String empName, String city, Double salary, Department department) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
		this.department = department;
	}

	/**
	 * @return the empID
	 */
	public Long getEmpID() {
		return empID;
	}

	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(Long empID) {
		this.empID = empID;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", city=" + city + ", salary=" + salary
				+ ", department=" + department + "]";
	}

}
