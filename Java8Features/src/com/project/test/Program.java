/**
 * 
 */
package com.project.test;

import java.time.LocalDate;

/**
 * @author User
 *
 */
public class Program {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.ofYearDay(2015, 363);
		ld.plusWeeks(2);
		System.out.println(ld.isLeapYear());
		
		StringBuilder sb = new StringBuilder("abc");
		sb.append("-pqr");
		System.out.println(sb.length()+"");
		System.out.println(sb.capacity());
		
		int[] a1 = { 3, 2, 1, 0};
		int[] a2 = { 2, 4, 5 };
		
		int y = a1.length;
		int x = y - 1;
		
		/*while(y >= 0) {
			System.out.print(a1[--y]);
		}*/

		// System.out.println(a1==a2);
		// System.out.println(Arrays.equals(a1, a2));
		// System.out.println(Arrays.deepEquals(a1, a2));

		/*Integer[] a = new Integer[2];
		a[1] = 10;
		for (Integer b : a) {
			System.out.print(b);
		}*/
		
		System.out.println(true | (false ^ false));
		System.out.println(true | (false ^ true));
		System.out.println(true | false ^ true);
		System.out.println((true | false) ^ false);
		
		

	}

	public static int size(Object o) {
		return ((int[]) o).length;
	}

}
