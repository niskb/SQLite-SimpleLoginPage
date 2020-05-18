package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import view.SceneBuilder;

public class SqliteUtils {

	public static void insertToDatabase(int id, String name, String username, String password) {
		Connection connection = SqliteConnection.connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO users(id, name, username, password) VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.execute();
			System.out.println("Data has been inserted!");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	// Should only be ran once
	private static boolean isRanFlag = false;

	public static void readAllData() {
		if (!isRanFlag) {
			Connection connection = SqliteConnection.connect();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				String sql = "SELECT * FROM users";
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				System.out.println("ALL USERS");
				while (resultSet.next()) {
					int id = Integer.parseInt(resultSet.getString("id"));
					String name = resultSet.getString("name");
					String username = resultSet.getString("username");
					String password = resultSet.getString("password");
					System.out.println("Id: " + id + "; Name: " + name + "; Username: " + username + "; Password: "
							+ password + "");
					User user = new User(name, username, password);
					SceneBuilder.userList.add(user);
				}
			} catch (SQLException e) {
				System.out.println(e.toString());
			} finally {
				try {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
			isRanFlag = true;
		}
	}

	public static void readSpecificRowById(int inputId) {
		Connection connection = SqliteConnection.connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT * FROM users";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("USER FROM INPUTTED ID" + inputId + "?");
			while (resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString("id"));
				if (id == inputId) {
					String name = resultSet.getString("name");
					String username = resultSet.getString("username");
					String password = resultSet.getString("password");
					System.out.println("Id: " + id + "; Name: " + name + "; Username: " + username + "; Password: "
							+ password + "");
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

}
