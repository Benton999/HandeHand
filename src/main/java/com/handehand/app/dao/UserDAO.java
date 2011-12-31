package com.handehand.app.dao;

import java.util.List;

import com.handehand.app.model.User;

public interface UserDAO {

	User findUser(String username);

	User login (String u, String pw) ;
	
	List<User> findAll();	

}