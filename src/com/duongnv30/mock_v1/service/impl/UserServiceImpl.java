package com.duongnv30.mock_v1.service.impl;

import java.util.List;

import com.duongnv30.mock_v1.dao.impl.UserDAOImpl;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.service.UserService;

public class UserServiceImpl implements UserService{
	
	private static UserServiceImpl userServiceImpl;
	private static UserDAOImpl userDaoImpl;
	
	public UserServiceImpl() {
		userDaoImpl = UserDAOImpl.getInstance();
	}

	public static UserServiceImpl getInstance(){
		if(userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}
	
	@Override
	public User findByUserNamePassWord(String userName, String passWord, int isActive) {
		User user = userDaoImpl.findByUserNamePassWord(userName, passWord, isActive);
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> listUser = userDaoImpl.findAll();
		return listUser;
	}
	
}
