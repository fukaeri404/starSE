package com.starse.prob10;

public class Book {
	private Integer bookId;
	private String title;
	private Integer lendFlag; // 1-already lent, 0-available to borrow

	public Book(Integer bookId, String title, Integer lendFlag) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.lendFlag = lendFlag;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLendFlag() {
		return lendFlag;
	}

	public void setLendFlag(Integer lendFlag) {
		this.lendFlag = lendFlag;
	}

}
