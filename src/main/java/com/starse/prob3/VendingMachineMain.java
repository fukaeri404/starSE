package com.starse.prob3;

import java.util.Scanner;

final public class VendingMachineMain {
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			final UiImpl uiImpl = new UiImpl();
			uiImpl.showInitialState();
			// validate if input is number
			Validation.validate(sc);
			// show avail items based on user's cash
			uiImpl.showAvailList(sc.nextInt());
			// validate if input is number
			Validation.validate(sc);
			// check if the user input avail number
			while (!uiImpl.canPurchase(sc.nextInt()))
				Validation.validate(sc);
			System.out.println();
		}
	}
}
