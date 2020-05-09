package com.ntier.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbTest2 {

	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	public static void main(String[] args) {
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527//trainingDb");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee");

			System.out.println(rs.getMetaData().getColumnCount());
		} catch (SQLException e) {
			System.out.println("Problem talking to DB");
			e.printStackTrace();
		}
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE WHERE CREDITS > 35";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %n", rs.getMetaData().getColumnName(1),
					rs.getMetaData().getColumnName(2), rs.getMetaData().getColumnName(3),
					rs.getMetaData().getColumnName(4), rs.getMetaData().getColumnName(5));
			while (rs.next()) {
				long id = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString("LASTNAME");
				int deptId = rs.getInt("DEPTID");
				int credits = rs.getInt("CREDITS");
				employees.add(new Employee(id, firstName, lastName, deptId, credits));
			}
			employees.forEach(p -> System.out.printf("%-10d %-10s %-10s %-10d %-10d %n", p.getId(), p.getFirstName(),
					p.getLastName(), p.getDeptId(), p.getCredits()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
