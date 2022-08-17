package com.ty.passwordmanager.controller;

import com.ty.passwordmanager.dao.SecretDao;
import com.ty.passwordmanager.dto.Secret;

public class SavePassword {
	public static void main(String[] args) {
		Secret secret=new Secret();
		secret.setUserid(1);
		secret.setAppName("Instagram");
		secret.setUserName("sham1234");
		secret.setPassword("sham1234");
		secret.setDescription("fhdafafaa");
		
		SecretDao dao=new SecretDao();
		dao.savePassword(secret);
	}

}