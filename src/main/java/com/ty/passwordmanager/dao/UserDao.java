package com.ty.passwordmanager.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.passwordmanager.dto.User;
import com.ty.passwordmanager.helper.AES;
import com.ty.passwordmanager.helper.ConnectionObject;

public class UserDao {

	public void saveUser(User user) {
		Connection connection = ConnectionObject.getConnection();
		String query = "INSERT INTO user VALUES(?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, AES.encrypt(user.getPassword()));
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUserById(int id) {
		User user = null;
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * From user WHERE ID=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPassword(AES.decrypt(resultSet.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean validateUser(String email, String password) {
		boolean result = false;
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM user WHERE BINARY EMAIL=? AND BINARY PASSWORD=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, AES.encrypt(password));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Connection connection = ConnectionObject.getConnection();

		String query = "SELECT * FROM user";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPassword(AES.decrypt(resultSet.getString(4)));
				users.add(user);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public void deleteUserById(int id) {
		Connection connection = ConnectionObject.getConnection();
		String query = "CALL delete_user(?)";

		try {
			CallableStatement callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, id);
			callableStatement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}