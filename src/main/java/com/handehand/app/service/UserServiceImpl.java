package com.handehand.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.handehand.app.dao.UserDAO;
import com.handehand.app.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO userDAO;
	
	public User findUser(String username){
		return userDAO.findUser(username);
	}

	public User login (String u, String pw){
		return userDAO.login(u, pw);
	}
	
	public List<User> findAll(){
		return userDAO.findAll();
	}
}