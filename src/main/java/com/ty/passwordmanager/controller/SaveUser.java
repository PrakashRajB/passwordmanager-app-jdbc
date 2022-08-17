package com.ty.passwordmanager.controller;

import com.ty.passwordmanager.dao.UserDao;
import com.ty.passwordmanager.dto.User;

public class SaveUser {

	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setName("Sham");
		user.setEmail("sham@gmail.com");
		user.setPassword("sham1234");
		
		UserDao dao=new UserDao();
		dao.saveUser(user);

	}

}