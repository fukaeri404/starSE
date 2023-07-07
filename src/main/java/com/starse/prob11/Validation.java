package com.starse.prob11;

import java.util.Scanner;

public class Validation {
	static double validate(Scanner sc) {
		double userInput;
			while (!sc.hasNextDouble()) {
				sc.next();
				System.out.print("Invalid input. Please enter a number :");
			}
			userInput = sc.nextDouble();
		return userInput;
	}
}
