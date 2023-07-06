package com.starse.prob10;

import java.util.ArrayList;

public class Member {
	private Integer memberId;
	private String name;
	private ArrayList<Book> borrowedBooks;

	public Member(Integer memberId, String name, ArrayList<Book> borrowedBooks) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.borrowedBooks = borrowedBooks;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

}
