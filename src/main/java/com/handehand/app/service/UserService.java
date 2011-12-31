package com.handehand.app.service;

import java.util.List;

import com.handehand.app.model.User;

public interface UserService {

	User findUser(String username);

	User login (String u, String pw) ;
	
	List<User> findAll();	

}