package com.duongnv30.mock_v1.dao.impl;

import java.util.List;

import com.duongnv30.mock_v1.dao.BookCaseDAO;
import com.duongnv30.mock_v1.model.BookCase;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;
import com.duongnv30.mock_v1.utils.mappers.impl.BookCaseMapper;

public class BookCaseDAOImpl extends AbstractDAO<BookCase> implements BookCaseDAO{

	/* 
	 *	lấy BookCase tương ứng với User
	 */
	@Override
	public BookCase findOne(int id) {
//		StringBuilder sql = new StringBuilder("SELECT * FROM dbo.BookCase WHERE BookCaseID = ?");
		StringBuilder sql = new StringBuilder("SELECT * FROM "+DatabaseConstant.DBO_BOOKCASE);
		sql.append(" WHERE "+DatabaseConstant.DBO_BOOKCASE_BOOKCASEID+"= ?");
		List<BookCase> listBookCase = query(sql.toString(), new BookCaseMapper(), id);
		if(listBookCase == null || listBookCase.isEmpty()) {
			return null;
		}else {
			BookCase bookCase = listBookCase.get(0);
			// Lấy danh sách Book tương ứng trong BookCase
			bookCase.setListBook(new BookDAOImpl().findBookOfBookCase(id));
			return bookCase;
		}
	}

	/*
	 *	thêm BookCase mới vào Database
	 */
	@Override
	public Integer insert(User user) {
		String bookCaseName = "BookCase of " + user.getUserName();
//		StringBuilder sql = new StringBuilder("INSERT INTO dbo.BookCase VALUES (?,N'"+bookCaseName+"')");
		StringBuilder sql = new StringBuilder("INSERT INTO "+DatabaseConstant.DBO_BOOKCASE);
		sql.append(" VALUES (?,N'"+bookCaseName+"')");
		return insert(sql.toString(), user.getId());
	}
	
}
