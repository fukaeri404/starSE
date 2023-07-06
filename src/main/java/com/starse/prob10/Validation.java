package com.starse.prob10;

import java.util.Scanner;

public class Validation {
	static int validate(Scanner sc, int start, int end, String type) {
		int userInput;
		do {
			while (!sc.hasNextInt()) {
				System.out.print("Please enter a number (integer) :");
				sc.next();
			}
			userInput = sc.nextInt();
			if (userInput < start || userInput > end) {
				if (!type.equalsIgnoreCase("choice"))
					System.out.println(
							"Doesn't exist. Please enter correct " + type + " ID (" + start + "~" + end + ") :");
				else
					System.out.println("Doesn't exist. Please enter a number (" + start + "~" + end + ") :");
			}
		} while (userInput < start || userInput > end);
		return userInput;
	}
}
