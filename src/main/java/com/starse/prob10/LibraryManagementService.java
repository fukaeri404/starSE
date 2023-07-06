package com.starse.prob10;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementService {

	private static LibraryManagementService libraryManagementService;
	final static ArrayList<Member> memberList = new ArrayList<>();
	final static ArrayList<Book> bookList = new ArrayList<>();

	private LibraryManagementService() {

	}

	public static LibraryManagementService getInstance() {
		if (libraryManagementService == null)
			libraryManagementService = new LibraryManagementService();
		return libraryManagementService;
	}

	void initializeData() {
		Member member1 = new Member(1, "John", new ArrayList<Book>());
		Member member2 = new Member(2, "Mike", new ArrayList<Book>());

		memberList.add(member1);
		memberList.add(member2);

		Book book1 = new Book(1, "The Lord of the Rings", 0);
		Book book2 = new Book(2, "The Hobbit", 0);
		Book book3 = new Book(3, "Harry Potter and Philosopher's Stone", 0);
		Book book4 = new Book(4, "Harry Potter and Chamber of Secrets", 0);
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
	}

	void displayAllBooks() {
		for (Book book : bookList) {
			System.out.print(book.getBookId() + ". " + book.getTitle());
			if (book.getLendFlag() == 1)
				System.out.print(" (lent) ");
			else
				System.out.print(" (available) ");
		}
		System.out.println();
	}

	void displayAllMembers() {
		for (Member member : memberList) {
			System.out.print(member.getMemberId() + ". " + member.getName() + " recently borrowed ");
			if (member.getBorrowedBooks().size() > 0) {
				for (Book book : member.getBorrowedBooks()) {
					System.out.print(book.getBookId() + ":" + book.getTitle() + " ||");
				}
			} else
				System.out.print("nothing yet!");
			System.out.println();
		}
		System.out.println();
	}

	void lendBook(Scanner sc) {
		do {
			System.out.print("Please enter book ID to borrow: ");
			int bookId = Validation.validate(sc, 1, bookList.size(), "book");
			Book book = bookList.get(bookId - 1);
			if (book.getLendFlag() == 1) {
				System.out.println("Your choice is already lent!");
			} else {
				System.out.println("Enter member Id:");
				int memberId = Validation.validate(sc, 1, memberList.size(), "member");
				Member member = memberList.get(memberId - 1);
				removeInsert(book, member, "insert");
				break;
			}
		} while (true);
		System.out.println("<3<3<3Thank you<3<3<3");
	}

	void returnBook(Scanner sc) {
		outer: do {
			System.out.print("Please enter book ID to return: ");
			int bookId = Validation.validate(sc, 1, bookList.size(), "book");
			Book book = bookList.get(bookId - 1);
			if (book.getLendFlag() == 1) {
				System.out.println("Enter member Id:");
				int memberId = Validation.validate(sc, 1, memberList.size(), "member");
				Member member = memberList.get(memberId - 1);
				if (member.getBorrowedBooks().size() > 0) {
					for (Book borrowedBook : member.getBorrowedBooks()) {
						if (book.getBookId() == borrowedBook.getBookId()) {
							removeInsert(book, member, "remove");
							break outer;
						} else
							System.out.println("Sorry! This member didn't borrow this book!");
					}
				} else
					System.out.println("Sorry! This member has't borrowed any books yet!");
			} else
				System.out.println("You can't return this book since it is not borrowed by anyone yet!!");
		} while (true);
		System.out.println("!!!Returned the book successfully!!!");
	}

	void showErrorMessage() {
	}

	void removeInsert(Book book, Member member, String status) {
		if (status.equalsIgnoreCase("insert")) {
			book.setLendFlag(1);
			member.getBorrowedBooks().add(book);
		} else {
			book.setLendFlag(0);
			member.getBorrowedBooks().remove(book);
		}
	}

	boolean mapp(Scanner sc) {
		boolean cont = true;
		System.out.print("Enter your choice : ");
		int userInput = Validation.validate(sc, 1, 5, "choice");
		switch (userInput) {
		case 1 -> this.displayAllBooks();
		case 2 -> this.displayAllMembers();
		case 3 -> this.lendBook(sc);
		case 4 -> this.returnBook(sc);
		case 5 -> cont = false;
		default -> this.showErrorMessage();
		}
		return cont;
	}
}
