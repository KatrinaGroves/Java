package com.ntier.lab;

import java.util.List;

class EmployeeTrainingClient {

	public static void main(String[] args) {
		TrainingDAO td = new TrainingDAO();
		List<Employee> employeeList = td.getAllEmployees();
		employeeList.forEach(e -> System.out.printf("%-10d %-10s %-10s %-10d %-10d %n", e.getEmpID(), e.getFirstName(),
				e.getLastName(), e.getDeptID(), e.getCredits()));
	}
}