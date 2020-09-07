package com.duongnv30.mock_v1.utils.mappers.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duongnv30.mock_v1.model.BookCase;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;
import com.duongnv30.mock_v1.utils.mappers.DBMapper;

//map record của dbo.BookCase vs Object BookCase
public class BookCaseMapper implements DBMapper<BookCase>{

	@Override
	public BookCase mapRow(ResultSet rs) {
		BookCase bookCase = new BookCase();
		try {
//			bookCase.setId(rs.getInt("BookCaseID"));
//			bookCase.setBookCaseName(rs.getString("BookCaseName"));
			bookCase.setId(rs.getInt(DatabaseConstant.DBO_BOOKCASE_BOOKCASEID));
			bookCase.setBookCaseName(rs.getString(DatabaseConstant.DBO_BOOKCASE_BOOKCASENAME));
			return bookCase;
		} catch (SQLException e) {
			return null;
		}
	}
		
}
