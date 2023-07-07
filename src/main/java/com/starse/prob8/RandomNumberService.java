package com.starse.prob8;

import java.util.Scanner;

public class RandomNumberService {

	private static RandomNumberService randomNumberService;
	private static Scanner sc = new Scanner(System.in);

	private RandomNumberService() {

	}

	public static RandomNumberService getInstance() {
		if (randomNumberService == null)
			randomNumberService = new RandomNumberService();
		return randomNumberService;
	}

	void guess() {
		boolean again;
		do {
			int randNum = generateRandomNumber();
			int guessNum = getUserinput();
			again = false;

			while (randNum != guessNum) {
				System.out.println("Wrong!Would you like to try again? (yes/no):");
				if (Validation.continueOrNot(sc))
					guessNum = getUserinput();
				else {
					System.out.println("You gave up. The correct number was " + randNum);
					System.out.println("Would you like to play another match? (yes/no):");
					again = Validation.continueOrNot(sc);
					break;
				}
			}
			
			if(randNum == guessNum) {
				System.out.println("!!!You guessed it right!!!");
				System.out.println("Would you like to play another match? (yes/no):");
				again = Validation.continueOrNot(sc);
			}
		} while (again);
		System.out.println("Exiting Guess Random Number.Good Bye!!");
	}

	int generateRandomNumber() {
		return (int) (Math.random() * 10);
	}

	int getUserinput() {
		System.out.println("Enter a number you think (0~9): ");
		return Validation.validate(sc, 0, 9);
	}
}
