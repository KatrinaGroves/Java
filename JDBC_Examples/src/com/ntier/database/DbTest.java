package com.ntier.database;

import java.sql.*;

public class DbTest {

	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;

		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527//trainingDb");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee");

			System.out.println(rs.getMetaData().getColumnCount());
		} catch (SQLException e) {
			System.out.println("Problem talking to DB");
			e.printStackTrace();
		}
	}
}
