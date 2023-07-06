package com.starse.prob10;

import java.util.Scanner;

public class LibraryManagementSystem {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		final LibraryManagementService service = LibraryManagementService.getInstance();
		final LibraryManagementView view = LibraryManagementView.getInstance();
		service.initializeData();
		boolean exit = false;
		do {
			view.initialDisplay();
			exit = service.mapp(sc);
		}while(exit);
	}
}
