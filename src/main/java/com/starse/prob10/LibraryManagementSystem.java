package com.starse.prob10;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		LibraryManagementService service = LibraryManagementService.getInstance();
		service.initializeData();

		while (true) {
			service.displayInitialState();
			int inputChoice = service.getInputChoice();
			switch (inputChoice) {
			case 1 -> service.displayAllBooks();
			case 2 -> service.displayAllMembers();
			case 3 -> service.lendBook();
			case 4 -> service.returnBook();
			case 5 -> service.exit();
			default -> service.showErrorMessage();// you will never can reach this default because of validation
			}
		}

	}
}
