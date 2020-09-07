package com.duongnv30.mock_v1.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private int isActive;
	private List<Role> roles = new ArrayList<>();
	private BookCase bookCase;

	public User(String userName, String passWord, int isActive) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.isActive = isActive;
	}

	public User(int id, String userName, String passWord, int isActive, List<Role> roles, BookCase bookCase) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.isActive = isActive;
		this.roles = roles;
		this.bookCase = bookCase;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public BookCase getBookCase() {
		return bookCase;
	}

	public void setBookCase(BookCase bookCase) {
		this.bookCase = bookCase;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", isActive=" + isActive
				+ ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + id;
		result = prime * result + isActive;
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		// result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
