package com.duongnv30.mock_v1.dao.impl;

import com.duongnv30.mock_v1.dao.ContainDAO;
import com.duongnv30.mock_v1.model.Contain;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;

public class ContainDAOImpl extends AbstractDAO<Contain> implements ContainDAO {

	/*
	 *	Thêm Contain mới vào trong Database
	 *  phục vụ chức năng 'Edit BookCase' -> 'Add a new book'
	 */
	@Override
	public Integer insert(Contain contain) {
//		StringBuilder sql = new StringBuilder("INSERT INTO dbo.Contain VALUES  ( ?, ?, GETDATE())");
		StringBuilder sql = new StringBuilder("INSERT INTO "+DatabaseConstant.DBO_CONTAIN+" VALUES  ( ?, ?, GETDATE())");
		return insert(sql.toString(), contain.getBookCaseID(), contain.getBookID());
	}

	/*
	 * Xóa danh sách Contain dựa trên BookCaseID
	 * phục vụ chức năng 'Edit BookCase' -> 'Clear BookCase'
	 */
	@Override
	public Integer removeByBookCaseID(int bookCaseID) {
//		StringBuilder sql = new StringBuilder("DELETE FROM dbo.Contain WHERE BookCaseID = ?");
		StringBuilder sql = new StringBuilder("DELETE FROM "+DatabaseConstant.DBO_CONTAIN);
		sql.append(" WHERE "+DatabaseConstant.DBO_CONTAIN_BOOKCASEID+" = ?");
		return removeOrUpdate(sql.toString(), bookCaseID);
	}

	/*
	 * Xóa Contain dựa trên BookCaseID và BookID
	 * phục vụ chức năng 'Edit BookCase' -> 'Remove a book'
	 */
	@Override
	public Integer removeByBookCaeIDBookID(int bookCaseID, int bookID) {
//		StringBuilder sql = new StringBuilder("DELETE FROM dbo.Contain WHERE BookCaseID = ? AND BookID = ?");
		StringBuilder sql = new StringBuilder("DELETE FROM "+DatabaseConstant.DBO_CONTAIN);
		sql.append(" WHERE "+DatabaseConstant.DBO_CONTAIN_BOOKCASEID+" = ? AND "+DatabaseConstant.DBO_CONTAIN_BOOKID+" = ?");
		return removeOrUpdate(sql.toString(), bookCaseID, bookID);
	}
	
}
