package com.project.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StackOverFlowErrorTest {

	public static void main(String[] args) {
		//methodA();

		Stream<String> reducedStream = IntStream.range(0, 1000).mapToObj(TestStackError::new).reduce(Stream.of("Test"),
				(str, abc) -> abc.process(str), (a, b) -> {
					throw new IllegalStateException();
				});
		System.out.println(reducedStream.findFirst().get());
	}

/*	private static void methodA() {
		methodA();
		System.out.println("I am here");
	}*/
	
	private static class TestStackError { 
        public TestStackError(int id) {
        }

        public Stream<String> process(Stream<String> batch) {
            return batch.map(this::doNothing);
        }

        private String doNothing(String test) {
            return test;
        }
    }
}
