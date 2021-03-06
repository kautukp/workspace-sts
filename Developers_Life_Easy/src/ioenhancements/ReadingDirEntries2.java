package ioenhancements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadingDirEntries2 {

	public static void main(String[] args) throws IOException {
		// Java 7 : try with resources and use of paths
		
		Path path = Paths.get("c:","windows");
		
		try(Stream<Path> stream = Files.walk(path,2)){ // one can limit the depth of exploration
			stream.filter(mypath -> mypath.toFile().isDirectory())
			.forEach(System.out::println);
		}

	}

}
