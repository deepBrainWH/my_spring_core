package com.wangheng.bean;


public interface UserService {
	
	String getName();

	UserDao getUserDao();

	void setUserDao(UserDao userDao);
}
