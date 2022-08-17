package com.ty.passwordmanager.controller;

import com.ty.passwordmanager.dao.SecretDao;
import com.ty.passwordmanager.dto.Secret;

public class GetPassword {
	public static void main(String[] args) {
		SecretDao dao=new SecretDao();
		Secret secret=dao.getPassword(1,"fb");
		System.out.println(secret);
	}

}