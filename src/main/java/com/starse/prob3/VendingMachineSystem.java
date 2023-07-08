package com.starse.prob3;

import java.util.Scanner;

public class VendingMachineSystem {
	private final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		VendingMachineService service = VendingMachineService.getInstance();
		service.initializeData();
		while (true) {
			service.displayInitialState();
			double inputCash = service.getInputCash(sc);
			int availList = service.displayAvailList(inputCash);
			if(availList > 0) {
				int userWanted = service.getUserwanted(sc);
				boolean isEnough = service.isEnough(userWanted);
				if (isEnough)
					System.out.println("Thank you!");
				else
					System.out.println("Your input amount was not enough!");
			}
			System.out.println("XXXXXXXXXXXX");
		}
	}
}
