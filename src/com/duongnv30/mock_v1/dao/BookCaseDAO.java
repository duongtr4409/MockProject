package com.duongnv30.mock_v1.dao;

import com.duongnv30.mock_v1.model.BookCase;
import com.duongnv30.mock_v1.model.User;

public interface BookCaseDAO extends GenericDAO<BookCase>{
	BookCase findOne(int id);
	Integer insert(User user);
}
