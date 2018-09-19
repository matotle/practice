package problems;

import java.util.Scanner;

import util.AccessorInterface;
import util.UtilMethods;

/**
 * @author Michael Totleben
 * @description This is my solution for Project Euler Question 1 'If we list all
 *              the natural numbers below 10 that are multiples of 3 or 5, we
 *              get 3, 5, 6 and 9. The sum of these multiples is 23. Find the
 *              sum of all the multiples of 3 or 5 below 1000.' default answer
 *              should be: 233168
 */
public class P01MutlipeOf3n5 implements AccessorInterface {
	public static void main(String[] args) {
		P01MutlipeOf3n5 p = new P01MutlipeOf3n5();
		System.out.println("The sum of all mulitples of 3 and 5 from begining to max");
		if (UtilMethods.useCustomInputConsole()) {
			p.runCustomConsole();
		} else {
			p.runBase();
		}
	}

	/**
	 * 
	 * @param begining
	 * @param max
	 * @return int of the sum of all mulitples of 3 and 5 from begining to max
	 */
	public int multipleOf3n5ToMax(int begining, int max) {
		int sum = 0;

		for (int i = begining; i < max; i++) {
			// use modulus to check to see if a number is a multiple of 3 or 5
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}

		return sum;
	}

	public void runBase() {
		System.out.println("base input 0, 1000");
		System.out.println(multipleOf3n5ToMax(0, 1000));
	}

	public void runCustomConsole() {
		int begin;
		int max;
		System.out.println("Enter begining number:");
		Scanner keyboard = new Scanner(System.in);
		try {
			begin = keyboard.nextInt();
			System.out.println("Enter max number:");
			max = keyboard.nextInt();
			System.out.println(multipleOf3n5ToMax(begin, max));

			// not really interested in doing complex error handinling since its not the
			// point of this excerise.
		} catch (Exception e) {
			System.out.println("Bad data entered, rerunning");
			runCustomConsole();
		} finally {
			keyboard.close();
		}
	}

	public void runCustomWeb() {
		// todo for web
	}

}
