/**
 * 
 */
package com.java8.streams;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class PrintEvenOddNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printEvenOddUsingParallelStream(1, 10);
		
		/*Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false));
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true));
        t1.start();
        t2.start();*/
	}

	private static void printEvenOddUsingParallelStream(int rangeStart, int rangeEnd) {
		Stream<Integer> numberList = Stream.iterate(rangeStart, i -> i + 1);
		ConcurrentMap<Integer, List<Integer>> concurrentEvenOddMap = numberList.parallel()
				.limit(rangeEnd)
				.collect(Collectors.groupingByConcurrent(i -> i % 2 == 0 ? 0 : 1));
		concurrentEvenOddMap.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
		
		Stream<Integer> numberList1 = Stream.iterate(rangeStart, i -> i + 1);
	    ConcurrentMap<Object, Set<Integer>> concurrentEvenOddMap1 = numberList1.parallel()
	    		.limit(rangeEnd)
	            .collect(Collectors.groupingByConcurrent(i -> i % 2 == 0 ? 0 : 1,  Collectors.toCollection(TreeSet::new)));
	    concurrentEvenOddMap1.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
	}

	static class TaskEvenOdd implements Runnable {

		private int max;
		private Printer print;
		private boolean isEvenNumber;

		TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
			this.print = print;
			this.max = max;
			this.isEvenNumber = isEvenNumber;
		}

		@Override
		public void run() {

			// System.out.println("Run method");
			int number = isEvenNumber == true ? 2 : 1;
			while (number <= max) {

				if (isEvenNumber) {
					// System.out.println("Even :"+ Thread.currentThread().getName());
					print.printEven(number);
					// number+=2;
				} else {
					// System.out.println("Odd :"+ Thread.currentThread().getName());
					print.printOdd(number);
					// number+=2;
				}
				number += 2;
			}
		}
	}

	static class Printer {

		boolean isOdd = false;

		synchronized void printEven(int number) {
			while (isOdd == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Even:" + number);
			isOdd = false;
			notifyAll();
		}

		synchronized void printOdd(int number) {
			while (isOdd == true) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Odd:" + number);
			isOdd = true;
			notifyAll();
		}
	}

}
