package com.duongnv30.mock_v1.service;

import java.util.List;

import com.duongnv30.mock_v1.model.User;

public interface UserService {
	User findByUserNamePassWord(String userName, String passWord, int isActive);
	List<User> findAll();
}
