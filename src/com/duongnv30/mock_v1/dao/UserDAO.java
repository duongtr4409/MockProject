package com.duongnv30.mock_v1.dao;

import java.util.List;

import com.duongnv30.mock_v1.model.User;

public interface UserDAO extends GenericDAO<User>{
	User findByUserNamePassWord(String userName, String passWord, int isActive);
	List<User> findAll();
}
