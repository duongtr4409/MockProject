package com.duongnv30.mock_v1.dao.impl;

import java.util.List;

import com.duongnv30.mock_v1.dao.UserDAO;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;
import com.duongnv30.mock_v1.utils.mappers.impl.UserMapper;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO{
	
	private static UserDAOImpl userDAOImpl;
	
	public static UserDAOImpl getInstance() {
		if(userDAOImpl == null) {
			userDAOImpl = new UserDAOImpl();
		}
		return userDAOImpl;
	}
	
	/*
	 * Lấy ra User còn hoạt động tương ứng với UserName, PassWord đã truyền vào
	 */
	@Override
	public User findByUserNamePassWord(String userName, String passWord, int isActive) {
//		StringBuilder sql = new StringBuilder("SELECT u.UserID, u.UserNames, u.PassWords, u.IsActive, r.RoleID, r.Authority ");
//		sql.append("FROM dbo.Users AS u JOIN dbo.UserRole AS ur ON u.UserID = ur.UserID ");
//		sql.append("JOIN dbo.Roles AS r ON r.RoleID = ur.RoleID ");
//		sql.append("WHERE u.UserNames = ? AND u.PassWords = ? AND u.IsActive = ? ");
		StringBuilder sql = new StringBuilder("SELECT u.UserID, u.UserNames, u.PassWords, u.IsActive, r.RoleID, r.Authority ");
		sql.append("FROM "+DatabaseConstant.DBO_USERS+" AS u JOIN "+DatabaseConstant.DBO_USERROLE+" AS ur ON u.UserID = ur.UserID ");
		sql.append("JOIN "+DatabaseConstant.DBO_ROLES+" AS r ON r.RoleID = ur.RoleID ");
		sql.append("WHERE u.UserNames = ? AND u.PassWords = ? AND u.IsActive = ? ");
		List<User> listUser = query(sql.toString(), new UserMapper(), userName, passWord, isActive);
		if(listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}else {
			return null;
		}
	}

	/*
	 * Lấy toàn bộ User có trong Database
	 */
	@Override
	public List<User> findAll() {
//		StringBuilder sql = new StringBuilder("SELECT u.UserID, u.UserNames, u.PassWords, u.IsActive, r.RoleID, r.Authority");
//		sql.append(" FROM dbo.Users AS u JOIN dbo.UserRole AS ur ON u.UserID = ur.UserID");
//		sql.append(" JOIN dbo.Roles AS r ON r.RoleID = ur.RoleID");
		StringBuilder sql = new StringBuilder("SELECT u.UserID, u.UserNames, u.PassWords, u.IsActive, r.RoleID, r.Authority");
		sql.append(" FROM "+DatabaseConstant.DBO_USERS+" AS u JOIN "+DatabaseConstant.DBO_USERROLE+" AS ur ON u.UserID = ur.UserID");
		sql.append(" JOIN "+DatabaseConstant.DBO_ROLES+" AS r ON r.RoleID = ur.RoleID");
		List<User> listResult = query(sql.toString(), new UserMapper());
		return listResult;
	}
	
}
