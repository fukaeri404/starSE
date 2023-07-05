package com.starse.prob9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelBookingService {

	private static HotelBookingService hotelBookingService;
	final static Map<Integer, Boolean> rooms = new HashMap<>();

	private HotelBookingService() {

	}

	public static HotelBookingService getInstance() {
		if (hotelBookingService == null)
			hotelBookingService = new HotelBookingService();
		return hotelBookingService;
	}

	Map<Integer, Boolean> initializeRooms() {
		for (int i = 1; i <= 10; i++) {
			rooms.put(i, true); // (true : not booked, false : booked)
		}
		return rooms;
	}

	void bookRoom(Scanner sc) {
		System.out.print("Please enter the room number you want to book (1~10) : ");
		if (isFound(sc, "book"))
			System.out.println("Booking successful!Thank you for choosing our hotel.");
		else
			System.out.println("This room is already booked, please choose another room.");
	}

	void cancelBooking(Scanner sc) {
		System.out.print("Please enter the room number you want to cancel (1~10) : ");
		if (isFound(sc, "cancel"))
			System.out.println("Booking is cancelled successfully!");
		else
			System.out.println("This room is not booked, please enter a valid room number.");
	}

	void displayOptions() {
		System.out.printf("Welcome to the Hotel Booking System!%n" + "1. Book a room%n" + "2. Cancel booking%n"
				+ "3. Display bookings%n" + "4. Exit%n" + "Enter your choice : ");

	}

	void displayBooking() {
		for (Map.Entry<Integer, Boolean> entry : rooms.entrySet()) {
			if (entry.getValue() == false) 
				System.out.println("Room "+entry.getKey()+" : Booked");
		}
	}

	boolean exit() {
		System.out.println("Exiting Hotel Booking System. Goodbye!");
		return false;
	}

	void showErrorMessage() {
		System.out.println("Invalid choice. Please try again!");
	}
	
	boolean isFound(Scanner sc, String status) {
		int roomId = Validation.validate(sc, 1, 10);
		boolean found = false;
		
		boolean booked = false;
		if(status.equalsIgnoreCase("cancel")) 
			booked = false;
		else
			booked = true;
		
		for (Map.Entry<Integer, Boolean> entry : rooms.entrySet()) {
			if (entry.getKey() == roomId && entry.getValue() == booked) {
				entry.setValue(!booked);
				found = true;
				break;
			}
		}
		
		
		return found;
	}
}
