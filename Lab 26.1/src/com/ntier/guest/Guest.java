package com.ntier.guest;

class Guest implements Comparable<Guest> {

	private String firstName;
	private String lastName;
	private int points;

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

	public int getPoints() {
		return points;
	}

	public void setPoints(int pointsIn) {
		points = pointsIn;
	}

	Guest(String firstNameIn, String lastNameIn, int pointsIn) {
		super();
		firstName = firstNameIn;
		lastName = lastNameIn;
		points = pointsIn;
	}

	
	@Override
	public String toString() {
		return "Guest: " + firstName + " " + lastName + ", Points: " + points;
	}

	public int compareTo(Guest gst) {
		int compared = this.getLastName().compareTo(gst.getLastName());
		if (compared == 0) {
			compared = this.getFirstName().compareTo(gst.getFirstName());
		}
		return compared;
	}
}
