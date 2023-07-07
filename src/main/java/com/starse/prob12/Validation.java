package com.starse.prob12;

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
			if(type.equalsIgnoreCase("initial")) {
				if (userInput < start || userInput > end) {
					System.out.println("Doesn't exist. Please enter a number (" + start + "~" + end + ") :");
				}
			}else {
				if (userInput < start || userInput > end) {
					System.out.println("Doesn't exist. Please enter correct student ID :");
				}
			}
		} while (userInput < start || userInput > end);
		return userInput;
	}
}
