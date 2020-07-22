package ioenhancements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReadDemo2 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		// Java 7 : try with resources and use of paths
		Path path = Paths.get("C:\\Sanjay Data Backup\\java\\Java8_29_June_2020\\PL\\src\\ioenhancements\\debug.log");
		try(Stream<String> stream = Files.lines(path)){ // directly opening streams
			
					
			stream.filter(line->line.contains("ERROR"))
			.findFirst()
			.ifPresent(System.out::println);
			
		}//Stream implements AutoCloseable and will close the underlying file
				
	}

}
