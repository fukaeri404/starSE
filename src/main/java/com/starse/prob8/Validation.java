package com.starse.prob8;

import java.util.Scanner;

public class Validation {
	static int validate(Scanner sc, int start, int end) {
		int userInput;
		do {
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.print("Invalid input. Please enter a number (" + start + "~" + end + ") :");
			}
			userInput = sc.nextInt();
			if (userInput < start || userInput > end)
				System.out.print("Invalid range. Make sure you enter a number between(" + start + "~" + end + ") :");
		} while (userInput < start || userInput > end);
		return userInput;
	}

	static boolean continueOrNot(Scanner sc) {
		boolean cont = false;
		do {
			String userInput = sc.next();
			if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")) {
				cont = true;
				break;
			} else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("n")) {
				cont = false;
				break;
			} else
				System.out.print("Invalid input. Please enter 'yes' or 'no' :");
		} while (true);
		return cont;
	}
}
