package com.duongnv30.mock_v1.utils.mappers.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duongnv30.mock_v1.model.Book;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;
import com.duongnv30.mock_v1.utils.mappers.DBMapper;

//map record của dbo.Book vs Object Book
public class BookMapper implements DBMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs) {
		Book book = new Book();
		try {
//			book.setId(rs.getInt("BookID"));
//			book.setName(rs.getString("BookName"));
//			book.setAuthor(rs.getString("Author"));
//			book.setCategory(rs.getString("Category"));
//			book.setBrief(rs.getString("Brief"));
//			book.setTitle(rs.getString("BookTitle"));
//			book.setPublisher(rs.getString("Publisher"));
//			book.setContent(rs.getString("Content"));
			book.setId(rs.getInt(DatabaseConstant.DBO_BOOK_BOOKID));
			book.setName(rs.getString(DatabaseConstant.DBO_BOOK_BOOKNAME));
			book.setAuthor(rs.getString(DatabaseConstant.DBO_BOOK_AUTHOR));
			book.setCategory(rs.getString(DatabaseConstant.DBO_BOOK_CATEGORY));
			book.setBrief(rs.getString(DatabaseConstant.DBO_BOOK_BRIEF));
			book.setTitle(rs.getString(DatabaseConstant.DBO_BOOK_BOOKTITLE));
			book.setPublisher(rs.getString(DatabaseConstant.DBO_BOOK_PUBLISHER));
			book.setContent(rs.getString(DatabaseConstant.DBO_BOOK_CONTENT));
			return book;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
