package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {

	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:UserDb.sqlite");	// connecting to our database
			System.out.println("Connected!");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e + "");
		}
		return connection;
	}
	
}
