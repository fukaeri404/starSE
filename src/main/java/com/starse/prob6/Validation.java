package com.starse.prob6;

import java.util.Scanner;

public class Validation {
	static void validate(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input. Please enter a number  : ");
			sc.next(); // Discard invalid input
		}
	}
	
	static void validateDouble(Scanner sc) {
		while (!sc.hasNextDouble()) {
			System.out.println("Invalid input. Please enter a number with fraction (eg. 12.00)  : ");
			sc.next(); // Discard invalid input
		}
	}

	static boolean validateRange(int id) {
		boolean valid = (id < 1 || id > 5) ? false : true;
		if(valid) UI.getInstance().displayParticularExpense(id);
		else
			System.out.println("Invalid input. Please enter a number 1~5 : ");
		return valid;
	}
}
