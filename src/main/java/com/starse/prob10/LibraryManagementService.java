package com.starse.prob10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryManagementService {
	private static LibraryManagementService libraryManagementService;
	static final Scanner sc = new Scanner(System.in);
	final ArrayList<Book> bookList = new ArrayList<>();
	final ArrayList<Member> memberList = new ArrayList<>();
	final Map<Integer, Integer> BookMember = new HashMap<>();

	private LibraryManagementService() {

	}

	void initializeData() {
		Member member1 = new Member(1, "John", new ArrayList<>());
		Member member2 = new Member(2, "Mike", new ArrayList<>());

		memberList.add(member1);
		memberList.add(member2);

		Book book1 = new Book(1, "The Lord of the Rings", 0);
		Book book2 = new Book(2, "The Hobbit", 0);
		Book book3 = new Book(3, "Harry Potter and Philosopher's Stone", 0);
		Book book4 = new Book(4, "Harry Potter and the Chamber of Secrets", 0);

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
	}

	void displayInitialState() {
		System.out.println("Welcome to the library management system. Please choose an option:");
		System.out.println("1. Display all books");
		System.out.println("2. Display all members");
		System.out.println("3. Lend a book");
		System.out.println("4. Return a book");
		System.out.println("5. Exit");
	}

	void displayAllBooks() {
		for (Book book : bookList) {
			System.out.print(book.getBookId() + ". " + book.getTitle() + " is currently ");
			if (book.getLendFlag() == 0)
				System.out.print("'AVAILABLE'");
			else
				System.out.print("'NOT AVAILABLE'");
			System.out.println();
		}
	}

	void displayAllMembers() {
		for (Member member : memberList) {
			StringBuffer buffer = new StringBuffer("");
			buffer.append(member.getMemberId() + ". " + member.getName() + "    ");
			if (member.getBorrowedBooks() != null && member.getBorrowedBooks().size() > 0) {
				for (Book book : member.getBorrowedBooks()) {
					buffer.append(book.getTitle() + " ,");
				}
			}
			buffer.delete(buffer.length() - 2, buffer.length());
			System.out.println(buffer);
		}
	}

	void lendBook() {
		while (true) {
			int inputBookId = getInputBookId();
			if (isAvailable(inputBookId)) {
				int inputMemberId = getInputMemberId();
				processLending(inputBookId, inputMemberId);
				break;
			} else
				System.out.println("Your choice is already lent!");
		}

	}

	private void processLending(int inputBookId, int inputMemberId) {
		Book book = bookList.get(inputBookId - 1);
		Member member = memberList.get(inputMemberId - 1);
		book.setLendFlag(1);
		member.getBorrowedBooks().add(book);
		BookMember.put(inputBookId, inputMemberId);
		System.out.println("Thank you!You borrowed " + book.getTitle());
	}

	void returnBook() {
		outer:
		while (true) {
			int inputBookId = getInputBookId();
			if (isLent(inputBookId)) {
				while (true) {
					int inputMemberId = getInputMemberId();
					if (isCorrectMemberCorrectBook(inputBookId, inputMemberId)) {
						processReturning(inputBookId, inputMemberId);
						break outer;
					} else
						System.out.println("Sorry!This member doesn't seem to be the one who borrowed it");
				}
			} else
				System.out.println("This book is currently available to borrow which means nobody borrow it yet!");
		}
	}

	boolean isCorrectMemberCorrectBook(int inputBookId, int inputMemberId) {
		for (Map.Entry<Integer, Integer> entry : BookMember.entrySet()) {
			if (inputBookId == entry.getKey() && inputMemberId == entry.getValue()) {
				return true;
			}
		}
		return false;
	}

	private void processReturning(int inputBookId, int inputMemberId) {
		Book book = bookList.get(inputBookId - 1);
		Member member = memberList.get(inputMemberId - 1);
		book.setLendFlag(0);
		member.getBorrowedBooks().remove(book);
		BookMember.remove(inputBookId, inputMemberId);
		System.out.println("Your borrowed book '" + book.getTitle() + "' is returned successfully!");
	}

	boolean isAvailable(int inputBookId) {
		return (bookList.get(inputBookId - 1).getLendFlag() == 0) ? true : false;
	}

	boolean isLent(int inputBookId) {
		return (bookList.get(inputBookId - 1).getLendFlag() == 1) ? true : false;
	}

	void showErrorMessage() {
		System.out.println("You will never see this error message");
	}

	void exit() {
		System.out.println("Exiting Library Management System....GoodBye!");
		System.exit(0);
	}

	int getInputChoice() {
		System.out.print("Enter your choice :");
		return Validation.validate(sc, 1, 5, "choice");
	}

	int getInputBookId() {
		System.out.print("Plese enter book ID :");
		return Validation.validate(sc, 1, bookList.size(), "book");
	}

	int getInputMemberId() {
		System.out.print("Plese enter member ID :");
		return Validation.validate(sc, 1, memberList.size(), "member");
	}

	public static LibraryManagementService getInstance() {
		if (libraryManagementService == null)
			libraryManagementService = new LibraryManagementService();
		return libraryManagementService;
	}
}
