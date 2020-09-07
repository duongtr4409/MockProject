package com.duongnv30.mock_v1.service;

import java.util.List;

import com.duongnv30.mock_v1.model.Book;

public interface BookService {
	List<Book> findAll();
	Book findByID(int id);
	List<Book> findByName(String name);
	List<Book> findByAuthor(String author);
	List<Book> findByCategory(String category);
	Integer deleteByID(int bookID);
	Integer updateBookByID(int bookID, String content);
	Integer insert(Book book);
}
