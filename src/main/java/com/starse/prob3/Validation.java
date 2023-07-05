package com.starse.prob3;

import java.util.Scanner;

public class Validation {
	static void validate(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input. Please enter a number: ");
			sc.next(); // Discard invalid input
		}
	}
}
