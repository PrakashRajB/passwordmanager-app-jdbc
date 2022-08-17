package com.ty.passwordmanager.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ty.passwordmanager.dao.UserDao;
import com.ty.passwordmanager.helper.ConnectionObject;

public class DeleteUserById {
	public static void main(String[] args) {
	     UserDao dao=new UserDao();
	     dao.deleteUserById(1);
	}

}
