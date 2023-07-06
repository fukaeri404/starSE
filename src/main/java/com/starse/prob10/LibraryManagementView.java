package com.starse.prob10;

public class LibraryManagementView {
	private static LibraryManagementView libraryManagementView;
	
	private LibraryManagementView() {
		
	}
	
	public static LibraryManagementView getInstance() {
		if(libraryManagementView == null)
			libraryManagementView = new LibraryManagementView();
		return libraryManagementView;
	}
	
	void initialDisplay() {
		System.out.println("Welcome to the library Management system. Please choose an option");
		System.out.println("1. Display All Books");
		System.out.println("2. Display All Members");
		System.out.println("3. Lend Book");
		System.out.println("4. Return Book");
		System.out.println("5. Exit");
	}
}
