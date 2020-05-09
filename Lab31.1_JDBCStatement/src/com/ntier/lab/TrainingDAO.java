package com.ntier.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class TrainingDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private List<Employee> employees = new ArrayList<>();

	List<Employee> getAllEmployees() {
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527//trainingDb");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				long empID = rs.getLong("EMPID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				int deptID = rs.getInt("DEPTID");
				int credits = rs.getInt("CREDITS");
				employees.add(new Employee(empID, firstName, lastName, deptID, credits));
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect to Database");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Connection not closed");
				e.printStackTrace();
			}
		}
		return employees;
	}
}
