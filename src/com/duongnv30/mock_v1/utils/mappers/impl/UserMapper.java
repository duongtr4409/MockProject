package com.duongnv30.mock_v1.utils.mappers.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duongnv30.mock_v1.model.Role;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;
import com.duongnv30.mock_v1.utils.mappers.DBMapper;

//map record của dbo.User vs Object User
public class UserMapper implements DBMapper<User>{

	@Override
	public User mapRow(ResultSet rs) {
		User u = new User();
		try {
//			u.setId(rs.getInt("UserID"));
//			u.setUserName(rs.getString("UserNames"));
//			u.setPassWord(rs.getString("PassWords"));
//			u.setIsActive(rs.getInt("IsActive"));
			u.setId(rs.getInt(DatabaseConstant.DBO_USERS_USERID));
			u.setUserName(rs.getString(DatabaseConstant.DBO_USERS_USERNAMES));
			u.setPassWord(rs.getString(DatabaseConstant.DBO_USERS_PASSWORDS));
			u.setIsActive(rs.getInt(DatabaseConstant.DBO_USERS_ISACTIVE));
			try {
				Role role = new Role();
//				role.setId(rs.getInt("RoleID"));
//				role.setAuthority(rs.getString("Authority"));
				role.setId(rs.getInt(DatabaseConstant.DBO_ROLES_ROLEID));
				role.setAuthority(rs.getString(DatabaseConstant.DBO_ROLES_AUTHORITY));
				u.getRoles().add(role);
			} catch (Exception e) {
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
