package com.duongnv30.mock_v1.dao.impl;

import java.util.List;

import com.duongnv30.mock_v1.dao.BookDAO;
import com.duongnv30.mock_v1.model.Book;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;
import com.duongnv30.mock_v1.utils.mappers.impl.BookMapper;

public class BookDAOImpl extends AbstractDAO<Book> implements BookDAO {
	private static BookDAOImpl bookDAOImpl;

	/*
	 *	tránh việc phải khởi tạo đối tượng quá nhiều lần 
	 */
	public static BookDAOImpl getInstance() {
		if (bookDAOImpl == null) {
			bookDAOImpl = new BookDAOImpl();
		}
		return bookDAOImpl;
	}

	/*
	 * lấy danh sách Book có trong Database phục vụ chức năng 'View List Book'
	 */
	@Override
	public List<Book> findAll() {
//		StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Book");
		StringBuilder sql = new StringBuilder("SELECT * FROM "+DatabaseConstant.DBO_BOOK);
		List<Book> listBook = query(sql.toString(), new BookMapper());
		return listBook;
	}

	/*
	 * lấy thông tin của 1 Book theo ID phục vụ chức năng 'ReadBook'
	 */
	@Override
	public Book findByID(int id) {
//		StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Book WHERE BookID = ?");
		StringBuilder sql = new StringBuilder("SELECT * FROM "+DatabaseConstant.DBO_BOOK);
		sql.append(" WHERE "+DatabaseConstant.DBO_BOOK_BOOKID+" = ?");
		List<Book> listBook = query(sql.toString(), new BookMapper(), id);
		if (listBook == null || listBook.isEmpty())
			return null;
		else
			return listBook.get(0);
	}

	/*
	 * lấy danh sách Book có BookName tương ứng với từ khóa
	 * phục vụ chức năng 'Search by name'
	 */
	@Override
	public List<Book> findByName(String name) {
//		StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Book WHERE BookName LIKE N'%" + name + "%';");
		StringBuilder sql = new StringBuilder("SELECT * FROM "+DatabaseConstant.DBO_BOOK);
		sql.append(" WHERE "+DatabaseConstant.DBO_BOOK_BOOKNAME+" LIKE N'%" + name + "%';");
		List<Book> listBook = query(sql.toString(), new BookMapper());
		return listBook;
	}

	/*
	 * lấy danh sách Book có Author tương ứng với từ khóa
	 * phục vụ chức năng 'Search by author'
	 */
	@Override
	public List<Book> findByAuthor(String author) {
//		StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Book WHERE Author LIKE N'%" + author + "%';");
		StringBuilder sql = new StringBuilder("SELECT * FROM "+DatabaseConstant.DBO_BOOK);
		sql.append(" WHERE "+DatabaseConstant.DBO_BOOK_AUTHOR+" LIKE N'%" + author + "%';");
		List<Book> listBook = query(sql.toString(), new BookMapper());
		return listBook;
	}

	/*
	 * lấy danh sách Book có Category tương ứng với từ khóa
	 * phục vụ chức năng 'Search by category'
	 */
	@Override
	public List<Book> findByCategory(String category) {
//		StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Book WHERE Category LIKE N'%" + category + "%';");
		StringBuilder sql = new StringBuilder("SELECT * FROM "+DatabaseConstant.DBO_BOOK);
		sql.append(" WHERE "+DatabaseConstant.DBO_BOOK_CATEGORY+" LIKE N'%" + category + "%';");
		List<Book> listBook = query(sql.toString(), new BookMapper());
		return listBook;
	}

	/*
	 * lấy danh sách Book tương ứng với BookCase
	 * phục vụ chức năng 'View BookCase'
	 */
	@Override
	public List<Book> findBookOfBookCase(int bookCaseID) {
//		StringBuilder sql = new StringBuilder("SELECT b.* ");
//		sql.append("FROM dbo.Contain AS c JOIN dbo.Book AS b ON c.BookID = b.BookID ");
//		sql.append("WHERE c.BookCaseID = ?");
		StringBuilder sql = new StringBuilder("SELECT b.* ");
		sql.append("FROM "+DatabaseConstant.DBO_CONTAIN+" AS c JOIN ");
		sql.append(DatabaseConstant.DBO_BOOK+" AS b ON c.BookID = b.BookID ");
		sql.append("WHERE c.BookCaseID = ?");
		List<Book> listBookOfBookCase = query(sql.toString(), new BookMapper(), bookCaseID);
		return listBookOfBookCase;
	}

	/*
	 * Xóa Book khỏi Database dựa trên ID
	 * phục vụ chức năng 'Delete Book' của ADMIN
	 */
	@Override
	public Integer deleteByID(int bookID) {
//		StringBuilder sql = new StringBuilder("DELETE FROM dbo.Book WHERE BookID = ?");
		StringBuilder sql = new StringBuilder("DELETE FROM "+DatabaseConstant.DBO_BOOK);
		sql.append(" WHERE "+DatabaseConstant.DBO_BOOK_BOOKID+" = ?");
		return removeOrUpdate(sql.toString(), bookID);
	}

	/*
	 * Cập nhật lại Content của Book dựa theo ID
	 * phục vụ chức năng 'Update book's content' của ADMIN 
	 */
	@Override
	public Integer updateBookByID(int bookID,String content) {
//		StringBuilder sql = new StringBuilder("UPDATE dbo.Book SET Content = N'"+content+"'");
		StringBuilder sql = new StringBuilder("UPDATE "+DatabaseConstant.DBO_BOOK);
		sql.append(" SET "+DatabaseConstant.DBO_BOOK_CONTENT+" = N'"+content+"'");
		sql.append(" WHERE "+DatabaseConstant.DBO_BOOK_BOOKID+" = ?");
		return removeOrUpdate(sql.toString(),bookID);
	
	}

	/*
	 * Thêm Book mới vào trong Database
	 * phục vụ chức năng 'Create book' của ADMIN
	 */
	@Override
	public Integer insert(Book book) {
//		StringBuilder sql = new StringBuilder("INSERT INTO dbo.Book VALUES (?, ?, ?, ?, ?, ?, ?)");
		StringBuilder sql = new StringBuilder("INSERT INTO "+DatabaseConstant.DBO_BOOK);
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), book.getName(), book.getTitle(), book.getAuthor(),
						book.getBrief(), book.getPublisher(), book.getContent(), book.getCategory());
	}
}
