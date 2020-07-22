package ioenhancements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class FileReadDemo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		try(BufferedReader reader =
				new BufferedReader(
				new FileReader(
				new File("C:\\Sanjay Data Backup\\java\\Java8_29_June_2020\\PL\\src\\ioenhancements\\debug.log")));){
			
			
			Stream<String> stream = reader.lines();  //A Lines() method has been added on on the BufferedReader class
			stream.filter(line->line.contains("ERROR"))
			.findFirst()
			.ifPresent(System.out::println);
			
		}
				
	}

}
