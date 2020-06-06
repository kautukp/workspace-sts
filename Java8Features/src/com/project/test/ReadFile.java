/**
 * 
 */
package com.project.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author USER
 *
 */
public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "file/Cards.json";
		BufferedReader fileReader;
		List<String> list = new ArrayList<>();
		try {
			fileReader = new BufferedReader(new FileReader(new File(filePath)));
			fileReader.lines().forEach(System.out::println);
			list = fileReader.lines().collect(Collectors.toList());
		} catch (IOException fileException) {
			fileException.getMessage();
		}
		list.forEach(System.out::println);
	}
	
	

}
