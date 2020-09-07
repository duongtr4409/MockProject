package com.duongnv30.mock_v1.model;

import java.util.ArrayList;
import java.util.List;

public class BookCase {
	private int id;
	private String bookCaseName;
	List<Book> listBook = new ArrayList<>();

	public BookCase(int id, String bookCaseName, List<Book> listBook) {
		super();
		this.id = id;
		this.bookCaseName = bookCaseName;
		this.listBook = listBook;
	}

	public BookCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookCaseName() {
		return bookCaseName;
	}

	public void setBookCaseName(String bookCaseName) {
		this.bookCaseName = bookCaseName;
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}

	@Override
	public String toString() {
		return "BookCase [id=" + id + ", bookCaseName=" + bookCaseName + ", listBook=" + listBook + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCaseName == null) ? 0 : bookCaseName.hashCode());
		result = prime * result + id;
		result = prime * result + ((listBook == null) ? 0 : listBook.hashCode());
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
		BookCase other = (BookCase) obj;
		if (bookCaseName == null) {
			if (other.bookCaseName != null)
				return false;
		} else if (!bookCaseName.equals(other.bookCaseName))
			return false;
		if (id != other.id)
			return false;
		if (listBook == null) {
			if (other.listBook != null)
				return false;
		} else if (!listBook.equals(other.listBook))
			return false;
		return true;
	}

}
