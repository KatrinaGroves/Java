package com.ntier.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class TrainingDAO {

	private Connection conn;
	private List<Employee> employees = new ArrayList<>();
	private Employee emp;

	List<Employee> getAllEmployees() throws SQLException {
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527//trainingDb");
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("select * from employee");
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

	Employee getEmployeeByID(int empID) throws SQLException {
		String sql = "select * from employee where empid = ?";
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527//trainingDb");
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, empID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getLong(1), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getInt("DEPTID"), rs.getInt("CREDITS"));
			}
		} catch (SQLException e) {
			System.out.println("Database not found");
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
		return emp;
	}

	List<Employee> getEmployeeByCredits(int deptID) throws SQLException {
		String sql = "select * from employee where credits > ? and deptid = ? order by credits desc";
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527//trainingDb");
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, 20);
			pstmt.setInt(2, deptID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getLong(1), rs.getString(2), rs.getString("LASTNAME"),
						rs.getInt("DEPTID"), rs.getInt("CREDITS")));
			}
		} catch (SQLException e) {
			System.out.println("Database not found");
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