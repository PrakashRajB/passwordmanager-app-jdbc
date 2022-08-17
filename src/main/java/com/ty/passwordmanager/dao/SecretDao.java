package com.ty.passwordmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.passwordmanager.dto.Secret;
import com.ty.passwordmanager.helper.AES;
import com.ty.passwordmanager.helper.ConnectionObject;

public class SecretDao {

	public void savePassword(Secret secret) {
		Connection connection = ConnectionObject.getConnection();
		String query = "INSERT INTO secret VALUES(?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,secret.getUserid());
			preparedStatement.setString(2, secret.getAppName());
			preparedStatement.setString(3, secret.getUserName());
			preparedStatement.setString(4, AES.encrypt(secret.getPassword()));
			preparedStatement.setString(5, secret.getDescription());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePassword(String appName, int id) {
		Connection connection = ConnectionObject.getConnection();
		String query = "DELETE FROM secret WHERE APPNAME=? AND USERID=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, appName);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Secret getPassword(int id, String appName) {
		Secret secret = null;
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM secret WHERE USERID=? AND APPNAME=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, appName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				secret = new Secret();
				secret.setUserid(resultSet.getInt(1));
				secret.setAppName(resultSet.getString(2));
				secret.setUserName(resultSet.getString(3));
				secret.setPassword(AES.decrypt(resultSet.getString(4)));
				secret.setDescription(resultSet.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return secret;
	}

	public List<Secret> getPasswords(int id) {
		List<Secret> secrets = new ArrayList<>();
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM secret WHERE ID=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Secret secret=new Secret();
				secret.setUserid(resultSet.getInt(1));
				secret.setAppName(resultSet.getString(2));
				secret.setUserName(resultSet.getString(3));
				secret.setPassword(AES.decrypt(resultSet.getString(4)));
				secret.setDescription(resultSet.getString(5));
				secrets.add(secret);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return secrets;
	}
	
	
}