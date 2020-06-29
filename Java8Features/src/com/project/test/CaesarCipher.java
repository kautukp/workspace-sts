/**
 * 
 */
package com.project.test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class CaesarCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(caesarEncrypt("Please encrypt me", 4));
		System.out.println(carsarDecrypt("Tpiewi irgvctx qi", 4));

	}

	private static String caesarEncrypt(String message, int offset) {
		StringBuilder result = new StringBuilder();
		for (char character : message.toCharArray()) {
			if (character != ' ') {
				int originalAlphabetPosition = character - 'a';
				int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
				char newCharacter = (char) ('a' + newAlphabetPosition);
				result.append(newCharacter);
			} else {
				result.append(character);
			}
		}
		return result.toString();
	}
	
	private static String carsarDecrypt(String message, int offset) {
		StringBuilder result = new StringBuilder();
		for (char character : message.toCharArray()) {
			if (character != ' ') {
				int originalAlphabetPosition = character - 'a';
				int newAlphabetPosition = (originalAlphabetPosition - offset) % 26;
				char newCharacter = (char) ('a' + newAlphabetPosition);
				result.append(newCharacter);
			} else {
				result.append(character);
			}
		}
		return result.toString();
	}
	
	/*private static String caesarEncryptJava8(String message, int offset) {
		
		String output = Stream.of(message)
				.map(string -> string.toCharArray())				
				.collect(Collectors.joining(" "));
		reverseString(output, input.split(" "));
		
		
	}*/

}
