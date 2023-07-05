package com.starse.prob9;

import java.util.Scanner;

public class Validation {
	static int validate(Scanner sc, int start, int end) {
		int userInput;
		do {
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.print("Invalid input. Please enter a number ("+start+"~"+end+") :");
			}
			userInput = sc.nextInt();
		} while (userInput < start || userInput > end);
		return userInput;
	}
}
