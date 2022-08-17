package com.ty.passwordmanager.controller;

import java.util.List;

import com.ty.passwordmanager.dao.UserDao;
import com.ty.passwordmanager.dto.User;

public class GetAllUsers {
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		List<User> users=dao.getAllUsers();
		System.out.println(users);
	}

}
