/**
 * 
 */
package com.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author USER
 *
 */
public class MyArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> mylist = myTestList();

		List<String> myNewList = new ArrayList<>();
		myNewList.add("KP");
		myNewList.add("DP");

		mylist.forEach(System.out::println);
		myNewList.forEach(System.out::println);
	}
	
	private static List<String> myTestList() {
		List<String> mylist = new ArrayList<>();
		mylist.add("KP");
		mylist.add("DP");
		
		return mylist;

	}

}
