package com.duongnv30.mock_v1.service.impl;

import java.util.List;

import com.duongnv30.mock_v1.dao.impl.BookDAOImpl;
import com.duongnv30.mock_v1.model.Book;
import com.duongnv30.mock_v1.service.BookService;

public class BookServiceImpl implements BookService {

	private static BookServiceImpl bookServiceImpl;
	private static BookDAOImpl bookDAOImpl;

	public BookServiceImpl() {
		bookDAOImpl = BookDAOImpl.getInstance();
	}

	public static BookServiceImpl getInstance() {
		if (bookServiceImpl == null) {
			bookServiceImpl = new BookServiceImpl();
		}
		return bookServiceImpl;
	}

	@Override
	public List<Book> findAll() {
		List<Book> listBook = bookDAOImpl.findAll();
		return listBook;
	}

	@Override
	public Book findByID(int id) {
		Book book = bookDAOImpl.findByID(id);
		return book;
	}

	@Override
	public List<Book> findByName(String name) {
		List<Book> listBook = bookDAOImpl.findByName(name);
		return listBook;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> listBook = bookDAOImpl.findByAuthor(author);
		return listBook;
	}

	@Override
	public List<Book> findByCategory(String category) {
		List<Book> listBook = bookDAOImpl.findByCategory(category);
		return listBook;
	}

	@Override
	public Integer deleteByID(int bookID) {
		return bookDAOImpl.deleteByID(bookID);
	}

	@Override
	public Integer updateBookByID(int bookID, String content) {
		return bookDAOImpl.updateBookByID(bookID, content);
	}

	@Override
	public Integer insert(Book book) {
		return bookDAOImpl.insert(book);
	}
}
