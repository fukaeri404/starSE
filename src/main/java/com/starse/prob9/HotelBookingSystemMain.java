package com.starse.prob9;

import java.util.Scanner;

public class HotelBookingSystemMain {
	final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelBookingService service = HotelBookingService.getInstance();
		service.initializeRooms();
		boolean cont = true;
		do {
			service.displayOptions();
			int userinput = Validation.validate(sc, 1, 5);
			switch (userinput) {
			case 1 -> service.bookRoom(sc);
			case 2 -> service.cancelBooking(sc);
			case 3 -> service.displayBooking();
			case 4 -> cont = service.exit();
			default -> service.showErrorMessage();
			}
			System.out.println();
		} while (cont);
	}

}
