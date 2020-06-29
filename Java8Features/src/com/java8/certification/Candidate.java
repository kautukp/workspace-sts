/**
 * 
 */
package com.java8.certification;

/**
 * @author User
 *
 */
public class Candidate {

	private String name;

	private int age;

	/**
	 * 
	 */
	public Candidate(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", age=" + age + "]";
	}

}
