package com.ty.passwordmanager.controller;

import com.ty.passwordmanager.dao.UserDao;
import com.ty.passwordmanager.dto.User;

public class GetUserById {
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		
         User user=dao.getUserById(1);
         System.out.println(user);
	}
}
