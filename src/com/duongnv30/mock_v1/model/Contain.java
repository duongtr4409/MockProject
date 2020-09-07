package com.duongnv30.mock_v1.model;

import java.util.Date;

public class Contain {
	private int bookCaseID;
	private int bookID;
	private Date createDate;

	public Contain(int bookCaseID, int bookID, Date createDate) {
		super();
		this.bookCaseID = bookCaseID;
		this.bookID = bookID;
		this.createDate = createDate;
	}

	public Contain(int bookCaseID, int bookID) {
		super();
		this.bookCaseID = bookCaseID;
		this.bookID = bookID;
	}

	public Contain() {
		super();
	}

	public int getBookCaseID() {
		return bookCaseID;
	}

	public void setBookCaseID(int bookCaseID) {
		this.bookCaseID = bookCaseID;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Contain [bookCaseID=" + bookCaseID + ", bookID=" + bookID + ", createDate=" + createDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookCaseID;
		result = prime * result + bookID;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contain other = (Contain) obj;
		if (bookCaseID != other.bookCaseID)
			return false;
		if (bookID != other.bookID)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		return true;
	}

}
