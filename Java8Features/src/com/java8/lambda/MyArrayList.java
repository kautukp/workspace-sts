/**
 * 
 */
package com.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author USER
 *
 */
public class MyArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr = { 0, 0, 0 };
		increment(arr);
		System.out.println("======");

		int[][] twoDMat = { { 1, 2 }, { 3, 4 } };
		int[][] threeDMat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		printMatrix(threeDMat);
		transposeMatrixNonJava8(threeDMat);
		System.out.println("======");
		printMatrix(threeDMat);
		
	}

	/**
	 * method to increment array [000] .... [999]
	 * 
	 * @param input
	 */
	private static void increment(Integer[] input) {
		List<Integer> ListInput = Arrays.asList(input);
		int startPoint = Integer.parseInt(ListInput.stream()
				.map(String::valueOf)
				.collect(Collectors.joining()));

		IntStream.rangeClosed(startPoint, 100)
			.mapToObj(n -> String.format("%03d", n))
			.map(String::toCharArray)
			.forEach(e -> System.out.println("{" + e[0] + e[1] + e[2] + "}"));
	}

	private static int[][] transposeMatrixJava8(int[][] matrix) {
	    int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transpose = new int[columns][rows];
        
        return IntStream.range(0, columns)
                .mapToObj(i -> Stream.of(matrix)
                		.mapToInt(row -> row[i]).toArray())
                .toArray(int[][]::new);
    
		/*return IntStream.rangeClosed(0, rows)
				.mapToObj(i -> Stream.of(matrix)
						.mapToInt(row -> row[i]).toArray())
				.forEach(e -> {transpose[c][r] = matrix[r][c]})
				.toArray(int[][]::new);*/
	}
	
	/**
	 * Function for do transpose of matrix
	 * 
	 * @param matrix
	 */
	private static void transposeMatrixNonJava8(int matrix[][]) {
		int N = matrix.length;
		// Traverse each cycle
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {

				// Swap elements of each cycle
				// in clockwise direction
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N - 1 - j][i];
				matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
				matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
				matrix[j][N - 1 - i] = temp;
			}
		}
	}

	/**
	 * Function for print matrix
	 * 
	 * @param arr
	 */
	private static void printMatrix(int arr[][]) {
		
		for(int[] row : arr) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
	}

}
