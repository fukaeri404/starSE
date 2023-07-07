package com.starse.prob8;

import java.util.Scanner;

public class GuessRandomNumberMain {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String again = "";
		int randomNum = (int) (Math.random() * 10);
		System.out.println(randomNum);
		do {
			boolean guess = false;
			while (!sc.hasNextInt()) {
				System.out.println("Invalid input. Please enter a number 0~9 : ");
				sc.next(); // Discard invalid input
			}
			int guessNum = sc.nextInt();
			if (randomNum == guessNum) {
				guess = true;
				System.out.println("Congratulation!");
			} else {
				guess = false;
				System.out.println("Sorry!Would you like to try again?(y/n)");
			}
			if (!guess) {
				String input = sc.next();
				while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
					System.out.println("Invalid input. Please enter 'y' or 'n' : ");
					input = sc.next(); // Discard invalid input
				}
				again = input;
			}
		} while (again.equalsIgnoreCase("y"));

	}

}
