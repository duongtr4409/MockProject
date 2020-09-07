package com.duongnv30.mock_v1.service.impl;

import com.duongnv30.mock_v1.dao.ContainDAO;
import com.duongnv30.mock_v1.dao.impl.ContainDAOImpl;
import com.duongnv30.mock_v1.model.Contain;
import com.duongnv30.mock_v1.service.ContainService;

public class ContainServiceImpl implements ContainService {

	private static ContainServiceImpl containServiceImpl;
	private static ContainDAO containDAO;

	public ContainServiceImpl() {
		containDAO = new ContainDAOImpl();
	}

	public static ContainServiceImpl getInstance() {
		if (containServiceImpl == null) {
			containServiceImpl = new ContainServiceImpl();
		}
		return containServiceImpl;
	}

	@Override
	public Integer insert(Contain contain) {
		return containDAO.insert(contain);
	}

	@Override
	public Integer removeByBookCaseID(int bookCaseID) {
		return containDAO.removeByBookCaseID(bookCaseID);
	}

	@Override
	public Integer removeByBookCaseIDBookID(int bookCaseID, int bookID) {
		return containDAO.removeByBookCaeIDBookID(bookCaseID, bookID);
	}

}
