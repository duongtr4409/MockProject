package com.duongnv30.mock_v1.utils.constant;

public class DatabaseConstant {
	
		// thông tin kết nối đến DATABASE
	public static final String DB_HOST = "127.0.0.1";
	public static final String DB_PORT = "1433";
	public static final String DB_DATABASE_NAME = "fsoftMock";
	public static final String DB_USER = "sa";
	public static final String DB_PASSWORD = "123456789";
	
		// thông tin các bảng trong DATABASE
	
	//Bảng dbo.Users
	public static final String DBO_USERS = "dbo.users";
	public static final String DBO_USERS_USERID = "UserID";
	public static final String DBO_USERS_USERNAMES = "UserNames";
	public static final String DBO_USERS_PASSWORDS = "PassWords";
	public static final String DBO_USERS_ISACTIVE = "IsActive";
	
	//Bảng dbo.Roles
	public static final String DBO_ROLES = "dbo.Roles";
	public static final String DBO_ROLES_ROLEID = "RoleID";
	public static final String DBO_ROLES_AUTHORITY = "Authority";
	
	//Bảng dbo.Book
	public static final String DBO_BOOK = "dbo.Book";
	public static final String DBO_BOOK_BOOKID = "BookID";
	public static final String DBO_BOOK_BOOKNAME = "BookName";
	public static final String DBO_BOOK_AUTHOR = "Author";
	public static final String DBO_BOOK_CATEGORY = "Category";
	public static final String DBO_BOOK_BRIEF = "Brief";
	public static final String DBO_BOOK_BOOKTITLE = "BookTitle";
	public static final String DBO_BOOK_PUBLISHER = "Publisher";
	public static final String DBO_BOOK_CONTENT = "Content";
	
	//Bảng dbo.BookCase
	public static final String DBO_BOOKCASE = "dbo.BookCase";
	public static final String DBO_BOOKCASE_BOOKCASEID = "BookCaseID";
	public static final String DBO_BOOKCASE_BOOKCASENAME = "BookCaseName";
	
	//Bảng dbo.Contain
	public static final String DBO_CONTAIN = "dbo.Contain";
	public static final String DBO_CONTAIN_BOOKCASEID = "BookCaseID";
	public static final String DBO_CONTAIN_BOOKID = "BookID";
	public static final String DBO_CONTAIN_CREATEDATE = "CreateDate";
	
	//Bảng dbo.UserRole
	public static final String DBO_USERROLE = "dbo.UserRole";
	public static final String DBO_USERROLE_USERROLEID = "UserRoleID";
	public static final String DBO_USERROLE_USERID = "UserID";
	public static final String DBO_USERROLE_ROLEID = "RoleID";
}
