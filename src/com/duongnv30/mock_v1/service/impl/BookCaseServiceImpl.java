package com.duongnv30.mock_v1.service.impl;

import com.duongnv30.mock_v1.dao.BookCaseDAO;
import com.duongnv30.mock_v1.dao.impl.BookCaseDAOImpl;
import com.duongnv30.mock_v1.model.BookCase;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.service.BookCaseService;

public class BookCaseServiceImpl implements BookCaseService {

	private static BookCaseServiceImpl bookCaseServiceImpl;
	private static BookCaseDAO bookCaseDAOImpl;

	public BookCaseServiceImpl() {
		bookCaseDAOImpl = new BookCaseDAOImpl();
	}

	public static BookCaseServiceImpl getInstance() {
		if (bookCaseServiceImpl == null) {
			bookCaseServiceImpl = new BookCaseServiceImpl();
		}
		return bookCaseServiceImpl;
	}

	@Override
	public BookCase findOne(int id) {
		BookCase bookCase = bookCaseDAOImpl.findOne(id);
		return bookCase;
	}

	@Override
	public BookCase insert(User user) {
		Integer id = bookCaseDAOImpl.insert(user);
		if(id == null) return null;
		return findOne(id);
	}

}
