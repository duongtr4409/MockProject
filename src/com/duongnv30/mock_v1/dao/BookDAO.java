package com.duongnv30.mock_v1.dao;

import java.util.List;

import com.duongnv30.mock_v1.model.Book;

public interface BookDAO extends GenericDAO<Book>{
	List<Book> findAll();
	Book findByID(int id);
	List<Book> findByName(String name);
	List<Book> findByAuthor(String author);
	List<Book> findByCategory(String category);
	List<Book> findBookOfBookCase(int bookCaseID);
	Integer deleteByID(int bookID);
	Integer updateBookByID(int bookID, String content);
	Integer insert(Book book);
}
