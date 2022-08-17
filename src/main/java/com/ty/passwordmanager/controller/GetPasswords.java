package com.ty.passwordmanager.controller;

import java.util.List;
import com.ty.passwordmanager.dao.SecretDao;
import com.ty.passwordmanager.dto.Secret;

public class GetPasswords {
	public static void main(String[] args) {
		SecretDao dao=new SecretDao();
		List<Secret> secrets= dao.getPasswords(1);
		System.out.println(secrets);
	}

}