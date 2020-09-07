package com.duongnv30.mock_v1.main.user.service;

import java.util.Scanner;

import com.duongnv30.mock_v1.model.User;

public interface UserRoleService {
	void ViewListBook();
	void SearchBook(Scanner sc);
	void ReadBook(Scanner sc);
	void viewBookCase(User user);
	void editBookCase(Scanner sc, User user);
}
