package com.ntier.database;

public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private int deptId;
	private int credits;

	public long getId() {
		return id;
	}

	public void setId(long idIn) {
		id = idIn;
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptIdIn) {
		deptId = deptIdIn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int creditsIn) {
		credits = creditsIn;
	}

	public Employee() {

	}

	public Employee(long idIn, String firstNameIn, String lastNameIn, int deptIdIn, int creditsIn) {
		this.setId(idIn);
		this.setFirstName(firstNameIn);
		this.setLastName(lastNameIn);
		this.setDeptId(deptIdIn);
		this.setCredits(creditsIn);
	}

}
