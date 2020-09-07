package com.duongnv30.mock_v1.service;

import com.duongnv30.mock_v1.model.Contain;

public interface ContainService {
	Integer insert(Contain contain);
	Integer removeByBookCaseID(int bookCaseID);
	Integer removeByBookCaseIDBookID(int bookCaseID, int bookID);
}
