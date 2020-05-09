package com.ntier.lab;

import java.sql.SQLException;
import java.util.List;

class EmployeeTrainingClient {

	public static void main(String[] args) throws SQLException {
		System.out.println("Employee Training List:\r");
		List<Employee> empList1 = new TrainingDAO().getAllEmployees();
		empList1.forEach(System.out::print);
		divider();

		System.out.println("Employee Found by ID:\r");
		Employee empListByID1 = new TrainingDAO().getEmployeeByID(2);
		Employee empListByID2 = new TrainingDAO().getEmployeeByID(5);
		System.out.print(empListByID1);
		System.out.print(empListByID2);
		divider();

		System.out.println("Employees with 20 Credits or more:\r");
		List<Employee> empListByCredits1 = new TrainingDAO().getEmployeeByCredits(1001);
		List<Employee> empListByCredits2 = new TrainingDAO().getEmployeeByCredits(1002);
		List<Employee> empListByCredits3 = new TrainingDAO().getEmployeeByCredits(1003);
		empListByCredits1.forEach(System.out::print);
		empListByCredits2.forEach(System.out::print);
		empListByCredits3.forEach(System.out::print);
		divider();
	}

	static void divider() {
		System.out.println("\r------------------------------------------------\r");
	}
}
