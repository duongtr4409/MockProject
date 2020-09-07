package com.duongnv30.mock_v1.utils.system;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.service.impl.UserServiceImpl;

public class SystemObject {
	public static Dictionary<Integer, User> dictionaryUser = new Hashtable<>();

	//load các User từ Database vào trong Dictionary
	public SystemObject() {
		List<User> listUser = UserServiceImpl.getInstance().findAll();
		listUser.stream().forEach( user -> dictionaryUser.put(user.hashCode(), user));
	}
}
