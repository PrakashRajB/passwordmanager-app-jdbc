package com.ty.passwordmanager.controller;

import com.ty.passwordmanager.dao.UserDao;

public class ValidateUser {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		boolean result = dao.validateUser("sham@gmail.com", "sham1234");
		System.out.println(result);
	}

}
