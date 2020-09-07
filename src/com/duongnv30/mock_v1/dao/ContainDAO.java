package com.duongnv30.mock_v1.dao;

import com.duongnv30.mock_v1.model.Contain;

public interface ContainDAO extends GenericDAO<Contain>{
	Integer insert(Contain contain);
	Integer removeByBookCaseID(int bookCaseID);
	Integer removeByBookCaeIDBookID(int bookCaseID, int bookID);
}
