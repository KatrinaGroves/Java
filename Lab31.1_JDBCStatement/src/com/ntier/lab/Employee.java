package com.ntier.lab;

import java.io.Serializable;

public class Employee implements Serializable {

	private long empID;
	private String firstName;
	private String lastName;
	private int deptID;
	private int credits;

	public long getEmpID() {
		return empID;
	}

	public void setEmpID(long empIDIn) {
		empID = empIDIn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstNameIn) {
		firstName = firstNameIn;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastNameIn) {
		lastName = lastNameIn;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptIDIn) {
		deptID = deptIDIn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int creditsIn) {
		credits = creditsIn;
	}

	public Employee() {

	}

	public Employee(long empIDIn, String firstNameIn, String lastNameIn, int deptIDIn, int creditsIn) {
		this.setEmpID(empIDIn);
		this.setFirstName(firstNameIn);
		this.setLastName(lastNameIn);
		this.setDeptID(deptIDIn);
		this.setCredits(creditsIn);
	}
}
