/**
 * 
 */
package com.java8.lambda;

/**
 * @author USER
 *
 */
public class ThreadDemo implements Runnable {

	@Override
	public void run() {
		System.out.println("Running..");

	}

	/**
	 * @param args
	 */
	int i[] = { 0 };

	public static void main(String[] args) {
		int i[] = { 1 };
		change_i(i);
		System.out.println(i[0]);

		String str;
		int fname;
		str = "Foolish boy.";
		fname = str.indexOf("Fo");
		System.out.println(fname);
	}

	public static void change_i(int i[]) {
		int j[] = { 2 };
		i = j;
	}

}
