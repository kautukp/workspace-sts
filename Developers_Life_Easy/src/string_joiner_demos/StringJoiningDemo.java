package string_joiner_demos;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJoiningDemo {

	public static void main(String[] args) {
		String s = Stream.of("a", "simple", "string")
	               .collect(Collectors.joining()); // "asimplestring"
		
		System.out.println(s);
		
		String s1 = Stream.of("a", "simple", "string")
	               .collect(Collectors.joining(" ")); // "a simple string"
		
		System.out.println(s1);
		
		
		String s2 = Stream.of("a", "simple", "string")
	               .collect(Collectors.joining(" ", "This is ", ".")); // "This is a simple string."
		
		System.out.println(s2);


	}

}
