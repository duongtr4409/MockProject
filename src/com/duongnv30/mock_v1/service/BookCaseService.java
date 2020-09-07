package com.duongnv30.mock_v1.service;

import com.duongnv30.mock_v1.model.BookCase;
import com.duongnv30.mock_v1.model.User;

public interface BookCaseService {
	BookCase findOne(int id);
	BookCase insert(User user);
}
